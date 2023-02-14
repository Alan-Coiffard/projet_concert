/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gwendal Roy
 */
@Entity
@Table(name = "concert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concert.findAll", query = "SELECT c FROM Concert c"),
    @NamedQuery(name = "Concert.findById", query = "SELECT c FROM Concert c WHERE c.id = :id"),
    @NamedQuery(name = "Concert.findByDateHeure", query = "SELECT c FROM Concert c WHERE c.dateHeure = :dateHeure"),
    @NamedQuery(name = "Concert.findByDuree", query = "SELECT c FROM Concert c WHERE c.duree = :duree"),
    @NamedQuery(name = "Concert.findByPrix", query = "SELECT c FROM Concert c WHERE c.prix = :prix")})
public class Concert implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Column(name = "duree")
    private Integer duree;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix")
    private Float prix;
    @OneToMany(mappedBy = "concertSoireeId")
    private Set<Billet> billetSet;
    @OneToMany(mappedBy = "concertId")
    private Set<Compose> composeSet;
    @JoinColumn(name = "groupe_id", referencedColumnName = "id")
    @ManyToOne
    private Groupe groupeId;
    @JoinColumn(name = "salle_id", referencedColumnName = "id")
    @ManyToOne
    private Salle salleId;

    public Concert() {
    }

    public Concert(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    @XmlTransient
    public Set<Billet> getBilletSet() {
        return billetSet;
    }

    public void setBilletSet(Set<Billet> billetSet) {
        this.billetSet = billetSet;
    }

    @XmlTransient
    public Set<Compose> getComposeSet() {
        return composeSet;
    }

    public void setComposeSet(Set<Compose> composeSet) {
        this.composeSet = composeSet;
    }

    public Groupe getGroupeId() {
        return groupeId;
    }

    public void setGroupeId(Groupe groupeId) {
        this.groupeId = groupeId;
    }

    public Salle getSalleId() {
        return salleId;
    }

    public void setSalleId(Salle salleId) {
        this.salleId = salleId;
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
        if (!(object instanceof Concert)) {
            return false;
        }
        Concert other = (Concert) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Concert[ id=" + id + " ]";
    }
    
}
