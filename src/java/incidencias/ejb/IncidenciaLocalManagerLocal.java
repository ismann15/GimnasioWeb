/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.ejb;

import incidencias.entity.Incidencia;
import incidencias.entity.Maquina;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author isma
 */
@Local
public interface IncidenciaLocalManagerLocal {
    
    public List <Incidencia> getAllIncidencias();
    
    public List <Incidencia> getFiltradasFecha(String fecha, List<Incidencia> filtro);
    
    public List <Incidencia> getFiltradasMaquina(String maquina, List <Incidencia> filtro);
    
    public List <Incidencia> getFiltradasEstado (String estado, List <Incidencia> filtro);
    
    public List <Incidencia> getFiltradasID(String id, List <Incidencia> filtro);
    
    public List <Maquina> getAllMaquinas();
    
    public List <String> getAllEstados();
    
    public void añadirIncidencia(Incidencia incidencia);
    
    public void modificarIncidencia(Incidencia incidencia);
    
    public void elimiarIncidencia (Incidencia incidencia);
    
}
