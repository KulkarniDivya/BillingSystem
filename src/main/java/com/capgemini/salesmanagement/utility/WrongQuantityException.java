package com.capgemini.salesmanagement.utility;

public class WrongQuantityException extends Exception {
	public WrongQuantityException()
	{
		System.out.println("Quantity should not be less than or equal to 0");
	}
}
