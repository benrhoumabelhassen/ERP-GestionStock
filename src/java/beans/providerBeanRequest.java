/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ProviderDao;
import entity.Fournisseurs;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author benrh
 */
@Named
@RequestScoped
public class providerBeanRequest {
    public String delete(Fournisseurs provider){
        ProviderDao.delete(provider);
        return "provider.xhtml?faces-redirect=true";
    }
    public String update(int id){
        return "provider-update.xhtml?faces-redirect=true&id="+id;
    }
    public String updateProvider(Fournisseurs provider){
        ProviderDao.update(provider);
        return "provider.xhtml?faces-redirect=true";
    }
    public String addProvider(Fournisseurs provider){
        ProviderDao.insert(provider);
        return "provider.xhtml?faces-redirect=true"; 
    }
}
