package com.kn.product.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kn.product.persistence.dao.impl.ProductDao;
import com.kn.product.service.model.Product;

@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public  class ProductServiceImpl implements ProductService {

	@Autowired
	private Environment env;

	@Autowired
	private ProductDao productDao;

	// @Autowired
	// HttpHeaders headers;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	private static String url;

	// @Autowired(required = true)
	private void init() {
		// url = env.getProperty("prescriber.service.endpoint");
		// headers.setContentType(MediaType.APPLICATION_JSON);
		// headers.set
	}

	@Override
	public List<Product> getProductId() {
		return productDao.getProductId();
	}

	@Override
	public void updateProductId(List<Product> product) {
		productDao.updateProductId(product);
	}

	@Override
	public Product findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		System.out.println(product.getProductName());
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(product);
			System.out.println(jsonInString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		productDao.saveOrUpdate(product);

	}

	@Override
	public void updateProduct(Product product) {
		productDao.update(product);

	}

	@Override
	public void softDeleteProduct(Product product) {
		productDao.remove(product);

	}

	@Override
	public void deleteProductById(long id) {
		// TODO Auto-generated method stub

	}

	@Override

	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllProduct() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isProductExist(Product product) {
		// TODO Auto-generated method stub
		System.out.println("is emp");
		return false;
	}

	@Override
	public String size() {
		// TODO Auto-generated method stub
		return null;
	}

}