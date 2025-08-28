package com.excelsoft.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.excelsoft.enties.Customer;

@Component
public interface CustomerDao {
	Customer addNewCustomer(Customer c);

	Customer searchById(int id);

	Customer updateCustomerDetail(Customer c, int id);

	List<Customer> ListAllCustomer();
}
