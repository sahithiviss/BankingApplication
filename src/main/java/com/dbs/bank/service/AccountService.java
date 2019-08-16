package com.dbs.bank.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dbs.bank.model.Account;


public interface AccountService {
	List<Account> listAll();

	Account saveAccount(Account account);

	Account findById(long id);

	Account updateAccount(long id, Account accountDetails);

	ResponseEntity<?> deleteAccount(long id);
}
