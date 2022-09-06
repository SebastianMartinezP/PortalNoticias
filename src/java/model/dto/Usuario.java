package model.dto;

public class Usuario
{
    private int idUsuario;
    private String nickname;
    private String password;
    private boolean isEnabled;

    public Usuario()
    {
    }

    public Usuario(int idUsuario, String nickname, String password, boolean isEnabled)
    {
        this.idUsuario = idUsuario;
        this.nickname = nickname;
        this.password = password;
        this.isEnabled = isEnabled;
    }

    public int getIdUsuario()
    {
        return idUsuario;
    }

    public String getNickname()
    {
        return nickname;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean getIsEnabled()
    {
        return isEnabled;
    }

    public void setIdUsuario(int idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setIsEnabled(boolean isEnabled)
    {
        this.isEnabled = isEnabled;
    }

    @Override
    public String toString()
    {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nickname=" + nickname + ", password=" + password + ", isEnabled=" + isEnabled + '}';
    }
    
    
}
