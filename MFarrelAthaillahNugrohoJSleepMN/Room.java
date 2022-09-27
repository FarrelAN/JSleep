package MFarrelAthaillahNugrohoJSleepMN;
/**
 * Ini adalah class Room
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 3
 */
public class  Room extends Serializable {
    
    public int size;
    public String name;
    public Facility facility;
    public Price price;

    public Room(int id, String name, int size, Price price, Facility facility) {
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
    }

}

