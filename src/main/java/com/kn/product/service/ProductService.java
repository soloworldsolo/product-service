
package com.kn.product.service;
import java.util.List;

import com.kn.product.model.Product;

public interface ProductService {


	Product findById(long id);
	
	Product findByName(String name);
	
	void saveProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProductById(long id);

	List<Product> findAllProduct();
	
	void deleteAllProduct();
	
	boolean isProductExist(Product product);

	List<Product> getProductId();

	void updateProductId(List<Product> product);

	String size();

	void softDeleteProduct(Product product);

}
