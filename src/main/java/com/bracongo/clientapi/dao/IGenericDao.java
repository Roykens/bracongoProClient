/**
 * 
 */
package com.bracongo.clientapi.dao;

import com.bracongo.clientapi.entities.BaseClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;



/**
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 *
 */
@NoRepositoryBean
public interface IGenericDao<T extends BaseClass> extends JpaRepository<T, Long> {

}
