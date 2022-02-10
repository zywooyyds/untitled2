package com.sy.service.impl;

import com.sy.entity.Price;
import com.sy.mapper.PriceMapper;
import com.sy.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.sy.constant.BusinessConstant.ALL_ID;
import static com.sy.constant.BusinessConstant.ALL_NAME;


@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceMapper priceMapper;
    @Override
    public List<Price> getPrice() {
            Price price = new Price();
            price.setId(ALL_ID);
            price.setDesc(ALL_NAME);
            List<Price> prices = new ArrayList<>();
            //添加“全部”
            prices.add(price);
            //添加数据库中所有的信息
            prices.addAll(priceMapper.getPrice());
            return prices;
    }
}
