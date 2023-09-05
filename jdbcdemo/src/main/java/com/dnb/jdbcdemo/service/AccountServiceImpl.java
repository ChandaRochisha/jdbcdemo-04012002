package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.repo.AccountRepositoryImpl;

public class AccountServiceImpl implements AccountService {

	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return AccountRepositoryImpl.getInstance().createAccount(account);
	}

	@Override
	public Optional<Account> getAccountById(String accountId) {
		// TODO Auto-generated method stub
		return AccountRepositoryImpl.getInstance().getAccountById(accountId);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return AccountRepositoryImpl.getInstance().getAllAccounts();
	}
	

}