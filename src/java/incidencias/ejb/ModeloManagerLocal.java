/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.ejb;

import incidencias.entity.Modelo;
import incidencias.exceptions.CrearModeloException;
import incidencias.exceptions.EliminarModeloException;
import incidencias.exceptions.IncorrectInputException;
import incidencias.exceptions.ModificarModeloException;
import incidencias.exceptions.QueryException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ubuntu
 */
@Local
public interface ModeloManagerLocal {
    
    public List <Modelo> getAllModelos() throws QueryException;
    
    public Modelo getModeloByID(String id) throws QueryException,IncorrectInputException;
    
    public int idFromNombre (String nombre) throws QueryException;
    
    public void crearModelo(Modelo modelo) throws CrearModeloException;
    
    public void eliminarModelo(Modelo modelo) throws EliminarModeloException;
    
    public void modificarModelo(Modelo modelo) throws ModificarModeloException;
    
}
