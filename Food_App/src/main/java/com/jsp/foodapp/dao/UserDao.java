package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entities.Admin;
import com.jsp.foodapp.entities.Product;
import com.jsp.foodapp.entities.User;


@Repository
public class UserDao {
	
	@Autowired
	EntityManagerFactory emf;
	public void saveUser(User u)
	{
		EntityManager em= emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(u);
		et.commit();	
	}
	public User viewUserById(int id)
	{

		EntityManager em=emf.createEntityManager();
		User u=em.find(User.class, id);
		return u;
	}
	
	
	public void updateUser(User u)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.merge(u);
		et.commit();
	}
	
	public void deleteUser(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		User u=em.find(User.class, id);
		et.begin();
		em.remove(u);
		et.commit();
	}
	 public User Login(String email,String password)
	 {
		 EntityManager em=emf.createEntityManager();
		 Query query=em.createQuery("select u from User u where u.email=?1 and u.password=?2");
		 query.setParameter(1, email);
		 query.setParameter(2, password);
		 
		List<User> users=query.getResultList();
		if(users.size()>0) return users.get(0);
		else return null;
		 
	 }
 

}
