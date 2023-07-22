package com.kn.product.service;

import com.kn.product.exception.ProductException;
import com.kn.product.exception.ProductNotFoundException;
import com.kn.product.repository.ProductRepository;
import com.kn.product.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    private ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductId() {
        return productRepository.findByRecordStatusIsNull();
    }

    @Override
    public void updateProductId(List<Product> product) {

        productRepository.saveAll(product);
    }

    @Override
    public Product findById(long id) throws ProductNotFoundException {

        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Product findByName(String name) throws ProductNotFoundException {

        return productRepository.findByProductName(name).orElseThrow(ProductNotFoundException::new);
    }

    public void saveProduct(Product product) throws ProductException {
        try {
            productRepository.save(product);
        }catch (Exception e) {
            throw new ProductException(e.getMessage(),e);
        }

    }

    @Override
    public void updateProduct(Product product) throws ProductException {
        try {
            productRepository.save(product);

        }catch (Exception e) {
           throw new ProductException(e.getMessage() ,e);
        }

    }

    @Override
    public void softDeleteProduct(Product product) {
        productRepository.deleteByEn(product.getEn());

    }

    @Override
    public void deleteProductById(long id) {

        productRepository.deleteById(id);

    }

    @Override

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteAllProduct() {
        productRepository.deleteAll();

    }

    @Override
    public boolean isProductExist(Product product) {
        return productRepository.existsById(product.getEn());
    }

    @Override
    public String size() {
        return productRepository.count() + "";
    }
}