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
import com.itextpdf.text.pdf.PdfPTable;
import java.util.stream.Collectors;

import model.dto.Usuario;

// Hibernate
import model.hibernate.dao.*;

public class ServletControllerHibernate extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {

            // DAOs
            NoticiaDao daoNoticia = new NoticiaDao();
           
            
            
            // Parameters 
            String site = request.getParameter("site");
            String action = request.getParameter("action");

            // Variables globales
            List<model.hibernate.dto.Noticia> noticias;

            switch (site)
            {
                case "index":
                    switch (action)
                    {
                        // descargar informe / reporte
                        case "downloadReport":
                            // rescatamos la noticia, creamos el nombre del pdf
                            daoNoticia = new NoticiaDao();
                            
                            List<model.hibernate.dto.Noticia> oldest = daoNoticia.listOldest();
                            List<model.hibernate.dto.Noticia> newest = daoNoticia.listar();
                            model.hibernate.dto.Usuario mostComments = new model.hibernate.dto.Usuario();//new UsuarioDao().listMostComments();
                            
                            
                            String filename = "Reporte_PortalNoticias.pdf";
                            
                            
                            // configuramos la respuesta del Servlet
                            
                            response.setContentType("application/pdf");
                            response.setHeader("Content-disposition", "attachment; filename=" + filename);

                            
                            // creamos el documento
                            
                            Document document = new Document();
                            PdfWriter.getInstance(document, response.getOutputStream());

                            document.open();
                            
                            document.add(
                                new Paragraph(
                                    new Chunk("Informe", 
                                        FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK)
                                    )
                                )
                                
                            );
                            
                            // Noticias mas antiguas
                            document.add(
                                    new Paragraph(
                                    new Chunk("Noticias mas antiguas", 
                                        FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 15, BaseColor.BLACK)
                                    )
                                )
                            );
                            
                            
                            PdfPTable tableOldest = new PdfPTable(3);
                            tableOldest.addCell(new Paragraph("ID"));
                            tableOldest.addCell(new Paragraph("Titulo"));
                            tableOldest.addCell(new Paragraph("Fecha emision"));
                            for (int i = 0; i < 2; i++)
                            {
                                tableOldest.addCell(Integer.toString(i + 1));
                                tableOldest.addCell(oldest.get(i).getTitulo());
                                tableOldest.addCell(oldest.get(i).getFechaEmision());
                            }
                            document.add(tableOldest);
                            
                            
                            
