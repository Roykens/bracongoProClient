package com.bracongo.clientapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Entity
@Table(name = "HHT_COMMANDE")
@XmlRootElement(name="commande")
@XmlAccessorType(XmlAccessType.FIELD)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class HhtCommande extends BaseClass{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dateCommande")
    private Date dateCommande;
    
    @Column(name = "client")
    private String client;
    
    @XmlTransient
    @JsonIgnore
    @OneToMany(mappedBy = "commande")
    private List<HhtCommandeItem> commandeItems;
    
    @Column(columnDefinition = "int default 1", name = "active")
    private int active;
    
    @Column(columnDefinition = "int default 0", name = "geree")
    private int geree;

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<HhtCommandeItem> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(List<HhtCommandeItem> commandeItems) {
        this.commandeItems = commandeItems;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int isGeree() {
        return geree;
    }

    public void setGeree(int geree) {
        this.geree = geree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
