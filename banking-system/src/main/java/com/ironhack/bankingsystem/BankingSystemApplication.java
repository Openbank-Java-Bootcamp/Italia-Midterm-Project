package com.ironhack.bankingsystem;

import com.ironhack.bankingsystem.DTO.userDTOs.AccountHolderDTO;
import com.ironhack.bankingsystem.models.Address;
import com.ironhack.bankingsystem.models.Role;
import com.ironhack.bankingsystem.service.impl.RoleService;
import com.ironhack.bankingsystem.service.impl.users.AccountHolderService;
import com.ironhack.bankingsystem.service.impl.users.UserService;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


@SpringBootApplication
public class BankingSystemApplication {


	public static void main(String[] args) {
		SpringApplication.run(BankingSystemApplication.class, args);
	}



	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService, RoleService roleService, AccountHolderService accountHolderService) {

		@Autowired
		public Environment environment;

		if(!Arrays.asList(environment.getActiveProfiles()).contains("test")) {

			return args -> {
				roleService.saveRole(new Role(null, "ROLE_USER"));
				roleService.saveRole(new Role(null, "ROLE_ADMIN"));
				roleService.saveRole(new Role(null, "ACCOUNT_HOLDER"));



				accountHolderService.saveAccountHolder(new AccountHolderDTO("John Doe", "john", "1234", new ArrayList<>(),
						new ArrayList<>(), (LocalDate.of(Integer.parseInt("2001"), Integer.parseInt("02"), Integer.parseInt("27"))),
						new Address("C/ Alcorcón, 7", "Ronda", "Spain", "11005"),
						new Address("C/ Alcorcón, 7", "Ronda", "Spain", "11005")));

				accountHolderService.saveAccountHolder(new AccountHolderDTO("Christina Anderson", "chris", "1234", new ArrayList<>(),
						new ArrayList<>(), (LocalDate.of(Integer.parseInt("1983"), Integer.parseInt("06"), Integer.parseInt("12"))),
						new Address("C/ Ilustración, 84", "Madrid", "Spain", "01259"),
						new Address("C/ Ilustración, 84", "Madrid", "Spain", "01259")));


				roleService.addRoleToUser("john", "ROLE_ADMIN");
				roleService.addRoleToUser("chris", "ROLE_ADMIN");


			};

		}
	}
}