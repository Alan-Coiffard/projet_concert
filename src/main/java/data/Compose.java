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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gwendal Roy
 */
@Entity
@Table(name = "compose")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compose.findAll", query = "SELECT c FROM Compose c"),
    @NamedQuery(name = "Compose.findById", query = "SELECT c FROM Compose c WHERE c.id = :id")})
public class Compose implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "concert_id", referencedColumnName = "id")
    @ManyToOne
    private Concert concertId;
    @JoinColumn(name = "soiree_id", referencedColumnName = "id")
    @ManyToOne
    private Soiree soireeId;

    public Compose() {
    }

    public Compose(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Concert getConcertId() {
        return concertId;
    }

    public void setConcertId(Concert concertId) {
        this.concertId = concertId;
    }

    public Soiree getSoireeId() {
        return soireeId;
    }

    public void setSoireeId(Soiree soireeId) {
        this.soireeId = soireeId;
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
        if (!(object instanceof Compose)) {
            return false;
        }
        Compose other = (Compose) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Compose[ id=" + id + " ]";
    }
    
}
