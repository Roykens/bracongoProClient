package com.bracongo.clientapi.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Entity
@Table(name = "HHT_PLAINTE")
@XmlRootElement(name = "hhtPlainte")
@XmlAccessorType(XmlAccessType.FIELD)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class HhtPlainte extends BaseClass {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "client")
    private String client;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "datePlainte")
    private Date datePlainte;

    @Column(name = "type")
    private String typePlainte;

    @Lob
    @Column(length = 1000, name = "contenu")
    private String contenu;
    
    @Column(columnDefinition = "int default 0", name = "geree")
    private int geree;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDatePlainte() {
        return datePlainte;
    }

    public void setDatePlainte(Date datePlainte) {
        this.datePlainte = datePlainte;
    }

    public String getTypePlainte() {
        return typePlainte;
    }

    public void setTypePlainte(String typePlainte) {
        this.typePlainte = typePlainte;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getGeree() {
        return geree;
    }

    public void setGeree(int geree) {
        this.geree = geree;
    }
    
    

}
