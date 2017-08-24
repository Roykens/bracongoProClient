/**
 * 
 */
package com.bracongo.clientapi.utils;

/**
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 *
 */
public class Constants {

	public static final int INITIAL_USER_MARKS = 0;

	public static final String ADMIN_ROLE = "admin";
	public static final String USER_ROLE = "user";

	public static final Integer ZERO_STAR_RATE = 0;
	public static final Integer ONE_STAR_RATE = 1;
	public static final Integer TWO_STAR_RATE = 2;
	public static final Integer THREE_STAR_RATE = 3;
	public static final Integer FOUR_STAR_RATE = 4;
	public static final Integer FIVE_STAR_RATE = 5;
       

	// genders
	public static final char MALE = 'm';
	public static final char FEMALE = 'F';

	public static final String CROWDED_RATE = "crowded";
	public static final String GENERAL_RATE = "general";

	// Reaction types
	public static final String LIKE = "like";
	public static final String DISLIKE = "dislike";
	public static final String LOVE = "love";
	public static final String FUNNY = "funny";
	public static final String WOW = "wow";
	public static final String SAD = "sad";

	// json data keys
	public static final String JSON_PAYLOAD_KEY = "payload";
	public static final String JSON_SUCCESS_KEY = "success";
	public static final String JSON_MESSAGE_KEY = "message";

	// path for thravvel global config file
	public static final String THRAVVEL_GLOBAL_CONFIG_FILE = "thravvel-global.properties";

	// path to the controller message properties file
	public static final String CONTROLLER_MESSAGES_PROPERTIES_FILE = "controller/controllerMessages.properties";

	// session variables names
	public static final String SESSION_USER = "user";
        
        // customer account creation
        public static final Integer  NEW_CLIENT = 0; // le client n'a pas encore de compte
        public static final Integer  OLD_CLIENT = 1; // le client a deja un compte
        public static final Integer  CLIENT_ERROR = 2; // le client n'existe pas

}
