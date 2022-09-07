package test;

//import model.connection;
//import model.dao;
//import model.dto;

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
        

        /////////////////////////// Noticia (R) TESTED
        
        model.dao.Noticia noticia = new model.dao.Noticia();
        System.out.println(noticia.list());

        /////////////////////////// Imagen (R)
        


        /////////////////////////// Comentario (CRU)
        
        
        
    }
}
