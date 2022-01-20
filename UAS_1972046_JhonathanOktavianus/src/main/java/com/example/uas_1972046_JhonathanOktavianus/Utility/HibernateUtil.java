package com.example.uas_1972046_JhonathanOktavianus.Utility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 1972046 - Jhonathan Oktavianus
 */
public class HibernateUtil {
    public static Session getSession(){
        SessionFactory sf;

        sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session s;
        s = sf.openSession();
        return s;
    }
}
