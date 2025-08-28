package com.excelsoft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.excelsoft.enties.Customer;

@Component
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Customer addNewCustomer(Customer c) {

		em.persist(c);
		return c;
	}

	@Override
	public Customer searchById(int id) {
		return em.find(Customer.class, id);
	}

	@Override
	@Transactional
	public Customer updateCustomerDetail(Customer c, int id) {

		Customer customer = em.find(Customer.class, id);
		if (customer != null) {
			customer.setName(c.getName());
			customer.setGender(c.getGender());
			customer.setEmail(c.getEmail());
			customer.setContact(c.getContact());
			customer.setAadharNo(c.getAadharNo());
			customer.setAccount(c.getAccount());
			System.out.println("Customer not found.................");
		}
		return customer;
	}

	@Override
	@Transactional
	public List<Customer> ListAllCustomer() {
		String jpql = "select c from Customer c";
		javax.persistence.Query q = em.createQuery(jpql);
		List<Customer> custlist = q.getResultList();
		return custlist;

	}

}
