package model.dto;

import com.mysql.cj.jdbc.Blob;

public class Imagen
{
    private int idImagen;
    private Blob imagenBlob;
    private int idNoticia;

    public Imagen()
    {
    }

    public Imagen(int idImagen, Blob imagenBlob, int idNoticia)
    {
        this.idImagen = idImagen;
        this.imagenBlob = imagenBlob;
        this.idNoticia = idNoticia;
    }

    public int getIdImagen()
    {
        return idImagen;
    }

    public Blob getImagenBlob()
    {
        return imagenBlob;
    }

    public int getIdNoticia()
    {
        return idNoticia;
    }

    public void setIdImagen(int idImagen)
    {
        this.idImagen = idImagen;
    }

    public void setImagenBlob(Blob imagenBlob)
    {
        this.imagenBlob = imagenBlob;
    }

    public void setIdNoticia(int idNoticia)
    {
        this.idNoticia = idNoticia;
    }

    @Override
    public String toString()
    {
        return "Imagen{" + "idImagen=" + idImagen + ", imagenBlob=" + imagenBlob + ", idNoticia=" + idNoticia + '}';
    }
    
    
}
