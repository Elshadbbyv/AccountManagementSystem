package com.bbyv.AccountManagementSystem;

import com.bbyv.AccountManagementSystem.model.Account;
import com.bbyv.AccountManagementSystem.model.Customer;
import com.bbyv.AccountManagementSystem.repository.AccountRepository;
import com.bbyv.AccountManagementSystem.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;

@SpringBootApplication
public class AccountManagementSystemApplication implements CommandLineRunner {
	private final CustomerRepository customerRepository;
	private final AccountRepository accountRepository;

	public AccountManagementSystemApplication(CustomerRepository customerRepository,
											  AccountRepository accountRepository) {
		this.customerRepository = customerRepository;
		this.accountRepository = accountRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountManagementSystemApplication.class, args);}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer = customerRepository.save(new Customer("Murad","Azadov"));

		System.out.println(customer.getId());

	}
}
