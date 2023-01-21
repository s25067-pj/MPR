package com.pjatk.s25067Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S25067BankApplication {

	public S25067BankApplication(Bank bank) {
		TransactionInfo testTransfer = bank.cashTransferOrder(
				"4", 200
		);
		System.out.println(testTransfer);
	}

	public static void main(String[] args) {
		SpringApplication.run(S25067BankApplication.class, args);
	}

}
