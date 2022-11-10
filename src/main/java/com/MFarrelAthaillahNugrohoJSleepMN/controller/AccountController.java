package com.MFarrelAthaillahNugrohoJSleepMN.controller;

import com.MFarrelAthaillahNugrohoJSleepMN.Algorithm;
import com.MFarrelAthaillahNugrohoJSleepMN.Predicate;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static org.apache.logging.log4j.util.Strings.isBlank;

@RestController
@RequestMapping("/account")

public class AccountController implements BasicGetController<Account> {
    @JsonAutowired(value = Account.class, filepath = "D:\\Kuliah\\kelas semm 3\\Praktikum OOP\\JSleep\\src\\main\\java\\json\\account.json")
    public final static String REGEX_EMAIL = "^[A-Za-z0-9]+@(.+)$";
    public final static String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    public static JsonTable<Account> accountTable;
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);


    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }
    public List<Account> getPage(int page, int pageSize) {
        return null;
    }
    @GetMapping
    String index() {
        return "account page";
    }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));
        final String generatedPassword = PasswordHashing(password);
        if(findAccount != null && generatedPassword.equals(findAccount.password)) {
            return findAccount;
        }else {
            return null;
        }
    }

    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        boolean matchEmail = matcherEmail.find();
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();
        Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));
        final String generatedPassword;
        if ( matchEmail && matchFoundPassword && !name.isBlank() && findAccount == null){
            generatedPassword = PasswordHashing(password);
            Account newAccount = new Account(name, email, generatedPassword);
            accountTable.add(newAccount);
            return newAccount;
        }
        return null;
    }

    @PostMapping("/{id}/registerRenter")
    public Renter registerRenter(
            @PathVariable int id,
            @RequestParam String username,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ) {
        Account temp = Algorithm.<Account>find(accountTable,pred -> pred.id == id);
        if(temp.renter == null && temp != null){
            temp.renter = new Renter(username, address, phoneNumber);
            return temp.renter;
        }
        else{
            return null;
        }
    }


    @PostMapping("/{id}/topUp")
    public boolean topUp(
            @PathVariable int id,
            @RequestParam double balance
    ) {
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if(account != null) {
            account.balance += balance;
            return true;
        }else {
            return false;
        }
    }

    String PasswordHashing(String password) {
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
