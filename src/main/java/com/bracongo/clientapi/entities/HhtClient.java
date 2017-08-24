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
import javax.persistence.Lob;
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
@Table(name = "HHT_CLIENT")
@XmlRootElement(name="clients")
@XmlAccessorType(XmlAccessType.FIELD)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class HhtClient extends BaseClass{

 private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "client", unique = true)
    private String client;
    
    @Column(name = "password")
    private String password;
    
    @XmlTransient
    @Column(columnDefinition = "int default 1", name = "active")
    private int active;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dateCreation")
    private Date dateCreation;
    
    @Lob
    @Column(name = "token", unique = true, length = 1000)
    private String token;
    
    @JsonIgnore
    @XmlTransient
    @OneToMany(mappedBy = "client")
    private List<HhtMessage> hhtMassages;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<HhtMessage> getHhtMassages() {
        return hhtMassages;
    }

    public void setHhtMassages(List<HhtMessage> hhtMassages) {
        this.hhtMassages = hhtMassages;
    }
    
    
    
}
