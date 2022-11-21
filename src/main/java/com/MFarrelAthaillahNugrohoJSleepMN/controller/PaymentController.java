package com.MFarrelAthaillahNugrohoJSleepMN.controller;

import com.MFarrelAthaillahNugrohoJSleepMN.*;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.*;
import org.springframework.web.bind.annotation.*;
import java.text.*;
import java.util.*;


@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    @JsonAutowired(value = Account.class, filepath = "D:\\Kuliah\\kelas semm 3\\Praktikum OOP\\JSleep\\src\\main\\java\\com\\MFarrelAthaillahNugrohoJSleepMN\\json\\account.json")
    public static JsonTable<Payment> paymentTable;

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/{create}")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    )throws Exception
    {
        double price;
        Account buyer = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == roomId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFrom = dateFormat.parse(from);
        Date dateTo = dateFormat.parse(to);
        if(buyer != null || room != null || buyer.balance >= room.price.price || Payment.availability(dateFrom, dateTo, room)){
            Payment payment = new Payment(buyerId, renterId, roomId, dateFrom, dateTo);
            paymentTable.add(payment);
            return payment;
        }
        else {
            return null;
        }
    }
    @PostMapping("/{accept}")
    public boolean accept (
            @RequestParam int id
    ){
        Payment payment = Algorithm.<Payment>find(paymentTable, payment1 -> payment1.id == id);
        if(payment != null || payment.status == Invoice.PaymentStatus.WAITING){
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        else{
            return false;
        }
    }
    @PostMapping("/{cancel}")
    public boolean cancel (
            @RequestParam int id
    ){
        Payment payment = Algorithm.<Payment>find(paymentTable, payment1 -> payment1.id == id);
        if(payment != null || payment.status == Invoice.PaymentStatus.WAITING){
            Account buyer = Algorithm.<Account>find(AccountController.accountTable, account -> account.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, room1 -> room1.id == payment.getRoomId());
            buyer.balance += room.price.price;
            payment.status = Invoice.PaymentStatus.FAILED;
            paymentTable.remove(payment);
            return true;
        }
        else{
            return false;
        }
    }
    @PostMapping("/{submit}")
    public boolean submit (
            @RequestParam int id
    ){
        return false;
    }
}
