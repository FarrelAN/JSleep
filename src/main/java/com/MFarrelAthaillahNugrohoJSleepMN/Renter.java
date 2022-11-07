package com.MFarrelAthaillahNugrohoJSleepMN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ini adalah class Renter
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 6
 */
public class Renter extends Serializable {
    public String phoneNumber = "0";
    public String address = "";
    public String username;
    public static final String REGEX_NAME  = "^[A-Z][^\\s][A-Za-z0-9_]{3,19}$";
    public static final String REGEX_PHONE = "^[0-9]{8,12}$";

    public Renter(String username, String phoneNumber, String address) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public boolean validate() {
        Pattern pattern = Pattern.compile(REGEX_NAME);
        Matcher matchName = pattern.matcher(username);
        Pattern pat = Pattern.compile(REGEX_PHONE);
        Matcher matchPhone = pat.matcher(phoneNumber);
        boolean matchUsername = matchName.find();
        boolean matchPhoneNumber = matchPhone.find();
        return matchUsername && matchPhoneNumber;
    }

}
