package com.bracongo.clientapi.dao.contract;

import com.bracongo.clientapi.dao.IGenericDao;
import com.bracongo.clientapi.entities.HhtClient;
import com.bracongo.clientapi.entities.HhtMessage;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Repository
public interface IHhtMessageDao extends IGenericDao<HhtMessage>{
    
    @Query("select message from HhtMessage message  where client = :client  and active = 1 order by dateMessage desc")
    public List<HhtMessage> getMessageByClient(@Param("client") HhtClient client) throws PdvException;
    
}
