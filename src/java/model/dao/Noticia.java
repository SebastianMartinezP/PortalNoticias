package model.dao;



import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
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
        String sql = "SELECT * FROM Noticia order by fecha_emision DESC";
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
                element.setImagenes(new model.dao.Imagen().listImagesByNewsId(element.getIdNoticia()));
                list.add(element);
            }

        } catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }

        return list;
    }
    
    public List<model.dto.Noticia> listOldest()
    {
        String sql = "SELECT * FROM Noticia ORDER BY fecha_emision ASC";

        
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
                element.setImagenes(new model.dao.Imagen().listImagesByNewsId(element.getIdNoticia()));
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
        String sql = "SELECT * FROM Noticia WHERE id_tipo_noticia = ? order by fecha_emision DESC";
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
                element.setImagenes(new model.dao.Imagen().listImagesByNewsId(element.getIdNoticia()));
                list.add(element);
            }

        } catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }

        return list;
    }

    public model.dto.Noticia findNoticia(int idNoticia)
    {
        String sql = "SELECT * FROM Noticia WHERE id_noticia = ? order by fecha_emision DESC";
        model.dto.Noticia noticia = null;

        try
        {

            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, idNoticia);
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
                element.setImagenes(new model.dao.Imagen().listImagesByNewsId(element.getIdNoticia()));
                noticia = element;
            }

        } catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }

        return noticia;
    }
    
    public List<model.dto.Noticia> listByTitle(String titulo)
    {
        String sql = "SELECT * FROM Noticia WHERE titulo  LIKE \'%" + titulo +"%\' order by fecha_emision DESC";
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
                element.setImagenes(new model.dao.Imagen().listImagesByNewsId(element.getIdNoticia()));
                list.add(element);
            }

        } catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }

        return list;
    }

    public List<model.dto.Noticia> listByDate(String year, String month, String day)
    {
        // String.format("%02d", intValue);
        String fecha = 
                String.format("%04d",Integer.parseInt(year))    + '-' + 
                String.format("%02d",Integer.parseInt(month))   + '-' + 
                String.format("%02d",Integer.parseInt(day));
        String sql = "SELECT * FROM Noticia WHERE fecha_emision LIKE \'" + fecha + "%\' order by fecha_emision DESC";
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
                element.setImagenes(new model.dao.Imagen().listImagesByNewsId(element.getIdNoticia()));
                list.add(element);
            }

        } catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }

        return list;
    }
 
}
