package com.shop.controllers;


import com.shop.model.LoginModel;
import com.shop.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView model) throws IOException {
        model.setViewName("login");
        return model;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView loginPost(ModelAndView model, @ModelAttribute LoginModel loginModel, HttpServletRequest request, HttpSession session) throws IOException {

        if(userService.checkUser(loginModel)) {
            System.out.println("login success");model.setViewName("login");}
        HttpSession newSession = request.getSession(); // create session

        return new ModelAndView("redirect:/home");
    }
}
