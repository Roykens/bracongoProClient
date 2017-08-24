package com.bracongo.clientapi.service.contract;

import com.bracongo.clientapi.entities.HhtPlainte;
import com.bracongo.clientapi.entities.projection.PlainteProjection;
import com.bracongo.clientapi.service.IGenericService;
import com.bracongo.clientapi.utils.Exceptions.PdvException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Transactional
public interface IHhtPlainteService extends IGenericService<HhtPlainte>{
    
    public void savePlainteFromWeb(PlainteProjection projection)  throws PdvException;
    
}
