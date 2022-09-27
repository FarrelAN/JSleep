package MFarrelAthaillahNugrohoJSleepMN;
/**
 * Ini adalah class Renter
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 3
 */
public class Renter extends Serializable {
    public int phoneNumber = 0;
    public String address = "";
    public String username;
    
    public Renter(int id, String username) {
        super(id);
        this.username = username;
    }
    
    public Renter(int id, String username, String address) {
        super(id);
        this.username = username;
        this.address = address;
    }
    
    public Renter(int id, String username, int phoneNumber) {
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
    
    public Renter(int id, String username, int phoneNumber, String address) {
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

}
