/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.VentesDao;
import entity.Clients;
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
    

    public String selectProduit(Produits produit) {
        return "sales-add.xhtml?faces-redirect=true&idprod="+produit.getId();
    }
    public String selectClient(Clients client,int idprod) {
        return "sales-add.xhtml?faces-redirect=true&idprod="+idprod+"&idprov="+client.getId();
    }
    public String delete(Ventes v){
        VentesDao.delete(v);
        return "sales.xhtml?faces-redirect=true";
    }
    public String update(Ventes v){
        return "sales-update.xhtml?faces-redirect=true&id="+v.getId();
    }
    public String updateVente(Ventes vente){
        VentesDao.update(vente);
        return "sales.xhtml?faces-redirect=true";
    }
    public String addVente(Ventes vente){
        VentesDao.insert(vente);
        return "sales.xhtml?faces-redirect=true";
    }
}
