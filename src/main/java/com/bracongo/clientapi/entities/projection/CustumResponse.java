package com.bracongo.clientapi.entities.projection;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name = "reponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustumResponse implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String numclient;
    
    private String message;

    private Integer status;

    
    public String getNumclient() {
        return numclient;
    }

    public void setNumclient(String numclient) {
        this.numclient = numclient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
}
