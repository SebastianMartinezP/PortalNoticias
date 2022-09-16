package model.dao;


import java.util.ArrayList;
import java.util.List;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;


import model.connection.*;

public class Imagen
{
    MySqlConnection mysqlConnection = new MySqlConnection();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public List<model.dto.Imagen> listImagesByNewsId(int idNoticia)
    {
        String sql = "SELECT * FROM imagen WHERE id_noticia = ?";
        List<model.dto.Imagen> imagenes = new ArrayList<>();
        try
        {
            this.connection = mysqlConnection.getConection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, idNoticia);
            this.resultSet = this.preparedStatement.executeQuery();
            
            while (this.resultSet.next()) {
                model.dto.Imagen img = new model.dto.Imagen();
                img.setIdImagen(this.resultSet.getInt("id_imagen"));
                img.setIdNoticia(this.resultSet.getInt("id_noticia"));
                
                Blob blob = this.resultSet.getBlob("imagen_blob");
                 
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                 
                 
                inputStream.close();
                outputStream.close();
                 
                img.setBase64imagen(base64Image);
                
                imagenes.add(img);
            }          
            
            
            
        } catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
        
        return imagenes;
    }
}
