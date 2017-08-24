/**
 * 
 */
package com.bracongo.clientapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 *
 */
@Configuration
@PropertySource("classpath:service/service.properties")
public class SpringServiceConfig {

	@Bean
	@Value("${service.error.messages.path}")
	public String errorMessagesFilePath(String errorMessagesFilePath) {
		return errorMessagesFilePath;
	};

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();

	}

}
