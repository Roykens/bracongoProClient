package com.bracongo.clientapi.service.contract;

import com.bracongo.clientapi.entities.HhtMessage;
import com.bracongo.clientapi.entities.projection.MessageProjection;
import com.bracongo.clientapi.service.IGenericService;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import java.io.InputStream;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vr.kenfack
 */
@Transactional
public interface IHhtMessageService extends IGenericService<HhtMessage>{
    
    public String sendMessageFromFile(HhtMessage message, InputStream fichier) throws PdvException;
    
    public String sendMessageFromList(HhtMessage message, String clients) throws PdvException;
    
    public String sendMessageFromList(MessageProjection message) throws PdvException;
    
    public List<HhtMessage> getAllClientMessage(String numeroCompte, String password) throws PdvException;
    
}
