/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.ejb;

import incidencias.entity.EstadoMaquina;
import incidencias.entity.Maquina;
import incidencias.exceptions.CrearMaquinaException;
import incidencias.exceptions.DateFormatException;
import incidencias.exceptions.EliminarMaquinaException;
import incidencias.exceptions.IncorrectInputException;
import incidencias.exceptions.ModificarMaquinaException;
import incidencias.exceptions.QueryException;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ubuntu
 */
@Local
public interface MaquinaManagerLocal {
    
    public List<Maquina> getAllMaquinasList() throws QueryException;
    
    public List<Maquina> getMaquinaByID(String id)
            throws QueryException, IncorrectInputException;
    
    public List<Maquina> getMaquinaByFiltroMultiple(int idModelo, EstadoMaquina estado, String ultimaRevision)
            throws QueryException, DateFormatException;
    
    public void crearMaquina(Maquina maquina) throws CrearMaquinaException;
    
    public void eliminarMaquina(Maquina maquina)
            throws EliminarMaquinaException;
    
    public void modificarMaquina(Maquina maquina)
            throws ModificarMaquinaException;
    
}
