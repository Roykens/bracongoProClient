package com.bracongo.clientapi.entities.projection;

import com.bracongo.clientapi.entities.HhtPlainte;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name = "plainte")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlainteProjection implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String client;
    
    private HhtPlainte plainte;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public HhtPlainte getPlainte() {
        return plainte;
    }

    public void setPlainte(HhtPlainte plainte) {
        this.plainte = plainte;
    }
    
}
