package com.bracongo.clientapi.service.impl;

import com.bracongo.clientapi.dao.contract.IHhtUtilisateurDao;
import com.bracongo.clientapi.entities.HhtUtilisateur;
import com.bracongo.clientapi.service.CommonService;
import com.bracongo.clientapi.service.contract.IHhtUtilisateurService;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Service
@Transactional
public class HhtUtilisateurServiceImpl extends CommonService implements IHhtUtilisateurService {

    private static final long serialVersionUID = 1L;

    private HhtUtilisateurServiceImpl() {

    }

    @Autowired
    private IHhtUtilisateurDao utilisateurDao;

    private static Logger logger = Logger.getLogger(HhtUtilisateurServiceImpl.class);

    @Override
    public HhtUtilisateur findByLoginAndPassword(String login, String password) throws PdvException {
        try {
            if (login != null && password != null) {
                return utilisateurDao.findByLoginAndPassword(login, password);
            } else {
                PdvException coreException = new PdvException(errorMessagesFilePath,
                        "THRAVVELCOREAGENCYSERVICEERROR-007");
                logger.error(coreException.getMessage());
                throw coreException;
            }
        } catch (PdvException e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
    }

    @Override
    public HhtUtilisateur createOrUpdateEntity(HhtUtilisateur entity) throws PdvException {
        try {
            if(entity != null){
                return utilisateurDao.save(entity);
            }
            else{
                PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage());
            throw coreException;
            }
        } catch (PdvException e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
    }

    @Override
    public HhtUtilisateur getEntityById(Long entityId) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEntity(HhtUtilisateur entity) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Long entityId) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<HhtUtilisateur> getAllEntities(int page, int size) throws PdvException {
        try {
            return utilisateurDao.findAll(new PageRequest(page,size));
        } catch (Exception e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
    }

    @Override
    public Page<HhtUtilisateur> findEntities(String keyWord, int page, int size) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
