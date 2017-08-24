package com.bracongo.clientapi.controller;

import com.bracongo.clientapi.entities.projection.RequestAnswer;
import com.bracongo.clientapi.entities.projection.CommandeProjection;
import com.bracongo.clientapi.service.contract.IHhtComandeService;
import com.bracongo.clientapi.utils.Constants;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import com.bracongo.clientapi.utils.SharedResourcesProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@RestController
public class HhtCommandeCtrl {
    
    private static final Logger logger = Logger.getLogger(HhtCommandeCtrl.class);
    private Map<String, Object> resultMap;
    private final Properties messageCtx = SharedResourcesProvider.getInstance().getFrontMessageCtx();
    private String errorMessage;
    
    @Autowired
    private IHhtComandeService commandeService;
    
    @RequestMapping(value = "/commandes/send", method = RequestMethod.POST)
    public Map<String, Object> sendCommand(HttpServletRequest request, @RequestBody CommandeProjection commande) {
        resultMap = new HashMap<>();
        RequestAnswer answer;
        try {
            commandeService.saveCommandeFromWeb(commande);
            answer = new RequestAnswer();
            answer.setContenu("Commande enregistr�e");
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.TRUE);
            resultMap.put(Constants.JSON_PAYLOAD_KEY, answer);

        } catch (PdvException tce) {
            answer = new RequestAnswer();
            answer.setContenu("Erreur lors de l'envoie");
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, answer);
            logger.error(tce);

        } 
        return resultMap;
    }
    
}
