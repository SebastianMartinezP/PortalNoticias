package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dto.TipoNoticia;

public class ServletController extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            
        
            // DAOs
            model.dao.TipoNoticia daoTipoNoticia = new model.dao.TipoNoticia();
            model.dao.Noticia daoNoticia = new model.dao.Noticia();
            


            // Variables 
            
            String tipoNoticia = request.getParameter("tipoNoticia");
            int idTipoNoticia = daoTipoNoticia.list(tipoNoticia).get(0).getIdTipoNoticia();
            
            List<model.dto.Noticia> noticias = daoNoticia.list(idTipoNoticia);

            
            request.setAttribute("index_noticias", noticias);
            request.getRequestDispatcher("jsp/newsFeed.jsp").forward(request, response);

            
        
        } catch (Exception e)
        {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.write("<h1>Error</h1>");
            out.write("<p>");
            out.write(e.toString());
            out.write("</p>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}
