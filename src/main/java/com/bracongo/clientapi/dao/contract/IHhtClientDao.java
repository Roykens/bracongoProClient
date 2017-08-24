package com.bracongo.clientapi.dao.contract;

import com.bracongo.clientapi.dao.IGenericDao;
import com.bracongo.clientapi.entities.HhtClient;
import com.bracongo.clientapi.entities.HhtUtilisateur;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Repository
public interface IHhtClientDao extends IGenericDao<HhtClient>{
    
    @Query("select c from HhtClient c where c.client like :numero and c.password like :password")
    public HhtClient findByNumberAndPassword(@Param("numero")String numero, @Param("password")String password) throws PdvException;
    
    @Query("select c from HhtClient c where c.client like :numero")
    public HhtClient findByNumber(@Param("numero")String numero) throws PdvException;
}
