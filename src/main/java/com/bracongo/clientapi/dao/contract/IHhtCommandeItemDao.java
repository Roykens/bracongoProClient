package com.bracongo.clientapi.dao.contract;

import com.bracongo.clientapi.entities.HhtCommandeItem;
import com.bracongo.clientapi.entities.HhtCommande;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import com.bracongo.clientapi.dao.IGenericDao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Repository
public interface IHhtCommandeItemDao extends IGenericDao<HhtCommandeItem>{
    
    @Query("select item from HhtCommandeItem item where item.commande = :commande")
    public List<HhtCommandeItem> findAllByCommande(HhtCommande commande) throws PdvException;
}
