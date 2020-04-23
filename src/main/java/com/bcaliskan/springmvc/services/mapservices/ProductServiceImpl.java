package com.bcaliskan.springmvc.services.mapservices;

import com.bcaliskan.springmvc.domain.DomainObject;
import com.bcaliskan.springmvc.domain.Product;
import com.bcaliskan.springmvc.services.ProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@Profile("map")
public class ProductServiceImpl extends AbstractMapService implements ProductService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Product getById(Integer id) {
        return (Product) super.getById(id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        return (Product) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

}
