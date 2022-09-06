package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.connection.*;

public class Comentario
{
    MySqlConnection mysqlConnection = new MySqlConnection();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public String Save(model.dto.Comentario comentario)
    {
        String sql = "INSERT INTO comentario(contenido, is_enabled, id_noticia, id_usuario) VALUES(?,?,?,?)";
        try {
            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1, comentario.getContenido());
            this.preparedStatement.setBoolean(2, comentario.getIsEnabled());
            this.preparedStatement.setInt(3, comentario.getIdNoticia());
            this.preparedStatement.setInt(3, comentario.getIdUsuario());
            this.preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            return e.toString();
        }
        return "Comentario guardado correctamente";
    }
    
    public List<model.dto.Comentario> list()
    {
        String sql = "SELECT * FROM comentario";
        List<model.dto.Comentario> list = new ArrayList<>();

        try
        {

            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next())
            {
                model.dto.Comentario element = new model.dto.Comentario();

                element.setIdUsuario(this.resultSet.getInt("id_usuario"));
                element.setContenido(this.resultSet.getString("contenido"));
                element.setIdNoticia(this.resultSet.getInt("id_noticia"));
                element.setIdUsuario(this.resultSet.getInt("id_usuario"));
                element.setIsEnabled(this.resultSet.getBoolean("is_enabled"));

                list.add(element);
            }

        } catch (Exception e)
        {
        }

        return list;
    }
    
    public String UpdateIsEnabledByUser(model.dto.Usuario user, boolean newState)
    {
        String sql = "UPDATE comentario SET is_enabled = ? WHERE id_usuario = ?";
        
        try
        {
            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setBoolean(1, newState);
            this.preparedStatement.setInt(2, user.getIdUsuario());
            this.preparedStatement.executeUpdate();
            
        } catch (SQLException e)
        {
            return e.toString();
        }
        return "Update ok";
    }
}
