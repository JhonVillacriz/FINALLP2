

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Carrera"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.CarreraDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Estudiantes</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Listado de Carreras</h1>
             
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombre</th>
                        
                        <th class="text-center">Estado</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        CarreraDAO carreraDAO = new CarreraDAO();
                        List<Carrera> carreras = carreraDAO.listarcarrera();
                        Iterator<Carrera> iterator = carreras.iterator();
                        Carrera carrera = null;
                        while (iterator.hasNext()) {
                            carrera = iterator.next();


                    %>
                    <tr>
                        <td><% out.print(carrera.getIdcarrera()); %></td>
                        <td><% out.print(carrera.getNombre()); %></td>
                        
                        <td><% out.print(carrera.getEstado()); %></td>
                        <td>
                            <a class="btn btn-warning" href="ControladorCarrera?f_accion=editarcarrera01&f_idcarrera=<% out.print(carrera.getIdcarrera()); %>">
                                Editar
                            </a>
                            <a class="btn btn-danger" href="ControladorCarrera?f_accion=eliminarcarrera&f_idcarrera=<% out.print(carrera.getIdcarrera()); %>">
                                Eliminar
                            </a>
                        </td>
                    </tr>
                    <%    }
                    %>       
                    
                    <tr align="center">
                       <td colspan="4">
                    <a class="btn btn-success" href="index.html"> Atrás</a>
                    <a class="btn btn-success" href="ControladorCarrera?f_accion=agregarcarrera01">Agregar Nueva Carrera</a>
                       </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
