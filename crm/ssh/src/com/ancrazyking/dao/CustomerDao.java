package com.ancrazyking.dao;

import com.ancrazyking.bean.Customer;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/4/21 10:01
 **/
public interface CustomerDao
{
    //保存客户
    void save(Customer customer);

    //查询所有客户
    List<Customer> getAll();

    //根据id获得客户
    Customer getById(Long cust_id);


    //有点迷啊
    //根据条件查询所有客户
    List<Customer> getAll(DetachedCriteria detachedCriteria);


}
