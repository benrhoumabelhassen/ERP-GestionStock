/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.AchatDao.session;
import static dao.VentesDao.session;
import entity.Achats;
import entity.Produits;
import entity.Ventes;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author benrh
 */
public class ProduitsDao {
    static Session session=null;
    public static void insert(Produits e){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.save(e);
        ts.commit();
        session.flush();
        session.close();
    }
    public static Produits findById(int id){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        Produits prod = (Produits)session.get(Produits.class,id);
        ts.commit();
        session.flush();
        session.close();
        return prod;
    }
    public static List<Produits> getAll(){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        List<Produits> prod = session.createCriteria(Produits.class).list();
        ts.commit();
        session.flush();
        session.close();
        return prod;
    }
    public static void delete(Produits p){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        List<Ventes> list = session.createCriteria(Ventes.class).list();
        for(int i =0;i<list.size();i++){
            if(list.get(i).getProduits().getId() == p.getId()){
                session.delete(list.get(i));
            }
        }
        List<Achats> list1 = session.createCriteria(Achats.class).list();
        for(int i =0;i<list1.size();i++){
            if(list1.get(i).getProduits().getId() == p.getId()){
                session.delete(list1.get(i));
            }
        }
        session.delete(p);
        ts.commit();
        session.flush();
        session.close();
    }
    public static void update(Produits p){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.merge(p);
        ts.commit();
        session.flush();
        session.close();
    }
    public static int getNbrProduit(){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        int nbr = session.createCriteria(Produits.class).list().size();
        ts.commit();
        session.flush();
        session.close();
        return nbr;
    }
    
}
