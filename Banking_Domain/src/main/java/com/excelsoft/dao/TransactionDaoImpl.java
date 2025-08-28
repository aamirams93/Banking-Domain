package com.excelsoft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.excelsoft.enties.Account;
import com.excelsoft.enties.Customer;
import com.excelsoft.enties.Transaction;

@Component
public class TransactionDaoImpl implements TransactionDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Transaction transferFunds(long fromId, long toId, int amt) {
		Query fromQuery = em.createQuery("select c from Customer c where c.accountNumber=:n");
		fromQuery.setParameter("n", fromId);
		List<Customer> fromClist = fromQuery.getResultList();
		Query toQuery = em.createQuery("select c from Customer c where c.accountNumber=:m");
		toQuery.setParameter("m", toId);
		List<Customer> toClist = toQuery.getResultList();

		Account fromAccount = em.find(Account.class, fromId);
		if (fromAccount != null) {
			Account toAccount = em.find(Account.class, toId);
			if (toAccount != null) {
				if (fromAccount.getBalanceAmount() >= amt) {
					Transaction fromTran = new Transaction();
					Transaction toTran = new Transaction();
					fromAccount.setBalanceAmount(fromAccount.getBalanceAmount() - amt);
					toAccount.setBalanceAmount(toAccount.getBalanceAmount() + amt);
					for (Customer c : fromClist) {
						toTran.setBeneficiaryName(c.getName());
						fromTran.setFromAccountNumber(fromId);
						fromTran.setBeneficiaryAccountNumber(toId);
						fromTran.setAmount(amt);
						fromTran.setBalanceAmount(fromAccount.getBalanceAmount());
						fromTran.setCust(c);
						em.persist(fromTran);
					}

					for (Customer c : toClist) {

						fromTran.setBeneficiaryName(c.getName());

						toTran.setFromAccountNumber(toId);
						toTran.setBeneficiaryAccountNumber(fromId);
						toTran.setAmount(amt);
						toTran.setBalanceAmount(toAccount.getBalanceAmount());
						toTran.setCust(c);
						em.persist(toTran);
					}
					return fromTran;
				} else {
				}
			}
		}
		return null;
	}

	@Override
	public List<Transaction> fetchTransactionByAccountNo(int cid) {
		Customer c = em.find(Customer.class, cid);
		if (c != null) {
			return c.getTran();
		}
		return null;
	}

	@Override
	@Transactional
	public List<Transaction> fetchTransactions() {
		String jpql = "select t from Transaction t";
		javax.persistence.Query q = em.createQuery(jpql);
		List<Transaction> tlist = q.getResultList();
		return tlist;
	}
	
	
}