package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.PalabrasDAO;
import modelo.Palabras;

/**
 *
 * @author Clara Lopez
 */
public class Controlador extends HttpServlet {

    PalabrasDAO palabraDAO = new PalabrasDAO();

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
        String direccion = request.getParameter("direccion");
        String accion = request.getParameter("accion");

        if (direccion.equals("Game")) {
            switch (accion) {
                case "Mostrar":
                    List listaPalabras = palabraDAO.listarPalabras();
                    request.setAttribute("palabras", listaPalabras);
                    break;
                case "Buscar":

                    break;               
                case "ObtenerPalabra":
                    int cantidadPalabras = palabraDAO.cantidadPalabras();
                    if (cantidadPalabras > 0) {
                        int idAleatorio = (int) (Math.random() * cantidadPalabras) + 1;
                        Palabras palabraJuego = palabraDAO.buscarPalabra(idAleatorio);
                        request.getSession().setAttribute("palabraJuego", palabraJuego);
                    }
                    request.getRequestDispatcher("MenuInicio.jsp").forward(request, response);
                    break;
// ...
            }
            request.getRequestDispatcher("MenuInicio.jsp").forward(request, response);
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
        processRequest(request, response);
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
