package com.bracongo.clientapi.entities.projection;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name = "ventesInfos")
@XmlAccessorType(XmlAccessType.FIELD)
public class VentesInfos implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Double remise;
    
    private Double chiffreAffaire;
    
    private Date dateFinRemise;
    
    private Date dateDebutRemise;
    
    private List<VenteItem> venteItems;
    
    private List<VenteJourItem> venteJourItems;

    public double getRemise() {
        return remise;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
    }

    public List<VenteItem> getVenteItems() {
        return venteItems;
    }

    public void setVenteItems(List<VenteItem> venteItems) {
        this.venteItems = venteItems;
    }

    public List<VenteJourItem> getVenteJourItems() {
        return venteJourItems;
    }

    public void setVenteJourItems(List<VenteJourItem> venteJourItems) {
        this.venteJourItems = venteJourItems;
    }

    public Date getDateFinRemise() {
        return dateFinRemise;
    }

    public void setDateFinRemise(Date dateFinRemise) {
        this.dateFinRemise = dateFinRemise;
    }

    public Date getDateDebutRemise() {
        return dateDebutRemise;
    }

    public void setDateDebutRemise(Date dateDebutRemise) {
        this.dateDebutRemise = dateDebutRemise;
    }

    public Double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(Double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }
    
    
    
}
