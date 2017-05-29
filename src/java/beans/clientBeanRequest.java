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
    public String delete(Clients client){
        ClientDao.delete(client);
        return "client.xhtml?faces-redirect=true";
    }
    public String update(int idclient){
        return "client-update.xhtml?faces-redirect=true&id="+idclient;
    }
    public String updateC(Clients client){
        ClientDao.update(client);
        return "client.xhtml?faces-redirect=true";
    }
    public String addC(Clients client){
        ClientDao.insert(client);
        return "client.xhtml?faces-redirect=true"; 
    }
}
