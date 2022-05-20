package com.ironhack.bankingsystem.service.impl.users;

import com.ironhack.bankingsystem.DTO.userDTOs.ThirdPartyDTO;
import com.ironhack.bankingsystem.models.users.ThirdParty;
import com.ironhack.bankingsystem.repository.users.ThirdPartyRepository;
import com.ironhack.bankingsystem.service.interfaces.users.IThirdPartyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ThirdPartyService implements IThirdPartyService {

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ThirdParty saveThirdParty(ThirdPartyDTO tPDTO) {
        ThirdParty thirdParty = new ThirdParty(tPDTO.getName(), tPDTO.getHashedKey());
        log.info("Saving Third Party {} in database", tPDTO.getName());

        return thirdPartyRepository.save(thirdParty);
    }

    public List<ThirdParty> getThirdParties() {
        log.info("Fetching all Third Parties");
        return thirdPartyRepository.findAll();
    }
}
