/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que gestiona los modelos que puede tener un objeto {@link incidencias.entity.Maquina}
 * <ul>
 *  <li>id: es el identificador de modelo, es unico, en ningun momento
 *             es necesario darle un valor a este campo, se lo da automaticamente el programa</li>
 *  <li>nombre: es el nombre para el modelo</li>
 *  <li>modoEmpleo: define el modo de uso del modelo</li>
 * </ul>
 * 
 * @author isma
 */
@Entity
@Table(name="modelo",schema="dindb")
@NamedQueries({
    @NamedQuery(
            name="findAllModelos",
            query="SELECT m FROM Modelo m ORDER BY m.id"
    ),
    @NamedQuery(
            name="findModeloByID",
            query="SELECT m FROM Modelo m WHERE m.id = :id"
    ),
    @NamedQuery(
            name="findIDByNombre",
            query="SELECT m.id FROM Modelo m WHERE m.nombre = :nombre"
    )
})
@XmlRootElement
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String modoEmpleo;
    @OneToMany(mappedBy ="modelo")
    private Collection<Maquina> maquinas;
    
    /**Constructor sobrecargado vacio para un objeto Modelo, da valores null a todos los atributos*/
    public Modelo(){
        
    }
    /**Constructor sobrecargado que recibe los valores de nombre y modoEmpleo
     * @param nombre es el nombre del modelo
     * @param modoEmpleo define el modo de empleo del modelo
     */
    public Modelo(String nombre, String modoEmpleo){
        this.nombre=nombre;
        this.modoEmpleo=modoEmpleo;
    }

    public Collection<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(Collection<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModoEmpleo() {
        return modoEmpleo;
    }

    public void setModoEmpleo(String modoEmpleo) {
        this.modoEmpleo = modoEmpleo;
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
        Boolean ok=true;
        if (!(object instanceof Modelo)) {
            return false;
        }else{
            Modelo other= (Modelo)object;
            if(this.id==null||this.nombre==null||other.id==null||other.nombre==null){
                ok=false;
            }else if(!(this.id.equals(other.id)||this.nombre.equalsIgnoreCase(other.nombre))){
                ok=false;
            }
        }
        return ok;
    }

    @Override
    public String toString() {
        return "incidencias.tabla.entity.Modelo[ id=" + id + " ]";
    }
    
}
