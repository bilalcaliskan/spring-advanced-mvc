package com.bcaliskan.springadvancedmvc.services.mapservices;

import com.bcaliskan.springadvancedmvc.commands.ProductForm;
import com.bcaliskan.springadvancedmvc.converters.ProductFormToProduct;
import com.bcaliskan.springadvancedmvc.domain.DomainObject;
import com.bcaliskan.springadvancedmvc.domain.Product;
import com.bcaliskan.springadvancedmvc.services.ProductService;
import com.bcaliskan.springadvancedmvc.services.SendTextMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@Profile("map")
public class ProductServiceImpl extends AbstractMapService implements ProductService {

    private ProductFormToProduct productFormToProduct;
    private SendTextMessageService sendTextMessageService;

    @Autowired
    public void setProductFormToProduct(ProductFormToProduct productFormToProduct) {
        this.productFormToProduct = productFormToProduct;
    }

    @Autowired
    public void setSendTextMessageService(SendTextMessageService sendTextMessageService) {
        this.sendTextMessageService = sendTextMessageService;
    }

    @Override
    public List<DomainObject> listAll() {
        sendTextMessageService.sendTextMessage("Listing products");

        return super.listAll();
    }

    @Override
    public Product getById(Integer id) {
        sendTextMessageService.sendTextMessage("Requested product ID: " + id);

        return (Product) super.getById(id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        return (Product) super.saveOrUpdate(domainObject);
    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        return saveOrUpdate(productFormToProduct.convert(productForm));
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

}
