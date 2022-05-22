package com.ironhack.bankingsystem.DTO;

import com.ironhack.bankingsystem.models.Money;
import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class TransactionDTO {

    private Long requesterAccountId;

    private Long targetAccountId;

    private Money amount;

/*    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UserDetails) {
        String username = ((UserDetails)principal).getUsername();
    } else {
        String username = principal.toString();
    }*/

}