                            // Noticias mas nuevas
                            document.add(
                                    new Paragraph(
                                    new Chunk("Noticias mas nuevas", 
                                        FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 15, BaseColor.BLACK)
                                    )
                                )
                            );
                            
                            PdfPTable tableNewest = new PdfPTable(3);
                            tableNewest.addCell(new Paragraph("ID"));
                            tableNewest.addCell(new Paragraph("Titulo"));
                            tableNewest.addCell(new Paragraph("Fecha emision"));
                            for (int i = 0; i < 2; i++)
                            {
                                tableNewest.addCell(Integer.toString(i + 1));
                                tableNewest.addCell(newest.get(i).getTitulo());
                                tableNewest.addCell(newest.get(i).getFechaEmision());
                            }
                            document.add(tableNewest);
                            
                            
                            
                            
                            // Usuario con mas opiniones
                            document.add(
                                    new Paragraph(
                                    new Chunk("Usuario con mas opiniones", 
                                        FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 15, BaseColor.BLACK)
                                    )
                                )
                            );
                            
                            PdfPTable tableUser = new PdfPTable(2);
                            tableUser.addCell(new Paragraph("ID"));
                            tableUser.addCell(new Paragraph("Usuario"));
                            //tableUser.addCell(new Paragraph("Cantidad opiniones"));
                            
                            
                            tableUser.addCell(Integer.toString(mostComments.getIdUsuario()));
                            tableUser.addCell(mostComments.getNickname());
                            //tableUser.addCell(Integer.toString(mostComments.getCountComentarios()));
                            document.add(tableUser);
                            
                            document.close();
                            break;
                        
                        
                        
                        
                        // cambiar el orden de las busquedas
                        case "listOldestNews":
                            daoNoticia = new NoticiaDao();

                            noticias = daoNoticia.listOldest();
                            request.setAttribute("noticias", noticias);
                            request.getRequestDispatcher("jsp/newsFeed.jsp").forward(request, response);

                            break;

                        // cargar pagina principal por tipos de noticias
                        case "getNoticiaByTipoNoticia":
                            daoNoticia = new NoticiaDao();

                            String tipoNoticia = request.getParameter("tipoNoticia");

                            if (!tipoNoticia.equals("todo"))
                            {
                                noticias = daoNoticia.listar().stream().filter(p -> p.getTipoNoticia().getDescripcion().equals(tipoNoticia)).collect(Collectors.toList());
                            } else
                            {
                                noticias = daoNoticia.listar();
                            }

                            request.setAttribute("noticias", noticias);
                            request.getRequestDispatcher("jsp/newsFeed.jsp").forward(request, response);
                            
                            
                            break;

                        // cargar pagina principal por tipos de noticias
                        case "searchNoticiaByTitulo":
                            daoNoticia = new NoticiaDao();

                            String tituloNoticia = request.getParameter("txtSearch");
                            noticias = daoNoticia.listByTitulo(tituloNoticia);

                            request.setAttribute("noticias", noticias);
                            request.getRequestDispatcher("jsp/newsFeed.jsp").forward(request, response);

                            break;


                        // cargar pagina principal por tipos de noticias
                        case "searchNoticiaByDate":
                            daoNoticia = new NoticiaDao();

                            String day = request.getParameter("txtDay");
                            String month = request.getParameter("txtMonth");
                            String year = request.getParameter("txtYear");

                            // en el caso que los textos esten vacios
                            if (day.length() == 0 || month.length() == 0 || year.length() == 0)
                            {
                                noticias = daoNoticia.listar();
                            } else
                            {
                                noticias = daoNoticia.listByDate(year, month, day);
                            }

                            // en el caso que la fecha no exista
                            if (noticias.isEmpty())
                            {
                                noticias = daoNoticia.listar();
                            }

                            request.setAttribute("noticias", noticias);
                            request.getRequestDispatcher("jsp/newsFeed.jsp").forward(request, response);

                            break;

                        default:
                            throw new AssertionError();

                        
                        case "Login":
                            String userl = request.getParameter("txtnickname");
                            String passl = request.getParameter("txtpassword");
                            model.dao.Usuario userlogin = new model.dao.Usuario();      
                            Usuario usuariologin = userlogin.login(userl,passl);
                            try {

                                if (usuariologin != null) {
                                                                  
                                   request.getRequestDispatcher("jsp/newsFeed.jsp").forward(request, response);
                                   break;
                                   
                                } else {
                                    String message = "Invalid email/password";
                                    request.setAttribute("message", message);
                                }                         
                            } catch (Exception ex) {
                                throw new ServletException(ex);
                            }

                        case "ingresar":
                            request.getRequestDispatcher("jsp/Login.jsp").forward(request, response);
                            break;
                            
                        case "nuevoRegistro":
                            request.getRequestDispatcher("jsp/Registro.jsp").forward(request, response);
                            break;
                            
                        case "GuardarUsuario":
                            String user = request.getParameter("txtnicknamenu");
                            String pass = request.getParameter("txtpasswordnu");
                            
                            model.dao.Usuario usuarioHandler = new model.dao.Usuario();      
                            model.dto.Usuario usuario = new model.dto.Usuario(1,user,pass,(Boolean.TRUE));                          
                            usuarioHandler.Save(usuario);
                            
                            request.getRequestDispatcher("jsp/Login.jsp").forward(request, response);
                            break;
                      

                    }
                    break;

                case "newsFeed":
                    switch (action)
                    {
                        case "downloadPdfById":
                            
                            // rescatamos la noticia, creamos el nombre del pdf
                            
                            daoNoticia = new NoticiaDao();
                            int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
                            model.hibernate.dto.Noticia noticia = daoNoticia.buscar(idNoticia);
                            
                            String filename = 
                                    "Noticia_" + noticia.getIdNoticia() + '_' 
                                    + noticia.getFechaEmision() + ".pdf";
                            
                            
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
