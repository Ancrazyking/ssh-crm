package com.ancrazyking.dao.impl;

import com.ancrazyking.bean.LinkMan;
import com.ancrazyking.dao.LinkManDao;
import com.ancrazyking.utils.HibernateUtils;
import org.hibernate.Session;

/**
 * @author Ancrazyking
 * @date 2018/4/21 10:37
 **/
public class LinkManDaoImlp implements LinkManDao
{
    @Override
    public void save(LinkMan linkMan)
    {
        Session session= HibernateUtils.getCurrentSession();
        session.save(linkMan);
    }
}
