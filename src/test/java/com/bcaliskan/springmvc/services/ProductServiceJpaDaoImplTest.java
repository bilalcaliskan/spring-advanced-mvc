package com.bcaliskan.springmvc.services;

import com.bcaliskan.springmvc.config.JpaIntegrationConfig;
import com.bcaliskan.springmvc.domain.Product;
import lombok.NonNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.Objects;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class ProductServiceJpaDaoImplTest {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void testListMethod() throws Exception {
        List<Product> products = (List<Product>) productService.listAll();
        assert products.size() == 5;
    }

    @Test
    public void testGetByIdMethod() {
        Integer id = 1;
        Product product = productService.getById(id);
        assert Objects.nonNull(product);
    }

}