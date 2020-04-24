package com.bcaliskan.springadvancedmvc.services.mapservices;

import com.bcaliskan.springadvancedmvc.domain.DomainObject;
import com.bcaliskan.springadvancedmvc.domain.User;
import com.bcaliskan.springadvancedmvc.services.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Profile("map")
public class UserServiceMapImpl extends AbstractMapService implements UserService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public User getById(Integer id) {
        return (User) super.getById(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return (User) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

}