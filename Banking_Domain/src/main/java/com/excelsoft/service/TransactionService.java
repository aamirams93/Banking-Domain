package com.excelsoft.service;

import java.util.List;

import com.excelsoft.enties.Transaction;

public interface TransactionService {
	Transaction transferFundsService(long fromId, long toId, int amt);

	List<Transaction> fetchTransactionByAccountNoService(int cid);

	public List<Transaction> fetchTransactionsService();

}
