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
    private List<Fournisseurs> providers;
    private Fournisseurs provider;
    @PostConstruct
    public void init() {
        providers = ProviderDao.getAll();
        provider = new Fournisseurs();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String id= null;
        if(request!=null){
            if(request.getParameter("id") != null){
                id= request.getParameter("id");
                provider = ProviderDao.findById(Integer.parseInt(id));
            }
        }
    }

    public List<Fournisseurs> getProviders() {
        return providers;
    }

    public void setProviders(List<Fournisseurs> providers) {
        this.providers = providers;
    }

    public Fournisseurs getProvider() {
        return provider;
    }

    public void setProvider(Fournisseurs provider) {
        this.provider = provider;
    }

    
    
    
    
}
