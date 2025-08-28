package com.excelsoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excelsoft.dao.AccountDao;
import com.excelsoft.enties.Account;
import com.excelsoft.exceptions.RecordNotFoundException;

@Component
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accDao;

	@Override
	@Transactional
	public Account openNewAccountservice(Account a, int id) {
		 a = accDao.openNewAccount(a, id);
		if (a == null) {
			String msg = "Customer with id " + id + " Not found or Acoount already exist";
			throw new RecordNotFoundException(msg);
		}
		return a;
	}

	@Override
	@Transactional
	public Account serachAccountByNoService(long accNo) {

		Account acc = accDao.serachAccountByNo(accNo);
		if (acc == null) {
			String msg = "Account No " + accNo + " not found";
			throw new RecordNotFoundException(msg);
		}
		return acc;
	}

	@Override
	@Transactional
	public List<Account> ListAllAccountService() {
		return accDao.ListAllAccount();

	}
}
