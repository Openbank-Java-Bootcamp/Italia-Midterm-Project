package com.ironhack.bankingsystem.controller.impl.accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.bankingsystem.models.Address;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.Checking;
import com.ironhack.bankingsystem.models.users.AccountHolder;
import com.ironhack.bankingsystem.repository.accounts.AccountRepository;
import com.ironhack.bankingsystem.repository.accounts.CheckingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ActiveProfiles("test")
@SpringBootTest
class CheckingControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    private CheckingRepository checkingRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();


/*        Checking checking1 = new Checking(new Money(BigDecimal.valueOf(2560)), new AccountHolder("Mariona Velazquez", "mariona", "1234", new ArrayList<>(),
                new ArrayList<>(), (LocalDate.of(Integer.parseInt("2001"), Integer.parseInt("02"), Integer.parseInt("27"))),
                new Address("C/ Alcorcón, 7", "Ronda", "Spain", "11005"),
                new Address("C/ Alcorcón, 7", "Ronda", "Spain", "11005"))), );
        Checking checking2 = new Checking();

        checkingRepository.saveAll(List.of(checking1, checking2));*/
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveChecking() {
        MvcResult mvcResult = mockMvc.perform(get("/checkings"));
    }

    @Test
    void getCheckings() {
    }

    @Test
    void getBalance() {
    }

    @Test
    void modifyBalance() {
    }
}