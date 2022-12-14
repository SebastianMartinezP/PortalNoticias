package model.hibernate.dto;
// Generated Oct 24, 2022 12:23:58 PM by Hibernate Tools 4.3.1


import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * Imagen generated by hbm2java
 */
@Entity(name="imagen")
public class Imagen  implements java.io.Serializable {

    @Id
    private Integer idImagen;
    private Noticia noticia;
    private byte[] imagenBlob;

    public Imagen() {
    }

    public Imagen(Noticia noticia, byte[] imagenBlob) {
       this.noticia = noticia;
       this.imagenBlob = imagenBlob;
    }
   
    public Integer getIdImagen() {
        return this.idImagen;
    }
    
    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }
    public Noticia getNoticia() {
        return this.noticia;
    }
    
    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
    public byte[] getImagenBlob() {
        return this.imagenBlob;
    }
    
    public void setImagenBlob(byte[] imagenBlob) {
        this.imagenBlob = imagenBlob;
    }




}


