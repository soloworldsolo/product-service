
package com.kn.product.service;
import java.util.List;

import com.kn.product.exception.ProductException;
import com.kn.product.exception.ProductNotFoundException;
import com.kn.product.model.Product;

public interface ProductService {


	Product findById(long id) throws ProductNotFoundException;
	
	Product findByName(String name) throws ProductNotFoundException;
	
	void saveProduct(Product product) throws ProductException;
	
	void updateProduct(Product product) throws ProductException;
	
	void deleteProductById(long id);

	List<Product> findAllProduct();
	
	void deleteAllProduct();
	
	boolean isProductExist(Product product);

	List<Product> getProductId();

	void updateProductId(List<Product> product);

	String size();

	void softDeleteProduct(Product product);

}
