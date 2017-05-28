/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ProviderDao;
import entity.Fournisseurs;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author benrh
 */
@Named
@RequestScoped
public class providerBeanRequest {
    public String delete(Fournisseurs p){
        ProviderDao.delete(p);
        return "provider.xhtml?faces-redirect=true";
    }
    public String update(int id){
        return "provider-update.xhtml?faces-redirect=true&id="+id;
    }
    public String updateP(Fournisseurs p){
        ProviderDao.update(p);
        return "provider.xhtml?faces-redirect=true";
    }
    public String addP(Fournisseurs p){
        ProviderDao.insert(p);
        return "provider.xhtml?faces-redirect=true"; 
    }
}
