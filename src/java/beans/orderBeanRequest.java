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
    public String selectProd(Produits p) {
        return "order-add.xhtml?faces-redirect=true&idprod="+p.getId();
    }
    public String selectProv(Fournisseurs p,int idprod) {
        return "order-add.xhtml?faces-redirect=true&idprod="+idprod+"&idprov="+p.getId();
    }
    public String delete(Achats v){
        AchatDao.delete(v);
        return "order.xhtml?faces-redirect=true";
    }
    public String update(Achats v){
        return "order-update.xhtml?faces-redirect=true&id="+v.getId();
    }
    public String updateV(Achats v){
        AchatDao.update(v);
        return "order.xhtml?faces-redirect=true";
    }
    public String addV(Achats v){
        AchatDao.insert(v);
        return "order.xhtml?faces-redirect=true";
    }
}
