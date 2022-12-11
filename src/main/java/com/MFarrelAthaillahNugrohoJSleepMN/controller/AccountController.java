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
    @JsonAutowired(value = Account.class, filepath = "S:\\Kuliah\\Kelas Sem 3\\Praktikum OOP\\JSleep\\src\\json\\account.json")
    public static JsonTable<Account> accountTable;
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public final static String REGEX_EMAIL = "^[A-Za-z0-9]+@(.+)$";
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }

    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ){
        Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));

        final String generatedPassword = hashPassword(password);

        if (findAccount != null && generatedPassword.equals(findAccount.password)){
            return findAccount;
        }else{
            return null;
        }
    }

    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){

        Matcher matcherEmail = REGEX_PATTERN_EMAIL.matcher(email);
        boolean matchEmail = matcherEmail.find();

        Matcher matcherPassword = REGEX_PATTERN_PASSWORD.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();

        Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));

        if (findAccount == null && matchEmail && matchFoundPassword) {
            final String generatedPassword;
            generatedPassword = hashPassword(password);
            Account account = new Account(name, email, generatedPassword);
            accountTable.add(account);
            return account;
        } return null;

    }

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(@PathVariable int id,
                          @RequestParam String username,
                          @RequestParam String address,
                          @RequestParam String phoneNumber)
    {
        Account temp = Algorithm.<Account>find(accountTable,pred -> pred.id == id);
        if(temp.renter == null && temp != null){
            temp.renter = new Renter(username, address, phoneNumber);
            return temp.renter;
        }
        else{
            return null;
        }
    }

    @PostMapping("/{id}/topup")
    boolean topUp(@PathVariable int id, @RequestParam double amount) {
        Account account = Algorithm.<Account>find(getJsonTable(), acc -> id == acc.id);
        if (account != null){
            account.balance += amount;
            return true;
        }
        return false;
    }

    String hashPassword(String password) {
        String generatedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }

}
