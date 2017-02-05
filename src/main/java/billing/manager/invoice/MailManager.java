package billing.manager.invoice;

import org.springframework.stereotype.Component;


@Component
class MailManager {


    public boolean mailHtml(String mail) {
        return true;
    }


}
