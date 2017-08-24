package com.bracongo.clientapi.controller;

import com.bracongo.clientapi.entities.HhtMessage;
import com.bracongo.clientapi.entities.projection.MessageProjection;
import com.bracongo.clientapi.service.contract.IHhtMessageService;
import com.bracongo.clientapi.utils.Constants;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import com.bracongo.clientapi.utils.SharedResourcesProvider;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@RestController
public class IHhtMessageCtrl {
    
    private static final Logger logger = Logger.getLogger(IHhtMessageCtrl.class);
    private Map<String, Object> resultMap;
    private final Properties messageCtx = SharedResourcesProvider.getInstance().getFrontMessageCtx();
    private String errorMessage;
    
    @Autowired
    private IHhtMessageService messageService;
    
    @RequestMapping(value = "/messages/send/file", method = RequestMethod.POST,headers=("content-type=multipart/*"))
    public Map<String, Object> sendMessageToFile(HttpServletRequest request, @RequestParam("fichier") MultipartFile inputFile,@RequestParam("message") HhtMessage message) throws IOException {
        try {
            resultMap = new HashMap<>();
            //RequestAnswer answer;
            String result = messageService.sendMessageFromFile(message, inputFile.getInputStream());
            //answer = new RequestAnswer();
           // answer.setContenu("Commande enregistr�e");
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.TRUE);
            resultMap.put(Constants.JSON_PAYLOAD_KEY, result);
            return resultMap;
        } catch (PdvException ex) {
            java.util.logging.Logger.getLogger(IHhtMessageCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @RequestMapping(value = "/messages/send/list", method = RequestMethod.POST)
    public Map<String, Object> sendMessageToList(HttpServletRequest request, @RequestParam("clients") String clients,@RequestParam("message") HhtMessage message) throws IOException {
        try {
            resultMap = new HashMap<>();
            String result = messageService.sendMessageFromList(message, clients);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.TRUE);
            resultMap.put(Constants.JSON_PAYLOAD_KEY, result);
            return resultMap;
        } catch (PdvException ex) {
            java.util.logging.Logger.getLogger(IHhtMessageCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @RequestMapping(value = "/messages/send", method = RequestMethod.POST)
    public Map<String, Object> sendMessage(HttpServletRequest request, @RequestBody MessageProjection message) throws IOException {
        try {
            resultMap = new HashMap<>();
            String result = messageService.sendMessageFromList(message);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.TRUE);
            resultMap.put(Constants.JSON_PAYLOAD_KEY, result);
            return resultMap;
        } catch (PdvException ex) {
            java.util.logging.Logger.getLogger(IHhtMessageCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @RequestMapping(value = "/messages/{numCompte}/{password}", method = RequestMethod.GET)
    public Map<String, Object> getMessages(HttpServletRequest request, @PathVariable("numCompte") String numCompte, @PathVariable("password") String password) {
        resultMap = new HashMap<>();
        try {
            
            List<HhtMessage> messages = messageService.getAllClientMessage(numCompte, password);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.TRUE);
            resultMap.put(Constants.JSON_PAYLOAD_KEY, messages);
        } catch (PdvException ex) {
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, ex.getMessage().substring(ex.getMessage().lastIndexOf('-') + 1));
            logger.error(ex);
        } catch (Exception e) {
            errorMessage = MessageFormat.format(messageCtx.getProperty("THRAVVELCORESTATIONCTRL-001"), (Object) null);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, errorMessage.substring(errorMessage.lastIndexOf('-') + 1));
            logger.error(errorMessage, e);
        }
        return resultMap;
    }
    
}
