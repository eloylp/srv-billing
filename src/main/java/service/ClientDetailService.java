package service;

import dao.ClientDetailRepository;
import model.ClientDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ClientDetailService implements ClientDetailsService, ClientRegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final ClientDetailRepository clientDetailsRepository;

    @Autowired
    public ClientDetailService(PasswordEncoder passwordEncoder, ClientDetailRepository clientDetailsRepository) {
        this.passwordEncoder = passwordEncoder;
        this.clientDetailsRepository = clientDetailsRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientDetail clientDetails = clientDetailsRepository.findByClientId(clientId);
        if (null == clientDetails) {
            throw new ClientRegistrationException("Client not found with id '" + clientId + "'");
        }
        return getClientFromMongoDBClientDetails(clientDetails);
    }

    @Override
    public void addClientDetails(ClientDetails cd) throws ClientAlreadyExistsException {
        ClientDetail clientDetails = getMongoDBClientDetailsFromClient(cd);
        clientDetailsRepository.save(clientDetails);
    }

    @Override
    public void updateClientDetails(ClientDetails cd) throws NoSuchClientException {
        ClientDetail clientDetails = clientDetailsRepository.findByClientId(cd.getClientId());
        if (null == clientDetails) {
            throw new NoSuchClientException("Client not found with ID '" + cd.getClientId() + "'");
        }
        clientDetails = getMongoDBClientDetailsFromClient(cd);
        clientDetailsRepository.save(clientDetails);
    }

    @Override
    public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {
        ClientDetail clientDetails = clientDetailsRepository.findByClientId(clientId);
        if (null == clientDetails) {
            throw new NoSuchClientException("Client not found with ID '" + clientId + "'");
        }
        clientDetails.setClientSecret(passwordEncoder.encode(secret));
        clientDetailsRepository.save(clientDetails);
    }

    @Override
    public void removeClientDetails(String clientId) throws NoSuchClientException {
        ClientDetail clientDetails = clientDetailsRepository.findByClientId(clientId);
        if (null == clientDetails) {
            throw new NoSuchClientException("Client not found with ID '" + clientId + "'");
        }
        clientDetailsRepository.delete(clientDetails);
    }

    @Override
    public List listClientDetails() {
        List<ClientDetail> mdbcds = clientDetailsRepository.findAll();
        return getClientsFromMongoDBClientDetails(mdbcds);
    }

    private List<BaseClientDetails> getClientsFromMongoDBClientDetails(List<ClientDetail> clientDetails) {
        List<BaseClientDetails> bcds = new LinkedList<>();
        if (clientDetails != null && !clientDetails.isEmpty()) {
            clientDetails.stream().forEach(mdbcd -> {
                bcds.add(getClientFromMongoDBClientDetails(mdbcd));
            });
        }
        return bcds;
    }

    private BaseClientDetails getClientFromMongoDBClientDetails(ClientDetail clientDetails) {
        BaseClientDetails bc = new BaseClientDetails();
        bc.setAccessTokenValiditySeconds(clientDetails.getAccessTokenValiditySeconds());
        bc.setAuthorizedGrantTypes(clientDetails.getAuthorizedGrantTypes());
        bc.setClientId(clientDetails.getClientId());
        bc.setClientSecret(clientDetails.getClientSecret());
        bc.setRefreshTokenValiditySeconds(clientDetails.getRefreshTokenValiditySeconds());
        bc.setRegisteredRedirectUri(clientDetails.getRegisteredRedirectUri());
        bc.setResourceIds(clientDetails.getResourceIds());
        bc.setScope(clientDetails.getScope());
        return bc;
    }

    private ClientDetail getMongoDBClientDetailsFromClient(ClientDetails cd) {
        ClientDetail clientDetails = new ClientDetail();
        clientDetails.setAccessTokenValiditySeconds(cd.getAccessTokenValiditySeconds());
        clientDetails.setAdditionalInformation(cd.getAdditionalInformation());
        clientDetails.setAuthorizedGrantTypes(cd.getAuthorizedGrantTypes());
        clientDetails.setClientId(cd.getClientId());
        clientDetails.setClientSecret(cd.getClientSecret());
        clientDetails.setRefreshTokenValiditySeconds(cd.getRefreshTokenValiditySeconds());
        clientDetails.setRegisteredRedirectUri(cd.getRegisteredRedirectUri());
        clientDetails.setResourceIds(cd.getResourceIds());
        clientDetails.setScope(cd.getScope());
        clientDetails.setScoped(cd.isScoped());
        clientDetails.setSecretRequired(cd.isSecretRequired());
        clientDetails.setId(cd.getClientId());
        return clientDetails;
    }

    public ClientDetail save(ClientDetail authClient) {
        return clientDetailsRepository.save(authClient);
    }

    public void deleteAll() {
        clientDetailsRepository.deleteAll();
    }

}