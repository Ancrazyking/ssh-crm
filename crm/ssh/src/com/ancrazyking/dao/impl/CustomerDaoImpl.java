package com.ancrazyking.dao.impl;

import com.ancrazyking.bean.Customer;
import com.ancrazyking.dao.CustomerDao;
import com.ancrazyking.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/4/21 10:22
 **/
public class CustomerDaoImpl implements CustomerDao
{
    @Override
    public void save(Customer customer)
    {
        Session session= HibernateUtils.getCurrentSession();
        session.save(customer);
    }


    /**
     *创建Criteria对象,返回该对象的集合.list()
     *
     *
     **/
    @Override
    public List<Customer> getAll()
    {
        Session session=HibernateUtils.getCurrentSession();
        //创建Criteria对象,便于查询单表
        Criteria criteria=session.createCriteria(Customer.class);
        //返回列表的集合
        return criteria.list();
    }


    //session的方法真的多啊
    @Override
    public Customer getById(Long cust_id)
    {
        Session session=HibernateUtils.getCurrentSession();
        return session.get(Customer.class,cust_id);
    }

    /**
     * ???
     * wtf
     *
     * @param detachedCriteria
     * @return
     */
    @Override
    public List<Customer> getAll(DetachedCriteria detachedCriteria)
    {
        Session session=HibernateUtils.getCurrentSession();
        Criteria criteria=detachedCriteria.getExecutableCriteria(session);
        return criteria.list();
    }
}
