package com.ancrazyking.service.impl;

import com.ancrazyking.bean.User;
import com.ancrazyking.dao.UserDao;
import com.ancrazyking.service.UserService;
import com.ancrazyking.utils.HibernateUtils;

/**
 * @author Ancrazyking
 * @date 2018/4/21 10:47
 **/
public class UserServiceImpl implements UserService
{
    private UserDao userDao;


    @Override
    public User login(User user)
    {
        userDao.getByUserCode(user.getUser_code());
       //打开事务
        HibernateUtils.getCurrentSession().beginTransaction();
        User existUser=userDao.getByUserCode(user.getUser_code());
        //提交事务
        HibernateUtils.getCurrentSession().getTransaction().commit();

        if(existUser==null){
            throw new RuntimeException("用户名不存在!");
        }
        if(!existUser.getUser_password().equals(user.getUser_password())){
            throw new RuntimeException("密码错误!");
        }

        return existUser;


    }

    //设置UserDao
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }
}