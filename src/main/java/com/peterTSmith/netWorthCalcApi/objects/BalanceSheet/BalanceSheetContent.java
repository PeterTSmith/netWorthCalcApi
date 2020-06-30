package com.peterTSmith.netWorthCalcApi.objects.BalanceSheet;

public class BalanceSheetContent {
    private String title;
    private Field[] fields;
    
    public BalanceSheetContent() {
        title = "";
        fields = null;
    }

    public BalanceSheetContent(String titleIn, Field[] fieldsIn) {
        title = titleIn;
        fields = fieldsIn;
    }

    public String getTitle() {
        return title;
    }

    public Field[] getFields() {
        return fields;
    }
}