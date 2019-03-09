package com.capgemini.salesmanagement.SalesManagement;

import java.util.Scanner;

import com.capgemini.salesmanagement.bean.Product;
import com.capgemini.salesmanagement.service.IProductService;
import com.capgemini.salesmanagement.service.ProductService;
import com.capgemini.salesmanagement.utility.WrongCodeException;
import com.capgemini.salesmanagement.utility.WrongQuantityException;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner scan = new Scanner(System.in);
    	IProductService iProductService = new ProductService();
    	Product product = new Product();

        	 System.out.println("Enter the product code");
					int productCode1 = scan.nextInt();
					if(productCode1 > 1000 && productCode1 < 1005)
					{
						System.out.println("Enter the quantity:");
						int quantity = scan.nextInt();
						if(quantity > 0)
						{
							product = iProductService.getProductDetails(productCode1);
							product.setQuantity(quantity);
							if(iProductService.insertSalesDetail(product))
							{
								System.out.println("Product Details");
								System.out.println("Product Name:"+product.getName());
								System.out.println("Product Category:"+product.getCategory());
								System.out.println("Product Description:"+product.getDescription());
								System.out.println("Product Price:"+product.getPrice());
								System.out.println("Quantity:"+quantity);
								System.out.println("Line Total(Rs):"+(product.getPrice()*quantity));
							}
						}
						else
						{
							try {
								throw new WrongQuantityException();
							} catch (WrongQuantityException e) {
								// TODO Auto-generated catch block
			
							}
						}
					}
					else
					{
						try {
							throw new WrongCodeException();
						} catch (WrongCodeException e) {
							// TODO Auto-generated catch block
	
						}
					}
       }

	
}
