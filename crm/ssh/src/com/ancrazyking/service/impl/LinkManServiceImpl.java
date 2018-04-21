package com.ancrazyking.service.impl;

import com.ancrazyking.bean.Customer;
import com.ancrazyking.bean.LinkMan;
import com.ancrazyking.dao.CustomerDao;
import com.ancrazyking.dao.LinkManDao;
import com.ancrazyking.service.LinkManService;
import com.ancrazyking.utils.HibernateUtils;

/**
 * @author Ancrazyking
 * @date 2018/4/21 10:46
 **/
public class LinkManServiceImpl implements LinkManService
{

    //一般在Servic层进行事务的配置
    private CustomerDao customerDao;
    private LinkManDao linkManDao;
    @Override
    public void save(LinkMan linkMan)
    {
        HibernateUtils.getCurrentSession().beginTransaction();
        try{
            //根据客户id获得客户对象
            Long cust_id=linkMan.getCust_id();
            Customer customer=customerDao.getById(cust_id);
            //将客户放入LinkMan中表表达关系
            linkMan.setCustomer(customer);
            //保存LinkMan
            linkManDao.save(linkMan);
        }catch(Exception e){
            e.printStackTrace();
            HibernateUtils.getCurrentSession().getTransaction().rollback();
        }
        HibernateUtils.getCurrentSession().getTransaction().commit();
    }

    public void setCustomerDao(CustomerDao customerDao){
        this.customerDao=customerDao;
    }

    public void setLinkManDao(LinkManDao linkManDao){
        this.linkManDao=linkManDao;

    }
}
