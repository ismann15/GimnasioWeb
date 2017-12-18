/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.ejb;

import incidencias.entity.EstadoMaquina;
import incidencias.entity.Maquina;
import incidencias.exceptions.CrearMaquinaException;
import incidencias.exceptions.EliminarMaquinaException;
import incidencias.exceptions.IncorrectInputException;
import incidencias.exceptions.ModificarMaquinaException;
import incidencias.exceptions.QueryException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ubuntu
 */
@Stateless
public class MaquinaManager implements MaquinaManagerLocal {

    //Declaracion del EJB que nos permitirá administrar los datos
    @PersistenceContext
    private EntityManager em;
    
    //Declaración del cuaderno de bitacora
    private static final Logger log =
            Logger.getLogger("incidencias.ejb");
    
    @Override
    public List<Maquina> getAllMaquinasList() throws QueryException {
    
        //Creamos una lista de objetos maquina vacia, que se utilizará para
        //cargar los datos y devolverlos en el return
        List<Maquina> maquinas = null;
        
        //Se avisa de que se está realizando una carga de datos
        log.info("MaquinaManager: Se están cargando las maquinas");
        
        try {
            
            //Realizamos la carga de datos
            maquinas = em.createNamedQuery("findAllMaquinas").getResultList();
            
            //Se avisa de que se ha realizado la carga de datos con exito
            log.info("MaquinaManager: Se han cargado los datos de las maquinas");
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error durante la carga de datos
            log.severe("MaquinaManager: Error cargando los datos de las maquinas"
                    + e.getMessage());
            
            //Se llama a la excepcion de problemas en las busquedas
            throw new QueryException(e.getMessage());
            
        }
        
        //Se devuelve la lista de objetos maquina cargada con los datos
        return maquinas;
                
    }

    @Override
    public Maquina getMaquinaByID(String id) throws QueryException, IncorrectInputException {
    
        //Creamos una lista de objetos maquina vacia, que se utilizará para
        //cargar los datos y devolverlos en el return
        Maquina maquinas = null;
        
        //Se avisa de que se está realizando una carga de datos filtrados
        log.info("MaquinaManager: Se está realizando un filtrado de maquinas"
                + "por su ID");

        if (!(Integer.parseInt(id) > -1)) {
            
            //Se avisa de que ha sucedido un error porque el input es incorrecto
            log.severe("MaquinaManager: El dato introducido no es un numero"
                    + " positivo");
            
            //Se llama a la excepcion de problemas con el input
            throw new IncorrectInputException("El dato no es un numero positivo");
            
        }
        
        try {
            
            //Realizamos la carga de datos
            maquinas = (Maquina)em.createNamedQuery("findMaquinasByID")
                    .setParameter("id", Integer.parseInt(id)).getSingleResult();
            
            //Se avisa de que se ha realizado la carga de datos filtrados
            //con exito
            log.info("MaquinaManager: Se han cargado los datos de las maquinas");
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error durante la carga de datos
            log.severe("MaquinaManager: Error cargando los datos de las maquinas "
                    + "filtradas por ID " + e.getMessage());
            
            //Se llama a la excepción de problemas en las busquedas
            throw new QueryException(e.getMessage());
            
        }
        
        //Se devuelve la lista de objetos maquina cargada con los datos
        return maquinas;
            
    }

    @Override
    public List<Maquina> getMaquinaByFiltroMultiple
        (int idModelo, EstadoMaquina estado, String ultimaRevision)
                throws QueryException{
        
        //Creamos una lista de objetmos maquina vacia, que se utilizará para
        //cargar los datos y devolverlos en el return
        List <Maquina> maquinas = null;
        
        //Se avisa de que se está realizando una carga de datos filtrados
        log.info("MaquinaManager: Se está realizando un filtrado de maquinas "
                + "por su modelo, estado y fecha de última revisión");
        
        try {
            
            //Realizamos la carga de datos
            maquinas = em.createNamedQuery("findMaquinasByFitroMultiple")
                    .setParameter("modelo", estado.toString())
                    .setParameter("modelo", idModelo)
                    .setParameter("fecha", Date.valueOf(ultimaRevision))
                    .getResultList();
            
            //Se avisa de que se ha realizado la carga de datos filtrados
            //con exito
            log.info("MaquinaManager: Se han cargado los datos de las maquinas");
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error durante la carga de datos
            log.severe("MaquinaManager: Error cargando los datos de las maquinas "
                    + "filtradas por su modelo, estado y fecha de última revisión "
                    + e.getMessage());
            
            //Se llama a la excepción de problemas en las busquedas
            throw new QueryException(e.getMessage());
            
        }
        
        //Se devuelve la lista de objetos cargada con los datos
        return maquinas;
        
    }
    
    @Override
    public void crearMaquina(Maquina maquina) throws CrearMaquinaException {
        
        //Se avisa de que se está creando una maquina
        log.info("MaquinaManager: Se está creando una maquina");
        
        try {
            
            //Guardamos una maquina
            em.persist(maquina);
            
            //Se avisa de que se ha creado una maquina con exito
            log.info("MaquinaManager: Se ha creado una maquina");
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se crea una maquina
            log.severe("MaquinaManager: Error creando una maquina"
                    + e.getMessage());
            
            //Se llama a la excepción de creación de maquinas
            throw new CrearMaquinaException (e.getMessage());
            
        }
        
    }

    @Override
    public void eliminarMaquina(Maquina maquina) throws EliminarMaquinaException {
    
        //Se avisa al Logger de que se está eliminando una maquina
        log.info("MaquinaManager: Se está eliminando una maquina");
        
        try {
            
            //Eliminamos una maquina
            em.remove(maquina);
            
            //Se avisa de que se ha eliminado una maquina con exito
            log.info("MaquinaManager: Se ha eliminado una maquina");
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se elimina una maquina
            log.severe("MaquinaManager: Error eliminando una maquina"
                    + e.getMessage());
            
            //Se llama a la incidencia de eliminación de maquinas
            throw new EliminarMaquinaException(e.getMessage());
            
        }
        
    }

    @Override
    public void modificarMaquina(Maquina maquina) throws ModificarMaquinaException {
    
        //Se avisa de que se está modificando una maquina
        log.info("MaquinaManager: Se está modificando una maquina");
        
        try {
            
            //Modificamos una maquina
            em.refresh(maquina);
            
            //Se avisa de que se ha modificado una maquina con exito
            log.info("MaquinaManager: Se ha modificado una maquina");
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se modifica una maquina
            log.severe("MaquinaManager: Error modificando una maquina"
                    + e.getMessage());
            
            //Se llama a la incidencia de modificacion de maquinas
            throw new ModificarMaquinaException(e.getMessage());
            
        }
        
    }

}
