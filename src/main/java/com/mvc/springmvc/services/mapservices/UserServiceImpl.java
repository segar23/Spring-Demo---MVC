package com.mvc.springmvc.services.mapservices;

import com.mvc.springmvc.domain.DomainObject;
import com.mvc.springmvc.domain.User;
import com.mvc.springmvc.services.UserService;

import java.util.List;

public class UserServiceImpl extends AbstractMapService implements UserService {

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

    @Override
    protected void loadDomainObjects() {

    }
}
