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
    public String delete(Produits p){
        ProduitsDao.delete(p);
        return "produit.xhtml?faces-redirect=true";
    }
    public String update(int id){
        return "produit-update.xhtml?faces-redirect=true&id="+id;
    }
    public String updateP(Produits p){
        ProduitsDao.update(p);
        return "produit.xhtml?faces-redirect=true";
    }
    public String addP(Produits p){
        ProduitsDao.insert(p);
        return "produit.xhtml?faces-redirect=true"; 
    }
    
    
}
