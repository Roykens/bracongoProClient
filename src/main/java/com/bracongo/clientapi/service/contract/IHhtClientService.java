package com.bracongo.clientapi.service.contract;

import com.bracongo.clientapi.entities.HhtClient;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Transactional
public interface IHhtClientService{
    
    public HhtClient createOrUpdateEntity(HhtClient entity) throws PdvException;
    
}
