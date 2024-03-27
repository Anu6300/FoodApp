package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entities.FoodOrder;


@Repository
public class FoodOrderDao {
	
	@Autowired
	EntityManagerFactory emf;
	public void saveFoodOrder(FoodOrder f)
	{
		EntityManager em= emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(f);
		et.commit();
	}
	
	public FoodOrder viewFoodOrderById(int id)
	{
		EntityManager em=emf.createEntityManager();
		FoodOrder f=em.find(FoodOrder.class, id);
		return f;
		
	}
	public List<FoodOrder> viewFoodOrders()
	{
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select f from FoodOrder f");
		return query.getResultList();
		
	}
	
	public void updateFoodOrder(FoodOrder f)
	{
		
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.merge(f);
		et.commit();
	}
	
	public void deleteFoodOrder(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		FoodOrder f=em.find(FoodOrder.class, id);
		et.begin();
		em.remove(f);
		et.commit();
		
	}
 

}
