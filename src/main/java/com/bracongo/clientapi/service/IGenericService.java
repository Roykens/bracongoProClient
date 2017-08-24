/**
 *
 */
package com.bracongo.clientapi.service;

import com.bracongo.clientapi.entities.BaseClass;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import com.bracongo.clientapi.utils.Exceptions.PdvException;


/**
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 *
 */
@Transactional
public interface IGenericService<T extends BaseClass> {

	/**
	 * @param entity
	 * @return
	 * @throws PdvException
	 */
	T createOrUpdateEntity(T entity) throws PdvException;

	/**
	 * @param entityId
	 * @return
	 * @throws PdvException
	 */
	T getEntityById(Long entityId) throws PdvException;

	/**
	 * @param entity
	 * @throws PdvException
	 */
	void deleteEntity(T entity) throws PdvException;

	/**
	 * @param entityId
	 * @throws PdvException
	 */
	void deleteById(Long entityId) throws PdvException;

	/**
	 * @param page
	 * @param size
	 * @return
	 * @throws PdvException
	 */
	Page<T> getAllEntities(int page, int size) throws PdvException;

	/**
	 * @param keyWord
	 * @param page
	 * @param size
	 * @return
	 * @throws PdvException
	 */
	Page<T> findEntities(String keyWord, int page, int size) throws PdvException;

}
