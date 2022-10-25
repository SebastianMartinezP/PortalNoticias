/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.hibernate.dao;

import interfaces.Crud;
import java.util.List;
import model.hibernate.dto.Noticia;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Casa
 */
public class NoticiaDao implements Crud<model.hibernate.dto.Noticia> {

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
            List<Noticia> aux = session.createQuery("from Noticia").list();
            return aux;         
        } catch (Exception e) {
            session.close();
            throw new RuntimeException("error al listar noticias"+e.toString());
        }
    }

    @Override
    public Noticia buscar(int id) {
         try {
            initOperaciones();
            List<Noticia> aux = session.createQuery("from Noticia where id_noticia ="+id).list();
               for (Noticia noticia : aux) {
                   return noticia;
               }
                    
        } catch (Exception e) {
            session.close();
            throw new RuntimeException("Noticia no encontrada"+e.toString());
        }
           return null;
    }
    
}
