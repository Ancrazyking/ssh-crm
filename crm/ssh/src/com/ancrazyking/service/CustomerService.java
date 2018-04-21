package com.ancrazyking.service;

import com.ancrazyking.bean.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/4/21 10:43
 **/
public interface CustomerService
{
    //保存客户
    void save(Customer c);

    //获得所有客户
    List<Customer> getAll();

    //根据条件获得所有客户
    List<Customer> getAll(DetachedCriteria detachedCriteria);







}
