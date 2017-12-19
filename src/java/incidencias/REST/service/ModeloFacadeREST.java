/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.REST.service;

import incidencias.ejb.ModeloManagerLocal;
import incidencias.entity.Modelo;
import incidencias.exceptions.EliminarModeloException;
import incidencias.exceptions.ModificarModeloException;
import incidencias.exceptions.QueryException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ubuntu
 */
@Path("incidencias.entity.modelo")
public class ModeloFacadeREST{

    private static final Logger LOGGER = Logger.getLogger("incidencias.REST.ModeloREST");
    @EJB
    private ModeloManagerLocal mml;

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Modelo entity) {
        
        //Se avisa de que se está creando un modelo
        LOGGER.log(Level.INFO,"ModeloManager: Se está creando un modelo {0}",entity);
        
        try {
            
            //Guardamos un modelo
            mml.crearModelo(entity);
            
            //Se avisa de que se ha creado un modelo con éxito
            LOGGER.log(Level.INFO,"ModeloManager: Se ha creado un modelo {0}",entity);
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se crea un modelo
            LOGGER.log(Level.SEVERE,"ModeloManager: Error creando un modelo",e);
            
        }
        
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Modelo entity) {

        //Se avisa de que se está modificando un modelo
        LOGGER.log(Level.INFO,"ModeloManager: Se está modificando un modelo {0}",entity);
        
        try {
            
            //Modificamos un modelo
            mml.modificarModelo(entity);
            
            //Se avisa de que se ha modificado un modelo con éxito
            LOGGER.log(Level.INFO,"ModeloManager: Se ha modificado un modelo {0}",entity);
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se modifica un modelo
            LOGGER.log(Level.SEVERE,"ModeloManager: Error modificando un modelo {0}",entity);
        }
    
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
    
        //Se avisa de que se está eliminando un modelo
        LOGGER.log(Level.INFO,"ModeloManager: Se está eliminando un modelo");
        
        try {
            
            //Eliminamos un modelo
            mml.eliminarModelo(mml.getModeloByID(String.valueOf(id)));
            
            //Se avisa de que se ha eliminado un modelo con éxito
            LOGGER.log(Level.INFO,"ModeloManager: Se ha eliminado un modelo");
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se elimina un modelo
            LOGGER.log(Level.SEVERE,"ModeloManager: Error eliminando un modelo ",e);
            
        }  
    
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Modelo find(@PathParam("id") Integer id) {
        
        Modelo modelo = null;
        
        //Se avisa de que se está realizando una carga de datos
        LOGGER.log(Level.INFO,"ModeloManager: Se está realizando un filtrado de"
                + "los modelos por su id");

        try {

            //Realizamos la carga de datos
            modelo = mml.getModeloByID(String.valueOf(id));

            //Se avisa de que se ha realizado la carga de datos
            LOGGER.log(Level.INFO,"ModeloManager: Se han cargado los datos de"
                    + "los modelos filtrados por su id");

        } catch (Exception e) {

            //Se avisa de que ha sucedido un error durante la carga de datos
            LOGGER.log(Level.SEVERE,"ModeloManager: Error cargando los datos de"
                    + "los modelos filtrados por su id ",e);

        }

        //Se devuelve la lista de objetos modelo cargada con los datos de todos los modelos
        return modelo;
        
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Modelo> findAll() {

        //Creamos una lista de objetos modelo vacia, que se utilizará para
        //cargar los datos y devolverlos en el return
        List<Modelo> modelos = null;

        //Se avisa de que se está realizando una carga de datos
        LOGGER.log(Level.INFO,"ModeloManager: Se están cargando los modelos");

        try {

            //Realizamos la carga de datos
            modelos = mml.getAllModelos();

            //Se avisa de que se ha realizado la carga de datos
            LOGGER.log(Level.INFO,"ModeloManager: Se han cargado los datos de los modelos");

        } catch (Exception e) {

            //Se avisa de que ha sucedido un error durante la carga de datos
            LOGGER.log(Level.SEVERE,"ModeloManager: Error cargando los datos de"
                    + "los modelos",e);

        }

        //Se devuelve la lista de objetos modelo cargada con los datos de todos los modelos
        return modelos;

    }
    
}
