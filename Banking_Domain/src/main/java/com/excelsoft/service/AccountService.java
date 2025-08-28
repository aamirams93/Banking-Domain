package com.excelsoft.service;

import java.util.List;

import com.excelsoft.enties.Account;

public interface AccountService {
	Account openNewAccountservice(Account a, int id);

	Account serachAccountByNoService(long accNo);

	List<Account> ListAllAccountService();

}
