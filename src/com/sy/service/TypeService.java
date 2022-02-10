package com.sy.service;

import com.sy.entity.Type;

import java.util.List;

public interface TypeService {
    List<Type> getTypesByBrandId(String brandId);
}
