package com.ironhack.bankingsystem.controller.interfaces.users;


import com.ironhack.bankingsystem.models.users.ThirdParty;

import java.util.List;

public interface IThirdPartyController {

    void saveThirdParty(ThirdParty thirdParty);
    List<ThirdParty> getThirdParties();
}
