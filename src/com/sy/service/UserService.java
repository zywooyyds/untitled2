package com.sy.service;

import com.sy.dto.Result;
import com.sy.entity.User;
import com.sy.vo.LoginParams;
import com.sy.vo.RegistVo;

import java.util.List;

public interface UserService {
   User regist(RegistVo registVo);

    User login(LoginParams loginParams, String correctValidateCode);
}
