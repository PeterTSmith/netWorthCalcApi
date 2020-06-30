package com.peterTSmith.netWorthCalcApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.peterTSmith.netWorthCalcApi.objects.BalanceSheet.*;

@RestController
public class AssetsSheetController {

    private BalanceSheet assetsSheet;

    AssetsSheetController() {
        Field[] cashAndInvestmentsFields = new Field[11];
        cashAndInvestmentsFields[0] = new Field("chequing", "Chequing");
        cashAndInvestmentsFields[1] = new Field("savingsForTaxes", "Savings For Taxes");
        cashAndInvestmentsFields[2] = new Field("rainyDayFund", "Rainy Day Fund");
        cashAndInvestmentsFields[3] = new Field("savingsForFun", "Savings For Fun");
        cashAndInvestmentsFields[4] = new Field("savingsForTravel", "Savings For Travel");
        cashAndInvestmentsFields[5] = new Field("savingsForPersonalDevelopment", "Savings For Personal Development");
        cashAndInvestmentsFields[6] = new Field("investment1", "Investment 1");
        cashAndInvestmentsFields[7] = new Field("investment2", "Investment 2");
        cashAndInvestmentsFields[8] = new Field("investment3", "Investment 3");
        cashAndInvestmentsFields[9] = new Field("investment4", "Investment 4");
        cashAndInvestmentsFields[10] = new Field("investment5", "Investment 5");

        Field[] longTermInvestmentsFields = new Field[3];
        longTermInvestmentsFields[0] = new Field("primaryHome", "Primary Home");
        longTermInvestmentsFields[1] = new Field("secondHome", "Second Home");
        longTermInvestmentsFields[2] = new Field("other", "Other");

        BalanceSheetContent[] assetsSheetContent = new BalanceSheetContent[2];
        assetsSheetContent[0] = new BalanceSheetContent("Cash and Investments", cashAndInvestmentsFields);
        assetsSheetContent[1] = new BalanceSheetContent("Long Term Investments", longTermInvestmentsFields);

        assetsSheet = new BalanceSheet("Assets", assetsSheetContent, 0);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/assetsSheet")
    public BalanceSheet GetAssetsSheet(){
        return assetsSheet;
    }
    
}