package com.sy.service.impl;

import com.sy.entity.User;
import com.sy.exception.BusinessException;
import com.sy.mapper.UserMapper;
import com.sy.service.UserService;
import com.sy.vo.LoginParams;
import com.sy.vo.RegistVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User regist(RegistVo registVo) {

           String userName=registVo.getUserName();
           String userPwd=registVo.getUserPwd();
           String userPwdConfirm=registVo.getUserPwdConfirm();
            //1.注册操作中保证用户名不能重复，密码必须是强密码类型，两次输入的密码必须一致
            if (StringUtils.isBlank(userName)) {
              throw new BusinessException(HttpStatus.BAD_GATEWAY,"用户名不能为空");
            }
            User user = userMapper.getUser(userName);
            if (null != user) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"用户名已存在");
            }
            if (StringUtils.isBlank(userPwd) || StringUtils.isBlank(userPwdConfirm)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"密码不能为空");
            }
            if (!StringUtils.equals(userPwd, userPwdConfirm)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"两次密码必须一致");
            }
            //2.将用户数据写入数据库中
        User user1 = new User();
        user1.setName(userName);
        user1.setPwd(DigestUtils.md5Hex(userPwd));
            boolean success = userMapper.addUser(user1);
            if (!success) {
                throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"注册失败");
            }else {
                return user;
            }

    }

    @Override
    public User login(LoginParams loginParams, String correctValidateCode) {

            String userName = loginParams.getUserName();
            String userPwd = loginParams.getUserPwd();
            String validateCode = loginParams.getValidateCode();
            if (StringUtils.isBlank(userName)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"用户名不能为空");
            }
            User user = userMapper.getUser(userName);
            if (null == user) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"用户不存在");
            }
            if (StringUtils.isBlank(userPwd)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"密码不能为空");
            }
            if (!StringUtils.equals(user.getPwd(), DigestUtils.md5Hex(loginParams.getUserPwd()))) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"密码错误");
            }
            if (StringUtils.isBlank(validateCode)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"验证码不得为空");
            }
            if (!StringUtils.equalsIgnoreCase(correctValidateCode, loginParams.getValidateCode())) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"验证码不正确");
            }
        return  user;
    }
}
