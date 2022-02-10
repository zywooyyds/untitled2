package com.sy.controller;

import com.sy.entity.Price;
import com.sy.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("price")
public class PriceController {
    @Autowired
    private PriceService priceService;
    @RequestMapping(method = RequestMethod.GET)
    public List<Price> getPrice(){
        List<Price> price = priceService.getPrice();
        return price;
    }

}
