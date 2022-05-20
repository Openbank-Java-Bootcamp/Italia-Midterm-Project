package com.ironhack.bankingsystem.controller.impl.users;

import com.ironhack.bankingsystem.DTO.userDTOs.ThirdPartyDTO;
import com.ironhack.bankingsystem.controller.interfaces.users.IThirdPartyController;
import com.ironhack.bankingsystem.models.users.ThirdParty;
import com.ironhack.bankingsystem.service.impl.users.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

    public List<ThirdParty> getThirdParties() {
        return thirdPartyService.getThirdParties();
    }
}
