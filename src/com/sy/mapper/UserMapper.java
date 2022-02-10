package com.sy.mapper;

import com.sy.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User getUser(@Param("name") String name);

    boolean addUser(User user);
}
