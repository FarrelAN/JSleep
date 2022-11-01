package MFarrelAthaillahNugrohoJSleepMN;
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
    
    public Account(String name, String email, String password){
    this.name = name;
    this.email = email;
    this.password = password;
    }
    
    public String toString(){
        return "====ACCOUNT====\n" + "Nama : " + name + "\nEmail : " + email + 
        "\nPassword : " + password;
    }

}
