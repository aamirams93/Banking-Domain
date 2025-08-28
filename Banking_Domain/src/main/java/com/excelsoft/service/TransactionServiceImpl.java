package com.excelsoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excelsoft.dao.TransactionDao;
import com.excelsoft.enties.Transaction;
import com.excelsoft.exceptions.RecordNotFoundException;

@Component
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionDao tranDao;

	@Override
	@Transactional
	public Transaction transferFundsService(long fromId, long toId, int amt) {

		Transaction t = tranDao.transferFunds(fromId, toId, amt);
		
		if (t == null) {
			String msg = "Account Number " + fromId + " or " + toId + " Not Found " +"or Insufficient Balance in Your Account";
			throw new RecordNotFoundException(msg);
		}
		return t;
	}

	@Override
	@Transactional
	public List<Transaction> fetchTransactionByAccountNoService(int cid) {

	return tranDao.fetchTransactionByAccountNo(cid);
	}
	@Override
	@Transactional
	public List<Transaction> fetchTransactionsService() {
		return tranDao.fetchTransactions();

	}



}
