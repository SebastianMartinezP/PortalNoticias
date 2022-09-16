package model.dto;

import com.mysql.cj.jdbc.Blob;
import java.time.LocalDateTime;
import java.util.List;

public class Noticia
{

    private int idNoticia;
    public int idTipoNoticia;
    private String titulo;
    private String subtitulo;
    private String cuerpo;
    private LocalDateTime fechaEmision;
    private Blob pdf;
    private String autor;
    private List<model.dto.Imagen> imagenes;

    public Noticia()
    {
    }

    public Noticia(int idNoticia, int idTipoNoticia, String titulo, String subtitulo, String cuerpo, LocalDateTime fechaEmision, String autor)
    {
        this.idNoticia = idNoticia;
        this.idTipoNoticia = idTipoNoticia;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.cuerpo = cuerpo;
        this.fechaEmision = fechaEmision;
        this.autor = autor;
    }

    public int getIdNoticia()
    {
        return idNoticia;
    }

    public int getIdTipoNoticia()
    {
        return idTipoNoticia;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public String getSubtitulo()
    {
        return subtitulo;
    }

    public String getCuerpo()
    {
        return cuerpo;
    }

    public LocalDateTime getFechaEmision()
    {
        return fechaEmision;
    }

    public Blob getPdf()
    {
        return pdf;
    }

    public String getAutor()
    {
        return autor;
    }

    public void setImagenes(List<Imagen> imagenes)
    {
        this.imagenes = imagenes;
    }

    public List<Imagen> getImagenes()
    {
        return imagenes;
    }

    public void setIdNoticia(int idNoticia)
    {
        this.idNoticia = idNoticia;
    }

    public void setIdTipoNoticia(int idTipoNoticia)
    {
        this.idTipoNoticia = idTipoNoticia;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public void setSubtitulo(String subtitulo)
    {
        this.subtitulo = subtitulo;
    }

    public void setCuerpo(String cuerpo)
    {
        this.cuerpo = cuerpo;
    }

    public void setFechaEmision(LocalDateTime fechaEmision)
    {
        this.fechaEmision = fechaEmision;
    }

    public void setPdf(Blob pdf)
    {
        this.pdf = pdf;
    }

    public void setAutor(String autor)
    {
        this.autor = autor;
    }

    @Override
    public String toString()
    {
        return "Noticia{" + "idNoticia=" + idNoticia + ", idTipoNoticia=" + idTipoNoticia + ", titulo=" + titulo + ", subtitulo=" + subtitulo + ", cuerpo=" + cuerpo + ", fechaEmision=" + fechaEmision + ", pdf=" + pdf + ", autor=" + autor + ", imagenes=" + imagenes + '}';
    }

    
}
