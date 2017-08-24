package com.bracongo.clientapi.service.impl;

import com.bracongo.clientapi.dao.contract.IHhtClientDao;
import com.bracongo.clientapi.entities.HhtClient;
import com.bracongo.clientapi.service.contract.IHhtClientService;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Service
@Transactional
public class HhtClientServiceImpl implements IHhtClientService{
    
    @Autowired
    private IHhtClientDao clientDao;

    @Override
    public HhtClient createOrUpdateEntity(HhtClient entity) throws PdvException {
        try {
            HhtClient client = clientDao.findByNumber(entity.getClient());
            if(client == null || client.getId() == null){
                entity.setDateCreation(new Date());
                entity.setActive(1);
                clientDao.save(entity);
            }
            else{
                client.setToken(entity.getToken());
                clientDao.save(entity);
            }          
        } catch (PdvException e) {
        }
        return null;
    }

    
}
