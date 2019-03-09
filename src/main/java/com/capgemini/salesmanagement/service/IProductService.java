package com.capgemini.salesmanagement.service;

import com.capgemini.salesmanagement.bean.Product;

public interface IProductService {
	Product getProductDetails(int productCode);
	boolean insertSalesDetail(Product product);
}
