package com.peterTSmith.netWorthCalcApi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peterTSmith.netWorthCalcApi.objects.BalanceSheet.*;

@RestController
public class LiabilitiesSheetController {
    
    private BalanceSheet liabilitiesSheet;

    LiabilitiesSheetController() {
        Field[] shortTermLiabilities = new Field[3];
        shortTermLiabilities[0] = new Field("creditCard1", "Chequing");
        shortTermLiabilities[1] = new Field("creditCard2", "Savings For Taxes");
        shortTermLiabilities[2] = new Field("others", "(others...)");

        Field[] longTermDebt = new Field[6];
        longTermDebt[0] = new Field("mortgage1", "Mortgage 1");
        longTermDebt[1] = new Field("mortgage2", "Mortgage 2");
        longTermDebt[2] = new Field("lineOfCredit", "Line of Credit");
        longTermDebt[3] = new Field("investmentLoan", "Investment Loan");
        longTermDebt[4] = new Field("studentLoan", "Student Loan");
        longTermDebt[5] = new Field("carLoan", "Car Loan");

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
}