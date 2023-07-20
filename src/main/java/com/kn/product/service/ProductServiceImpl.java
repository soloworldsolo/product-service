package com.kn.product.service;

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
    public Product findById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByProductName(name).orElse(null);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);

    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);

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