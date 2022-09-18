package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Creacion pdf
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class ServletController extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {

            // DAOs
            model.dao.TipoNoticia daoTipoNoticia;
            model.dao.Noticia daoNoticia;

            // Parameters 
            String site = request.getParameter("site");
            String action = request.getParameter("action");

            // Variables globales
            List<model.dto.Noticia> noticias;

            switch (site)
            {
                case "index":
                    switch (action)
                    {
                        // cambiar el orden de las busquedas
                        case "listOldestNews":
                            daoNoticia = new model.dao.Noticia();

                            noticias = daoNoticia.listOldest();
                            request.setAttribute("noticias", noticias);
                            request.getRequestDispatcher("jsp/newsFeed.jsp").forward(request, response);

                            break;

                        // cargar pagina principal por tipos de noticias
                        case "getNoticiaByTipoNoticia":
                            daoTipoNoticia = new model.dao.TipoNoticia();
                            daoNoticia = new model.dao.Noticia();

                            String tipoNoticia = request.getParameter("tipoNoticia");

                            if (!tipoNoticia.equals("todo"))
                            {
                                int idTipoNoticia = daoTipoNoticia.list(tipoNoticia).get(0).getIdTipoNoticia();
                                noticias = daoNoticia.list(idTipoNoticia);
                            } else
                            {
                                noticias = daoNoticia.list();
                            }

                            request.setAttribute("noticias", noticias);
                            request.getRequestDispatcher("jsp/newsFeed.jsp").forward(request, response);

                            break;

                        // cargar pagina principal por tipos de noticias
                        case "searchNoticiaByTitulo":
                            daoNoticia = new model.dao.Noticia();

                            String tituloNoticia = request.getParameter("txtSearch");
                            noticias = daoNoticia.listByTitle(tituloNoticia);

                            request.setAttribute("noticias", noticias);
                            request.getRequestDispatcher("jsp/newsFeed.jsp").forward(request, response);

                            break;

                        // cargar pagina principal por tipos de noticias
                        case "searchNoticiaByDate":
                            daoNoticia = new model.dao.Noticia();

                            String day = request.getParameter("txtDay");
                            String month = request.getParameter("txtMonth");
                            String year = request.getParameter("txtYear");

                            // en el caso que los textos esten vacios
                            if (day.length() == 0 || month.length() == 0 || year.length() == 0)
                            {
                                noticias = daoNoticia.list();
                            } else
                            {
                                noticias = daoNoticia.listByDate(year, month, day);
                            }

                            // en el caso que la fecha no exista
                            if (noticias.isEmpty())
                            {
                                noticias = daoNoticia.list();
                            }

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
                            
                            // rescatamos la noticia, creamos el nombre del pdf
                            
                            daoNoticia = new model.dao.Noticia();
                            int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
                            model.dto.Noticia noticia = daoNoticia.findNoticia(idNoticia);
                            
                            String filename = 
                                    "Noticia_" + noticia.getIdNoticia() + '_' 
                                    + noticia.getFechaEmision().toString() + ".pdf";
                            
                            
                            // configuramos la respuesta del Servlet
                            
                            response.setContentType("application/pdf");
                            response.setHeader("Content-disposition", "attachment; filename=" + filename);

                            
                            // creamos el documento
                            
                            Document document = new Document();
                            PdfWriter.getInstance(document, response.getOutputStream());

                            document.open();
                            
                            
                            document.add(
                                new Paragraph(
                                    new Chunk(noticia.getAutor(), 
                                        FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.LIGHT_GRAY)
                                    )
                                )
                            );
                            
                            document.add(
                                new Paragraph(
                                    new Chunk(noticia.getTitulo(), 
                                        FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK)
                                    )
                                )
                                
                            );
                            
                            document.add(
                                    new Paragraph(
                                    new Chunk(noticia.getSubtitulo(), 
                                        FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 15, BaseColor.BLACK)
                                    )
                                )
                            );
                            
                            document.add(
                                    new Paragraph(
                                    new Chunk(noticia.getCuerpo(), 
                                        FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK)
                                    )
                                )
                            );
                            
                            document.close();
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
