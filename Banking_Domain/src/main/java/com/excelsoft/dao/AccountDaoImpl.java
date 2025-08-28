package com.excelsoft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.excelsoft.enties.Account;
import com.excelsoft.enties.Customer;

@Component
public class AccountDaoImpl implements AccountDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Account openNewAccount(Account a, int id) {
		Customer c = em.find(Customer.class, id);
		if (c!= null && c.getAccount()==null) {
			a.setCustomer(c);
			c.setAccountNumber(a.getAccountNumber());
			em.persist(a);
			return a;
		}
		return null;
	}

	@Override
	public Account serachAccountByNo(long accNo) {
		Account a = em.find(Account.class, accNo);
		return a;
	}

	@Override
	@Transactional
	public List<Account> ListAllAccount() {
		String jpql = "select a from Account a";
		javax.persistence.Query q = em.createQuery(jpql);
		List<Account> acclist = q.getResultList();
		return acclist;

	}
}
