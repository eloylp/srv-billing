package security;

import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import model.User;
import service.ClientDetailService;
import service.UserAuthConfigService;


@Configuration
public class CustomMongoDBConvertor implements Converter<DBObject, OAuth2Authentication> {

    private final UserAuthConfigService authConfigService;
    private final ClientDetailService clientDetailService;

    @Autowired
    public CustomMongoDBConvertor(UserAuthConfigService authConfigService, ClientDetailService clientDetailService) {
        this.authConfigService = authConfigService;
        this.clientDetailService = clientDetailService;
    }


    @Override
    public OAuth2Authentication convert(DBObject source) {
        DBObject storedRequest = (DBObject) source.get("storedRequest");
        OAuth2Request oAuth2Request = new OAuth2Request((Map<String, String>) storedRequest.get("requestParameters"),
                (String) storedRequest.get("clientId"), null, true, new HashSet((List) storedRequest.get("scope")),
                null, null, null, null);
        DBObject userAuthorization = (DBObject) source.get("userAuthentication");
        if (null != userAuthorization) { //its a user
            Object prinObj = userAuthorization.get("principal");
            User u = null;
            if ((null != prinObj) && prinObj instanceof String) {
                u = authConfigService.getUser((String) prinObj);
            } else if (null != prinObj) {
                DBObject principalDBO = (DBObject) prinObj;
                String email = (String) principalDBO.get("username");
                u = authConfigService.getUser(email);
            }
            if (null == u) {
                return null;
            }

            Authentication userAuthentication = new UserAuthenticationToken(u.getEmail(),
                    (String) userAuthorization.get("credentials"), authConfigService.getRights(u));
            OAuth2Authentication authentication = new OAuth2Authentication(oAuth2Request, userAuthentication);
            return authentication;
        } else { //its a client
            String clientId = (String) storedRequest.get("clientId");
            ClientDetails client = null;
            if ((null != clientId) && clientId instanceof String) {
                client = clientDetailService.loadClientByClientId(clientId);
            }
            if (null == client) {
                return null;
            }
            Authentication userAuthentication = new ClientAuthenticationToken(client.getClientId(),
                    null, client.getAuthorities());
            return new OAuth2Authentication(oAuth2Request, userAuthentication);
        }
    }

    @Bean
    public CustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
        converterList.add(this);
        return new CustomConversions(converterList);
    }
}
