package com.peterTSmith.netWorthCalcApi.objects.BalanceSheet;

public class Field {
    private String id;
    private String name;

    public Field() {
        id = "";
        name = "";
    }

    public Field(String idIn, String nameIn) {
        id = idIn;
        name = nameIn;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}