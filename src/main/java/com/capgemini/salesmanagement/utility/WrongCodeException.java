package com.capgemini.salesmanagement.utility;

public class WrongCodeException extends Exception {
	public WrongCodeException()
	{
		System.out.println("Product Code is incorrect");
	}
}
