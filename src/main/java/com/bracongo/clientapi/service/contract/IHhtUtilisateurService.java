package com.bracongo.clientapi.service.contract;

import com.bracongo.clientapi.entities.HhtUtilisateur;
import com.bracongo.clientapi.service.IGenericService;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Transactional
public interface IHhtUtilisateurService extends IGenericService<HhtUtilisateur>{
    
    public HhtUtilisateur findByLoginAndPassword(String login, String password) throws PdvException;
    
}
