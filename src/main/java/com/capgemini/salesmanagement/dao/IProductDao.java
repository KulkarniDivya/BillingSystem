package com.capgemini.salesmanagement.dao;

import com.capgemini.salesmanagement.bean.Product;

public interface IProductDao {
	Product getProductDetails(int productCode);
	boolean insertSalesDetail(Product product);
}
