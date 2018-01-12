/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que gestiona maquinas, estos son sus atributos
 * <ul>
 * <li> id : objeto de tipo Integer que identifica a una maquina</li>
 * <li> estadoMaquina : es un objeto de la clase
 * {@link incidencias.entity.EstadoMaquina}, define el estado de la maquina
 * <li> fechaUltimaRevision: objeto de tipo Date que define la fecha de la
 * ultima revision de la maquina</li>
 * <li> fechaProximaRevision: objeto de tipo Date que define la fecha programada
 * para la proxima revision de la maquina</li>
 * <li> modelo:objecto de tipo {@link incidencias.entity.Modelo}, define el
 * modelo de una mquina</li>
 * </ul>
 *
 * @author isma
 */
@Entity
@Table(name="maquina",schema="dindb")
@NamedQueries({
    @NamedQuery(
            name="findAllMaquinas",
            query="SELECT m FROM Maquina m ORDER BY m.id"
    ),
    @NamedQuery(
            name="findMaquinasByID",
            query="SELECT m FROM Maquina m WHERE m.id = :id"
    ),
    @NamedQuery(
            name="findMaquinasByFiltroMultiple",
            query="Select m FROM Maquina m WHERE m.estado = :estado AND m.modelo = :modelo AND m.fechaUltimaRevision  = :fecha"
    )
})
@XmlRootElement
public class Maquina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private EstadoMaquina estado;
    private Date fechaUltimaRevision;
    private Date fechaProximaRevision;
    @ManyToOne
    private Modelo modelo;
    @OneToMany(mappedBy="maquina")
    private Collection<Incidencia> incidencias;

    /**
     * Constructor sobrecargado vacio para un objeto de tipo Maquina, pone valor
     * null a todos los atributos
     */
    public Maquina() {
    }

    /**
     * Constructor sobrecargado que recibe como parametros:
     *
     * @param estado Objeto de tipo {@link incidencias.entity.EstadoMaquina}, es
     * el estado de la maquina
     * @param fechaUltimaRevision Objeto de tipo Date, es la fecha de la ultima
     * revision de la maquina
     * @param fechaProximaRevision Objeto de tipo Date, es la fecha de la
     * proxima revision de la maquina
     * @param modelo Objeto de tipo {@link incidencias.entity.Modelo}, es el
     * modelo de la maquina
     */
    public Maquina(EstadoMaquina estado, Date fechaUltimaRevision,
            Date fechaProximaRevision, Modelo modelo) {
        this.estado = estado;
        this.fechaUltimaRevision = fechaUltimaRevision;
        this.fechaProximaRevision = fechaProximaRevision;
        this.modelo = modelo;
    }

    public Collection<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(Collection<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }
    
    

    public EstadoMaquina getEstado() {
        return estado;
    }

    public void setEstado(EstadoMaquina estado) {
        this.estado = estado;
    }

    public Date getFechaUltimaRevision() {
        return fechaUltimaRevision;
    }

    public void setFechaUltimaRevision(Date fechaUltimaRevision) {
        this.fechaUltimaRevision = fechaUltimaRevision;
    }

    public Date getFechaProximaRevision() {
        return fechaProximaRevision;
    }

    public void setFechaProximaRevision(Date fechaProximaRevision) {
        this.fechaProximaRevision = fechaProximaRevision;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Maquina)) {
            ok = false;
        } else {
            Maquina other = (Maquina) object;
            if (other.id == null || this.id == null) {
                ok = false;
            } else if (!(this.id.equals(other.id))) {
                ok = false;
            }
        }
        return ok;
    }

    @Override
    public String toString() {
        return "incidencias.tabla.entity.Maquina[ id=" + id + " ]";
    }

}