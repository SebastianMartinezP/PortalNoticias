package test;

//import model.connection;
//import model.dao;
//import model.dto;

public class Testing
{

    public static void main(String[] args)
    {
        model.dao.Prueba prueba = new model.dao.Prueba();
        
        System.out.println(prueba.list());
    }
}
