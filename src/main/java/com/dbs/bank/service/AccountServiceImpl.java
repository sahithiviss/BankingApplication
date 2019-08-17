package com.dbs.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dbs.bank.model.Account;
import com.dbs.bank.model.Customer;
import com.dbs.bank.repository.AccountRepository;
import com.dbs.bank.repository.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
//	@Autowired
//	private CustomerRepository customerRepository'
    @Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public Optional<List<Account>> findByCustomer(Customer id) {
		// TODO Auto-generated method stub
		return this.accountRepository.findByCustomer(id);
	}

	@Override
	public List<Account> listAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account saveAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}
//	@Override
//	public Account saveAccount(Customer customer,Account account) {
//		// TODO Auto-generated method stub
//		if(findByCustomer(customerRepository.findByPanId(cu))))
//		return accountRepository.save(account);
//	}
	@Override
	public Account findById(long id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id).get();
	}

	@Override
	public Account updateAccount(long id, Account accountDetails) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id).get();
		account.setAccountType(accountDetails.getAccountType());
		account.setBranch(accountDetails.getBranch());
		account.setIfsc(accountDetails.getIfsc());
		return accountRepository.save(account);
	}

	@Override
	public ResponseEntity<?> deleteAccount(long id) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id).get();
		accountRepository.delete(account);
		return ResponseEntity.ok().build();
	}

	@Override
	public Account findByAccountType(Account accountType) {
		// TODO Auto-generated method stub
		return accountRepository.findByAccountType(accountType);
	}

}
