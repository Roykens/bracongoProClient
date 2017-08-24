package com.bracongo.clientapi.entities.projection;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name = "commandeAnswer")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestAnswer implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String contenu;

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }  
}
