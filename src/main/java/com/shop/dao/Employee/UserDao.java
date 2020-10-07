package com.shop.dao.Employee;

import com.shop.model.LoginModel;
import com.shop.model.UserModel;

import java.util.List;

public interface UserDao {

    public void addUser(UserModel user);
    public List<UserModel> getAllUsers();
    public boolean deleteEmployee(UserModel user);
    public boolean checkUser(LoginModel user);
}
