package com.peterTSmith.netWorthCalcApi.objects.BalanceSheet;

public class BalanceSheet {
    public String title;
    public BalanceSheetContent[] content;

    public BalanceSheet() {
        title = "";
        content = null;
    }

    public BalanceSheet(String titleIn, BalanceSheetContent[] contentIn) {
        title = titleIn;
        content = contentIn;
    }
}