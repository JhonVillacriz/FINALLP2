/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Matricula;

import ModeloDAO.MatriculaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ControladorCurso", urlPatterns = {"/ControladorCurso"})
public class ControladorMatricula extends HttpServlet {
    String listarmatricula = "Vista/ListarMatricula.jsp";
    String agregarmatricula = "Vista/AgregarMatricula.jsp";
    String editarmatricula = "Vista/EditarMatricula.jsp";
    Matricula matricula = new Matricula();
    MatriculaDAO matriculaDAO = new MatriculaDAO();
    
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
            out.println("<title>Servlet ControladorMatricula</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorMatricula at " + request.getContextPath() + "</h1>");
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
        if (s_accion.equalsIgnoreCase("listarmatricula")) {
            acceso = listarmatricula;
        }else if (s_accion.equalsIgnoreCase("agregarmatricula01")) {
            acceso = agregarmatricula;
        }else if (s_accion.equalsIgnoreCase("agregarmatricula02")) {
            String s_semestre = request.getParameter("f_semestre");
            String s_ciclo = request.getParameter("f_ciclo");
            String s_id_curso = request.getParameter("f_id_curso");
            String s_id_estudiante = request.getParameter("f_id_estudiante");
            String s_id_carrera = request.getParameter("f_id_carrera");
            String s_estado = request.getParameter("f_estado");
            matricula.setSemestre(s_semestre);
            matricula.setCiclo(s_ciclo);
            matricula.setId_curso(s_id_curso);
            matricula.setId_estudiante(s_id_estudiante);
            matricula.setId_carrera(s_id_carrera);
            matricula.setEstado(s_estado);
            matriculaDAO.agregarmatricula(matricula);
            acceso = listarmatricula;
            
        }else if (s_accion.equalsIgnoreCase("editarmatricula01")) {
            request.setAttribute("f_idmatricula", request.getParameter("f_idmatricula"));
            acceso = editarmatricula;
        }else if (s_accion.equalsIgnoreCase("editarmatricula02")) {
            int s_idmatricula = Integer.valueOf(request.getParameter("f_idmatricula"));
            String s_semestre = request.getParameter("f_semestre");
            String s_ciclo = request.getParameter("f_ciclo");
            String s_id_curso = request.getParameter("f_id_curso");
            String s_id_estudiante = request.getParameter("f_id_estudiante");
            String s_id_carrera = request.getParameter("f_id_carrera");
            String s_estado = request.getParameter("f_estado");
            
            matricula.setIdmatricula(s_idmatricula);            
            matricula.setSemestre(s_semestre);
            matricula.setCiclo(s_ciclo);
            matricula.setId_curso(s_id_curso);
            matricula.setId_estudiante(s_id_estudiante);
            matricula.setId_carrera(s_id_carrera);
            matricula.setEstado(s_estado);
            matriculaDAO.editarmatricula(matricula);
            acceso = listarmatricula;
        }else if (s_accion.equals("eliminarmatricula")) {
            int s_idmatricula = Integer.valueOf(request.getParameter("f_idmatricula"));
            matriculaDAO.eliminarmatricula(s_idmatricula);
            acceso = listarmatricula;    }
        
        
      
        
        
        
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
