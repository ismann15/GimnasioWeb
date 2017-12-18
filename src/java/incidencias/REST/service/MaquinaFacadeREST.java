/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.REST.service;

import incidencias.ejb.MaquinaManager;
import incidencias.ejb.MaquinaManagerLocal;
import incidencias.ejb.ModeloManagerLocal;
import incidencias.entity.Maquina;
import incidencias.exceptions.CrearModeloException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Stateless
@Path("incidencias.entity.maquina")
public class MaquinaFacadeREST {

    private static final Logger LOGGER = Logger.getLogger("incidencias.REST.ModeloREST");
    @EJB
    private MaquinaManager mml;
    
    @PersistenceContext(unitName = "GimnasioWebAplicationPU")
    private EntityManager em;

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
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Maquina find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Maquina> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Maquina> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
