
<%@page import="Modelo.Matricula"%>
<%@page import="ModeloDAO.MatriculaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Matricula</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%
                MatriculaDAO matriculaDAO = new MatriculaDAO();
                int s_idmatricula = Integer.valueOf(request.getParameter("f_idmatricula"));
                Matricula matricula = (Matricula)matriculaDAO.buscarmatricula(s_idmatricula);
            %>
            <form name="EditarMatriculaForm" action="Controlador" method="get">
                <table  class="table">
                    <thead>
                        <tr>
                            <th class="text-center" colspan="2">Editar Matricula</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-right">Semestre</td>
                            <td><input class="form-control" type="text" name="f_semestre" value="<% out.println(matricula.getSemestre()); %>" maxlength="6" size="10" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Ciclo</td>
                            <td><input class="form-control" type="text" name="f_ciclo" value="<% out.println(matricula.getCiclo()); %>" maxlength="11" size="11" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Curso</td>
                            <td><input class="form-control" type="text" name="f_id_curso" value="<% out.println(matricula.getId_curso()); %>" maxlength="11" size="11" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Estudiante</td>
                            <td><input class="form-control" type="text" name="f_id_estudiante" value="<% out.println(matricula.getId_estudiante()); %>" maxlength="10" size="10" /></td>
                        </tr>
                        
                        <tr>
                            <td class="text-right">Carrera</td>
                            <td><input class="form-control" type="text" name="f_id_carrera" value="<% out.println(matricula.getId_carrera()); %>" maxlength="10" size="10" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Estado</td>
                            <td><input class="form-control" type="text" name="f_estado" value="<% out.println(matricula.getEstado()); %>" maxlength="1" size="2" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="text-center" >
                                <input class="btn btn-primary" type="submit" value="Editar Matricula" name="editar" />
                                <input type="hidden" value="editarmatricula02" name="f_accion"/>
                                <input type="hidden" value="<% out.print(matricula.getIdmatricula()); %>" name="f_idmatricula">

                            </td>
                        </tr>

                    </tbody>
                </table>


            </form>
        </div>
    </body>
</html>
