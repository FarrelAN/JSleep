package com.MFarrelAthaillahNugrohoJSleepMN;
/**
 * Ini adalah class Account yang merupakan subclass dari class Serializable dan digunakan untuk menginisialisasi variabel String name, String email, dan String password.
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 3
 */
public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;

    public final static String REGEX_EMAIL = "^[A-Za-z0-9]+@(.+)$";
    public final static String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    public Account (String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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
