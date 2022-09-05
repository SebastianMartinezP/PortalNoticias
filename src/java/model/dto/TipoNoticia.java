package model.dto;

public class TipoNoticia
{
    private int idTipoNoticia;
    private String descripcion;

    public TipoNoticia()
    {
    }

    public TipoNoticia(int idTipoNoticia, String descripcion)
    {
        this.idTipoNoticia = idTipoNoticia;
        this.descripcion = descripcion;
    }

    public int getIdTipoNoticia()
    {
        return idTipoNoticia;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setIdTipoNoticia(int idTipoNoticia)
    {
        this.idTipoNoticia = idTipoNoticia;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    @Override
    public String toString()
    {
        return "TipoNoticia{" + "idTipoNoticia=" + idTipoNoticia + ", descripcion=" + descripcion + '}';
    }
    
    
}
