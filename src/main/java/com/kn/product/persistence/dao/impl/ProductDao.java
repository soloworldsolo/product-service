package com.kn.product.persistence.dao.impl;

import java.util.List;

import com.kn.product.service.model.Product;

public interface ProductDao {


	List<Product> getProductId();

	void updateProductId(List<Product> productInfoList);

	void saveOrUpdate(Product product);

	void update(Product product);

	void remove(Product product);
}
