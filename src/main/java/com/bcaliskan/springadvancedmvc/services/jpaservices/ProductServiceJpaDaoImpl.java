package com.bcaliskan.springadvancedmvc.services.jpaservices;

import com.bcaliskan.springadvancedmvc.commands.ProductForm;
import com.bcaliskan.springadvancedmvc.converters.ProductFormToProduct;
import com.bcaliskan.springadvancedmvc.domain.Product;
import com.bcaliskan.springadvancedmvc.services.ProductService;
import com.bcaliskan.springadvancedmvc.services.SendTextMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class ProductServiceJpaDaoImpl extends AbstractJpaDaoService implements ProductService {

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
    public List<Product> listAll() {
        sendTextMessageService.sendTextMessage("Listing products");

        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getById(Integer id) {
        sendTextMessageService.sendTextMessage("Requested product ID: " + id);

        EntityManager em = emf.createEntityManager();
        return em.find(Product.class, id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Product savedProduct = em.merge(domainObject);
        em.getTransaction().commit();

        return savedProduct;
    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        return saveOrUpdate(productFormToProduct.convert(productForm));
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
    }
}