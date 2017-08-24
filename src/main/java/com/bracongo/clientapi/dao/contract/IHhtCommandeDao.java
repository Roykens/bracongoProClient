package com.bracongo.clientapi.dao.contract;

import com.bracongo.clientapi.dao.IGenericDao;
import com.bracongo.clientapi.entities.HhtCommande;
import com.bracongo.clientapi.utils.Exceptions.PdvException;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Repository
public interface IHhtCommandeDao extends IGenericDao<HhtCommande>{
    
    @Query("select commande from HhtCommande commande where (dateCommande between :debut and  :fin) and active = 1")
    public List<HhtCommande> findBetweenDates(@Param("debut")Date debut, @Param("fin")Date fin) throws PdvException;
}
