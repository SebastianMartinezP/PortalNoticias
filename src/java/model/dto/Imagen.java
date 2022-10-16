package model.dto;

public class Imagen
{
    private int idImagen;
    private String base64imagen;
    private int idNoticia;

    public Imagen()
    {
    }

    public Imagen(int idImagen, String base64imagen, int idNoticia)
    {
        this.idImagen = idImagen;
        this.base64imagen = base64imagen;
        this.idNoticia = idNoticia;
    }

    public int getIdImagen()
    {
        return idImagen;
    }

    public String getBase64Imagen()
    {
        return base64imagen;
    }

    public int getIdNoticia()
    {
        return idNoticia;
    }

    public void setIdImagen(int idImagen)
    {
        this.idImagen = idImagen;
    }

    public void setBase64imagen(String base64imagen)
    {
        this.base64imagen = base64imagen;
    }

    public void setIdNoticia(int idNoticia)
    {
        this.idNoticia = idNoticia;
    }

    @Override
    public String toString()
    {
        return "Imagen{" + "idImagen=" + idImagen + ", base64imagen=" + base64imagen + ", idNoticia=" + idNoticia + "}\n";
    }
    
    
}
