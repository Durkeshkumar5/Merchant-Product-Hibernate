package org.jsp.Merchant_Product_app.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.Merchant_Product_app.dao.MerchantDao;
import org.jsp.Merchant_Product_app.dao.ProductDao;
import org.jsp.Merchant_Product_app.dto.Merchant;
import org.jsp.Merchant_Product_app.dto.Product;

public class MerchantProductController {
	
	static Scanner sc=new Scanner(System.in);

	
	public static void main(String[] args) {
		
		System.out.println("========> : Options To Select : <========");
		System.out.println();
		System.out.println();
		System.out.println("1.Save Merchant : ");
		System.out.println("2.Update Merchant : ");
		System.out.println("3.Find Merchant by Id : ");
		System.out.println("4.Find Merchant by Name and Password : ");
		System.out.println("5.Find Merchant by Product Id :");
		
		System.out.println("6.Add Product : ");
		System.out.println("7.Update Product : ");
		System.out.println("8.Find Product by Id : ");
		System.out.println("9.Find Product by Merchant Name : ");
		System.out.println("10.Find Product by Merchant gst_num and Password : ");
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		System.out.println("Enter the Choice : ");
		int select=sc.nextInt();

		switch(select)
		{
		case 1:
			Merchant m1 = MerchantDao.saveMerchant(new Merchant());
			System.out.println();
			System.out.println();
			System.out.println(m1);
			break;
		case 2:
			System.out.println("Enter the Merchant Id to Update : ");
			int mid1=sc.nextInt();
			
			Merchant m2 = MerchantDao.updateMerchant(mid1);
			if(m2!=null)
			{
				System.out.println(m2);
			}
			break;
			
		case 3:
			System.out.println("Enter the Merchant Id : ");
			int mid2=sc.nextInt();
			Merchant merchant=MerchantDao.findMerchant(mid2);
			if(merchant !=null)
			{
				System.out.println(merchant);
			}
			break;
			
		case 4:
			sc.nextLine();
			System.out.println("Enter the Merchant Name : ");
			String mname=sc.nextLine();
			
			System.out.println("Enter the Merchant Password : ");
			String mpass=sc.nextLine();
			
			Merchant m4=MerchantDao.findMerchantByNameAndPassword(mname, mpass);
			if(m4!=null)
			{
				System.out.println(m4);
			}
			break;
			
		case 5:
			sc.nextLine();
			System.out.println("Enter the Product Id : ");
			int pId=sc.nextInt();
			
			Merchant m5=ProductDao.findMerchantByProductId(pId);
			
			if(m5!=null)
			{
				System.out.println();
				System.out.println(m5);
			}
			break;
			
			
		case 6:
			Product p=ProductDao.saveProduct(new Product());
			System.out.println();
			System.out.println();
			System.out.println(p);
			break;
			
		case 7:
			System.out.println("Enter the Product Id to Update : ");
			int pid1=sc.nextInt();

			Product p1=ProductDao.updateProduct(pid1);
			
			if(p1!=null)
			{
				System.out.println(p1);
			}
			break;
			
		case 8:
			System.out.println("Enter the Product Id : ");
			int pid2=sc.nextInt();
			Merchant product=MerchantDao.findMerchant(pid2);
			if(product !=null)
			{
				System.out.println(product);
			}
			break;
			
		case 9:
			sc.nextLine();
			
			System.out.println("Enter the  Merchant name to find Product : ");
			String mName=sc.nextLine();
			
			List<Product> products=ProductDao.findProductByMercahntName(mName);
			
			for(Product prd:products)
			{
				System.out.println();
				System.out.println(prd);
			}
			break;
			
		case 10:
			sc.nextLine();
			
			System.out.println("Enter the GST_Number :");
			String gstNum=sc.nextLine();
			
			System.out.println("Enter the Password : ");
			String pass=sc.nextLine();
			
			List<Product>prods=ProductDao.findProductByGstNumAndPassword(gstNum,pass);
			
			if(prods.isEmpty())
			{
				System.out.println("Product not Found : ");
			}
			else
			{
				for(Product prd:prods)
				{
					System.out.println();
					System.out.println(prd);
				}
			}
			
		}
		
	}
}
