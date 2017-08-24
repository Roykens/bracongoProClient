package com.bracongo.clientapi.service.impl;

import com.bracongo.clientapi.dao.contract.IHhtClientDao;
import com.bracongo.clientapi.dao.contract.IHhtMessageDao;
import com.bracongo.clientapi.entities.HhtClient;
import com.bracongo.clientapi.entities.HhtMessage;
import com.bracongo.clientapi.entities.projection.MessageProjection;
import com.bracongo.clientapi.service.contract.IHhtMessageService;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.resource.spi.AuthenticationMechanism;
import org.codehaus.jettison.json.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vr.kenfack
 */
@Service
@Transactional
public class HhtMessageServiceImpl implements IHhtMessageService {

    @Autowired
    private IHhtClientDao clientDao;

    @Autowired
    private IHhtMessageDao messageDao;

    @Override
    public HhtMessage createOrUpdateEntity(HhtMessage entity) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HhtMessage getEntityById(Long entityId) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEntity(HhtMessage entity) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Long entityId) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<HhtMessage> getAllEntities(int page, int size) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<HhtMessage> findEntities(String keyWord, int page, int size) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sendMessageFromFile(HhtMessage message, InputStream fichier) throws PdvException {
        return message.getTitre() + " : Fichier reçu";
    }

    @Override
    public String sendMessageFromList(HhtMessage message, String clients) throws PdvException {
        clients = clients.trim();
        String[] comptes = clients.split(";");
        for (String compte : comptes) {
            HhtClient client = clientDao.findByNumber(compte.trim());
            if (client != null) {
                message.setClient(client);
                message.setDateMessage(new Date());
                message.setActive(1);
                messageDao.save(message);
                sendPush(client.getToken());
            }
        }
        return message.getTitre() + " : Liste reçue";
    }

    @Override
    public List<HhtMessage> getAllClientMessage(String numeroCompte, String password) throws PdvException {
        try {
            HhtClient client = clientDao.findByNumberAndPassword(numeroCompte, password);
            if (client != null) {
                List<HhtMessage> messages = messageDao.getMessageByClient(client);
                return messages;
            }
        } catch (PdvException e) {
        }
        return new ArrayList<>();
    }

    public void sendPush(String token) {
        
        System.out.println(" =============  J'envoie la notif à : " + token);
        String[] clients = new String[1];
        clients[0] = token.trim();
        JSONArray tokens = new JSONArray();
        tokens.put(token);
        
        JSONObject header = new JSONObject();
        header.put("profile", "bracongoapp");
        header.put("Content-Type", "application/json");
        
        JSONObject pay = new JSONObject();
        pay.put("menu", "message");
        
        JSONObject notif = new JSONObject();
        notif.put("title", "BRACONGO SA");
        notif.put("message", "Nouveau Message !");
        notif.put("payload", pay);
        
        
        JSONObject data = new JSONObject();
        data.put("profile", "bracongoapp");
        data.put("notification", notif);
        
        data.put("tokens", tokens);
        System.out.println(data);
        
        String token1 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiIxMmMzYTQ0NS0wN2FhLTRmMDktOGYwZS1kY2Q5MGY1ZDlmYmQifQ.Dsr0rvzsiYb7BYKMEXNYyGWnweW_swx9Exsnt262jNQ";
        
        try {
                URL url = new URL("https://api.ionic.io/push/notifications");
                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);
               
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Authorization", "Bearer "+token1);
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(data.toString());
                out.close();

                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));

                while (in.readLine() != null) {
                }
                System.out.println("\nREST Service Invoked Successfully..");
                in.close();
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
    }

    @Override
    public String sendMessageFromList(MessageProjection message) throws PdvException {
        String clients = message.getClients().trim();
        String[] comptes = clients.split(";");
        for (String compte : comptes) {
            HhtClient client = clientDao.findByNumber(compte.trim());
            if (client != null) {
                HhtMessage m = new HhtMessage();
                m.setClient(client);
                m.setDateMessage(new Date());
                m.setActive(1);
                m.setContenu(message.getContenuMessage());
                m.setTitre(message.getTitreMessage());
                messageDao.save(m);
                sendPush(client.getToken());
            }
        }
        return message.getTitreMessage() + " : Liste reçue";
    }

}
