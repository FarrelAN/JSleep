package MFarrelAthaillahNugrohoJSleepMN;
/**
 * Ini adalah class Account yang merupakan subclass dari class Serializable dan digunakan untuk menginisialisasi variabel String name, String email, dan String password.
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 3
 */
public class Account extends Serializable implements FileParser
{   
    public String name;
    public String email;
    public String password;
    
    public Account(int id, String name, String email, String password){
    super(id);
    this.name = name;
    this.email = email;
    this.password = password;
    }
    
    public String toString(){
        return "====ACCOUNT====\n" + "Nama : " + name + "\nEmail : " + email + 
        "\nPassword : " + password;
    }
    
    public Object write() {
        return null;
    }
    
    public boolean read (String content) {
        return false;
    }
}
