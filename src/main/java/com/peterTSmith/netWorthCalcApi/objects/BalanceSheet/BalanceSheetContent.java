package com.peterTSmith.netWorthCalcApi.objects.BalanceSheet;

public class BalanceSheetContent {

    private String title;
    private BalanceSheetField[] fields;
    
    public BalanceSheetContent() {
        title = "";
        fields = null;
    }

    public BalanceSheetContent(String titleIn, BalanceSheetField[] fieldsIn) {
        title = titleIn;
        fields = fieldsIn;
    }

    public String getTitle() {
        return title;
    }

    public BalanceSheetField[] getFields() {
        return fields;
    }
}