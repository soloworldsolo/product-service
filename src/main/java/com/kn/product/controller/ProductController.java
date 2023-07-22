package com.kn.product.controller;

import com.kn.product.exception.ProductException;
import com.kn.product.exception.ProductNotFoundException;
import com.kn.product.model.Product;
import com.kn.product.service.ProductService;
import com.kn.product.validator.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("kn/product-service")
public class ProductController {

    public static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @Autowired
    ProductValidator productValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        // This WebDataBinder set the Date parameters to null in case they are
        // empty
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        dateFormat.setLenient(false);

        // true passed to CustomDateEditor constructor means convert empty
        // String to null
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

        binder.setValidator(productValidator);
    }

    @PostMapping(value = "/v1/product/")
    public ResponseEntity<?> createProduct(@RequestBody @Valid Product product, UriComponentsBuilder ucBuilder) throws ProductException {
        try {
            productService.saveProduct(product);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/api/product/{id}").buildAndExpand(product.getEn()).toUri());
            return new ResponseEntity<String>(headers, HttpStatus.CREATED);

        } catch (Exception e) {
            throw new ProductException(e.getMessage(), e);
        }

    }

    @GetMapping(value = "/v1/product/")
    public ResponseEntity<List<Product>> listAllProduct() {
        List<Product> products = productService.getProductId();
        if (products.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>((List<Product>) products, HttpStatus.OK);
    }

    @PutMapping(value = "/v1/product/")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) throws Exception {
        logger.info("Listing all  Product : {}", product);
        if (productService.isProductExist(product)) {
            logger.error("Unable to create. A User with name {} already exist", product.getProductName());
            throw new ProductNotFoundException("Unable to create. A User with name   product.getProductName()  already exist.");
        }
        try {
            productService.updateProduct(product);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/api/product/{id}").buildAndExpand(product.getEn()).toUri());
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            throw new ProductException(e.getMessage(), e);
        }
    }

    @DeleteMapping(value = "/v1/product/")
    public ResponseEntity<?> softDeleteProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
        logger.info("Soft Deleting Product record", product);
        productService.softDeleteProduct(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/product/{id}").buildAndExpand(product.getEn()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

}