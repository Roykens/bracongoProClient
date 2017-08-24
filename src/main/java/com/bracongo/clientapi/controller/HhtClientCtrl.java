
package com.bracongo.clientapi.controller;

import com.bracongo.clientapi.entities.HhtClient;
import com.bracongo.clientapi.entities.projection.RequestAnswer;
import com.bracongo.clientapi.service.contract.IHhtClientService;
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
public class HhtClientCtrl {
    
    private static final Logger logger = Logger.getLogger(HhtClientCtrl.class);
    private Map<String, Object> resultMap;
    private final Properties messageCtx = SharedResourcesProvider.getInstance().getFrontMessageCtx();
    private String errorMessage;
    
    @Autowired
    private IHhtClientService clientService;
    
    @RequestMapping(value = "/clients/send", method = RequestMethod.POST)
    public Map<String, Object> sendClient(HttpServletRequest request, @RequestBody HhtClient client) {
        resultMap = new HashMap<>();
        RequestAnswer answer;
        try {
            clientService.createOrUpdateEntity(client);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.TRUE);
            resultMap.put(Constants.JSON_PAYLOAD_KEY, "envoyé");

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
