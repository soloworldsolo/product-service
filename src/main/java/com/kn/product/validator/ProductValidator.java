package com.kn.product.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kn.product.model.Product;


@Component
public class ProductValidator implements Validator {

	private final static String PRODUCT_ID = "productId";

	private final static String PRODUCT_NAME = "productName";

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("withint validate......................................................");
		Product product = (Product) target;

		
		ValidationUtils.rejectIfEmpty(errors, "productName", "product.name.empty");
		String productName = product.getProductName();
		
		if (productName.length() <= 3 || productName.length() > 255) {
			errors.rejectValue(PRODUCT_NAME, "product.productName.min3Max255");
		}
		System.out.println("End  validate......................................................");

	}

}
