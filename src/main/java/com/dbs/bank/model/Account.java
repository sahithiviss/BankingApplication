package com.dbs.bank.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

//@Data
@Entity
@Table
public class Account implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long account_id;
	private long accountNum;
	private String accountType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customer_id", nullable = false)
	//@JsonBackReference
	private Customer customer;
	
	private String branch;
	private String ifsc;
	
	public long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(long accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
	
//	public Account(long accountNum, String accountType, Customer customer) {
//		//super();
//		this.accountNum = accountNum;
//		this.accountType = accountType;
//		this.customer = customer;
//	}
    public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(long account_id,long accountNum, String accountType, String branch, String ifsc) {
		this.account_id=account_id;
		this.accountNum = accountNum;
		this.accountType = accountType;
		this.branch = branch;
		this.ifsc = ifsc;
		
	}

	
}
