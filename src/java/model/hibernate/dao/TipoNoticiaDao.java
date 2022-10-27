/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.hibernate.dao;

import interfaces.Crud;
import java.util.List;
import model.hibernate.dto.TipoNoticia;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Casa
 */
public class TipoNoticiaDao implements Crud<TipoNoticia> {

    private Session session;
    private Transaction transaction;

    public void initOperaciones() {
        session = model.hibernate.dao.HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    @Override
    public boolean agregar(TipoNoticia generico) {
        try {
            initOperaciones();
            session.save(generico);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Tipo Noticia no se ha agregado" + e);
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            initOperaciones();
            TipoNoticia aux = buscar(id);
            session.delete(aux);
            transaction.commit();
            session.close();

        } catch (Exception e) {
            throw new RuntimeException("Noticia no se ha eliminado" + e.toString());
        }
    }

    @Override
    public List<TipoNoticia> listar() {
        try {
            initOperaciones();
            List<TipoNoticia> aux = session.createQuery("from TipoNoticia").list();
            session.close();
            return aux;
        } catch (Exception e) {

            throw new RuntimeException("error al listar tipo de noticias" + e.toString());
        }
    }

    @Override
    public TipoNoticia buscar(int id) {
        try {
            initOperaciones();
            List<TipoNoticia> aux = session.createQuery("from TipoNoticia where id_tipo_noticia =" + id).list();
            for (TipoNoticia noticia : aux) {
                session.close();
                return noticia;
            }

        } catch (Exception e) {
            throw new RuntimeException("Noticia no encontrada" + e.toString());
        }
        return null;
    }

}
