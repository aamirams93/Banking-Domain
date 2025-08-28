package com.excelsoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excelsoft.dao.CustomerDao;
import com.excelsoft.enties.Customer;
import com.excelsoft.exceptions.RecordNotFoundException;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao custDao;

	@Override
	@Transactional
	public Customer addNewCustomer(Customer c) {
		Customer ca = custDao.addNewCustomer(c);
		if (c == null) {
			String msg = "Customer id " + ca + " not found";
			throw new RecordNotFoundException(msg);
		}
		return ca;
	}

	@Override
	@Transactional
	public Customer searchById(int id) {
		Customer c = custDao.searchById(id);
		if (c == null) {
			String msg = "Customer id " + id + " not found";
			throw new RecordNotFoundException(msg);
		}
		return c;
	}

	@Override
	public Customer updateCustomerDetail(Customer c, int id) {
		c = custDao.updateCustomerDetail(c, id);
		if (c == null) {
			String msg = "Customer id " + id + " not found";
			throw new RecordNotFoundException(msg);
		}

		return c;
	}

	@Override
	@Transactional
	public List<Customer> ListAllCustomerService() {
		return custDao.ListAllCustomer();

	}
}
