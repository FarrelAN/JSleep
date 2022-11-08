package com.MFarrelAthaillahNugrohoJSleepMN;

import java.util.List;

import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.Account;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.JsonDBEngine;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.JsonTable;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.Room;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Ini adalah class JSleep
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 7
 */

@SpringBootApplication
public class JSleep {

    /*
    class Country {
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    */
    public static void main(String[] args) {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(()-> JsonDBEngine. join()));
    }
}

    /*
    JSLEEP PRE CS MODUL 7
            SpringApplication.run(JSleep.class, args);

        try {
            String filepath = "D:\\Kuliah\\kelas semm 3\\Praktikum OOP\\JSleep\\src\\json\\account.json";
            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name", "email", "password"));
            tableAccount.writeJson();
        }
        catch (Throwable t){
            t.printStackTrace();
        }

        for(int i = 0; i < 10; i++){
            ThreadingObject thread = new ThreadingObject("Thread " + i);
        }
        Account testRegex = new Account("Farrel", "farrel980@gmail.com", "404Farrel");
        Account testRegexFail =new Account("Farrel","__farrel980@gmail.com", "404 farrel");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());


    public static Room createRoom(){
        Price price = new Price(10000.0, 10);
        Room room = new Room(2, "Restaurant", 35, price, Facility.AC, City.BALI, "Jl. jalan");
        return room;
    }

    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){

        return Algorithm.<Room>paginate(list,page,pageSize,room -> room.accountId == accountId);
    }

    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){
        return Algorithm.<Room>collect(list,room -> room.price.price >= minPrice && room.price.price <= maxPrice);
    }

    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize){
        return Algorithm.paginate(list, page, pageSize, room -> room.city.toString().toLowerCase().contains(search.toLowerCase()));
    }
}


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


