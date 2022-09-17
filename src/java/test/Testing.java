package test;

import java.util.List;
import model.dto.Imagen;

public class Testing
{

    public static void main(String[] args)
    {
        /////////////////////////// Prueba (R) TESTED
        
        //model.dao.Prueba prueba = new model.dao.Prueba();
        //System.out.println(prueba.list());
        
        /////////////////////////// Usuario (CRU) TESTED 
        
        //model.dao.Usuario usuarioHandler = new model.dao.Usuario();
        
        //model.dto.Usuario usuario = new model.dto.Usuario();
        //usuario.setIdUsuario(1);
        //usuario.setNickname("usuario_prueba_3");
        //usuario.setPassword("password_prueba_3");
        //usuario.setIsEnabled(Boolean.TRUE);
        
        //String saveResult = usuarioHandler.Save(usuario);
        //System.out.println(saveResult);
        
        //System.out.println(usuarioHandler.list());
        
       
        //System.out.println(usuarioHandler.UpdateIsEnabledByCredentials(usuario, false));
        //System.out.println(usuarioHandler.list());
        
        
        /////////////////////////// TipoNoticia (R) TESTED
        
        //model.dao.TipoNoticia tipo_noticia = new model.dao.TipoNoticia();
        //System.out.println(tipo_noticia.list());
        //System.out.println(tipo_noticia.list(6));

        /////////////////////////// Noticia (R) TESTED
        
        model.dao.Noticia noticia = new model.dao.Noticia();
        //System.out.println(noticia.list());
        //System.out.println(noticia.findNoticia(21));
        //System.out.println(noticia.list(21));
        //System.out.println(noticia.listByTitle("pol"));
        System.out.println(noticia.listByDate("2022", "09", "01"));
        System.out.println(noticia.listByDate("2023", "09", "01"));
        /////////////////////////// Imagen (R) TESTED
        //model.dao.Imagen daoImagen = new model.dao.Imagen();
        //List<model.dto.Imagen> imagenes = daoImagen.listImagesByNewsId(21);
        
        //for (Imagen imagen : imagenes)
        //{
        //    System.out.println(imagenes.indexOf(imagen));
        //}

        /////////////////////////// Comentario (CRU)
        
        
        
    }
}
