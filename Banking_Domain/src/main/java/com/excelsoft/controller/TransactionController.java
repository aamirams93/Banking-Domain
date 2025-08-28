package com.excelsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.excelsoft.enties.Account;
import com.excelsoft.enties.Transaction;
import com.excelsoft.service.TransactionService;


@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService ts;
	
	@RequestMapping( value="/sender/{fromId}/reciever/{toId}/{amt}")
	public Transaction transferFunds(@PathVariable("fromId") long fromId,@PathVariable("toId") long toId,@PathVariable("amt") int amt) {
		return ts. transferFundsService(fromId,toId,amt);
	}
	@RequestMapping(value = "/customer/{cid}")
	public List<Transaction> allTransaction(@PathVariable("cid") int cid) {
	return ts.fetchTransactionByAccountNoService(cid);

	}
	@RequestMapping()
	public List<Transaction> alltransaction(){
		return ts.fetchTransactionsService();
		
	}
}
