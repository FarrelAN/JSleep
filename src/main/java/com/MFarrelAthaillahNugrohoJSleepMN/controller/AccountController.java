package com.MFarrelAthaillahNugrohoJSleepMN.controller;

import com.MFarrelAthaillahNugrohoJSleepMN.Algorithm;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.Account;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.Renter;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.JsonTable;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/account")

public class AccountController implements BasicGetController<Account> {
    public final static String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
    @JsonAutowired(value = Account.class, filepath = "D:\\Kuliah\\kelas semm 3\\Praktikum OOP\\JSleep\\src\\main\\java\\com\\MFarrelAthaillahNugrohoJSleepMN\\jsonaccount.json")
    public static JsonTable<Account> accountTable;
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public final static String REGEX_EMAIL = "^[A-Za-z0-9]+@(.+)$";
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    public JsonTable<Account> getJsonTable(){

        return accountTable;
    }

    @GetMapping
    String index() { return "account page"; }
    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        Matcher matcher = REGEX_PATTERN_EMAIL.matcher(email);
        if (!matcher.matches())
        {
            return null;
        }
        matcher = REGEX_PATTERN_PASSWORD.matcher(password);
        if (!matcher.matches())
        {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest();
            BigInteger no = new BigInteger(1, messageDigest);
            String hashedpass = no.toString(16);
            while (hashedpass.length() < 32) {
                hashedpass = "0" + hashedpass;
            }
            password = hashedpass;
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }

        Account account = new Account(name, email, password);
        accountTable.add(new Account(name, email, password));
        return new Account(name, email, password);
    }
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(
            @PathVariable int id,
            @RequestParam String username,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ){
        Account account = Algorithm.<Account>find(accountTable, pred -> pred.id == id);
        if (account == null)
        {
            return null;
        }
        else{
            Renter renter = new Renter(username, address, phoneNumber);
            account.renter = renter;
            return renter;
        }
    }
    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    )
    {
        String hashedpass = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hasedpass = no.toString(16);
            while (hasedpass.length() < 32) {
                hasedpass = "0" + hasedpass;
            }
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
        String finalHashedpass = hashedpass;
        Account account = Algorithm.<Account>find(accountTable, pred -> pred.email.equals(pred.email) && pred.password.equals(hashedpass));
        return account;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(
            @PathVariable int id,
            @RequestParam double balance
    ){
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account == null)
        {
            return false;
        }
        else{
            account.balance += balance;
            return true;
        }
    }
}
