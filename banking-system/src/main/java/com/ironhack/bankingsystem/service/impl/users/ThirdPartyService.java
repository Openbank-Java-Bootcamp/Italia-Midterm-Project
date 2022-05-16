package com.ironhack.bankingsystem.service.impl.users;

import com.ironhack.bankingsystem.repository.users.ThirdPartyRepository;
import com.ironhack.bankingsystem.service.interfaces.users.IThirdPartyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ThirdPartyService implements IThirdPartyService {

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;
}
