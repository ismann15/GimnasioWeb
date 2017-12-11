/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.ejb;

import incidencias.entity.Incidencia;
import incidencias.entity.Maquina;
import incidencias.exceptions.DateFormatException;
import incidencias.exceptions.DeleteException;
import incidencias.exceptions.InsertException;
import incidencias.exceptions.NoEstadosException;
import incidencias.exceptions.NoIdException;
import incidencias.exceptions.NoIncidenciasException;
import incidencias.exceptions.NoMaquinasException;
import incidencias.exceptions.QueryException;
import incidencias.exceptions.UpdateException;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author isma
 */
@Stateless
public class IncidenciaManager implements IncidenciaLocalManager{
    
    @PersistenceContext
    private EntityManager em;
    /**
     * Logger for the class
     */
    private static final Logger log= Logger.getLogger("incidencias.ejb.IncidenciaManager");

    @Override
    public List<Incidencia> getAllIncidencias() throws NoIncidenciasException, QueryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Incidencia> getFiltradasFecha(String fecha, List<Incidencia> filtro) throws DateFormatException, QueryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Incidencia> getFiltradasMaquina(String maquina, List<Incidencia> filtro) throws QueryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Incidencia> getFiltradasEstado(String estado, List<Incidencia> filtro) throws QueryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Incidencia> getFiltradasID(String id, List<Incidencia> filtro) throws NoIdException, QueryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Maquina> getAllMaquinas() throws NoMaquinasException, QueryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getAllEstados() throws NoEstadosException, QueryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void añadirIncidencia(Incidencia incidencia) throws InsertException {
        log.severe("IncidencaManager:añadirIncidencia creando la incidencia");
        if(incidencia.getId()==null||incidencia.getEstado()==null||
                incidencia.getEstado().equals("")||incidencia.getFechaAlta()==null||
                incidencia.getMaquina()==null){
            log.severe("IncidencaManager:añadirIncidencia creando la incidencia");
            throw new InsertException("Algunos campos de la incidencia no estan informados");
        }
        try{
           em.persist(incidencia);
        }catch(Exception e){
           log.severe("IncidencaManager:añadirIncidencia: "+e.getMessage());
           throw new InsertException(e.getMessage());
        }
    }

    @Override
    public void modificarIncidencia(Incidencia incidencia) throws UpdateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void elimiarIncidencia(Incidencia incidencia) throws DeleteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
