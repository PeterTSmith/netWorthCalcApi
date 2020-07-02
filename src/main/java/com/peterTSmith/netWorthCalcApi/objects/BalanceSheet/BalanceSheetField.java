package com.peterTSmith.netWorthCalcApi.objects.BalanceSheet;

public class BalanceSheetField {

    private long id;
    private String name;

    public BalanceSheetField() {
        id = 0;
        name = "";
    }

    public BalanceSheetField(long idIn, String nameIn) {
        id = idIn;
        name = nameIn;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}