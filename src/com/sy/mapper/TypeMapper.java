package com.sy.mapper;

import com.sy.entity.Type;

import java.util.List;

public interface TypeMapper {
    List<Type> getTypeByBrandId(Integer brandId);
}
