/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ProduitsDao;
import entity.Produits;
import entity.Ventes;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author benrh
 */
@Named
@ViewScoped
public class pdfBean implements Serializable{
    String libelle;
    String type;
    String prixVente;
    String qteVendue;
    String dateVente;
    String nom;
    String telephone;
    String adresse;
    @PostConstruct
    public void init() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String id= null;
        if(request!=null){
                libelle= request.getParameter("libelle");
                type= request.getParameter("type");
                prixVente= request.getParameter("prixVente");
                qteVendue= request.getParameter("qteVendue");
                dateVente= request.getParameter("dateVente");
                nom= request.getParameter("nom");
                telephone= request.getParameter("telephone");
                adresse= request.getParameter("adresse");
                
        }
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(String prixVente) {
        this.prixVente = prixVente;
    }

    public String getQteVendue() {
        return qteVendue;
    }

    public void setQteVendue(String qteVendue) {
        this.qteVendue = qteVendue;
    }

    public String getDateVente() {
        return dateVente;
    }

    public void setDateVente(String dateVente) {
        this.dateVente = dateVente;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
}
