package model.dao;

import interfaces.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.connection.*;

public class Usuario
{

    MySqlConnection mysqlConnection = new MySqlConnection();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public String Save(model.dto.Usuario user)
    {
        String sql = "INSERT INTO usuario(nickname, password, is_enabled) VALUES(?,?,?)";
        try
        {
            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1, user.getNickname());
            this.preparedStatement.setString(2, user.getPassword());
            this.preparedStatement.setBoolean(3, user.getIsEnabled());
            this.preparedStatement.executeUpdate();

        } catch (Exception e)
        {
            return e.toString();
        }
        return "Usuario guardado correctamente";
    }

    public List<model.dto.Usuario> list()
    {
        String sql = "SELECT * FROM usuario";
        List<model.dto.Usuario> list = new ArrayList<>();

        try
        {

            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next())
            {
                model.dto.Usuario element = new model.dto.Usuario();

                element.setIdUsuario(this.resultSet.getInt("id_usuario"));
                element.setNickname(this.resultSet.getString("nickname"));
                element.setPassword(this.resultSet.getString("password"));
                element.setIsEnabled(this.resultSet.getBoolean("is_enabled"));

                list.add(element);
            }

        } catch (Exception e)
        {
        }

        return list;
    }

    public model.dto.Usuario listByIdUsuario(int idUsuario)
    {
        String sql = "SELECT * FROM usuario where id_usuario = " + Integer.toString(idUsuario);
        model.dto.Usuario element = new model.dto.Usuario();
        try
        {

            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.resultSet = this.preparedStatement.executeQuery();

            if (this.resultSet.next())
            {
                element.setIdUsuario(this.resultSet.getInt("id_usuario"));
                element.setNickname(this.resultSet.getString("nickname"));
                element.setPassword(this.resultSet.getString("password"));
                element.setIsEnabled(this.resultSet.getBoolean("is_enabled"));
            }

        } catch (Exception e)
        {
        }

        return element;
    }

    public boolean Update(model.dto.Usuario user)
    {
        String sql
                = "UPDATE usuario SET nickname = ?, password = ?, is_enabled = ? WHERE id_usuario = ?";

        try
        {
            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1, user.getNickname());
            this.preparedStatement.setString(2, user.getPassword());
            this.preparedStatement.setBoolean(3, user.getIsEnabled());
            this.preparedStatement.setInt(4, user.getIdUsuario());
            this.preparedStatement.executeUpdate();

            return true;
        } catch (Exception e)
        {
        }
        return false;
    }

    public String UpdateIsEnabledByCredentials(model.dto.Usuario user, boolean newState)
    {
        String sql = "UPDATE usuario SET is_enabled = ? WHERE id_usuario = ?";

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

    public model.dto.Usuario login(String nickname, String pass)
    {
        model.dto.Usuario element = new model.dto.Usuario();
        String sql = "SELECT * FROM usuario WHERE nickname = ? and password = ?";
        try
        {
            this.connection = mysqlConnection.getConection();
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, nickname);
            this.preparedStatement.setString(2, pass);
            this.resultSet = preparedStatement.executeQuery();

            if (this.resultSet.next())
            {
                element.setIdUsuario(this.resultSet.getInt("id_usuario"));
                element.setNickname(this.resultSet.getString("nickname"));
                element.setPassword(this.resultSet.getString("password"));
                element.setIsEnabled(this.resultSet.getBoolean("is_enabled"));

            }
        } catch (Exception e)
        {
            System.out.println(e.toString() + ", " + e.getMessage());
        }
        
        return element;
    }

    public model.dto.Usuario listMostComments()
    {
        String sql
                = "SELECT "
                + "COUNT(id_comentario) "
                + "id_usuario "
                + "FROM comentario "
                + "GROUP BY id_usuario "
                ///+ "ORDER BY CUENTA DESC "
                + "LIMIT 1;";
        String sql2 = "SELECT COUNT(*) FROM comentario WHERE id_usuario = ?";
        model.dto.Usuario element = new model.dto.Usuario();

        try
        {
            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.resultSet = this.preparedStatement.executeQuery();

            if (this.resultSet.next())
            {
                element = listByIdUsuario(this.resultSet.getInt("id_usuario"));
                element.setCountComentarios(this.resultSet.getInt(1));
            }

            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql2);
            preparedStatement.setInt(1, element.getIdUsuario());
            this.resultSet = this.preparedStatement.executeQuery();

            if (this.resultSet.next())
            {
                element.setCountComentarios(this.resultSet.getInt(1));
            }

        } catch (Exception e)
        {
            System.out.println(e.toString() + ", " + e.getMessage());
        }
        return element;
    }

}
