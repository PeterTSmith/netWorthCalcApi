package com.peterTSmith.netWorthCalcApi.objects.BalanceSheet;

public class BalanceSheet {
    private String title;
    private BalanceSheetContent[] content;
    private long dateModified;

    public BalanceSheet() {
        title = "";
        content = null;
        dateModified = 0;
    }

    public BalanceSheet(String titleIn, BalanceSheetContent[] contentIn, int dateModifiedIn) {
        title = titleIn;
        content = contentIn;
        dateModified = dateModifiedIn;
    }
    
    public String getTitle() {
        return title;
    }

    public BalanceSheetContent[] getContent() {
        return content;
    }

    public long getDateModified() {
        return dateModified;
    }
}