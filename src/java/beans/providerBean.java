/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import dao.ProviderDao;
import entity.Fournisseurs;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
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
public class providerBean implements Serializable{
    private List<Fournisseurs> prov;
    private Fournisseurs p;
    @PostConstruct
    public void init() {
        prov = ProviderDao.getAll();
        p = new Fournisseurs();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String id= null;
        if(request!=null){
            if(request.getParameter("id") != null){
                id= request.getParameter("id");
                p = ProviderDao.findById(Integer.parseInt(id));
            }
        }
    }

    public List<Fournisseurs> getProv() {
        return prov;
    }

    public void setProv(List<Fournisseurs> prov) {
        this.prov = prov;
    }

    public Fournisseurs getP() {
        return p;
    }

    public void setP(Fournisseurs p) {
        this.p = p;
    }

    
    
    
    
}
