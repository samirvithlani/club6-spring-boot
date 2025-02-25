package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ProductBean;
import com.dao.ProductDao;

@RestController
public class ProductController {

	@Autowired
	ProductDao productDao;

	@PostMapping(value = "/product")
	public ResponseEntity<?> addProduct(@RequestBody ProductBean productBean) {

		int res = productDao.addProduct(productBean);
		if (res > 0) {

			return new ResponseEntity<ProductBean>(productBean, HttpStatus.CREATED);
		}

		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
