package com.example.passtools.model;

import android.accounts.Account;

import com.example.passtools.EncodeDecode;
import com.example.passtools.Password;

import java.util.ArrayList;

public class AccountStorage {

    public String website, userName, userPass;
    // private Password userPass = new Password(???,???);

    private ArrayList<AccountStorage> Accounts = new ArrayList();

    public AccountStorage(String websiteB, String usernameB, String userPassB) {
        this.website = websiteB;
        this.userName = usernameB;
        this.userPass = userPassB;
    }

    public void addAccount(AccountStorage userLogin){
        Accounts.add(userLogin);
    }
    public AccountStorage searchAccount(String query){

        int i = 0;

        while(i < Accounts.size()){
            if (Accounts.get(i).userName == query || Accounts.get(i).userPass == query || Accounts.get(i).website == query){
                return Accounts.get(i);
            }
            i++;
        }
        AccountStorage temp = new AccountStorage("NULL","NULL","NULL");
        return temp;

    }
    public String getWebsite() {
        return website;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setUserPass(String userPass) { this.userPass = userPass; }


}



