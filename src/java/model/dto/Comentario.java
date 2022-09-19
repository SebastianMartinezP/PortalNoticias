package model.dto;

public class Comentario
{
    private int idComentario;
    private String contenido;
    private int idNoticia;
    private int idUsuario;
    private boolean isEnabled;
    
    private model.dto.Usuario usuario;
    
    public Comentario()
    {
    }

    public Comentario(int idComentario, String contenido, int idNoticia, int idUsuario, boolean isEnabled)
    {
        this.idComentario = idComentario;
        this.contenido = contenido;
        this.idNoticia = idNoticia;
        this.idUsuario = idUsuario;
        this.isEnabled = isEnabled;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    
    public int getIdComentario()
    {
        return idComentario;
    }

    public String getContenido()
    {
        return contenido;
    }

    public int getIdNoticia()
    {
        return idNoticia;
    }

    public int getIdUsuario()
    {
        return idUsuario;
    }

    public boolean getIsEnabled()
    {
        return isEnabled;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

     
    public void setIdComentario(int idComentario)
    {
        this.idComentario = idComentario;
    }

    public void setContenido(String contenido)
    {
        this.contenido = contenido;
    }

    public void setIdNoticia(int idNoticia)
    {
        this.idNoticia = idNoticia;
    }

    public void setIdUsuario(int idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    public void setIsEnabled(boolean isEnabled)
    {
        this.isEnabled = isEnabled;
    }

    @Override
    public String toString()
    {
        return "Comentario{" + "idComentario=" + idComentario + ", contenido=" + contenido + ", idNoticia=" + idNoticia + ", idUsuario=" + idUsuario + ", isEnabled=" + isEnabled + '}';
    }


}
