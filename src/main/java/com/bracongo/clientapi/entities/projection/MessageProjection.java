package com.bracongo.clientapi.entities.projection;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name = "messageProjection")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageProjection implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String clients;
    
    private String titreMessage;
    
    private String contenuMessage;

    public String getClients() {
        return clients;
    }

    public void setClients(String clients) {
        this.clients = clients;
    }

    public String getTitreMessage() {
        return titreMessage;
    }

    public void setTitreMessage(String titreMessage) {
        this.titreMessage = titreMessage;
    }

    public String getContenuMessage() {
        return contenuMessage;
    }

    public void setContenuMessage(String contenuMessage) {
        this.contenuMessage = contenuMessage;
    }
    
    
    
}
