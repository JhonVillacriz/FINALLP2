/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Carrera;
import ModeloDAO.CarreraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MONARCA
 */
@WebServlet(name = "ControladorCarrera", urlPatterns = {"/ControladorCarrera"})
public class ControladorCarrera extends HttpServlet {
    String listarcarrera = "Vista/ListarCarrera.jsp";
    String agregarcarrera = "Vista/AgregarCarrera.jsp";
    String editarcarrera = "Vista/EditarCarrera.jsp";
    Carrera carrera = new Carrera();
    CarreraDAO carreraDAO = new CarreraDAO();

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
            out.println("<title>Servlet ControladorCarrera</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCarrera at " + request.getContextPath() + "</h1>");
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
        String acceso = "";
        String s_accion = request.getParameter("f_accion");
        if (s_accion.equalsIgnoreCase("listarcarrera")) {
            acceso = listarcarrera;
        }else if (s_accion.equalsIgnoreCase("agregarcarrera01")) {
            acceso = agregarcarrera;
        }else if (s_accion.equalsIgnoreCase("agregarcarrera02")) {
            String s_nombre = request.getParameter("f_nombre");
            
            String s_estado = request.getParameter("f_estado");
            carrera.setNombre(s_nombre);
            
            carrera.setEstado(s_estado);
            carreraDAO.agregarcarrera(carrera);
            acceso = listarcarrera;
            
        }else if (s_accion.equalsIgnoreCase("editarcarrera01")) {
            request.setAttribute("f_idcarrera", request.getParameter("f_idcarrera"));
            acceso = editarcarrera;
        }else if (s_accion.equalsIgnoreCase("editarcarrera02")) {
            int s_idcarrera = Integer.valueOf(request.getParameter("f_idcarrera"));
            String s_nombre = request.getParameter("f_nombre");
            
            String s_estado = request.getParameter("f_estado");
            
            carrera.setIdcarrera(s_idcarrera);            
            carrera.setNombre(s_nombre);
            carrera.setEstado(s_estado);
            carreraDAO.editarcarrera(carrera);
            acceso = listarcarrera;
        }else if (s_accion.equals("eliminarcarrera")) {
            int s_idcarrera = Integer.valueOf(request.getParameter("f_idcarrera"));
            carreraDAO.eliminarcarrera(s_idcarrera);
            acceso = listarcarrera;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
