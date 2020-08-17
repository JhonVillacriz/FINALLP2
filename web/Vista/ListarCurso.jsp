

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Curso"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.CursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Cursos</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Listado de Cursos</h1>
            
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Horas</th>
                        <th class="text-center">Creditos</th>
                        
                        <th class="text-center">Estado</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        CursoDAO cursoDAO = new CursoDAO();
                        List<Curso> cursos = cursoDAO.listarcurso();
                        Iterator<Curso> iterator = cursos.iterator();
                        Curso curso = null;
                        while (iterator.hasNext()) {
                            curso = iterator.next();


                    %>
                    <tr>
                        <td><% out.print(curso.getIdcurso()); %></td>
                        <td><% out.print(curso.getNombre()); %></td>
                        <td><% out.print(curso.getHoras()); %></td>
                        <td><% out.print(curso.getCreditos()); %></td>
                      
                        <td><% out.print(curso.getEstado()); %></td>
                        <td align="center">
                            <a class="btn btn-warning" href="ControladorCurso?f_accion=editarcurso01&f_idcurso=<% out.print(curso.getIdcurso()); %>">
                                Editar
                            </a>
                            <a class="btn btn-danger" href="ControladorCurso?f_accion=eliminarcurso&f_idcurso=<% out.print(curso.getIdcurso()); %>">
                                Eliminar
                            </a>
                        </td>
                    </tr>
                    <%    }
                    %>    
                    
                    <tr align="center">
                       <td align="center" colspan="6">
                    <a class="btn btn-success" href="index.html"> Atrás</a>
                    <a class="btn btn-success" href="ControladorCurso?f_accion=agregarcurso01">Agregar Nuevo Curso</a>
                       </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
