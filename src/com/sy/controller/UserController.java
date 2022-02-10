package com.sy.controller;


import com.sy.entity.User;
import com.sy.service.UserService;
import com.sy.vo.LoginParams;
import com.sy.vo.RegistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static com.sy.constant.Constant.*;


@RestController
@RequestMapping("users")
public class UserController{
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest req;
    @RequestMapping(value ="login", method = RequestMethod.POST)
    public User login(@RequestBody LoginParams loginParams) {
        HttpSession session = req.getSession();
        String correctValidateCode = String.valueOf(session.getAttribute(SESSION_VALIDATE_CODE_NAME));
       User login1 = userService.login(loginParams, correctValidateCode);
        return login1;
    }

    @RequestMapping(value ="regist",method = RequestMethod.POST)
    public User regist(@RequestBody RegistVo registVo) {
        User regist = userService.regist(registVo);
        return regist;
    }


}
