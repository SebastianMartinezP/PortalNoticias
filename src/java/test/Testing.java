package test;

import model.dto.Usuario;

public class Testing
{

    public static void main(String[] args)
    {
        /////////////////////////// Prueba (R) TESTED
        
        //model.dao.Prueba prueba = new model.dao.Prueba();
        //System.out.println(prueba.list());
        
        /////////////////////////// Usuario (CRU) TESTED 
        
        /*model.dao.Usuario usuarioHandler = new model.dao.Usuario();
        
        model.dto.Usuario usuario = new model.dto.Usuario();
        usuario.setIdUsuario(1);
        usuario.setNickname("usuario2");
        usuario.setPassword("password2");
        usuario.setIsEnabled(Boolean.TRUE);
        
        String saveResult = usuarioHandler.Save(usuario);
        System.out.println(saveResult);*/
        
         /////////////////////////// SAVE TESTED
        /*model.dao.Usuario usuarioHandler = new model.dao.Usuario();      
        model.dto.Usuario usuario = new model.dto.Usuario(1,"Gise","123",(Boolean.TRUE));
        String saveResult = usuarioHandler.Save(usuario);*/
        
        /////////////////////////// Login TESTED
        model.dao.Usuario usuarioHandler = new model.dao.Usuario();      
        Usuario usuario = usuarioHandler.login("Gi","123");
        System.out.println("Usuario: "+ usuario.getNickname());
        
        //System.out.println(usuarioHandler.list());
        
       
        //System.out.println(usuarioHandler.UpdateIsEnabledByCredentials(usuario, false));
        //System.out.println(usuarioHandler.list());
        
        
        /////////////////////////// TipoNoticia (R) TESTED
        
        //model.dao.TipoNoticia tipo_noticia = new model.dao.TipoNoticia();
        //System.out.println(tipo_noticia.list());
        //System.out.println(tipo_noticia.list(6));

        /////////////////////////// Noticia (R) TESTED
        
       
        //model.dao.Noticia noticia = new model.dao.Noticia();
        //System.out.println(noticia.list());
        //System.out.println(noticia.list(3));
        //System.out.println(noticia.listByTitle("pol"));

        /////////////////////////// Imagen (R)
        


        /////////////////////////// Comentario (CRU)
        
        
        
    }
}
