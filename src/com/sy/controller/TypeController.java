package com.sy.controller;

import com.sy.entity.Type;
import com.sy.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("types")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "{brandId}",method = RequestMethod.GET)
    public List<Type> getTypesByBrandId(@PathVariable("brandId")String brandId) {
        List<Type> BrandId = typeService.getTypesByBrandId(brandId);
        return BrandId;
    }
}
