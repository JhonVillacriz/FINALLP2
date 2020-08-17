/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.bd.ConectaBd;
import Interfaces.CRUDCurso;
import Modelo.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO implements CRUDCurso{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Curso e = new Curso();

    @Override
    public List listarcurso() {
        ArrayList<Curso> cursos = new ArrayList<>();
        String consulta = " select * "
                        + "from curso ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setIdcurso(rs.getInt("idcurso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setHoras(rs.getString("horas"));
                curso.setCreditos(rs.getString("creditos"));
                
                curso.setEstado(rs.getString("estado"));
                cursos.add(curso);
            }
        } catch (Exception e) {
            
        }
        return cursos;
    }

    @Override
    public Curso buscarcurso(int idcurso) {
        String consulta = " select *  "
                        + " from curso  "
                        + " where idcurso = " + idcurso + " ;";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                e.setIdcurso(rs.getInt("idcurso"));
                e.setNombre(rs.getString("nombre"));
                e.setHoras(rs.getString("horas"));
                e.setCreditos(rs.getString("creditos"));
               
               
                e.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }
        
        return e;
    }

    @Override
    public boolean agregarcurso(Curso curso) {
        String consulta = " insert into curso(nombre, horas, creditos,  estado)  "
                        + " values( "
                        + "'"+ curso.getNombre() +"', "
                        + "'"+ curso.getHoras() +"', "
                        + "'"+ curso.getCreditos() +"', "
                       
                        + "'"+ curso.getEstado() +"') ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editarcurso(Curso curso) {
        String consulta = " update curso "
                        + " set "
                        + " nombre = '"+ curso.getNombre() +"', "
                        + " horas = '"+ curso.getHoras() +"', "
                        + " creditos = '"+ curso.getCreditos() +"', "
                        
                        + " estado = '"+ curso.getEstado() +"' "
                        + " where "
                        + " idcurso = " + curso.getIdcurso() + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminarcurso(int idcurso) {
        String consulta = " delete from curso "
                        + " where "
                        + " idcurso = " + idcurso + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

   

  

    

    
    
}
