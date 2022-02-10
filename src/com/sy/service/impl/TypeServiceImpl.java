package com.sy.service.impl;

import com.sy.entity.Type;
import com.sy.exception.BusinessException;
import com.sy.mapper.TypeMapper;
import com.sy.service.TypeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.sy.constant.BusinessConstant.*;
import static com.sy.constant.RegexConstant.NUM_REGEX;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<Type> getTypesByBrandId(String brandIdstr) {

            if (StringUtils.isBlank(brandIdstr)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"品牌编号不能为空");
            }
            if (!brandIdstr.matches(NUM_REGEX)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"品牌编号必须为数字");
            }
            int brandId = Integer.parseInt(brandIdstr);
            Type type = new Type();
            type.setId(ALL_TYPE_ID);
            type.setName(ALL_TYPE_NAME);
            List<Type> types = new ArrayList<>();
            //添加“全部”
            types.add(type);
            //添加数据库中所有的信息
            types.addAll(typeMapper.getTypeByBrandId(brandId));
            return types;
    }
}
