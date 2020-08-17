/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Carrera;
import java.util.List;

/**
 *
 * @author MONARCA
 */
public interface CRUDcarrera {
  public List listarcarrera(); // listar
    public Carrera buscarcarrrera(int idcarrera); // buscar
    public boolean agregarcarrera(Carrera carrera); // agregar
    public boolean editarcarrera(Carrera carrera); // editar
    public boolean eliminarcarrera(int idcarrera); // eliminar
}
