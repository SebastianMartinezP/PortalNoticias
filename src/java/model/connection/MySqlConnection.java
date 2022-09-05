package model.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection
{

    Connection connection;
    String url = "jdbc:mysql://localhost:3306/portalnoticias";
    String user = "root";
    String pass = "SYSTEM";

    public Connection getConection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception e)
        {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return connection;
    }
}
