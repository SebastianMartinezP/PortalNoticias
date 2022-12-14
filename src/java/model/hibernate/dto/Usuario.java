package model.hibernate.dto;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="usuario")
public class Usuario  implements java.io.Serializable {

    

     @Id
     private Integer idUsuario;
     private String nickname;
     private String password;
     private boolean isEnabled;
     private Set comentarios = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String nickname, String password, boolean isEnabled) {
        this.nickname = nickname;
        this.password = password;
        this.isEnabled = isEnabled;
    }
    public Usuario(String nickname, String password, boolean isEnabled, Set comentarios) {
       this.nickname = nickname;
       this.password = password;
       this.isEnabled = isEnabled;
       this.comentarios = comentarios;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isIsEnabled() {
        return this.isEnabled;
    }
    
    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
    public Set getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }




}


