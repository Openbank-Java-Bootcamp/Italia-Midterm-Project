package com.ironhack.bankingsystem.controller.impl.users;

import com.ironhack.bankingsystem.controller.interfaces.users.IThirdPartyController;
import com.ironhack.bankingsystem.service.impl.users.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banking")
public class ThirdPartyController implements IThirdPartyController {

    @Autowired
    private ThirdPartyService thirdPartyService;
}
