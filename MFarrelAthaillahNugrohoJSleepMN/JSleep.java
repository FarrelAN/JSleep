package MFarrelAthaillahNugrohoJSleepMN;
/**
 * Ini adalah class JSleep
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 3
 */
public class JSleep
{   

    
    public static void main(String[] args) {
        Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice(2,2,2, "");
        System.out.println(testRoom.print());
        System.out.println(testInvoice.print()); 
    }
    /*  Room test = createRoom();
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.price.price);
        System.out.println(test.facility);
        
    public static Room createRoom(){
        Price price = new Price(200000, 15);
        Room room = new Room(1, "hotel", 20, price, Facility.WiFi);
        return room;
    } */
}

