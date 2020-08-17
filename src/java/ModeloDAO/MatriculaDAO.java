package ModeloDAO;

import Config.bd.ConectaBd;
import Interfaces.CRUDMatricula;

import Modelo.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO implements CRUDMatricula{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Matricula e = new Matricula();

    @Override
    public List listarmatricula() {
        ArrayList<Matricula> matriculas = new ArrayList<>();
        String consulta = " select * "
                        + "from matricula ";
        
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                Matricula matricula = new Matricula();
                matricula.setIdmatricula(rs.getInt("idmatricula"));
                matricula.setSemestre(rs.getString("semestre"));
                matricula.setCiclo(rs.getString("ciclo"));
                matricula.setId_curso(rs.getString("id_curso"));
                matricula.setId_estudiante(rs.getString("id_estudiante"));
                matricula.setId_carrera(rs.getString("id_carrera"));
                matricula.setEstado(rs.getString("estado"));
                matriculas.add(matricula);
            }
        } catch (Exception e) {
            
        }
        return matriculas;
    }

    @Override
    public Matricula buscarmatricula(int idmatricula) {
        String consulta = " select *  "
                        + " from matricula  "
                        + " where idmatricula = " + idmatricula + " ;";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                e.setIdmatricula(rs.getInt("idmatricula"));
                e.setSemestre(rs.getString("semestre"));
                e.setCiclo(rs.getString("ciclo"));
                e.setId_curso(rs.getString("id_curso"));
                e.setId_estudiante(rs.getString("id_estudiante"));
                e.setId_carrera(rs.getString("id_carrera"));
                e.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }
        
        return e;
    }

    @Override
    public boolean agregarmatricula(Matricula matricula) {
        String consulta = " insert into matricula(semestre, ciclo, id_curso, id_estudiante, id_carrera, estado)  "
                        + " values( "
                        + "'"+ matricula.getSemestre() +"', "
                        + "'"+ matricula.getCiclo() +"', "
                        + "'"+ matricula.getId_curso() +"', "
                        + "'"+ matricula.getId_estudiante() +"', "
                        + "'"+ matricula.getId_carrera() +"', "
                        + "'"+ matricula.getEstado() +"') ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editarmatricula(Matricula matricula) {
        String consulta = " update matricula "
                        + " set "
                        + " semestre = '"+ matricula.getSemestre() +"', "
                        + " ciclo = '"+ matricula.getCiclo() +"', "
                        + " id_curso = '"+ matricula.getId_curso() +"', "
                        + " id_estudiante = '"+ matricula.getId_estudiante() +"', "
                        + " id_carrera = '"+ matricula.getId_carrera() +"', "
                        + " estado = '"+ matricula.getEstado() +"' "
                        + " where "
                        + " idmatricula = " + matricula.getIdmatricula() + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminarmatricula(int idmatricula) {
        String consulta = " delete from matricula "
                        + " where "
                        + " idmatricula = " + idmatricula + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

  
    
}
