package com.mohran;

public enum Doctor {
    ashraf("mohamed ashraf"),
    essam("mahmoud esasam"),
    ali("ahmed ali") ;
    private String name ;

    Doctor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
