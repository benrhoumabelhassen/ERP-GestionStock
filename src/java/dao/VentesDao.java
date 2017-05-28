/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Ventes;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author benrh
 */
public class VentesDao {
    static Session session=null;
    public static void insert(Ventes e){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.save(e);
        ts.commit();
        session.flush();
    }
    public static Ventes findById(int id){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        Ventes prov = (Ventes)session.get(Ventes.class,id);
        ts.commit();
        session.flush();
        return prov;
    }
    public static List<Ventes> getAll(){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        List<Ventes> prov = session.createCriteria(Ventes.class).list();
        ts.commit();
        session.flush();
        return prov;
    }
    
    public static void delete(Ventes p){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.delete(p);
        ts.commit();
        session.flush();
    }
    public static void update(Ventes p){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.merge(p);
        ts.commit();
        session.flush();
    }
    public static int getPrice(){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        List<Ventes> list = session.createCriteria(Ventes.class).list();
        int nbr = 0;
        for(int i =0;i<list.size();i++){
            Ventes a = list.get(i);
            nbr = nbr + a.getPrixVente().intValue() * Integer.parseInt(a.getQteVendue());
        }
        ts.commit();
        session.flush();
        return nbr;
    }
 
}

