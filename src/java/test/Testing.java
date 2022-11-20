package test;

import model.dao.*;

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
        //model.dao.Usuario usuarioHandler = new model.dao.Usuario();      
        //Usuario usuario = usuarioHandler.login("Gi","123");
        //System.out.println("Usuario: "+ usuario.getNickname());
        
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
        //System.out.println(noticia.findNoticia(21));
        //System.out.println(noticia.list(21));
        //System.out.println(noticia.listByTitle("pol"));
        //System.out.println(noticia.listByDate("2022", "09", "01"));
        //System.out.println(noticia.listByDate("2023", "09", "01"));
        /////////////////////////// Imagen (R) TESTED
        //model.dao.Imagen daoImagen = new model.dao.Imagen();
        //List<model.dto.Imagen> imagenes = daoImagen.listImagesByNewsId(21);

       
        //model.dao.Noticia noticia = new model.dao.Noticia();
        //System.out.println(noticia.list());
        //System.out.println(noticia.list(3));
        //System.out.println(noticia.listByTitle("pol"));

        /////////////////////////// Imagen (R)

        
        //for (Imagen imagen : imagenes)
        //{
        //    System.out.println(imagenes.indexOf(imagen));
        //}

        /////////////////////////// Comentario (CRU)
        
        //System.out.println(new model.dao.Usuario().listMostComments());
         ////////////////////////////////////////////////////////////////////////////////////////////
        //-------------------------------------TEST HIBERNATE---------------------------------------
        ////////////////////////////////////////////////////////////////////////////////////////////
        
            
        //DAO USUARIO
        //model.hibernate.dto.Usuario usuarioh = new model.hibernate.dto.Usuario( "UserHibernate", "123", (Boolean.TRUE));
        //model.hibernate.dao.UsuarioDao dao = new model.hibernate.dao.UsuarioDao();
        //dao.agregar(usuarioh);
        //dao.eliminar(34);
        //for (model.hibernate.dto.Usuario aux :dao.listar()){
        //System.out.println("Nickname: "+aux.getNickname());
        //System.out.println("Password: "+aux.getPassword());
        //}
        
        //DAO NOTICIA      
        //model.hibernate.dto.Noticia hibernate = new model.hibernate.dto.Noticia("titulo", "subtitulo", "cuerpo",Date("2022/09/01"));
        //NoticiaDao NoDao = new NoticiaDao();
        //NoDao.agregar(hibernate);
        //NoDao.eliminar(34);
        /*for (model.hibernate.dto.Noticia aux :NoDao.listar()){
        System.out.println("Título: "+aux.getTitulo());
        System.out.println("Autor: "+aux.getAutor());
        System.out.println("Sub Título: "+aux.getSubtitulo());
        System.out.println("Cuerpo: "+aux.getCuerpo());
        }*/
        
        //DAO TIPO NOTICIA
        //model.hibernate.dto.TipoNoticia Salud = new model.hibernate.dto.TipoNoticia("Salud");
        //TipoNoticiaDao TipoNoDao = new TipoNoticiaDao();
        //TipoNoDao.agregar(Salud);
        //TipoNoDao.eliminar(6);
        /*for (model.hibernate.dto.TipoNoticia aux :TipoNoDao.listar()){
        System.out.println("Descripción: "+aux.getDescripcion());
        }*/
        //DAO COMENTARIO
        //model.hibernate.dto.Comentario hiber = new model.hibernate.dto.Comentario((Boolean.TRUE));
        //model.hibernate.dto.Comentario hiber = new model.hibernate.dto.Comentario(21,"UserHibernate", "contenido",(Boolean.TRUE));
        //ComentarioDao comen = new ComentarioDao();
        //comen.agregar(hiber);
        //comen.eliminar(1);
        /*for (model.hibernate.dto.Comentario aux :comen.listar()){
        System.out.println("Descripción: "+aux.getcontenido());
        }*/
        
        /////////////////////////////////////////////////////////////////
        model.dao.Usuario usuarioDao = new model.dao.Usuario();
        System.out.println(usuarioDao.login("Sebastian123", "123").toString());
        System.out.println(usuarioDao.login("Sebastian123", "13").toString());
        /*
        model.hibernate.dto.Usuario usuario = usuarioDao.buscar(1);
        
        System.out.println(usuario.getNickname() + ", " + usuario.getPassword());
        
        usuario.setNickname("nickname1");
        
        
        usuarioDao.actualizar(usuario);
        */
        
        //System.out.println(usuarioDao.listMostComments().toString());
        
    }
}
