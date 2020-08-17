/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.bd.ConectaBd;
import Interfaces.CRUDcarrera;
import Modelo.Carrera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MONARCA
 */
public class CarreraDAO implements CRUDcarrera{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Carrera e = new Carrera();

    @Override
    public List listarcarrera() {
        ArrayList<Carrera> carreras = new ArrayList<>();
        String consulta = " select * "
                        + "from carrera ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                Carrera carrera = new Carrera();
                carrera.setIdcarrera(rs.getInt("idcarrera"));
                carrera.setNombre(rs.getString("nombre"));
                carrera.setEstado(rs.getString("estado"));
                carreras.add(carrera);
            }
        } catch (Exception e) {
            
        }
        return carreras;
    }

    @Override
    public Carrera buscarcarrrera(int idcarrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarcarrera(Carrera carrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarcarrera(Carrera carrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarcarrera(int idcarrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
