package com.MFarrelAthaillahNugrohoJSleepMN.controller;

import com.MFarrelAthaillahNugrohoJSleepMN.*;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.*;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "S:\\Kuliah\\Kelas Sem 3\\Praktikum OOP\\JSleep\\src\\json\\payment.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ){
        Account find= Algorithm.<Account>find(AccountController.accountTable,pred->pred.id==buyerId);
        Room roomfind = Algorithm.<Room>find(RoomController.roomTable, pred->pred.id==roomId);
        double price = roomfind.price.price;
        System.out.println(from);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date checkIn = null;
        Date checkOut = null;

        try {
            checkIn  = sdf.parse(from);
            checkOut = sdf.parse(to);
            System.out.println("Date  "+ checkOut);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        long diffInMilliseconds = checkOut.getTime() - checkIn.getTime();
        long diffInDays = diffInMilliseconds / (1000 * 60 * 60 * 24);

        System.out.println(find.toString());
        if(find.balance>= price * diffInDays &&Payment.availability(checkIn, checkOut, roomfind)) {
            System.out.println(find.toString());
            Payment baru = new Payment(buyerId, renterId, roomId, checkIn, checkOut);
            baru.status  = Invoice.PaymentStatus.WAITING;
            Payment.makeBooking(checkIn, checkOut, roomfind);
            find.balance -= price * (double) diffInDays;
            System.out.println("response backend: " + baru.toString());
            paymentTable.add(baru);
            return baru;
        }
        if(find.balance < price){
            System.out.println("Insufficient funds");
        }
        if(!Payment.availability(checkIn, checkOut, roomfind)){
            System.out.println("Room already booked");
        }
        return null;
    }

    @PostMapping("/{id}/accept")
    public boolean accept(@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel(@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        long diffInMilliseconds = payment.to.getTime() - payment.from.getTime();
        long diffInDays = diffInMilliseconds / (1000 * 60 * 60 * 24);

        if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
            payment.status = Invoice.PaymentStatus.FAILED;
            Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.renterId);
            acc.balance += diffInDays * room.price.price;
            return true;
        }
        return false;
    }

    @PostMapping("/{id}/rating")
    public boolean rating(@PathVariable int id,
                          @RequestParam String rating
    ){
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if (payment != null && payment.status == Invoice.PaymentStatus.SUCCESS) {
            System.out.println("rating: "+rating);
            payment.rating = Invoice.RoomRating.valueOf(rating);
            return true;
        }
        return false;
    }

    @GetMapping("getAll/{id}")
    List<Payment> getAccountPayment(@PathVariable int id,
                                    @RequestParam int page,
                                    @RequestParam int pageSize
    ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> pred.buyerId == id);
    }
}


