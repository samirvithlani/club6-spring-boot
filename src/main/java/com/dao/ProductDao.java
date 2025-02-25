package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ProductBean;

@Repository
public class ProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addProduct(ProductBean productBean) {

		return jdbcTemplate.update("insert into products(pname,pprice)values(?,?)", productBean.getpName(),
				productBean.getpPrice());
	}

}
