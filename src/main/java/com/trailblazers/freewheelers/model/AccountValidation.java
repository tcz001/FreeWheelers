package com.trailblazers.freewheelers.model;

import java.util.HashMap;

public class AccountValidation {

    public static HashMap verifyInputs(Account account) {
        HashMap errors = new HashMap();

        if (!account.getEmail_address().contains("@")) {
           errors.put("email", "Must enter a valid email!");
        }

        if(account.getPassword().isEmpty()) {
            errors.put("password", "Must enter a password!");
        }

        if(account.getAccount_name().isEmpty()) {
            errors.put("name", "Must enter a name!");
        }

        if(account.getPhoneNumber().isEmpty()) {
            errors.put("phoneNumber", "Must enter a phone number!");
        }

        return errors;
    }

}