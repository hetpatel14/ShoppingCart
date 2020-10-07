package com.shop.service.UserService;

import com.shop.dao.Employee.UserDaoImpl;
import com.shop.model.LoginModel;
import com.shop.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Override
    @Transactional
    public void addUser(UserModel user) {
        userDao.addUser(user);
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
        return userDao.checkUser(user);
    }
}
