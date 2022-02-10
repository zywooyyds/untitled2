package com.sy.service.impl;


import com.sy.entity.Brand;
import com.sy.mapper.BrandMapper;
import com.sy.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.sy.constant.BusinessConstant.*;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<Brand> selectBrand() {
            Brand allBrand = new Brand();
            allBrand.setId(ALL_BRAND_ID);
            allBrand.setName(ALL_BRAND_NAME);
            List<Brand> brands = new ArrayList<>();
            brands.add(allBrand);
            brands.addAll(brandMapper.getBrands());
            return brands;
    }
}
