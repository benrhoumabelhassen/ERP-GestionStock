/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.AchatDao.session;
import entity.Fournisseurs;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author benrh
 */
public class ProviderDao {
    static Session session=null;
    public static void insert(Fournisseurs e){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.save(e);
        ts.commit();
        session.flush();
        session.close();
    }
    public static Fournisseurs findById(int id){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        Fournisseurs prov = (Fournisseurs)session.get(Fournisseurs.class,id);
        ts.commit();
        session.flush();
        session.close();
        return prov;
    }
    public static List<Fournisseurs> getAll(){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        List<Fournisseurs> prov = session.createCriteria(Fournisseurs.class).list();
        ts.commit();
        session.flush();
        session.close();
        return prov;
    }
    public static void delete(Fournisseurs p){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.delete(p);
        ts.commit();
        session.flush();
        session.close();
    }
    public static void update(Fournisseurs p){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.merge(p);
        ts.commit();
        session.flush();
        session.close();
    }
    public static int getNbrProvider(){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        int nbr = session.createCriteria(Fournisseurs.class).list().size();
        ts.commit();
        session.flush();
        session.close();
        return nbr;
    }
}
