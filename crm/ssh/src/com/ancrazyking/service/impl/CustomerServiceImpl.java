package com.ancrazyking.service.impl;

import com.ancrazyking.bean.Customer;
import com.ancrazyking.dao.CustomerDao;
import com.ancrazyking.service.CustomerService;
import com.ancrazyking.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;
import java.util.logging.Handler;

/**
 * @author Ancrazyking
 * @date 2018/4/21 11:09
 **/
public class CustomerServiceImpl implements CustomerService
{
    private CustomerDao customerDao;

    //保存客户
    @Override
    public void save(Customer c)
    {
       Session session=HibernateUtils.getCurrentSession();

       Transaction tx=session.beginTransaction();
       try{
           customerDao.save(c);
       }catch (Exception e){
           e.printStackTrace();
           tx.rollback();
       }
       tx.commit();
    }


    //查询所有客户
    @Override
    public List<Customer> getAll()
    {
        Session session=HibernateUtils.getCurrentSession();

        Transaction tx=session.beginTransaction();
        List<Customer> list=customerDao.getAll();
        tx.commit();

        return list;
    }




    @Override
    public List<Customer> getAll(DetachedCriteria detachedCriteria)
    {
        Session session=HibernateUtils.getCurrentSession();

        Transaction tx=session.beginTransaction();
        List<Customer> list=customerDao.getAll(detachedCriteria);
        tx.commit();

        return list;
    }


    public  void setCustomerDao(CustomerDao customerDao){
        this.customerDao=customerDao;
    }
}
