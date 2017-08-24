package com.bracongo.clientapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Entity
@Table(name = "HHT_COMMANDE_ITEM")
@XmlRootElement(name="commandeItem")
@XmlAccessorType(XmlAccessType.FIELD)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class HhtCommandeItem extends BaseClass{

    @ManyToOne
    private HhtCommande commande;
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    /**
     * le nom du produit commande
     */
    @Column(name = "nom")
    private String nom;
    
    /**
     * la quantite commande
     */
    @Column(name = "nombre")
    private int nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CommandeItem{" + "id=" + id + ", nom=" + nom + ", nombre=" + nombre + '}';
    }

    public HhtCommande getCommande() {
        return commande;
    }

    public void setCommande(HhtCommande commande) {
        this.commande = commande;
    }
    
    
    
}
