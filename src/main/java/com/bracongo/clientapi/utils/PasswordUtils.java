package com.bracongo.clientapi.utils;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public class PasswordUtils {

    public static String getPassFromClient(String clientNumber) {
        return clientNumber.substring(clientNumber.length() - 2) + getKeyFromClient(clientNumber) + clientNumber.substring(0, 2);
    }

    public static String getKeyFromClient(String clientNumber) {
        long hash = 0;
        for (int i = 0; i < clientNumber.length(); i++) {
            hash += clientNumber.charAt(i) * (i + 1);
        }
        return String.valueOf(hash);
    }
}
