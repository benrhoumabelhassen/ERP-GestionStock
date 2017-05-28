/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.AchatDao.session;
import static dao.ProduitsDao.session;
import entity.Produits;
import entity.Users;
import entity.Utilisateurs;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author benrh
 */
public class loginDao {
    static Session session=null;
    public static Utilisateurs login(String email,String pass){
        Utilisateurs user = null;
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        List<Utilisateurs> users = session.createCriteria(Utilisateurs.class).list();
        
        ts.commit();
        session.flush();
        session.close();
        for(int i=0;i<users.size();i++){
            if(users.get(i).getLogin().equals(email) && users.get(i).getPassword().equals(pass)){
                user = users.get(i);
            }
        }
        return user;
    }
    public static void update(Utilisateurs p){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.merge(p);
        ts.commit();
        session.flush();
        session.close();
    }
    
    
}
