package com.shop.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class AddToCart {


    @RequestMapping(value = "/addToCart")
    public String addToCart(ModelAndView model, HttpServletResponse response, HttpServletRequest request) throws IOException {

        HttpSession session = request.getSession();


        if (request.getSession() == null) {
            response.sendRedirect("login");
        }

        int productID = Integer.parseInt(request.getParameter("id"));

        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");

        request.getSession().removeAttribute("cart");
        if (cart.containsKey(productID)) {

            cart.put(productID, 1 + cart.get(productID));
        } else cart.put(productID, 1);

        float sum = 0.0f;
        for (float f : cart.values()) {
            sum += f;
        }


        session.setAttribute("cart", cart);
        session.setAttribute("counter", cart.size());
        session.setAttribute("totalCounter", sum);

        return "redirect:/home";
    }
}
