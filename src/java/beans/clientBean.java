/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ClientDao;
import entity.Clients;
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
/**
 *
 * @author benrh
 */
@Named
@ViewScoped
public class clientBean implements Serializable{
    private List<Clients> clients;
    private Clients client;
    @PostConstruct
    public void init() {
        clients = ClientDao.getAll();
        client = new Clients();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if(request!=null){
            if(request.getParameter("id") != null){
                client = ClientDao.findById(Integer.parseInt(request.getParameter("id")));
            }
        }
    }

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients c) {
        this.client = c;
    }

}
