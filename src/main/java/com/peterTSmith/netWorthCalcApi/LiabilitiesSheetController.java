package com.peterTSmith.netWorthCalcApi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.peterTSmith.netWorthCalcApi.objects.BalanceSheet.*;

@RestController
public class LiabilitiesSheetController {
    
    private BalanceSheet liabilitiesSheet;

    LiabilitiesSheetController() {
        BalanceSheetField[] shortTermLiabilities = new BalanceSheetField[3];
        shortTermLiabilities[0] = new BalanceSheetField(14, "Chequing");
        shortTermLiabilities[1] = new BalanceSheetField(15, "Savings For Taxes");
        shortTermLiabilities[2] = new BalanceSheetField(16, "(others...)");

        BalanceSheetField[] longTermDebt = new BalanceSheetField[6];
        longTermDebt[0] = new BalanceSheetField(17, "Mortgage 1");
        longTermDebt[1] = new BalanceSheetField(18, "Mortgage 2");
        longTermDebt[2] = new BalanceSheetField(19, "Line of Credit");
        longTermDebt[3] = new BalanceSheetField(20, "Investment Loan");
        longTermDebt[4] = new BalanceSheetField(21, "Student Loan");
        longTermDebt[5] = new BalanceSheetField(22, "Car Loan");

        BalanceSheetContent[] liabilitiesSheetContent = new BalanceSheetContent[2];
        liabilitiesSheetContent[0] = new BalanceSheetContent("Short Term Liabilities", shortTermLiabilities);
        liabilitiesSheetContent[1] = new BalanceSheetContent("Long Term Debt", longTermDebt);

        liabilitiesSheet = new BalanceSheet("Liabilities", liabilitiesSheetContent, 0);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/liabilitiesSheet")
    public BalanceSheet GetLiabilitiesSheet() {
        return liabilitiesSheet;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/liabilitiesSheet")
    public void PostLiabilitiesSheet(@RequestBody BalanceSheetField liabilitiesSheetField) {
    }
}