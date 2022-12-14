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
import javax.servlet.http.HttpSession;

public class ServletController extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            // Parameters 
            String site = request.getParameter("site");
            String action = request.getParameter("action");

            switch (site)
            {
                case "index":
                    switch (action)
                    {
                        case "downloadReport":
                            // descargar informe / reporte
                            downloadReportRequest(request, response);
                            break;
                        case "listOldestNews":
                            // cambiar el orden de las busquedas
                            listOldestNewsRequest(request, response);
                            break;
                        case "getNoticiaByTipoNoticia":
                            // cargar pagina principal por tipos de noticias
                            getNoticiaByTipoNoticiaRequest(request, response);
                            break;
                        case "searchNoticiaByTitulo":
                            // cargar pagina principal por tipos de noticias
                            searchNoticiaByTituloRequest(request, response);
                            break;
                        case "searchNoticiaByDate":
                            // cargar pagina principal por tipos de noticias
                            searchNoticiaByDateRequest(request, response);
                            break;

                        case "Login":
                            loginRequest(request, response);
                            break;
                        case "ingresar":
                            request.getRequestDispatcher("jsp/Login.jsp").forward(request, response);
                            break;
                        case "nuevoRegistro":
                            request.getRequestDispatcher("jsp/Registro.jsp").forward(request, response);
                            break;
                        case "GuardarUsuario":
                            registerRequest(request, response);
                            break;
                        
                         
                        default:
                            throw new AssertionError();
                    }
                    break;

                case "newsFeed":
                    switch (action)
                    {
                        case "downloadPdfById":
                            downloadPdfByIdRequest(request, response);
                            break;
                        case "SaveComment":
                            saveCommentRequest(request, response);
                            break;
                        case "reportUser":
                            reportUserRequest(request, response);
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

    protected void downloadReportRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        try
        {
            // rescatamos la noticia, creamos el nombre del pdf
            model.dao.Noticia daoNoticia = new model.dao.Noticia();

            List<model.dto.Noticia> oldest = daoNoticia.listOldest();
            List<model.dto.Noticia> newest = daoNoticia.list();
            model.dto.Usuario mostComments = new model.dao.Usuario().listMostComments();

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
                tableOldest.addCell(oldest.get(i).getFechaEmision().toString());
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
                tableNewest.addCell(newest.get(i).getFechaEmision().toString());
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

            PdfPTable tableUser = new PdfPTable(3);
            tableUser.addCell(new Paragraph("ID"));
            tableUser.addCell(new Paragraph("Usuario"));
            tableUser.addCell(new Paragraph("Cantidad opiniones"));

            tableUser.addCell(Integer.toString(mostComments.getIdUsuario()));
            tableUser.addCell(mostComments.getNickname());
            tableUser.addCell(Integer.toString(mostComments.getCountComentarios()));
            document.add(tableUser);

            document.close();
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

    protected void listOldestNewsRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            model.dao.Noticia daoNoticia = new model.dao.Noticia();
            List<model.dto.Noticia> noticias = daoNoticia.listOldest();
            request.setAttribute("noticias", noticias);
            
            model.dto.Usuario user =  (model.dto.Usuario) request.getSession().getAttribute("user");
            request.setAttribute("user", user);
            
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

    protected void getNoticiaByTipoNoticiaRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            List<model.dto.Noticia> noticias = null;

            model.dao.TipoNoticia daoTipoNoticia = new model.dao.TipoNoticia();
            model.dao.Noticia daoNoticia = new model.dao.Noticia();

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
            
            
            model.dto.Usuario user =  (model.dto.Usuario) request.getSession().getAttribute("user");
            request.setAttribute("user", user);
            
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

    protected void searchNoticiaByTituloRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            List<model.dto.Noticia> noticias = null;
            model.dao.Noticia daoNoticia = new model.dao.Noticia();

            String tituloNoticia = request.getParameter("txtSearch");
            noticias = daoNoticia.listByTitle(tituloNoticia);

            request.setAttribute("noticias", noticias);
            
            
            model.dto.Usuario user =  (model.dto.Usuario) request.getSession().getAttribute("user");
            request.setAttribute("user", user);
            
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

    protected void searchNoticiaByDateRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            List<model.dto.Noticia> noticias = null;
            model.dao.Noticia daoNoticia = new model.dao.Noticia();

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
            
            
            model.dto.Usuario user =  (model.dto.Usuario) request.getSession().getAttribute("user");
            request.setAttribute("user", user);
            
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

    protected void downloadPdfByIdRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            // rescatamos la noticia, creamos el nombre del pdf
            model.dao.Noticia daoNoticia = new model.dao.Noticia();
            int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
            model.dto.Noticia noticia = daoNoticia.findNoticia(idNoticia);

            String filename
                    = "Noticia_" + noticia.getIdNoticia() + '_'
                    + noticia.getFechaEmision().toString() + ".pdf";

            // configuramos la respuesta del Servlet
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "attachment; filename=" + filename);

            // creamos el documento
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();

            document.add(new Paragraph(new Chunk(
                    noticia.getAutor(),
                    FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.LIGHT_GRAY)))
            );

            document.add(new Paragraph(new Chunk(
                    noticia.getTitulo(),
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK)))
            );

            document.add(new Paragraph(new Chunk(
                    noticia.getSubtitulo(),
                    FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 15, BaseColor.BLACK)))
            );

            document.add(new Paragraph(new Chunk(
                    noticia.getCuerpo(),
                    FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK)))
            );

            document.close();

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
    protected void loginRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String user = request.getParameter("txtnickname");
            String pass = request.getParameter("txtpassword");
            
            model.dao.Usuario daoUsuario = new model.dao.Usuario();
            model.dto.Usuario usuariologin = daoUsuario.login(user, pass);

            String message = "Invalid email/password";

            if (usuariologin.getNickname() != null || usuariologin.getPassword() != null)
            {
                HttpSession session = request.getSession();
                session.setAttribute("user", usuariologin);
                
                message = "Bienvenido " + user;
            }
            
            request.setAttribute("message", message);
            request.getRequestDispatcher("jsp/Login.jsp").forward(request, response);

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

    protected void registerRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String user = request.getParameter("txtnicknamenu");
            String pass = request.getParameter("txtpasswordnu");

            model.dao.Usuario usuarioHandler = new model.dao.Usuario();
            model.dto.Usuario usuario = new model.dto.Usuario(1, user, pass, (Boolean.TRUE));
            usuarioHandler.Save(usuario);

            request.getRequestDispatcher("jsp/Login.jsp").forward(request, response);
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
    
    protected void saveCommentRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            model.dao.Comentario comentarioDao = new model.dao.Comentario();
            
            String comment = request.getParameter("inputComment");
            int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
            model.dto.Usuario user =  (model.dto.Usuario) request.getSession().getAttribute("user");
            
            
            model.dto.Comentario comentarioSave = new model.dto.Comentario();
            comentarioSave.setContenido(comment);
            comentarioSave.setIdNoticia(idNoticia);
            comentarioSave.setIsEnabled(true);
            comentarioSave.setIdUsuario(user.getIdUsuario());
            
            
            
            String result = comentarioDao.Save(comentarioSave);
            listOldestNewsRequest(request, response);
                    
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
    
    protected void reportUserRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            // Obtenemos el usuario que se pretende banear
            int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
            model.dao.Usuario daoUsuario = new model.dao.Usuario();
            model.dto.Usuario usuarioReported = daoUsuario.listByIdUsuario(IdUsuario);
            
            // baneamos usuario
            daoUsuario.UpdateIsEnabledByCredentials(usuarioReported, false);
            
            // baneamos sus comentarios
            model.dao.Comentario daoComentario = new model.dao.Comentario();
            daoComentario.UpdateIsEnabledByUser(usuarioReported, false);
            
            
            listOldestNewsRequest(request,response);
                    
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
