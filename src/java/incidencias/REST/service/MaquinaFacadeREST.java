/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.REST.service;

import incidencias.ejb.MaquinaManager;
import incidencias.ejb.MaquinaManagerLocal;
import incidencias.entity.Maquina;
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
@Path("incidencias.entity.maquina")
public class MaquinaFacadeREST {

    private static final Logger LOGGER = Logger.getLogger("incidencias.REST.ModeloREST");
    @EJB
    private MaquinaManagerLocal mml;

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Maquina entity) {
        
        //Se avisa de que se está creando una maqunia
        LOGGER.log(Level.INFO,"MaquinaREST: create {0}",entity);
        
        try {
            
            //Guardamos un maquina
            mml.crearMaquina(entity);
            
            //Se avisa de que se ha creado una maquina con éxito
            LOGGER.log(Level.INFO,"MaquinaREST: Se ha creado una maquina {0}",entity);
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se crea una maquina
            LOGGER.log(Level.SEVERE,null,e);
            
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Maquina entity) {
       
        //Se avisa de que se está modificando una maquina
        LOGGER.log(Level.INFO,"MaquinaREST: Se está modificando una maquina {0}",entity);
        
        try {
            
            //Modificamos una maquina
            mml.modificarMaquina(entity);
            
            //Se avisa de que se ha modificado una maquina con exito
            LOGGER.log(Level.INFO,"MaquinaREST: Se ha modificado una maquina",entity);
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se modifica una maquina
            LOGGER.log(Level.INFO,"MaquinaREST: Error modificando una maquina",e);
            
        }
        
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
       
        //Se avisa al Logger de que se está eliminando una maquina
        LOGGER.log(Level.INFO,"MaquinaREST: Se está eliminando una maquina {0}",id);
        
        try {
            
            //Eliminamos una maquina
            mml.eliminarMaquina(mml.getMaquinaByID(String.valueOf(id)));
            
            //Se avisa de que se ha eliminado una maquina con exito
            LOGGER.log(Level.INFO,"MaquinaREST: Se ha eliminado una maquina {0}",id);
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se elimina una maquina
            LOGGER.log(Level.ALL,"MaquinaREST: Error eliminando una maquina",e);
            
        }
        
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Maquina find(@PathParam("id") Integer id) {
        
        Maquina maquina = null;
        
        //Se avisa al Logger de que se está eliminando una maquina
        LOGGER.log(Level.INFO,"MaquinaREST: Se está buscando una maquina {0}",id);
        
        try {
            
            //Buscamos una maquina
            maquina = mml.getMaquinaByID(String.valueOf(id));
            
            //Se avisa de que se ha buscado una maquina
            LOGGER.log(Level.INFO,"MaquinaREST: Se ha encontrado una maquina {0}",id);
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se buscaba una maquina
            LOGGER.log(Level.ALL,"MaquinaREST: Error buscando una maquina",e);
            
        }
        
        return maquina;
        
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Maquina> findAll() {
        
        List <Maquina> maquinas = null;
        
        //Se avisa al Logger de que se está eliminando una maquina
        LOGGER.log(Level.INFO,"MaquinaREST: Se están buscando las maquians");
        
        try {
            
            //Buscamos una maquina
            maquinas = mml.getAllMaquinasList();
            
            //Se avisa de que se ha buscado maquinas
            LOGGER.log(Level.INFO,"MaquinaREST: Se han cargados las maquinas");
            
        } catch (Exception e) {
            
            //Se avisa de que ha sucedido un error cuando se buscaban maquinas
            LOGGER.log(Level.ALL,"MaquinaREST: Error cargando las maquinas");
            
        }
        
        return maquinas;
        
    }
    
}
