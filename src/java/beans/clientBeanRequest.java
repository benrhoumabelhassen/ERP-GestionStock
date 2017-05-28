/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ClientDao;
import entity.Clients;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author benrh
 */
@Named
@RequestScoped
public class clientBeanRequest {
    public String delete(Clients p){
        ClientDao.delete(p);
        return "client.xhtml?faces-redirect=true";
    }
    public String update(int id){
        return "client-update.xhtml?faces-redirect=true&id="+id;
    }
    public String updateC(Clients c){
        ClientDao.update(c);
        return "client.xhtml?faces-redirect=true";
    }
    public String addC(Clients c){
        ClientDao.insert(c);
        return "client.xhtml?faces-redirect=true"; 
    }
}
