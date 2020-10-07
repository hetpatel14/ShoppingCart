package com.shop.dao.Employee;

import com.shop.model.LoginModel;
import com.shop.model.UserModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addUser(UserModel userModel) {

        sessionFactory.getCurrentSession().saveOrUpdate(userModel);
        sessionFactory.close();
    }

    @Override
    public List<UserModel> getAllUsers() {
        return null;
    }

    @Override
    public boolean deleteEmployee(UserModel user) {
        return false;
    }

    @Override
    public boolean checkUser(LoginModel user) {

        return true;
    }
}
