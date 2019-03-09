package com.capgemini.salesmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

import com.capgemini.salesmanagement.bean.Product;
import com.capgemini.salesmanagement.utility.Database;

public class ProductDao implements IProductDao {
	Database db = new Database();
	Connection connection = db.getConnection();
	public Product getProductDetails(int productCode) {
		// TODO Auto-generated method stub
		Product productBean = new Product();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from product where product_code = ?");
			ps.setInt(1, productCode);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				productBean.setCode(productCode);
				productBean.setName(rs.getString(2));
				productBean.setCategory(rs.getString(3));
				productBean.setDescription(rs.getString(4));
				productBean.setPrice(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productBean;
	}

	public boolean insertSalesDetail(Product product) {
		// TODO Auto-generated method stub
		boolean isInsert = false;
		int line_total = product.getPrice() * product.getQuantity();  
		try {
			PreparedStatement ps = connection.prepareStatement("insert into sales values(?,?,?,?,?)");
			ps.setInt(1, 10000 + new Random().nextInt(90000));
			ps.setInt(2, product.getCode());
			ps.setInt(3, product.getQuantity());
			ps.setDate(4,Date.valueOf(LocalDate.now()));
			ps.setInt(5, line_total);
			int i = ps.executeUpdate();
			if(i == 1)
				isInsert = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isInsert;
	}

}
