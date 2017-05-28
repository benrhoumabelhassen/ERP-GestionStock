/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ProduitsDao;
import entity.Produits;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author benrh
 */
@Named
@ViewScoped
public class productBean implements Serializable{
    private List<Produits> prod;
    private Produits p;
    @PostConstruct
    public void init() {
        prod = ProduitsDao.getAll();
        p = new Produits();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String id= null;
        if(request!=null){
            if(request.getParameter("id") != null){
                id= request.getParameter("id");
                p = ProduitsDao.findById(Integer.parseInt(id));
            }
        }
    }

    public List<Produits> getProd() {
        return prod;
    }

    public void setProd(List<Produits> prod) {
        this.prod = prod;
    }

    public Produits getP() {
        return p;
    }

    public void setP(Produits p) {
        this.p = p;
    }
public void handleFileUpload(FileUploadEvent event) {
        new File("/" + p.getLibelle()).mkdirs();
        File result = new File("/upload/"+ p.getLibelle() + "/" + event.getFile().getFileName());

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(result);

            byte[] buffer = new byte[1000];

            int bulk;
            InputStream inputStream = event.getFile().getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }

            fileOutputStream.close();
            inputStream.close();

            FacesMessage msg = new FacesMessage("Succesful",
                    event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (IOException e) {
            e.printStackTrace();
            FacesMessage error = new FacesMessage("The files were not uploaded!");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }
    }
    
    
    

    
}
