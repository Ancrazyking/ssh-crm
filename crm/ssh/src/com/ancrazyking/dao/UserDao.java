package com.ancrazyking.dao;

import com.ancrazyking.bean.User;

/**
 * @author Ancrazyking
 * @date 2018/4/21 10:01
 **/
public interface UserDao
{
    User getByUserCode(String user_code);
}
