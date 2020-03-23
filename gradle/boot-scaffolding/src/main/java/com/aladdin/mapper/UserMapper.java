package com.aladdin.mapper;

import com.aladdin.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author lgc
 **/
public interface UserMapper extends BaseMapper<User> {

    List<User> selectUser();
}
