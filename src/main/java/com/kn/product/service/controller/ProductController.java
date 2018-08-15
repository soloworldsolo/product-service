package com.kn.product.service.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.kn.product.service.ProductService;
import com.kn.product.service.model.Product;
import com.kn.product.util.CustomErrorType;
import com.kn.validator.ProductValidator;


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
	
	@RequestMapping(value = "/v1/product/", method = RequestMethod.POST)
	public ResponseEntity<?> createProduct(@RequestBody @Valid Product product, UriComponentsBuilder ucBuilder) {
		if (productService.isProductExist(product)) {
			logger.error("Unable toc create. A User with name {} already exist", product.getProductName());
			return new ResponseEntity(new CustomErrorType(
					"Unable to create. A User with name " + product.getProductName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		productService.saveProduct(product);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/product/{id}").buildAndExpand(product.getEn()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/v1/product/", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProduct() {
		List<Product> product = productService.getProductId();
		if (product.isEmpty()) {
			System.out.println("product list is empty");
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Product>>((List<Product>) product, HttpStatus.OK);
	}

	@RequestMapping(value = "/v1/product/", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
		logger.info("Listing all  Product : {}", product);

		if (productService.isProductExist(product)) {
			logger.error("Unable to create. A User with name {} already exist", product.getProductName());
			return new ResponseEntity(new CustomErrorType(
					"Unable to create. A User with name " + product.getProductName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		productService.updateProduct(product);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/product/{id}").buildAndExpand(product.getEn()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.OK);

	}

	@RequestMapping(value = "/v1/product/", method = RequestMethod.DELETE)
	public ResponseEntity<?> softDeleteProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
		logger.info("Soft Deleting Product record", product);

		/*if (employeeService.isEmployeeExist(employee) == false) {
			logger.error("Unable to delete employee. As employee does not exist", employee.getPanguthaararPeyar());
			return new ResponseEntity(new CustomErrorType(
					"Unable to create. A User with name " + employee.getPanguthaararPeyar() + " already exist."),
					HttpStatus.CONFLICT);
		}*/
		productService.softDeleteProduct(product);

	//	employeeService.Employee(employee);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/product/{id}").buildAndExpand(product.getEn()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.OK);
	}

}