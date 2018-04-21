package com.ancrazyking.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Ancrazyking
 * @date 2018/4/21 10:13
 **/
public class HibernateUtils
{
    private static SessionFactory sessionFactory;

    static
    {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();

    }


    //获得全新Session
    public static Session openSession()
    {
        Session session = sessionFactory.openSession();
        return session;


    }

    public static Session getCurrentSession()
    {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }

    public static void main(String[] args)
    {
        System.out.println(HibernateUtils.openSession());
    }


}
