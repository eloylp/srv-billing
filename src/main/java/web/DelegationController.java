package web;


import model.Delegation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.DelegationService;

import java.util.ArrayList;
import java.util.List;


@RestController
class DelegationController {

    private DelegationService delegationService;

    @Autowired
    DelegationController(DelegationService delegationService) {
        this.delegationService = delegationService;

    }

    @PreAuthorize("#oauth2.hasScope('')")
    @RequestMapping(value = "/delegations", method = RequestMethod.GET)
    public List<Delegation> get() {


        return new ArrayList<Delegation>();


    }

    @PreAuthorize("#oauth2.hasScope('')")
    @RequestMapping(value = "/delegations", method = RequestMethod.POST)
    public Delegation create(Delegation delegation) {

        return delegation;
    }

    @PreAuthorize("#oauth2.hasScope('')")
    @RequestMapping(value = "/delegations", method = RequestMethod.PATCH)
    public Delegation update(Delegation delegation) {


        return delegation;

    }

}
