package managers;

import model.Delegation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.DelegationRepository;


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

    public Delegation getByName(String delegtionName) {

        return new Delegation();
    }
}
