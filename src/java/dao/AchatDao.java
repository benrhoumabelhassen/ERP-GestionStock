/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Achats;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author benrh
 */
public class AchatDao {
    static Session session=null;
    public static void insert(Achats e){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.save(e);
        ts.commit();
        session.flush();
    }
    public static Achats findById(int id){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        Achats prov = (Achats)session.get(Achats.class,id);
        ts.commit();
        session.flush();
        return prov;
    }
    public static List<Achats> getAll(){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        List<Achats> prov = session.createCriteria(Achats.class).list();
        ts.commit();
        session.flush();
        return prov;
    }
    public static void delete(Achats p){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.delete(p);
        ts.commit();
        session.flush();
    }
    public static void update(Achats p){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.merge(p);
        ts.commit();
        session.flush();
    }
    public static int getPrice(){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        List<Achats> list = session.createCriteria(Achats.class).list();
        int nbr = 0;
        for(int i =0;i<list.size();i++){
            Achats a = list.get(i);
            nbr = nbr + a.getPrixAchat().intValue() * Integer.parseInt(a.getQteAchete());
        }
        ts.commit();
        session.flush();
        return nbr;
    }
}
