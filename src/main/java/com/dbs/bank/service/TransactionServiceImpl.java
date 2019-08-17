package com.dbs.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dbs.bank.model.Account;
import com.dbs.bank.model.Transaction;
import com.dbs.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository=transactionRepository;
	}
	@Override
	public List<Transaction> listAll() {
		// TODO Auto-generated method stub
		return this.transactionRepository.findAll();
	}

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return this.transactionRepository.save(transaction);
	}


	@Override
	public Transaction updateTransaction(long id, Transaction transactionDetails) {
		// TODO Auto-generated method stub
		Transaction transaction = this.transactionRepository.findById(id).get();
		transaction.setAmmount(transactionDetails.getAmmount());
		transaction.setFromAccountNum(transactionDetails.getFromAccountNum());
		transaction.setToAccountNum(transactionDetails.getToAccountNum());
		return transactionRepository.save(transaction);
	}

	@Override
	public ResponseEntity<?> deleteTransaction(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Transaction>> findByAccount(Account id) {
		// TODO Auto-generated method stub
		return this.transactionRepository.findByAccount(id);
	}
	
	@Override
	public Transaction findById(long id) {
		// TODO Auto-generated method stub
		return this.transactionRepository.findById(id).get();
	}

}
