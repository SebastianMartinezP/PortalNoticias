package model.dao;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.connection.*;

public class Noticia
{
    MySqlConnection mysqlConnection = new MySqlConnection();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    
    
    public List<model.dto.Noticia> list()
    {
        String sql = "SELECT * FROM Noticia";
        List<model.dto.Noticia> list = new ArrayList<>();

        try
        {

            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next())
            {
                model.dto.Noticia element = new model.dto.Noticia();

                element.setIdNoticia(this.resultSet.getInt("id_noticia"));
                element.setIdTipoNoticia(this.resultSet.getInt("id_tipo_noticia"));
                element.setAutor(this.resultSet.getString("autor"));
                element.setTitulo(this.resultSet.getString("titulo"));
                element.setSubtitulo(this.resultSet.getString("subtitulo"));
                element.setCuerpo(this.resultSet.getString("cuerpo"));
                element.setFechaEmision(
                    LocalDateTime.parse(
                        this.resultSet.getString("fecha_emision"), 
                        this.dateTimeFormatter
                    )
                );
                list.add(element);
            }

        } catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }

        return list;
    }
    
    public List<model.dto.Noticia> list(int tipoNoticia)
    {
        String sql = "SELECT * FROM Noticia WHERE id_tipo_noticia = ?";
        List<model.dto.Noticia> list = new ArrayList<>();

        try
        {

            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, tipoNoticia);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next())
            {
                model.dto.Noticia element = new model.dto.Noticia();

                element.setIdNoticia(this.resultSet.getInt("id_noticia"));
                element.setIdTipoNoticia(this.resultSet.getInt("id_tipo_noticia"));
                element.setAutor(this.resultSet.getString("autor"));
                element.setTitulo(this.resultSet.getString("titulo"));
                element.setSubtitulo(this.resultSet.getString("subtitulo"));
                element.setCuerpo(this.resultSet.getString("cuerpo"));
                element.setFechaEmision(
                    LocalDateTime.parse(
                        this.resultSet.getString("fecha_emision"), 
                        this.dateTimeFormatter
                    )
                );
                list.add(element);
            }

        } catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }

        return list;
    }
    
    public List<model.dto.Noticia> listByTitle(String titulo)
    {
        String sql = "SELECT * FROM Noticia WHERE titulo  LIKE \'%" + titulo +"%\'";
        List<model.dto.Noticia> list = new ArrayList<>();

        try
        {

            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next())
            {
                model.dto.Noticia element = new model.dto.Noticia();

                element.setIdNoticia(this.resultSet.getInt("id_noticia"));
                element.setIdTipoNoticia(this.resultSet.getInt("id_tipo_noticia"));
                element.setAutor(this.resultSet.getString("autor"));
                element.setTitulo(this.resultSet.getString("titulo"));
                element.setSubtitulo(this.resultSet.getString("subtitulo"));
                element.setCuerpo(this.resultSet.getString("cuerpo"));
                element.setFechaEmision(
                    LocalDateTime.parse(
                        this.resultSet.getString("fecha_emision"), 
                        this.dateTimeFormatter
                    )
                );
                list.add(element);
            }

        } catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }

        return list;
    }
    
    
    public Boolean getPdf(model.dto.Noticia noticia)
    {
        String filename = "Noticia_" + noticia.getIdNoticia() + '_' + noticia.getFechaEmision().toString() + ".pdf";
        String sql = "SELECT pdf FROM Noticia WHERE id_noticia = " + noticia.getIdNoticia();
        try
        {
            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.resultSet = this.preparedStatement.executeQuery();
        
            if(this.resultSet.next())
            {
                java.sql.Blob blob = this.resultSet.getBlob("pdf");
                InputStream inputStream = blob.getBinaryStream();
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\" + filename);
                
                int b = 0;
                while ((b = inputStream.read()) != -1)
                {         
                    fileOutputStream.write(b);
                }
            }
        
            
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }
    
}
