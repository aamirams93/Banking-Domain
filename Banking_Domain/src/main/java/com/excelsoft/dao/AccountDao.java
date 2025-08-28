package com.excelsoft.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.excelsoft.enties.Account;

@Component
public interface AccountDao {
	Account openNewAccount(Account a, int id);

	Account serachAccountByNo(long accNo);

	List<Account> ListAllAccount();
}
