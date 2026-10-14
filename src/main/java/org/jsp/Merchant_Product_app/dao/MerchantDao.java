package org.jsp.Merchant_Product_app.dao;

import java.util.Scanner;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.Merchant_Product_app.dto.Merchant;
import org.jsp.Merchant_Product_app.dto.Product;

public class MerchantDao {
	
	static EntityManagerFactory emf =Persistence.createEntityManagerFactory("M15");
	static EntityManager em=emf.createEntityManager();
	static Scanner sc=new Scanner(System.in);
	
	//1.Save Merchant
	public static Merchant saveMerchant(Merchant m)
	{
		
		EntityTransaction etran=em.getTransaction();
		
		
		System.out.println("Enter the Merchant Name :");
		String mName=sc.nextLine();
		
		m.setName(mName);
		
		
		System.out.println("Enter the Merchan GST_Number :");
		String mGST=sc.nextLine();
		
		m.setGst_num(mGST);
		
		System.out.println("Enter the Merchant Email  :");
		String mEmail=sc.nextLine();
		
		m.setEmail(mEmail);
		
		System.out.println("Enter the Merchant PhoneNumber  :");
		long mPhone=sc.nextLong();
		sc.nextLine();
		
		m.setPhone(mPhone);
		
		System.out.println("Enter the Merchant Password  :");
		String mPass=sc.nextLine();
		
		m.setPassword(mPass);
		
		etran.begin();
		em.persist(m);
		etran.commit();
		
		System.out.println("Merchant Saved Sucessfully : ");
		
		return m;
		
	}
	//2.Update the Merchant
	public static Merchant updateMerchant(int id)
	{
		EntityTransaction etran=em.getTransaction();
		
		Merchant m=em.find(Merchant.class,id);
		if(m==null)
		{
			System.out.println();
			System.out.println("Merchant Not Found");
			return null;
		}
		
		System.out.println("Enter the Merchant Name : ");
		String mName=sc.nextLine();
		m.setName(mName);
		
		System.out.println("Enter the Merchant GST_Number : ");
		String mGst=sc.nextLine();
		m.setGst_num(mGst);
		
		System.out.println("Enter the Merchant Email : ");
		String mEmail=sc.nextLine();
		m.setEmail(mEmail);
		
		System.out.println("Enter the Merchant Phone_Number : ");
		long mPhone=sc.nextLong();
		sc.nextLine();
		m.setPhone(mPhone);
		
		System.out.println("Enter the Merchant Password : ");
		String mPass=sc.nextLine();
		m.setPassword(mPass);
		
		etran.begin();
		em.merge(m);
		etran.commit();
		
		System.out.println("Merchant Updated Sucessfully ");
		
		
		return m;
	}
	//3.Find Merchant By Id
	public static Merchant findMerchant(int id)
	{
		 Merchant merchant = em.find(Merchant.class, id);

		    if (merchant != null) {
		        return merchant;
		    } else {
		        System.out.println("Merchant Not Found");
		        return null;
		    }
	}
	//4.Find Merchant by Name and Password
	public static Merchant findMerchantByNameAndPassword(String name, String password)
	{
		String jpql1="Select m from Merchant m where m.name=?1 and m.password=?2";
		
		Query q = em.createQuery(jpql1, Merchant.class);

	    q.setParameter(1, name);
	    q.setParameter(2, password);

	    try {
	        return (Merchant) q.getSingleResult();
	    }
	    catch(Exception e) {
	        System.out.println("Invalid Name or Password");
	        return null;
	    }
	}
	
	
	
	
}
