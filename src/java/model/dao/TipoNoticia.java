package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.connection.*;

public class TipoNoticia
{
    MySqlConnection mysqlConnection = new MySqlConnection();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    
    public List<model.dto.TipoNoticia> list()
    {
        String sql = "SELECT * FROM tipo_noticia";
        List<model.dto.TipoNoticia> list = new ArrayList<>();

        try
        {

            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next())
            {

                model.dto.TipoNoticia element = new model.dto.TipoNoticia();

                element.setIdTipoNoticia(this.resultSet.getInt("id_tipo_noticia"));
                element.setDescripcion(this.resultSet.getString("descripcion"));

                list.add(element);
            }

        } catch (Exception e)
        {
        }

        return list;
    }
}
