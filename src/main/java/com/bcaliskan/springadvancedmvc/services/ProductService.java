package com.bcaliskan.springadvancedmvc.services;

import com.bcaliskan.springadvancedmvc.commands.ProductForm;
import com.bcaliskan.springadvancedmvc.domain.Product;

public interface ProductService extends CRUDService<Product> {

    Product saveOrUpdateProductForm(ProductForm productForm);

}
