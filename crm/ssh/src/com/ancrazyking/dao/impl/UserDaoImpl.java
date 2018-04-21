package com.ancrazyking.dao.impl;

import com.ancrazyking.bean.User;
import com.ancrazyking.dao.UserDao;
import com.ancrazyking.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Ancrazyking
 * @date 2018/4/21 10:12
 **/
public class UserDaoImpl implements UserDao
{
    @Override
    public User getByUserCode(String user_code)
    {
        //HQL查询
        //1.获得Session
        Session session= HibernateUtils.getCurrentSession();
        //2.写HQL语句
        String HQL="from User where user_code=?";
        //3.创建查询对象
        Query query=session.createQuery(HQL);
        //4.设置参数
        query.setParameter(0,user_code);
        //5.执行查询,唯一结果集
        User user=(User)query.uniqueResult();
        return user;
    }
}
