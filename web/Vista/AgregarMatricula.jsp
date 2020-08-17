

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AgregarEstudiante</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <form name="AgregarEstudianteForm" action="ControladorMatricula" method="get">
                <table  class="table">
                    <thead>
                        <tr>
                            <th class="text-center" colspan="2">Agregar Estudiante</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-right">Semestre</td>
                            <td><input class="form-control" type="text" name="f_semestre" value="" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Ciclo</td>
                            <td><input class="form-control" type="text" name="f_Ciclo" value="" maxlength="50" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Curso</td>
                            <td><input class="form-control" type="text" name="f_id_curso" value="" maxlength="8" size="8" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Estudiante</td>
                            <td><input class="form-control" type="text" name="f_id_estudiante" value="" maxlength="9" size="9" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Carrera</td>
                            <td><input class="form-control" type="text" name="f_id_carrera" value="" maxlength="50" size="20" /></td>
                        </tr>
                        
                        
                        <tr>
                            <td class="text-right">Estado</td>
                            <td><input class="form-control" type="text" name="f_estado" value="" maxlength="1" size="2" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="text-center">
                                <input class="btn-primary" type="submit" value="Agregar Estudiante" name="agregar" />
                                <input type="hidden" value="agregarestudiante02" name="f_accion"/>
                                    
                            </td>
                        </tr>
                        
                        
                        
                    </tbody>
                </table>
                
            </form>
        </div>
    </body>
</html>
