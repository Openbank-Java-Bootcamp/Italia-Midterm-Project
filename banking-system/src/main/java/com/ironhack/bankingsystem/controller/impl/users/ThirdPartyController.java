package com.ironhack.bankingsystem.controller.impl.users;

import com.ironhack.bankingsystem.DTO.userDTOs.ThirdPartyDTO;
import com.ironhack.bankingsystem.controller.interfaces.users.IThirdPartyController;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.users.ThirdParty;
import com.ironhack.bankingsystem.service.impl.users.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banking/users")
public class ThirdPartyController implements IThirdPartyController {

    @Autowired
    private ThirdPartyService thirdPartyService;

    @PostMapping("/third-party")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveThirdParty(ThirdPartyDTO thirdPartyDTO) {
        thirdPartyService.saveThirdParty(thirdPartyDTO);
    }

    @GetMapping("/third-party")
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdParty> getThirdParties() {
        return thirdPartyService.getThirdParties();
    }

    @PostMapping("/third-party/send-transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public void makeThirdPartySendTransaction(ThirdPartyDTO thirdPartyDTO, Long targetId, Money transactionAmount) {

    }

    @PostMapping("/third-party/receive-transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public void makeThirdPartyReceiveTransaction(ThirdPartyDTO thirdPartyDTO, Long requesterId, Money transactionAmount) {

    }
}
