/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.AchatDao.session;
import static dao.VentesDao.session;
import entity.Clients;
import entity.Ventes;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author benrh
 */
public class ClientDao {
    static Session session=null;
    public static void insert(Clients e){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.save(e);
        ts.commit();
        session.flush();
        session.close();
    }
    public static Clients findById(int id){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        Clients prov = (Clients)session.get(Clients.class,id);
        ts.commit();
        session.flush();
        session.close();
        return prov;
    }
    public static List<Clients> getAll(){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        List<Clients> prov = session.createCriteria(Clients.class).list();
        ts.commit();
        session.flush();
        session.close();
        return prov;
    }
    public static void delete(Clients p){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.delete(p);
        ts.commit();
        session.flush();
        session.close();
    }
    public static void update(Clients p){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.merge(p);
        ts.commit();
        session.flush();
        session.close();
    }
    public static int getNbrClient(){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        int nbr = session.createCriteria(Clients.class).list().size();
        ts.commit();
        session.flush();
        session.close();
        return nbr;
    }
}
