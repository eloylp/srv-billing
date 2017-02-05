package billing.manager;

import billing.model.Delegation;
import billing.repository.DelegationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DelegationManager {

    private final DelegationRepository delegationRepository;


    @Autowired
    public DelegationManager(DelegationRepository delegationRepository) {
        this.delegationRepository = delegationRepository;
    }


    public Delegation create(Delegation delegation) {

        return this.delegationRepository.getByName("ed");
    }

    public Delegation getByName(String delegationName) {

        return new Delegation();
    }
}
