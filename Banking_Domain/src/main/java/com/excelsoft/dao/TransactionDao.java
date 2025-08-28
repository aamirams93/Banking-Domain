package com.excelsoft.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.excelsoft.enties.Transaction;

@Component
public interface TransactionDao {

	Transaction transferFunds(long fromId, long toId, int amt);

	List<Transaction> fetchTransactionByAccountNo(int cid);

	public List<Transaction> fetchTransactions();

	

}
