package com.hannabennett.namemangler;

import java.util.Random;

/**
 * Created by HannaBennett on 10/11/17.
 */

public class NameMangler {
    private String firstName;
    private String lastName;

    public NameMangler() {
        this.firstName = "Default";
    }

    public NameMangler(String firstName, String[] lastName) {
        this.firstName = firstName;
        this.lastName = lastName[new Random().nextInt(lastName.length)];
    }

    public String getMangledName() {
        return firstName + " " + lastName;
    }
}
