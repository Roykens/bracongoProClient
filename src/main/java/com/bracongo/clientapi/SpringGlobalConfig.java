/**
 * 
 */
package com.bracongo.clientapi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bracongo.clientapi.dao.SpringDaoConfig;
import com.bracongo.clientapi.data.SpringPersistenceConfig;
import com.bracongo.clientapi.service.SpringServiceConfig;

/**
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 *
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan({ "com.bracongo.clientapi.dao", "com.bracongo.clientapi.service", "com.bracongo.clientapi.test",
		"com.bracongo.clientapi.controller" })
@Import({ SpringPersistenceConfig.class, SpringDaoConfig.class, SpringServiceConfig.class })

public class SpringGlobalConfig {

}
