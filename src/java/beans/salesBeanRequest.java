/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.VentesDao;
import entity.Clients;
import entity.Fournisseurs;
import entity.Produits;
import entity.Ventes;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author benrh
 */
@Named
@RequestScoped
public class salesBeanRequest {
    

    public String selectProd(Produits p) {
        return "sales-add.xhtml?faces-redirect=true&idprod="+p.getId();
    }
    public String selectProv(Clients p,int idprod) {
        return "sales-add.xhtml?faces-redirect=true&idprod="+idprod+"&idprov="+p.getId();
    }
    public String delete(Ventes v){
        VentesDao.delete(v);
        return "sales.xhtml?faces-redirect=true";
    }
    public String update(Ventes v){
        return "sales-update.xhtml?faces-redirect=true&id="+v.getId();
    }
    public String updateV(Ventes v){
        VentesDao.update(v);
        return "sales.xhtml?faces-redirect=true";
    }
    public String addV(Ventes v){
        VentesDao.insert(v);
        return "sales.xhtml?faces-redirect=true";
    }
}
