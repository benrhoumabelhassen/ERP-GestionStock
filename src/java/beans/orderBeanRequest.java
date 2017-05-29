/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AchatDao;
import entity.Fournisseurs;
import entity.Produits;
import entity.Achats;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author benrh
 */
@Named
@RequestScoped
public class orderBeanRequest {
    public String selectProd(Produits produit) {
        return "order-add.xhtml?faces-redirect=true&idprod="+produit.getId();
    }
    public String selectProv(Fournisseurs provider,int idprod) {
        return "order-add.xhtml?faces-redirect=true&idprod="+idprod+"&idprov="+provider.getId();
    }
    public String delete(Achats v){
        AchatDao.delete(v);
        return "order.xhtml?faces-redirect=true";
    }
    public String update(Achats achat){
        return "order-update.xhtml?faces-redirect=true&id="+achat.getId();
    }
    public String updateV(Achats achat){
        AchatDao.update(achat);
        return "order.xhtml?faces-redirect=true";
    }
    public String addV(Achats achat){
        AchatDao.insert(achat);
        return "order.xhtml?faces-redirect=true";
    }
}
