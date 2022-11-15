/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.hibernate.dao;

import interfaces.Crud;
import java.text.SimpleDateFormat;
import java.util.List;
import model.hibernate.dto.Noticia;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Casa
 */
public class NoticiaDao implements Crud<model.hibernate.dto.Noticia> {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private Session session;
    private Transaction transaction;
    public void initOperaciones(){
         session = model.hibernate.dao.HibernateUtil.getSessionFactory().openSession();
         transaction = session.beginTransaction();}
            

    @Override
    public boolean agregar(Noticia generico) {
        try {
            initOperaciones();
            session.save(generico);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Noticia no se ha agregado"+e);
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            initOperaciones();
            Noticia aux = buscar(id);
            session.delete(aux);
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            throw new RuntimeException("Noticia no se ha eliminado"+e.toString());
        }
    }

    @Override
    public List<Noticia> listar() {
        try {
            initOperaciones();
            List<Noticia> aux = session.createQuery("from Noticia order by fechaEmision desc").list();
            session.close();
            return aux;         
        } catch (Exception e) {
            
            throw new RuntimeException("error al listar noticias"+e.toString());
        }
    }

    @Override
    public Noticia buscar(int id) {
         try {
            initOperaciones();
            List<Noticia> aux = session.createQuery("from Noticia where idNoticia ="+id).list();
            for (Noticia noticia : aux) {
                session.close();
                return noticia;
            }
                    
        } catch (Exception e) {
            
            throw new RuntimeException("Noticia no encontrada"+e.toString());
        }
           return null;
    }
    
    // Metodos custom
    
    
    public List<Noticia> listOldest() {
        try {
            initOperaciones();
            List<Noticia> aux = session.createQuery("from Noticia n order by n.fechaEmision asc").list();
            session.close();
            return aux;         
        } catch (Exception e) {
            
            throw new RuntimeException("error al listar noticias"+e.toString());
        }
    }
    
    public List<Noticia> listByTipoNoticia(String tipoNoticia) {
        try {
            initOperaciones();
            List<Noticia> aux = session.createQuery("from Noticia n where n.tipoNoticia.descripcion= :tipoNoticia").setParameter("tipoNoticia", tipoNoticia).list();
            session.close();
            return aux;
        } catch (Exception e) {
            throw new RuntimeException( "list Tipo noticia" + e.toString());
        }
    }
    
    public List<Noticia> listByTitulo(String titulo) {
        try {
            titulo = "%"+titulo+"%";
            initOperaciones();
            List<Noticia> aux = session.createQuery("from Noticia n where n.titulo like :titulo").setParameter("titulo", titulo).list();
            session.close();
            return aux;
        } catch (Exception e) {
            
            throw new RuntimeException("list by titulo" + e.toString());
        }
    }
    
    public List<Noticia> listByDate(String year, String month, String day) {
        try {
            String fecha = 
                String.format("%04d",Integer.parseInt(year))    + '-' + 
                String.format("%02d",Integer.parseInt(month))   + '-' + 
                String.format("%02d",Integer.parseInt(day)) + " 00:00:00";
            
            initOperaciones();
            List<Noticia> aux = session.createQuery("from Noticia n where n.fechaEmision = :fecha").setParameter("fecha", fecha).list();
            session.close();
            return aux;
        } catch (Exception e) {
            
            throw new RuntimeException(e.toString());
        }
    }
}
