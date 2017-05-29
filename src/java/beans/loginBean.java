/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.lowagie.text.Anchor;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import dao.loginDao;
import entity.Utilisateurs;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.model.UploadedFile;
/**
 *
 * @author benrh
 */
@Named
@SessionScoped
public class loginBean implements 
        Serializable{
    private String email;
    private String password;
    static Utilisateurs user;
    private UploadedFile file;

    
    
    public void login() throws IOException{
        user = loginDao.login(email, password);
        FacesContext context = FacesContext.getCurrentInstance();
        if (user == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Wrong Input!!! "));
        } else {
            context.getExternalContext().getSessionMap().put("user", user);
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/index.xhtml");
        }
    }
    public void checkAuthentication() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

        if (externalContext.getSessionMap().get("user") == null) {
            externalContext.redirect(externalContext.getRequestContextPath() + "/login.xhtml");
        }
    }
    public void logout() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/login.xhtml");
    }

    public void createFactureVente(String libelle,String type,BigDecimal prixVente,String qteVendue,Date dateVente,String nom,String telephone,String adresse,int id) throws DocumentException, BadElementException, IOException {
        Document document = new Document(PageSize.A4.rotate(), 50, 50, 50, 50);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse response = (HttpServletResponse)externalContext.getResponse();
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        document.newPage();
        Image image1 = Image.getInstance("http://localhost:8088/ERP/plugins/images/eliteadmin-logo-dark.png");
        Image image2 = Image.getInstance("http://localhost:8088/ERP/plugins/images/eliteadmin-text-dark.png");
        image1.setAlignment(Image.MIDDLE);
        image2.setAlignment(Image.MIDDLE);
        document.add(image1);
        document.add(image2);
        Font font=new Font(Font.BOLD,30.0f,Font.UNDERLINE);
        Paragraph numfacture = new Paragraph("Facture N° "+id,font);
        numfacture.setSpacingBefore(50);
        numfacture.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(numfacture);
        Anchor providername = new Anchor("Provider Name: "+nom);
        Paragraph paragraph2 = new Paragraph();
        paragraph2.setSpacingBefore(50);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph2.add(providername);
        paragraph2.add(Chunk.NEWLINE);
        Anchor provideradresse = new Anchor("Provider Adresse: "+adresse);
        paragraph2.add(provideradresse);
        paragraph2.add(Chunk.NEWLINE);
        Anchor providertel = new Anchor("Provider Tel: "+telephone);
        paragraph2.add(providertel);
        paragraph2.add(Chunk.NEWLINE);
        providertel = new Anchor("Purchase Date: "+dateVente);
        paragraph2.add(providertel);
        paragraph2.add(Chunk.NEWLINE);
        document.add(paragraph2);
        PdfPTable table = new PdfPTable(4);
        table.setSpacingBefore(25);
        table.setSpacingAfter(25);
        table.setWidthPercentage(90);
        PdfPCell c1 = new PdfPCell(new Phrase("Product Name"));  
        table.addCell(c1);

        PdfPCell c2 = new PdfPCell(new Phrase("Quantity"));

        table.addCell(c2);

        PdfPCell c3 = new PdfPCell(new Phrase("Unit Price"));

        table.addCell(c3);
        PdfPCell c4 = new PdfPCell(new Phrase("Total Price"));

        table.addCell(c4);

        table.addCell(libelle);

        table.addCell(qteVendue + " Units");

        table.addCell("$"+prixVente.toString());
        int result = prixVente.intValue() * Integer.parseInt(qteVendue);
        table.addCell("$"+String.valueOf(result));
        table.setExtendLastRow(true);
        document.add(table);
        document.close();
    }
    
    public void createFactureAchat(String libelle,String type,BigDecimal prixAchat,String qteAchat,Date dateAchat,String nom,String telephone,String adresse,int id) throws DocumentException, BadElementException, IOException {
        Document document = new Document(PageSize.A4.rotate(), 50, 50, 50, 50);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse response = (HttpServletResponse)externalContext.getResponse();
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        document.newPage();
        Image image1 = Image.getInstance("http://localhost:8088/ERP/plugins/images/eliteadmin-logo-dark.png");
        Image image2 = Image.getInstance("http://localhost:8088/ERP/plugins/images/eliteadmin-text-dark.png");
        image1.setAlignment(Image.MIDDLE);
        image2.setAlignment(Image.MIDDLE);
        document.add(image1);
        document.add(image2);
        Font font=new Font(Font.BOLD,30.0f,Font.UNDERLINE);
        Paragraph paragraph = new Paragraph("Facture N° "+id,font);
        paragraph.setSpacingBefore(50);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph);
        Anchor anchorTarget = new Anchor("Client Name: "+nom);
        Paragraph paragraph2 = new Paragraph();
        paragraph2.setSpacingBefore(50);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph2.add(anchorTarget);
        paragraph2.add(Chunk.NEWLINE);
        anchorTarget = new Anchor("Client Adresse: "+adresse);
        paragraph2.add(anchorTarget);
        paragraph2.add(Chunk.NEWLINE);
        anchorTarget = new Anchor("Client Tel: "+telephone);
        paragraph2.add(anchorTarget);
        paragraph2.add(Chunk.NEWLINE);
        anchorTarget = new Anchor("Sell Date: "+dateAchat);
        paragraph2.add(anchorTarget);
        paragraph2.add(Chunk.NEWLINE);
        document.add(paragraph2);
        PdfPTable table = new PdfPTable(4);
 
        table.setSpacingBefore(25);
 
        table.setSpacingAfter(25);
        table.setWidthPercentage(90);
        PdfPCell productName = new PdfPCell(new Phrase("Product Name"));  

        table.addCell(productName);

        PdfPCell quantity = new PdfPCell(new Phrase("Quantity"));

        table.addCell(quantity);

        PdfPCell unitprice = new PdfPCell(new Phrase("Unit Price"));

        table.addCell(unitprice);
        PdfPCell totalprice = new PdfPCell(new Phrase("Total Price"));

        table.addCell(totalprice);

        table.addCell(libelle);

        table.addCell(qteAchat + " Units");

        table.addCell("$"+prixAchat.toString());
        int result = prixAchat.intValue() * Integer.parseInt(qteAchat);
        table.addCell("$"+String.valueOf(result));
        table.setExtendLastRow(true);
        document.add(table);
        document.close();
        
    }
    
    public void update() throws IOException{
        loginDao.update(user);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/index.xhtml");
    }
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
 

   
    public Utilisateurs getUser() {
        return user;
    }

    public void setUser(Utilisateurs user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
