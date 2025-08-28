package com.excelsoft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import com.excelsoft.enties.User;

@Component
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public User registerNewUser(User user) {
		em.persist(user);
		return user;
	}

	public User searchByUserName(String userName) {
		Query q = em.createQuery("select user from User user where user.userName= :n");
		q.setParameter("n", userName);
		List<User> users = q.getResultList();
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}
}