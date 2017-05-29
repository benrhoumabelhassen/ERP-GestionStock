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
    private List<Produits> produits;
    private List<Fournisseurs> providers;
    private Achats achats;
    private int idproduits;
    private int idproviders;
    private boolean showProd;
    private boolean showProv;
    private boolean showForm;
    @PostConstruct
    public void init() {
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if(request!=null){
            if(request.getParameter("idproviders") != null){
                idproviders= Integer.parseInt(request.getParameter("idproviders"));
                idproduits= Integer.parseInt(request.getParameter("idproduits"));
                achats = new Achats();
                achats.setFournisseurs(ProviderDao.findById(idproviders));
                achats.setProduits(ProduitsDao.findById(idproduits));
                showProv = false;
                showProd = false;
                showForm = true;
            }else if(request.getParameter("idproduits") != null){
                idproduits= Integer.parseInt(request.getParameter("idproduits"));
                providers = ProviderDao.getAll();
                showProv = true;
                showProd = false;
                showForm = false;
            }else{
                produits = ProduitsDao.getAll();
                showProd = true;
                showProv = false;
                showForm = false;
            }
            if(request.getParameter("id") != null){
                achats = AchatDao.findById(Integer.parseInt(request.getParameter("id")));
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

    public Achats getAchats() {
        return achats;
    }

    public void setAchats(Achats achats) {
        this.achats = achats;
    }

  


    public List<Produits> getProduits() {
        return produits;
    }

    public void setProduits(List<Produits> produits) {
        this.produits = produits;
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

    public List<Fournisseurs> getProviders() {
        return providers;
    }

    public void setProviders(List<Fournisseurs> providers) {
        this.providers = providers;
    }
    public int getIdproduits() {
        return idproduits;
    }

    public void setIdproduits(int idproduits) {
        this.idproduits = idproduits;
    }

    public int getIdproviders() {
        return idproviders;
    }

    public void setIdproviders(int idproviders) {
        this.idproviders = idproviders;
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
