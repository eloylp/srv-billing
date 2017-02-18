package billing;

import billing.manager.DelegationManager;
import billing.model.Delegation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DelegationService {

    private final DelegationManager delegationManager;

    @Autowired
    public DelegationService(DelegationManager delegationManager) {
        this.delegationManager = delegationManager;
    }


    public Delegation create(Delegation delegation) {

        this.delegationManager.create(delegation);
        return delegation;
    }

    public List<Delegation> showAll() {


        return new ArrayList<>();
    }

    public boolean deactivateDelegation(String delegationId) {

        return true;
    }

    public boolean activateDelegation(String delegationId) {

        return true;

    }

}
