package com.bracongo.clientapi.dao.contract;

import com.bracongo.clientapi.dao.IGenericDao;
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
public interface IHhtUtilisateurDao extends IGenericDao<HhtUtilisateur>{
    
     @Query("select u from HhtUtilisateur u where u.login like :login and u.password like :password")
    public HhtUtilisateur findByLoginAndPassword(@Param("login")String login, @Param("password")String password) throws PdvException;
    
}
