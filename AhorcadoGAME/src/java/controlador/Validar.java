
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Palabras;
import modelo.PalabrasDAO;
import modelo.UsuariosDAO;
import modelo.Usuarios;

/**
 *
 * @author Clara Lopez
 */
@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {
    Usuarios usuarios = new Usuarios();
    UsuariosDAO usuariosDAO = new UsuariosDAO();
    PalabrasDAO palabrasDAO = new PalabrasDAO();
    Palabras palabraAleatoria;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Validar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Validar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("Ingresar".equalsIgnoreCase(accion)) {
            //obtiene los parametros de los input y los ingresa al metodo
            String name = request.getParameter("txtUsuarioName");
            String pass = request.getParameter("txtPass");
            //Escoje el metodo validar y utiiliza los parametros
            usuarios = usuariosDAO.validar(name, pass);
            //si el metodo encuentra coincidencias avanza si no, recarga la pagina
            if (usuarios.getNombre_Usuario() != null) {
                //metodo para generar la palabra aleatoria en el juego (la obtiene de la base de datos)
                palabraAleatoria = palabrasDAO.obtenerPalabraAleatoria();
                //agrega la palabra aleatoria al contenedor con la id palabraJuego
                request.setAttribute("palabraJuego", palabraAleatoria);
                
                // Redirige a la página del juego menuInicio
                request.getRequestDispatcher("MenuInicio.jsp").forward(request, response);
                System.out.println("Inicio de sesion exitoso");
            } else {
                //si no encuentra coicidencias con los parametros recarga la pagina
                request.getRequestDispatcher("index.jsp").forward(request, response);
                System.out.println("Credencialse incorrectas");
            }
        } else {
            //si no encuenra coincidencias con los parametros recarga la pagina
            System.out.println("Intenta iniciar sesion");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
