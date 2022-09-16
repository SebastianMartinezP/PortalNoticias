package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            model.dao.Imagen daoImagen = new model.dao.Imagen();

            // Parameters 
            String site = request.getParameter("site");
            String action = request.getParameter("action");

            // Variables globales
            List<model.dto.Noticia> noticias = null;

            switch (site)
            {
                case "index":
                    switch (action)
                    {
                        // cargar pagina principal por tipos de noticias
                        case "getNoticiaByTipoNoticia":

                            String tipoNoticia = request.getParameter("tipoNoticia");

                            if (!tipoNoticia.equals("todo"))
                            {
                                int idTipoNoticia = daoTipoNoticia.list(tipoNoticia).get(0).getIdTipoNoticia();
                                noticias = daoNoticia.list(idTipoNoticia);
                            } else
                            {
                                noticias = daoNoticia.list();
                            }

                            for (model.dto.Noticia noticia : noticias)
                            {
                                noticia.setTitulo(noticia.getTitulo().replace("_", " "));
                            }

                            request.setAttribute("noticias", noticias);
                            request.getRequestDispatcher("jsp/newsFeed.jsp").forward(request, response);
                            break;

                        // cargar pagina principal por tipos de noticias
                        case "searchNoticiaByTitulo":

                            String tituloNoticia = request.getParameter("txtSearch");
                            noticias = daoNoticia.listByTitle(tituloNoticia);

                            request.setAttribute("noticias", noticias);
                            request.getRequestDispatcher("jsp/newsFeed.jsp").forward(request, response);

                            break;

                        default:
                            throw new AssertionError();
                    }
                    break;

                case "newsFeed":
                    switch (action)
                    {
                        case "downloadPdfById":
                            int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
                            model.dto.Noticia noticia = daoNoticia.findNoticia(idNoticia);
                            String filename = daoNoticia.downloadPdf(noticia);
                            break;
                            
                        default:
                            throw new AssertionError();
                    }
                    break;

                default:
                    throw new AssertionError();
            }

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
