/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.hibernate.dao;

import interfaces.Crud;
import java.util.List;
import model.hibernate.dto.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Casa
 */
public class UsuarioDao implements Crud<model.hibernate.dto.Usuario>{

    
    private Session session;
    private Transaction transaction;
    public void initOperaciones(){
         session = model.dao.HibernateUtil.getSessionFactory().openSession();
         transaction = session.beginTransaction();
     }
    
    @Override
    public boolean agregar(model.hibernate.dto.Usuario generico) {
        try {
            initOperaciones();
            session.save(generico);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Usuario no se ha agregado"+e);
        }
    }

    @Override
    public boolean eliminar(int id) {
        try {
            initOperaciones();
            session.delete(id);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Usuario no se ha eliminado"+e);
        }
    }

    @Override
    public List<model.hibernate.dto.Usuario> listar() {
        try {
            initOperaciones();
            List<model.hibernate.dto.Usuario> aux = session.createQuery("from usuario").list();
            return aux;         
        } catch (Exception e) {
            session.close();
            throw new RuntimeException("error al listar usuarios"+e);
        }
    }

    @Override
    public model.hibernate.dto.Usuario buscar(int id) {
        try {
            initOperaciones();
            List<model.hibernate.dto.Usuario> aux = session.createQuery("from usuario where id_usuario ="+id).list();
               for (model.hibernate.dto.Usuario usuario : aux) {
                   return usuario;
               }
                    
        } catch (Exception e) {
            session.close();
            throw new RuntimeException("Usuario no encontrado"+e);
        }
           return null;
    }
    
}
