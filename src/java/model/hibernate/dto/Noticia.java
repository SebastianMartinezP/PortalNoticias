package model.hibernate.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name="noticia")
public class Noticia  implements java.io.Serializable {

    @Id 
    private Integer idNoticia;
    private TipoNoticia tipoNoticia;
    private String titulo;
    private String subtitulo;
    private String cuerpo;
    private String fechaEmision;
    private byte[] pdf;
    private String autor;
    private Set comentarios = new HashSet(0);
    private Set imagens = new HashSet(0);
    
    public Noticia() {
    }

	
    public Noticia(String titulo, String subtitulo, String cuerpo, String fechaEmision) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.cuerpo = cuerpo;
        this.fechaEmision = fechaEmision;
    }
    public Noticia(TipoNoticia tipoNoticia, String titulo, String subtitulo, String cuerpo, String fechaEmision, byte[] pdf, String autor, Set comentarios, Set imagens) {
       this.tipoNoticia = tipoNoticia;
       this.titulo = titulo;
       this.subtitulo = subtitulo;
       this.cuerpo = cuerpo;
       this.fechaEmision = fechaEmision;
       this.pdf = pdf;
       this.autor = autor;
       this.comentarios = comentarios;
       this.imagens = imagens;
    }
   
    public Integer getIdNoticia() {
        return this.idNoticia;
    }
    
    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }
    public TipoNoticia getTipoNoticia() {
        return this.tipoNoticia;
    }
    
    public void setTipoNoticia(TipoNoticia tipoNoticia) {
        this.tipoNoticia = tipoNoticia;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getSubtitulo() {
        return this.subtitulo;
    }
    
    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }
    public String getCuerpo() {
        return this.cuerpo;
    }
    
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    public String getFechaEmision() {
        return this.fechaEmision;
    }
    
    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    public byte[] getPdf() {
        return this.pdf;
    }
    
    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }
    public String getAutor() {
        return this.autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Set getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }
    public Set getImagens() {
        return this.imagens;
    }
    
    public void setImagens(Set imagens) {
        this.imagens = imagens;
    }




}


