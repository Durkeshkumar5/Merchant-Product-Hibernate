package org.jsp.Merchant_Product_app.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.query.Query;
import org.jsp.Merchant_Product_app.dto.Merchant;
import org.jsp.Merchant_Product_app.dto.Product;



public class ProductDao {
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
	static EntityManager em=emf.createEntityManager();
	static Scanner sc=new Scanner(System.in);
	
	//6.Save Product
	public static Product saveProduct(Product p) {
		
		EntityTransaction etran=em.getTransaction();
		
		System.out.println("Enter the Product Name : ");
		String pName=sc.nextLine();
		
		p.setName(pName);
		
		System.out.println("Enter the Product Brand : ");
		String pBrant=sc.nextLine();
		
		p.setBrand(pBrant);
		
		System.out.println("Enter the Product Category : ");
		String pCategory=sc.nextLine();
		
		p.setCategory(pCategory);
		
		System.out.println("Enter the Product Price : ");
		double pPrice=sc.nextDouble();
		
		p.setPrice(pPrice);
		
		System.out.println("Enter the Merchant Id : ");
		int mId=sc.nextInt();
		sc.nextLine();
		
		Merchant m=em.find(Merchant.class, mId);
		
		if(m==null)
		{
			System.out.println();
			System.out.println("Merchant Id Not found");
			return null;
		}
		
		p.setM(m);
		
		
		etran.begin();
		em.persist(p);
		etran.commit();
		
		System.out.println("Product Saved Sucessfully");
		
		return p;
	}
	
	//7.Update Product
	public static Product updateProduct(int id)
	{
		EntityTransaction etran=em.getTransaction();
		
		Product p=em.find(Product.class,id);
		
		if(p==null)
		{
			System.out.println();
			System.out.println("Product not found");
			return null;
		}
		
		System.out.println("Enter the Product Name : ");
		String pName=sc.nextLine();
		
		p.setName(pName);
		
		System.out.println("Enter the Product Brand : ");
		String pBrand=sc.nextLine();
		
		p.setBrand(pBrand);
		
		System.out.println("Enter the Product Category : ");
		String pCategory=sc.nextLine();
		
		p.setCategory(pCategory);
		
		System.out.println("Enter the Product Price : ");
		double pDouble=sc.nextDouble();
		
		p.setPrice(pDouble);
		
		System.out.println("Enter the Merchant Id : ");
		int mId=sc.nextInt();
		sc.nextLine();
		
		Merchant m=em.find(Merchant.class, mId);
		
		if(m!=null)
		{
			p.setM(m);
		}
		
		
		etran.begin();
		em.merge(p);
		etran.commit();
		
		System.out.println("Product is Updated Sucessfully");
		
		return p;
	}
	
	//8.Find the Product Id :
	public static Product findProduct(int id)
	{
		Product product=em.find(Product.class,id);
		
		if(product!=null)
		{
			return product;
		}
		else
		{
			System.out.println("Product Id Not Found : ");
			return null;
		}
	}
	//9.Find Product by Merchant Name :

	public static List<Product> findProductByMercahntName(String mName) {
		
		
		Query<Product>query=(Query<Product>)em.createQuery("from Product p where p.m.name = :name");
		query.setParameter("name",mName);
		return query.getResultList();
	}
	//10.Find Product by GST_Number and Password 
	public static List<Product> findProductByGstNumAndPassword(String gstNum, String pass) {
		
		Query<Product>query=(Query<Product>)em.createQuery("from Product p where p.m.gst_num=:gst_num and p.m.password=:password");
		
		query.setParameter("gst_num",gstNum);
		query.setParameter("password",pass);
		
		return query.getResultList();
	}
	
	//5.Find Merchant by Product Id :
	public static Merchant findMerchantByProductId(int pId) {
		Product p=em.find(Product.class,pId);
		if(p!=null)
		{
			return p.getM();
		}
		System.out.println("Product Id Not Found : ");
		return null;
	}
	
	
}
