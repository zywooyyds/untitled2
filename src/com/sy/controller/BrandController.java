package com.sy.controller;

import com.sy.entity.Brand;
import com.sy.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("brands")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @RequestMapping(method = RequestMethod.GET)
    public List<Brand> selectBrand(){
        List<Brand> brand = brandService.selectBrand();
        return brand;
    }
}
