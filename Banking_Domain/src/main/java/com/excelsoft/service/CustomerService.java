package com.excelsoft.service;

import java.util.List;

import com.excelsoft.enties.Customer;

public interface CustomerService {
	Customer addNewCustomer(Customer c);

	Customer searchById(int id);

	Customer updateCustomerDetail(Customer c, int id);

	List<Customer> ListAllCustomerService();
}
