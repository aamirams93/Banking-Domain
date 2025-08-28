package com.excelsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.excelsoft.enties.Customer;
import com.excelsoft.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	CustomerService cs;
	
	@PostMapping(consumes = "application/json", produces = "application/xml")
	public Customer addNewCustomer(@RequestBody Customer c) {
		return cs.addNewCustomer(c);
	}
	
	@RequestMapping(value= "/{userId}", produces = {"application/json", "application/xml"})
	public Customer searchById(@PathVariable("userId") int id) {
		return cs.searchById(id);
	}
		


	@PutMapping(value= "/{userId}", produces = {"application/json", "application/xml"})
	public Customer updateCustomerDetail(@RequestBody Customer c,@PathVariable("userId") int cid) {
		return cs.updateCustomerDetail(c,cid);
	}
	@RequestMapping()
	public List<Customer> allCustomer(){
		return cs.ListAllCustomerService();
		
	}
}