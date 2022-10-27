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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Casa
 */

public class UsuarioDao implements Crud<model.hibernate.dto.Usuario>{

    
    private Session session;
    private Transaction transaction;
    public void initOperaciones(){
         session = model.hibernate.dao.HibernateUtil.getSessionFactory().openSession();
         transaction = session.beginTransaction();
     }
    
    @Override
    public boolean agregar(Usuario generico) {
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
    public void eliminar(int id) {
     
        try {
            initOperaciones();
            model.hibernate.dto.Usuario aux = buscar(id);
            session.delete(aux);
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            throw new RuntimeException("Usuario no se ha eliminado"+e.toString());
        }
    }

    @Override
    public List<model.hibernate.dto.Usuario> listar() {
        try {
            initOperaciones();
            List<model.hibernate.dto.Usuario> aux = session.createQuery("from Usuario").list();
            session.close();
            return aux;
        } catch (Exception e) {
            throw new RuntimeException("error al listar usuarios"+e.toString());
        }
    }

    @Override
    public model.hibernate.dto.Usuario buscar(int id) {
        try {
            initOperaciones();
            List<model.hibernate.dto.Usuario> aux = session.createQuery("from Usuario where id_usuario ="+id).list();
            for (model.hibernate.dto.Usuario usuario : aux) {
                session.close();
                return usuario;
            }
                    
        } catch (Exception e) {
            throw new RuntimeException("Usuario no encontrado"+e.toString());
        }
           return null;
    }
    
    public boolean actualizar(Usuario generico) {
        try {
            initOperaciones();
            session.update(generico);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Usuario no se ha agregado"+e);
            
        }
    }
    
    
    
    
}
