package MFarrelAthaillahNugrohoJSleepMN;
import java.util.ArrayList;
import java.util.Date;

/**
 * Ini adalah class Room
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 3
 */
public class Room extends Serializable implements FileParser
{
    public Price price;
    public String address;
    public int size;
    public Facility facility;
    public BedType bedType;
    public City city;
    public String name;
    public ArrayList <Date> booked = new ArrayList<Date>();
    
    public Room(int id, String name, int size, Price price, Facility facility, City city, String address)
    {
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
    }
    
    public String toString(){
        return "Room ID: " + super.id + "\nName: " + this.name + "\nSize: " + this.size +
                "\nPrice: " + this.price.price + "\nDiscount: " + this.price.discount + 
                "\nFacility: " + this.facility + "\nCity: "+ this.city + "\nAddress: " + this.address;
    }
    
    public Object write() {
        return null;
    }
    
    public boolean read (String content) {
        return false;
    }
}

