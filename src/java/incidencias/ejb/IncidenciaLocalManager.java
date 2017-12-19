/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.ejb;


import incidencias.entity.Incidencia;
import incidencias.entity.Maquina;
import incidencias.exceptions.NoIncidenciasException;
import incidencias.exceptions.DateFormatException;
import incidencias.exceptions.DeleteException;
import incidencias.exceptions.IncorrectInputException;
import incidencias.exceptions.InsertException;
import incidencias.exceptions.NoEstadosException;
import incidencias.exceptions.NoMaquinasException;
import incidencias.exceptions.QueryException;
import incidencias.exceptions.UpdateException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author isma
 */
@Local
public interface IncidenciaLocalManager {
    
    public List<Incidencia> getAllIncidencias()throws NoIncidenciasException, QueryException;
    
    public List<Incidencia> getFiltradasFecha(String fecha, List<Incidencia> filtro) throws NoIncidenciasException, DateFormatException, QueryException;
    
    public List<Incidencia> getFiltradasMaquina(String maquina, List <Incidencia> filtro) throws NoIncidenciasException, QueryException;
    
    public List<Incidencia> getFiltradasEstado (String estado, List <Incidencia> filtro) throws NoIncidenciasException, QueryException;
    
    public Incidencia getFiltradasID(String id) throws NoIncidenciasException,IncorrectInputException, QueryException;
    
    public List<Maquina> getAllMaquinas() throws NoMaquinasException,QueryException;
    
    public List<String> getAllEstados() throws NoEstadosException, QueryException;
    
    public void añadirIncidencia(Incidencia incidencia) throws InsertException;
    
    public void modificarIncidencia(Incidencia incidencia) throws UpdateException;
    
    public void elimiarIncidencia (Incidencia incidencia) throws DeleteException;
    
}
