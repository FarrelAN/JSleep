package MFarrelAthaillahNugrohoJSleepMN;

public class Room {
    int size;
    String name;
    Facility facility;
    Price price;

    public Room(String name, int size,  Price price, Facility facility){
        this.name = name;
        this.size = size;
        this.facility = facility;
        this.price = price;
    }

}


