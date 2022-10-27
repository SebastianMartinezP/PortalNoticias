/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.hibernate.dao;

import interfaces.Crud;
import java.util.List;
import model.dto.Comentario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Casa
 */
public class ComentarioDao implements Crud<Comentario>{

    private Session session;
    private Transaction transaction;
    public void initOperaciones(){
         session = model.hibernate.dao.HibernateUtil.getSessionFactory().openSession();
         transaction = session.beginTransaction();}
    
   

    @Override
    public void eliminar(int id) {
        try {
            initOperaciones();
            Comentario aux = buscar(id);
            session.delete(aux);
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            throw new RuntimeException("Comentario no se ha eliminado"+e.toString());
        }
    }

    @Override
    public List<Comentario> listar() {
        try {
            initOperaciones();
            List<Comentario> aux = session.createQuery("from Comentario").list();
            session.close();
            return aux;         
        } catch (Exception e) {
            throw new RuntimeException("error al listar comentarios"+e.toString());
        }
    }

    @Override
    public Comentario buscar(int id) {
        try {
            initOperaciones();
            List<Comentario> aux = session.createQuery("from Comentario where id_comentario ="+id).list();
            for (Comentario comentario : aux) {
                session.close();
                return comentario;
            }
                    
        } catch (Exception e) {
            throw new RuntimeException("Comentario no encontrada"+e.toString());
        }
           return null;
    }

    @Override
    public boolean agregar(Comentario generico) {
        try {
            initOperaciones();
            session.save(generico);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Tipo Noticia no se ha agregado"+e);
        }
    }
    
}
