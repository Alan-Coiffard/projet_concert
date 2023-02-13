/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gwendal Roy
 */
@Entity
@Table(name = "billet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Billet.findAll", query = "SELECT b FROM Billet b"),
    @NamedQuery(name = "Billet.findById", query = "SELECT b FROM Billet b WHERE b.id = :id"),
    @NamedQuery(name = "Billet.findByNumero", query = "SELECT b FROM Billet b WHERE b.numero = :numero"),
    @NamedQuery(name = "Billet.findByPrix", query = "SELECT b FROM Billet b WHERE b.prix = :prix"),
    @NamedQuery(name = "Billet.findByType", query = "SELECT b FROM Billet b WHERE b.type = :type"),
    @NamedQuery(name = "Billet.findByConcertSoireeId", query = "SELECT b FROM Billet b WHERE b.concertSoireeId = :concertSoireeId")})
public class Billet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero")
    private String numero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix")
    private Float prix;
    @Column(name = "type")
    private String type;
    @Column(name = "concert_soiree_id")
    private Integer concertSoireeId;

    public Billet() {
    }

    public Billet(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getConcertSoireeId() {
        return concertSoireeId;
    }

    public void setConcertSoireeId(Integer concertSoireeId) {
        this.concertSoireeId = concertSoireeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billet)) {
            return false;
        }
        Billet other = (Billet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Billet[ id=" + id + " ]";
    }
    
}
