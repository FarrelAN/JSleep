package MFarrelAthaillahNugrohoJSleepMN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

/**
 * Ini adalah class JSleep
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 6
 */
public class JSleep {
    class Country {
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static void main(String[] args) {
        String filepath = "D:\\Kuliah\\kelas semm 3\\Praktikum OOP\\JSleep\\city.json";
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states :");
            input.listOfStates.forEach(state -> System.out.println(state));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}










    /*
    public static void main(String[] args) {
        System.out.println("Hello from IntelliJ!");
    }



    public static Room createRoom(){
        Price price = new Price(100000, 5);
        Room room = new Room(1, "Presidential Suite", 5, price, Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        return room; 
    }
    
    public static void main(String[] args) 
    {
        Room RoomA = JSleep.createRoom();
        Room RoomB = JSleep.createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start, end,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start2 = Date.valueOf("2022-8-18");
        Date end2 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start2, end2,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
        Date start3 = Date.valueOf("2022-8-18");
        Date end3 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start3, end3,RoomB));
        System.out.println("Membuat booking dari tanggal 20 hingga 15");
    }
        Room test = createRoom();
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.price.price);
        System.out.println(test.facility);
        
    public static Room createRoom(){
        Price price = new Price(200000, 15);
        Room room = new Room(1, "hotel", 20, price, Facility.WiFi);
        return room;
    } */


