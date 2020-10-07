package com.shop.controllers;


import com.shop.service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class HomePageController {

    @Autowired
    ProductService productService;


    @RequestMapping(value = "/home")
    public ModelAndView homeScreen(ModelAndView model, HttpServletRequest request) throws IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new HashMap<Integer, Integer>());
        }
        model.addObject("products", productService.getProducts());
        model.setViewName("customer");
        return model;
    }


}
