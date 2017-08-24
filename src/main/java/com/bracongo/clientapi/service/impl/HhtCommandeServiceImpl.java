package com.bracongo.clientapi.service.impl;

import com.bracongo.clientapi.service.CommonService;
import com.bracongo.clientapi.service.contract.IHhtComandeService;
import com.bracongo.clientapi.dao.contract.IHhtCommandeDao;
import com.bracongo.clientapi.dao.contract.IHhtCommandeItemDao;
import com.bracongo.clientapi.entities.HhtCommande;
import com.bracongo.clientapi.entities.HhtCommandeItem;
import com.bracongo.clientapi.entities.projection.CommandeProjection;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Service
@Transactional
public class HhtCommandeServiceImpl extends CommonService implements IHhtComandeService {

    private static final long serialVersionUID = 8522279323469768575L;

    private HhtCommandeServiceImpl() {

    }

    private static Logger logger = Logger.getLogger(HhtCommandeServiceImpl.class);

   
    @Autowired
    IHhtCommandeDao commandeDao;

    @Autowired
    IHhtCommandeItemDao commandeItemDao;

    @Override
    public HhtCommande saveOrUpdateCommande(HhtCommande commande) throws PdvException {
        try {
            if (commande != null) {
                return commandeDao.save(commande);
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
    public HhtCommande findCommandeById(Long id) throws PdvException {
        try {
            if (id != null) {
                return commandeDao.findOne(id);
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
    public void deleteCommande(Long id) throws PdvException {
        try {
            if (id != null) {
                HhtCommande commande = commandeDao.findOne(id);
                if (commande != null) {
                    commandeDao.delete(commande);
                }
            }
        } catch (Exception e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
    }

    @Override
    public List<HhtCommande> findCommandesBetweenDates(Date debut, Date fin) throws PdvException {
        try {
            return commandeDao.findBetweenDates(debut, fin);
        } catch (PdvException e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
    }

    @Override
    public HhtCommandeItem saveOrUpdateCommandeItem(HhtCommandeItem commandeItem) throws PdvException {
        try {
            if (commandeItem != null) {
                return commandeItemDao.save(commandeItem);
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
    public HhtCommandeItem findCommandeItemById(Long id) throws PdvException {
        try {
            if (id != null) {
                return commandeItemDao.findOne(id);
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
    public void deleteCommandeItem(Long id) throws PdvException {
        try {
            if (id != null) {
                HhtCommandeItem item = commandeItemDao.findOne(id);
                if (item != null) {
                    commandeItemDao.delete(item);
                }
            }
        } catch (Exception e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
    }

    @Override
    public List<HhtCommandeItem> findByCommande(Long idCommande) throws PdvException {
        try {
            if (idCommande != null) {
                HhtCommande commande = commandeDao.findOne(idCommande);
                if (commande != null) {
                    return commandeItemDao.findAllByCommande(commande);
                } else {
                    PdvException coreException = new PdvException(errorMessagesFilePath,
                            "THRAVVELCOREAGENCYSERVICEERROR-007");
                    logger.error(coreException.getMessage());
                    throw coreException;
                }
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
    public void achieveCommande(Long idCommande) throws PdvException {
        try {
            if (idCommande != null) {
                HhtCommande commande = commandeDao.findOne(idCommande);
                if (commande != null) {
                    commande.setGeree(1);
                    commandeDao.save(commande);
                }
            }
        } catch (Exception e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
    }

    @Override
    public void saveCommandeFromWeb(CommandeProjection commande) throws PdvException {
        try {
            if(commande != null && commande.getClient() != null && commande.getItems() != null){
               // HhtClient client = clientDao.findByCustumerNumber(commande.getClient().trim());
               // if(client != null){
                    HhtCommande com = new HhtCommande();
                    com.setDateCommande(new Date());
                    com.setClient(commande.getClient().trim());
                    com.setGeree(0);
                    com.setActive(1);
                    com = commandeDao.save(com);
                    List<HhtCommandeItem> items = commande.getItems();
                    for (HhtCommandeItem item : items) {
                        item.setCommande(com);
                        commandeItemDao.save(item);
                    }
               // }
            }
        } catch (Exception e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
    }

}
