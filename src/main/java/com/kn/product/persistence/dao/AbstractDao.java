package com.kn.product.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

//import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kn.product.service.model.Product;

public abstract class AbstractDao<pk extends Serializable, T> {

	private final Class<T> persistentClass;

	@Autowired
	private SessionFactory sessionFactory;

	// @PersistenceContext
	// private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * This method will return the entity object by key.
	 * 
	 * @param key
	 * @return Entity object
	 */
	public T getByKey(pk key) {
		return (T) getSession().get(persistentClass, key);
	}

	/**
	 * This method will save the entity.
	 * 
	 * @param entity
	 */
	public void saveOrUpdate(T entity) {
		System.out.println("saveOrUpdate...");
		getSession().saveOrUpdate(entity);
		getSession().flush();
	}

	public void update(T entity) {
		System.out.println("Update...");
		getSession().update(entity);
		getSession().flush();
	}

	public void remove(T entity) {
		getSession().remove(entity);
		getSession().flush();

	}

	/**
	 * Batch Inserts or Updates
	 * 
	 * @param entitties
	 */
	public void saveOrUpdateBulk(Collection<T> entities) {
		for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
			getSession().saveOrUpdate(iterator.next());
			getSession().flush();
		}
	}

	/**
	 * 
	 * @param entities
	 */
	public void updateBulk(Collection<T> entities) {
		CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
		for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
			CriteriaUpdate<Product> criteriaUpdate = cb.createCriteriaUpdate(Product.class);

			Root<Product> presIdRoot = criteriaUpdate.from(Product.class);
			Product itr = (Product) iterator.next();
			criteriaUpdate.set("mdmId", itr.getEn());
			criteriaUpdate.where(cb.equal(presIdRoot.get("sfdcId"), itr.getProductId()));

			int rowCount = getSession().createQuery(criteriaUpdate).executeUpdate();
			getSession().flush();
		}

	}

	public List<Product> getProductId() {
		// TODO Auto-generated method stub
		return null;
	}

}