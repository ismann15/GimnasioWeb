/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Clase que gestiona las posibles incidencias que una
 * {@link incidencias.entity.Maquina} puede tener, estos son sus atributos:
 * <ul>
 * <li>id: objeto de tipo Integer identificador de la incidencia, es unico y
 * autognerado</li>
 * <li>estado: objeto de tipo {@link incidencias.entity.EstadoIncidencia}, es el
 * estado de la incidencia</li>
 * <li> fechaAlta: objeto de tipo Date, es la fecha cuando se realizo la
 * incidencia</li>
 * <li> maquina: objeto de tipo {@link incidencias.entity.Maquina}, es la
 * maquina sobre la que se ha realizado la incidencia </li>
 * </ul>
 *
 * @author isma
 */
@Entity
@Table(name="",schema="")
@NamedQueries({
    @NamedQuery(
           name="findAllIncidencias",
           query="SELECT i FROM Incidencia i ORDER BY i.fechaAlta"),
    @NamedQuery(
            name="findIncidenciaById",
            query="SELECT i FROM Inciencia i WHERE i.id= :id"),
    @NamedQuery(
            name="findIncidenciaByEstado",
            query="SELECT i FROM Inciencia i WHERE i.estado= :estado"),
    @NamedQuery(
            name="findIncidenciaByFechaAlta",
            query="SELECT i FROM Inciencia i WHERE i.fechaAlta= :fachaAlta"),
    @NamedQuery(
            name="findIncidenciaByMaquina",
            query="SELECT i FROM Inciencia i WHERE i.maquina= :maquina"),
})
public class Incidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private EstadoIncidencia estado;
    private Date fechaAlta;
    private Maquina maquina;
   

    /**
     * Constructor sobrecargado vacio para un objeto Incidencia, da valores null
     * a todos los atributos
     */
    public Incidencia() {
        this.estado = null;
        this.fechaAlta = null;
        this.maquina = null;
    }

    /**
     * Constructor sobrecargado que recibe como parametros:
     *
     * @param estado objeto de tipo {@link incidencias.entity.EstadoIncidencia},
     * es el estado de la incidencia
     * @param fechaAlta objeto de tipo Date, es la fecha cuando se realizo la
     * incidencia
     * @param maquina objeto de tipo {@link incidencias.entity.Maquina}, es la
     * maquina sobre la que se ha hecho la incidencia
     */
    public Incidencia(EstadoIncidencia estado, Date fechaAlta, Maquina maquina) {
        this.estado = estado;
        this.fechaAlta = fechaAlta;
        this.maquina = maquina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoIncidencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoIncidencia estado) {
        this.estado = estado;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        Boolean ok = true;
        if (!(object instanceof Incidencia)) {
            ok = false;
        } else {
            Incidencia other = (Incidencia) object;
            if (other.id == null || this.id == null) {
                ok = false;
            } else if (!(other.id.equals(this.id))) {
                ok = false;
            }
        }
        return ok;
    }

    @Override
    public String toString() {

        return "incidencias.tabla.entity.Incidencia[ id=" + id + " ]";
    }

}
