package com.ironhack.bankingsystem.service.interfaces.users;

import com.ironhack.bankingsystem.models.users.ThirdParty;

import java.util.List;

public interface IThirdPartyService {

    ThirdParty saveThirdParty(ThirdParty thirdParty);
    List<ThirdParty> getThirdParties();
}
