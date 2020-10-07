package com.shop.controllers;

import com.shop.model.ProductModel;
import com.shop.service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class CheckOut {

    @Autowired
    ProductService productService;


    @RequestMapping(value = "/checkout")
    public ModelAndView checkout(ModelAndView model, HttpServletResponse response, HttpServletRequest request) throws IOException {


        HttpSession session = request.getSession();


        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new HashMap<Integer, Integer>());
        }
        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");

        HashMap<ProductModel, Integer> data = new HashMap<ProductModel, Integer>();

        cart.forEach((k, v) -> {
            data.put(productService.getProductByID(k), v);
        });

        session.removeAttribute("cart");
        session.setAttribute("data", data);
        model.setViewName("checkout");
        return model;
    }


    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ModelAndView checkoutPost(ModelAndView model, HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("post checkout");
        HttpSession session = request.getSession();
        HashMap<ProductModel, Integer> data = (HashMap<ProductModel, Integer>) session.getAttribute("data");

        productService.order(data, 1);
        session.removeAttribute("cart");
        session.removeAttribute("counter");
        session.removeAttribute("totalCount");
        response.sendRedirect("/customer");
        model.setViewName("customer");
        return model;

    }

}
