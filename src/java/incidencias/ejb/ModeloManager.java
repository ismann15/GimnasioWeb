/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.ejb;

import incidencias.entity.Maquina;
import incidencias.entity.Modelo;
import incidencias.exceptions.CrearModeloException;
import incidencias.exceptions.EliminarModeloException;
import incidencias.exceptions.IncorrectInputException;
import incidencias.exceptions.ModificarModeloException;
import incidencias.exceptions.QueryException;
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
public class ModeloManager implements ModeloManagerLocal {

    //Declaración del EJB que nos permitirá administrar los datos
    @PersistenceContext
    private EntityManager em;
    
    //Declaración del cuaderno de bitacora
    private static final Logger log =
            Logger.getLogger("incidencias.ejb");
    
    @Override
    public List<Modelo> getAllModelos() throws QueryException {
    
    //Creamos una lista de objetos modelo vacia, que se utilizará para
    //cargar los datos y devolverlos en el return
    List<Modelo> modelos = null;
    
    //Se avisa de que se está realizando una carga de datos
    log.info("ModeloManager: Se están cargando los modelos");
    
    try {
        
        //Realizamos la carga de datos
        modelos = em.createNamedQuery("findAllModelos").getResultList();
        
        //Se avisa de que se ha realizado la carga de datos
        log.info("ModeloManager: Se han cargado los datos de los modelos");
        
    } catch (Exception e) {
        
        //Se avisa de que ha sucedido un error durante la carga de datos
        log.severe("ModeloManager: Error cargando los datos de los modelos "
                + e.getMessage());
        
        //Se llama a lla excepción de problemas en las busquedas
        throw new QueryException(e.getMessage());
        
    }
  
    //Se devuelve la lista de objetos modelo cargada con los datos de todos los modelos
    return modelos;
    
    }

    @Override
    public int idFromNombre(String nombre) throws QueryException {
    
        //Creamos un integer vacio que se utilizará para devolver los datos
        // en el return
        int id = -1;
        
        //Se avisa de que se está realizando una busqueda de id por nombre de modelo
        log.info("ModeloManager: Se está realizando una busqueda de id por "
                + "nombre de modelo");
        
        try {
            
            //Realizamos la busqueda
            id = em.createNamedQuery("findIDByNombre")
                    .setParameter("nombre", nombre)
                    .getFirstResult();
            
            //Se avisa de que se ha realizado la busqueda de forma correcta
            log.info("ModeloManager: Se ha cargado el id del modelo a partir de"
                    + " su nombre de forma correcta"); 
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error durante la busqueda
            log.severe("ModeloManager: Error realizando la busqueda del id del "
                    + "modelo por su nombre" + e.getMessage());
            
            //Se llama a la excepción de problemas en las busquedas
            throw new QueryException(e.getMessage());
            
        }
        
        //Se devuelve el integer cargado con la id
        return id;
        
    }

    @Override
    public void crearModelo(Modelo modelo) throws CrearModeloException {
    
        //Se avisa de que se está creando un modelo
        log.info("ModeloManager: Se está creando un modelo");
        
        try {
            
            //Guardamos un modelo
            em.persist(modelo);
            
            //Se avisa de que se ha creado un modelo con éxito
            log.info("ModeloManager: Se ha creado un modelo");
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se crea un modelo
            log.severe("ModeloManager: Error creando un modelo "
                    + e.getMessage());
            
            //Se llama a la excepción de creación de modelos
            throw new CrearModeloException (e.getMessage());
            
        }
        
    }

    @Override
    public void eliminarModelo(Modelo modelo) throws EliminarModeloException {
        
        //Se avisa de que se está eliminando un modelo
        log.info("ModeloManager: Se está eliminando un modelo");
        
        try {
            
            //Eliminamos un modelo
            em.remove(modelo);
            
            //Se avisa de que se ha eliminado un modelo con éxito
            log.info("ModeloManager: Se ha eliminado un modelo");
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se elimina un modelo
            log.severe("ModeloManager: Error eliminando un modelo "
                    + e.getMessage());
            
            //Se llama a la excepción de eliminación de modelos
            throw new EliminarModeloException (e.getMessage());
            
        }  
        
    }

    @Override
    public void modificarModelo(Modelo modelo) throws ModificarModeloException {
     
        //Se avisa de que se está modificando un modelo
        log.info("ModeloManager: Se está modificando un modelo");
        
        try {
            
            //Modificamos un modelo
            em.refresh(modelo);
            
            //Se avisa de que se ha modificado un modelo con éxito
            log.info("ModeloManager: Se ha modificado un modelo");
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se modifica un modelo
            log.severe("ModeloManager: Error modificando un modelo "
                    + e.getMessage());
            
            //Se llama a la excepción de modificación de modelos
            throw new ModificarModeloException (e.getMessage());
            
        }
        
    }

    @Override
    public Modelo getModeloByID(String id) throws QueryException,IncorrectInputException {
    
        //Creamos una objeto modelo vacio, que se utilizará para
        //cargar los datos y devolverlos en el return
        Modelo modelos = null;

        //Se avisa de que se está realizando una carga de datos
        log.info("ModeloManager: Se está realizando un filtrado de los modelos"
                + "por su id");

        try {
                       
            if (!(Integer.parseInt(id) > -1)) {
            
            //Se avisa de que ha sucedido un error porque el input es incorrecto
            log.severe("MaquinaManager: El dato introducido no es un numero"
                    + " positivo");
            
            //Se llama a la excepcion de problemas con el input
            throw new IncorrectInputException("El dato no es un numero positivo");
            
            }
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error porque el input es incorrecto
            log.severe("MaquinaManager: El dato introducido no es un número");
            
            //Se llama a la excepcion de problemas con el input
            throw new IncorrectInputException("El dato no es un numero");
            
        }
        
        try {

            //Realizamos la carga de datos
            modelos = (Modelo)em.createNamedQuery("findModeloByID")
                            .setParameter("id", Integer.parseInt(id))
                            .getSingleResult();

            //Se avisa de que se ha realizado la carga de datos
            log.info("ModeloManager: Se han cargado los datos de los modelos"
                    + "filtrados por su id");

        } catch (Exception e) {

            //Se avisa de que ha sucedido un error durante la carga de datos
            log.severe("ModeloManager: Error cargando los datos de los modelos"
                    + "filtrados por su id " + e.getMessage());

            //Se llama a lla excepción de problemas en las busquedas
            throw new QueryException(e.getMessage());

        }

        //Se devuelve la lista de objetos modelo cargada con los datos de todos los modelos
        return modelos;
    
    }
  
}
