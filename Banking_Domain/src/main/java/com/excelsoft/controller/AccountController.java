
package com.excelsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelsoft.enties.Account;
import com.excelsoft.enties.Customer;
import com.excelsoft.service.AccountService;


@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService as;
	@PostMapping( value="/{userId}",consumes = "application/json", produces = "application/json")
	public Account openNewAccount(@RequestBody Account a,@PathVariable("userId") int id) {
		return as.openNewAccountservice(a,id);
	}
	
	@RequestMapping(value= "/{accountNumber}", produces = {"application/json", "application/json"})
	public Account searchAccountByNo(@PathVariable("accountNumber") long accNo) {
		return as.serachAccountByNoService(accNo);
	}
	@RequestMapping()
	public List<Account> allAccount(){
		return as.ListAllAccountService();
		
	}
}
