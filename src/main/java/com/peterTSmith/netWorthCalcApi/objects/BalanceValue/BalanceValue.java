package com.peterTSmith.netWorthCalcApi.objects.BalanceValue;

public class BalanceValue {
    private String id;
    private long value;
    private long dateModified;

    public BalanceValue() {
        id = "";
        value = 0;
        dateModified = 0;
    }

    public BalanceValue(String idIn, long valueIn, long dateModifiedIn) {
        id = idIn;
        value = valueIn;
        dateModified = dateModifiedIn;
    }

    public String getId() {
        return id;
    }

    public long getValue() {
        return value;
    }

    public long getDateModified() {
        return dateModified;
    }
}