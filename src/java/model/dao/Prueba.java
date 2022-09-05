package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.connection.*;

public class Prueba
{

    MySqlConnection mysqlConnection = new MySqlConnection();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public List<model.dto.Prueba> list()
    {
        String sql = "SELECT * FROM prueba";
        List<model.dto.Prueba> list = new ArrayList<>();

        try
        {

            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next())
            {

                model.dto.Prueba element = new model.dto.Prueba();

                element.setId(this.resultSet.getInt("id"));
                element.setName(this.resultSet.getString("name"));

                list.add(element);
            }

        } catch (Exception e)
        {
        }

        return list;
    }
}
