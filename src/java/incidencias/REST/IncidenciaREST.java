/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.REST;

import incidencias.ejb.IncidenciaLocalManager;
import incidencias.entity.Incidencia;
import incidencias.exceptions.DeleteException;
import incidencias.exceptions.IncorrectInputException;
import incidencias.exceptions.InsertException;
import incidencias.exceptions.NoIncidenciasException;
import incidencias.exceptions.QueryException;
import incidencias.exceptions.UpdateException;
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
@Path("incidencia")
public class IncidenciaREST{
    
    private static final Logger LOGGER= Logger.getLogger("incidencias.REST.IncidenciaREST");
    @EJB
    private IncidenciaLocalManager ejb;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Incidencia incidencia) {
        try{
            LOGGER.log(Level.INFO,"IncidenciaRest: create {0}.",incidencia);
            ejb.añadirIncidencia(incidencia);
        } catch (InsertException e) {
            LOGGER.log(Level.SEVERE,null,e);
        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void update(Incidencia incidencia) {
        LOGGER.log(Level.INFO,"IncidenciaRest: update{0}.",incidencia);
        try {
            ejb.modificarIncidencia(incidencia);
        } catch (UpdateException e) {
            LOGGER.log(Level.SEVERE,null,e);
        }
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
        try {
            LOGGER.log(Level.INFO,"IncidenciaREST: delete by id={0}.",id);
            ejb.elimiarIncidencia(ejb.getFiltradasID(id.toString()));
        } catch (NoIncidenciasException | IncorrectInputException | QueryException | DeleteException e) {
            LOGGER.log(Level.SEVERE,null,e);
        }
       
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Incidencia find(@PathParam("id") Integer id) {
        Incidencia incidencia=null;
        try {
            LOGGER.log(Level.INFO,"IncidenciasREST: find id={0}.",id);
            incidencia=ejb.getFiltradasID(id.toString());
        } catch (NoIncidenciasException | IncorrectInputException | QueryException e) {
            LOGGER.log(Level.SEVERE,null,e);
        }
        return incidencia;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Incidencia> findAll() {
        List<Incidencia> incidencias = null;
        try {
            LOGGER.log(Level.SEVERE,"IncidenciaREST: find all users.");
            incidencias=ejb.getAllIncidencias();
        } catch (NoIncidenciasException | QueryException e) {
            LOGGER.log(Level.SEVERE,null,e);
        }
        return incidencias;
    }    
    
    /*@GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Incidencia> findByMaquina(Maquina maquina) {
        return null;
    }*/
}
