package com.MFarrelAthaillahNugrohoJSleepMN.dbjson;

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
    public double balance;

    public final static String REGEX_EMAIL = "^[A-Za-z0-9]+@(.+)$";
    public final static String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    public Account (String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
    }
    public Object write (){
        return 0;
    }
    public boolean read (String a){
        return true;
    }

    public String toString (){
        return "====ACCOUNT====\n" + "Nomor Id anda : " + id + "Nama : " + name + "\nEmail : " + email +
                "\nPassword : " + password;
    }

    public boolean validate () {
        if(this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD)) {
            return true;
        }
        else {
            return false;
        }
    }

}
