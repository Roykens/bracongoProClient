package com.bracongo.clientapi.service.contract;

import com.bracongo.clientapi.entities.HhtCommande;
import com.bracongo.clientapi.entities.HhtCommandeItem;
import com.bracongo.clientapi.entities.projection.CommandeProjection;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Transactional
public interface IHhtComandeService {
    
    public HhtCommande saveOrUpdateCommande(HhtCommande commande) throws PdvException;
    
    public HhtCommande findCommandeById(Long id)throws PdvException;
    
    public void deleteCommande(Long id)throws PdvException;
    
    public List<HhtCommande> findCommandesBetweenDates(Date debut, Date fin)throws PdvException;
    
    public HhtCommandeItem saveOrUpdateCommandeItem(HhtCommandeItem commandeItem)throws PdvException;
    
    public HhtCommandeItem findCommandeItemById(Long id)throws PdvException;
    
    public void deleteCommandeItem(Long id)throws PdvException;
    
    public List<HhtCommandeItem> findByCommande(Long idCommande)throws PdvException;
    
    public void achieveCommande(Long idCommande)throws PdvException;
    
    public void saveCommandeFromWeb(CommandeProjection commande) throws PdvException;
    
}
