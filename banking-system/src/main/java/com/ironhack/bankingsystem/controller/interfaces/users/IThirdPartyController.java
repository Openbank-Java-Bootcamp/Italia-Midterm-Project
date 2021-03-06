package com.ironhack.bankingsystem.controller.interfaces.users;


import com.ironhack.bankingsystem.DTO.userDTOs.ThirdPartyDTO;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.users.ThirdParty;

import java.util.List;

public interface IThirdPartyController {

    void saveThirdParty(ThirdPartyDTO thirdPartyDTO);
    List<ThirdParty> getThirdParties();

    void makeThirdPartySendTransaction(ThirdPartyDTO thirdPartyDTO, Long targetId, Money transactionAmount);

    void makeThirdPartyReceiveTransaction(ThirdPartyDTO thirdPartyDTO, Long requesterId, Money transactionAmount);
}
