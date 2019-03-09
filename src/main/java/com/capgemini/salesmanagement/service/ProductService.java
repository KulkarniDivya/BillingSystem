package com.capgemini.salesmanagement.service;

import com.capgemini.salesmanagement.bean.Product;
import com.capgemini.salesmanagement.dao.IProductDao;
import com.capgemini.salesmanagement.dao.ProductDao;

public class ProductService implements IProductService {
	IProductDao iProductDao = new ProductDao();
	public Product getProductDetails(int productCode) {
		// TODO Auto-generated method stub
		
		return iProductDao.getProductDetails(productCode);
	}

	public boolean insertSalesDetail(Product product) {
		// TODO Auto-generated method stub
		return iProductDao.insertSalesDetail(product);
	}

}
