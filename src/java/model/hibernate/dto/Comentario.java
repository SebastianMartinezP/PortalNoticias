package model.hibernate.dto;
// Generated Oct 24, 2022 12:23:58 PM by Hibernate Tools 4.3.1

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="comentario")
public class Comentario  implements java.io.Serializable {

    @Id
    private Integer idComentario;
    private Noticia noticia;
    private Usuario usuario;
    private String contenido;
    private boolean isEnabled;

    public Comentario() {
    }

	
    public Comentario(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
    public Comentario(Noticia noticia, Usuario usuario, String contenido, boolean isEnabled) {
       this.noticia = noticia;
       this.usuario = usuario;
       this.contenido = contenido;
       this.isEnabled = isEnabled;
    }
   
    public Integer getIdComentario() {
        return this.idComentario;
    }
    
    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }
    public Noticia getNoticia() {
        return this.noticia;
    }
    
    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getContenido() {
        return this.contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public boolean isIsEnabled() {
        return this.isEnabled;
    }
    
    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }




}


