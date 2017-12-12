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
import incidencias.exceptions.IncorrectInputException;
import incidencias.exceptions.InsertException;
import incidencias.exceptions.NoEstadosException;
import incidencias.exceptions.NoIncidenciasException;
import incidencias.exceptions.NoMaquinasException;
import incidencias.exceptions.QueryException;
import incidencias.exceptions.UpdateException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
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
        log.severe("IncidenciasManager: obteniendo todas las incidencias");
        List<Incidencia> incidencias=null;
        try{
            incidencias=em.createNamedQuery("findAllIncidencias").getResultList();
            if(incidencias==null||incidencias.isEmpty()){
                log.severe("IncidenciasManager:getAllIncidencias");
                throw new NoIncidenciasException("No se han encontrado incidencias");
            }else{
                log.severe("IncidenciasManager:getAllIncidencias: Incidencias correctamente cargadas");
            }
        }catch(Exception e){
            log.severe("IncidenciasManager: getAllIncidencias: "+e.getMessage());
            throw new QueryException(e.getMessage());
        }
        return incidencias;
    }

    @Override
    public List<Incidencia> getFiltradasFecha(String fecha, List<Incidencia> filtro) throws NoIncidenciasException, DateFormatException, QueryException {
        log.severe("IncidenciaManager: obteninendo las incidencias filtradas por fecha");
        filtro=null;
        SimpleDateFormat dma= new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d= dma.parse(fecha);
            try{
                filtro=em.createNamedQuery("findIncidenciaByFechaAlta").setParameter("fachaAlta", fecha).getResultList();
                if(filtro==null||filtro.isEmpty()){
                    log.severe("IncidenciasManager:getFiltradasFecha: no se han encontrado incidencias");
                    throw new NoIncidenciasException("No se han encontrado incidencias");
                }else{
                    log.severe("IncidenciasManager:getFiltradasFecha: Incidencias correctamente cargadas");
                }
            }catch(Exception e){
                log.severe("IncidenciasManager: getFiltradasFecha: "+e.getMessage());
                throw new QueryException(e.getMessage());
            }    
        } catch (ParseException e) {
            log.severe("IncidenciaManager: getFiltradasFecha: "+e.getMessage());
            throw new DateFormatException(e.getMessage());
        }
        return filtro;
    }

    @Override
    public List<Incidencia> getFiltradasMaquina(String maquina, List<Incidencia> filtro) throws NoIncidenciasException, QueryException {
        log.severe("IncidenciasManager: obteniendo incidencias filtradas por maquina");
        filtro=null;
        try{
            filtro=em.createNamedQuery("findIncidenciaByMaquina").setParameter("maquina", maquina).getResultList();
            if(filtro==null||filtro.isEmpty()){
                log.severe("IncidenciasManager:getFiltradasMaquina: no se han encontrado incidencias");
                throw new NoIncidenciasException("No se han encontrado incidencias");
            }else{
                log.severe("IncidenciasManager:getFiltradasMaquina: Incidencias correctamente cargadas");
            }
        }catch(Exception e){
            log.severe("IncidenciasManager: getFiltradasMaquina: "+e.getMessage());
            throw new QueryException(e.getMessage());
        }
        return filtro;
    }

    @Override
    public List<Incidencia> getFiltradasEstado(String estado, List<Incidencia> filtro) throws NoIncidenciasException, QueryException {
        log.severe("IncidenciasManager: obteniendo incidencias filtradas por estado");
        filtro=null;
        try{
            filtro=em.createNamedQuery("findIncidenciaByEstado").setParameter("estado", estado).getResultList();
            if(filtro==null||filtro.isEmpty()){
                log.severe("IncidenciasManager:getFiltradasEstado: no se han encontrado incidencias");
                throw new NoIncidenciasException("No se han encontrado incidencias");
            }else{
                log.severe("IncidenciasManager:getFiltradasEstado: Incidencias correctamente cargadas");
            }
        }catch(Exception e){
            log.severe("IncidenciasManager: getFiltradasEstado: "+e.getMessage());
            throw new QueryException(e.getMessage());
        }
        return filtro;
    }

    @Override
    public List<Incidencia> getFiltradasID(String id, List<Incidencia> filtro) throws NoIncidenciasException, IncorrectInputException, QueryException {
        log.severe("IncidenciasManager: obteniendo incidencias filtradas por id");
        filtro= null;
        try{
            Integer identificador= Integer.parseInt(id);
            try{
                filtro= em.createNamedQuery("findIncidenciaById").setParameter("id", id).getResultList();
                if(filtro.isEmpty()||filtro==null){
                    log.severe("IncidenciaManager:getFiltradasID: no se han encontrado incidencias");
                    throw new NoIncidenciasException("no se han encontrado incidencias");
                }else{
                    log.severe("IncidenciasManager:getFiltradasID: Incidencias correctamente cargadas");
                }
            }catch(Exception e){
                log.severe("IncidenciasManager: getFiltradasID: "+e.getMessage());
                throw new QueryException(e.getMessage());
            }
            
        }catch(Exception e){
            log.severe ("IncidenciasManager: getFiltradasID: "+e.getMessage());
            throw new IncorrectInputException(e.getMessage());
        }
        
        return filtro;
    }

    @Override
    public List<Maquina> getAllMaquinas() throws NoMaquinasException, QueryException {
        List <Maquina> maquinas= null;
        try{
            
        }catch(Exception e){
            log.severe("IncidenciasManager: getAllMaquinas: "+e.getMessage());
            throw new QueryException(e.getMessage());
        }
        return maquinas;
    }

    @Override
    public List<String> getAllEstados() throws NoEstadosException, QueryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void añadirIncidencia(Incidencia incidencia) throws InsertException {
        log.severe("IncidencaManager: creando la incidencia");
        if(incidencia.getId()==null||incidencia.getEstado()==null||
                incidencia.getEstado().equals("")||incidencia.getFechaAlta()==null||
                incidencia.getMaquina()==null){
            log.severe("IncidencaManager:añadirIncidencia");
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
        log.severe("IncidenciaManager: modificando incidencia");
        if(incidencia.getId()==null||incidencia.getEstado()==null||
                incidencia.getEstado().equals("")||incidencia.getFechaAlta()==null||
                incidencia.getMaquina()==null){
            log.severe("IncidenciaManager: modifiarIncidencia");
            throw new UpdateException("Algunos campos de la incidencia no estan informados");
        }
        try{
            em.refresh(incidencia);
        }catch(Exception e){
           log.severe("IncidencaManager: modificarIncidencia: "+e.getMessage());
           throw new UpdateException(e.getMessage());
        }
        
    }

    @Override
    public void elimiarIncidencia(Incidencia incidencia) throws DeleteException {
        log.severe("IncidenciaManager: eliminando la incidencia");
        if(incidencia.getId()==null||incidencia.getEstado()==null||incidencia.getEstado().equals("")
                ||incidencia.getFechaAlta()==null||incidencia.getMaquina()==null){
            log.severe("IncidenciaManager: eliminarIncidencia");
            throw new DeleteException("Se han encontrado algunos campos vacios al eliminar la incidencia");
        }
        try{
            em.remove(incidencia);
        }catch(Exception e){
            log.severe("IncidenciaManager:eliminarIncidencia: "+e.getMessage());
        }
    }

}
