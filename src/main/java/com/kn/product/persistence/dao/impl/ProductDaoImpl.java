package com.kn.product.persistence.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kn.product.persistence.dao.AbstractDao;
import com.kn.product.service.model.Product;

@Repository
public class ProductDaoImpl extends AbstractDao<Long, Product> implements ProductDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductId() {
		return (List<Product>) getSession().createQuery("from Product where recordStatus is NULL ").getResultList();
	}

	/**
	 * Update MDM Ids, for a bunch or SFDC Ids.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void updateProductId(List<Product> productList) {
		if (productList.size() > 0)
			updateBulk(productList);
	}

}
