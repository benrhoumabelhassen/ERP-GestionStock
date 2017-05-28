package entity;
// Generated 19 mai 2017 15:58:01 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String email;
     private String password;
     private String rememberToken;
     private Date createdAt;
     private Date updatedAt;

    public Users() {
    }

	
    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public Users(String name, String email, String password, String rememberToken, Date createdAt, Date updatedAt) {
       this.name = name;
       this.email = email;
       this.password = password;
       this.rememberToken = rememberToken;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRememberToken() {
        return this.rememberToken;
    }
    
    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }




}

