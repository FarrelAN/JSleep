package com.MFarrelAthaillahNugrohoJSleepMN.dbjson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ini adalah class Account
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 7
 */
public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;
    public Renter renter;
    public double balance = 0;

    public final static String REGEX_EMAIL = "^[A-Za-z0-9]+@(.+)$";
    public final static String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    public Account (String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Object write(){
        return null;
    }

    public boolean read(String a){
        return true;
    }


    public String toString (){
        return "====ACCOUNT====\n" +  "\nName : " + name + "\nEmail : " + email +
                "\nPassword : " + password;
    }

    public boolean validate() {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherEmail = patternEmail.matcher(email);
        Matcher matcherPassword = patternPassword.matcher(password);
        if(matcherEmail.matches() && matcherPassword.matches()) {
            return true;
        }else {
            return false;
        }
    }

}
