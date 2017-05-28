/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AchatDao;
import dao.ProduitsDao;
import dao.ProviderDao;
import entity.Achats;
import entity.Fournisseurs;
import entity.Produits;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author benrh
 */
@Named
@ViewScoped
public class orderBean implements Serializable{
    private List<Achats> sales;
    private List<Produits> prod;
    private List<Fournisseurs> prov;
    private Achats v;
    private int idprod;
    private int idprov;
    private boolean showProd;
    private boolean showProv;
    private boolean showForm;
    @PostConstruct
    public void init() {
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if(request!=null){
            if(request.getParameter("idprov") != null){
                idprov= Integer.parseInt(request.getParameter("idprov"));
                idprod= Integer.parseInt(request.getParameter("idprod"));
                v = new Achats();
                v.setFournisseurs(ProviderDao.findById(idprov));
                v.setProduits(ProduitsDao.findById(idprod));
                showProv = false;
                showProd = false;
                showForm = true;
            }else if(request.getParameter("idprod") != null){
                idprod= Integer.parseInt(request.getParameter("idprod"));
                prov = ProviderDao.getAll();
                showProv = true;
                showProd = false;
                showForm = false;
            }else{
                prod = ProduitsDao.getAll();
                showProd = true;
                showProv = false;
                showForm = false;
            }
            if(request.getParameter("id") != null){
                v = AchatDao.findById(Integer.parseInt(request.getParameter("id")));
            }else{
                sales = AchatDao.getAll();
            }
        }
    }

    public boolean isShowForm() {
        return showForm;
    }

    public void setShowForm(boolean showForm) {
        this.showForm = showForm;
    }

    public Achats getV() {
        return v;
    }

    public void setV(Achats v) {
        this.v = v;
    }

  


    public List<Produits> getProd() {
        return prod;
    }

    public void setProd(List<Produits> prod) {
        this.prod = prod;
    }

    

    public boolean isShowProd() {
        return showProd;
    }

    public void setShowProd(boolean showProd) {
        this.showProd = showProd;
    }
    public void handleEvent(AjaxBehaviorEvent event) {
        this.showProd = false;
    }

    public List<Fournisseurs> getProv() {
        return prov;
    }

    public void setProv(List<Fournisseurs> prov) {
        this.prov = prov;
    }
    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public int getIdprov() {
        return idprov;
    }

    public void setIdprov(int idprov) {
        this.idprov = idprov;
    }

    public boolean isShowProv() {
        return showProv;
    }

    public void setShowProv(boolean showProv) {
        this.showProv = showProv;
    }

    public List<Achats> getSales() {
        return sales;
    }

    public void setSales(List<Achats> sales) {
        this.sales = sales;
    }
    
}
