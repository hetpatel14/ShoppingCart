package com.shop.controllers;


import com.shop.model.UserModel;
import com.shop.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {

        model.setViewName("index");
        return model;
    }


    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ModelAndView register(ModelAndView model, @ModelAttribute UserModel userModel){

        userService.addUser(userModel);
        return new ModelAndView("redirect:/");
    }


}
