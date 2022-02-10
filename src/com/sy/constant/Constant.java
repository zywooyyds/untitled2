package com.sy.constant;

public class Constant {
    /**Session中验证码的属性名**/
    public static final String SESSION_VALIDATE_CODE_NAME="session_code";

    /**Session中登录用户的属性名**/
    public static final String SESSION_USER_NAME="session_user";
    /**
     * 属性描述: Session中存放登录用户的属性的名字
     */
    public static final String SESSION_USER = "session_user";
    /**
     * 属性描述: 是否选择了自动登录 1-是 0-否
     */
    public static final String AUTO_LOGIN = "true";
    /**
     * 属性描述: Cookie中用于保存登录自动登录用户信息的属性名
     */
    public static final String COOKIE_USER_NAME = "user";
    /**
     * 属性描述: Cookie中用户自动登录信息保留的时长
     */
    public static final Integer COOKIE_USER_NAME_MAX_AGE = 7 * 24 * 60 * 60;

}
