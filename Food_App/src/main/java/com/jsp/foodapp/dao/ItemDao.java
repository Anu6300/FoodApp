package com.jsp.foodapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entities.Item;
import com.jsp.foodapp.entities.User;


@Repository
public class ItemDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	public void saveItem(Item i)
	{
		EntityManager em= emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(i);
		et.commit();
		
	}
	public Item viewItemById(int id)
	{

		EntityManager em=emf.createEntityManager();
		Item i=em.find(Item.class, id);
		return i;
	}
	
	public void updateItem(Item i)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.merge(i);
		et.commit();
	}
	
	public void deleteItem(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Item i=em.find(Item.class, id);
		et.begin();
		em.remove(i);
		et.commit();
	}
	

}
