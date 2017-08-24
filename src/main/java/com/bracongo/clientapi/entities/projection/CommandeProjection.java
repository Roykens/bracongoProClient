package com.bracongo.clientapi.entities.projection;

import com.bracongo.clientapi.entities.HhtCommandeItem;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name = "commande")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommandeProjection implements Serializable{
    
    private static final long serialVersionUID = 1L;

    public CommandeProjection() {
    }
    
    private String client;
    
    private List<HhtCommandeItem> items;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<HhtCommandeItem> getItems() {
        return items;
    }

    public void setItems(List<HhtCommandeItem> items) {
        this.items = items;
    }
    
    
    
}
