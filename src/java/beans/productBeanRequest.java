/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ProduitsDao;
import entity.Produits;
import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/**
 *
 * @author benrh
 */
@Named
@RequestScoped
public class productBeanRequest {
    public String delete(Produits produit){
        ProduitsDao.delete(produit);
        return "produit.xhtml?faces-redirect=true";
    }
    public String update(int id){
        return "produit-update.xhtml?faces-redirect=true&id="+id;
    }
    public String updateProduit(Produits produit){
        ProduitsDao.update(produit);
        return "produit.xhtml?faces-redirect=true";
    }
    public String addProduit(Produits produit){
        ProduitsDao.insert(produit);
        return "produit.xhtml?faces-redirect=true"; 
    }
    
    
}
