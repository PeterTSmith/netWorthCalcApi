package com.peterTSmith.netWorthCalcApi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.peterTSmith.netWorthCalcApi.objects.BalanceSheet.*;

@RestController
public class AssetsSheetController {

    private BalanceSheet assetsSheet;

    AssetsSheetController() {
        BalanceSheetField[] cashAndInvestmentsFields = new BalanceSheetField[11];
        cashAndInvestmentsFields[0] = new BalanceSheetField(0, "Chequing");
        cashAndInvestmentsFields[1] = new BalanceSheetField(1, "Savings For Taxes");
        cashAndInvestmentsFields[2] = new BalanceSheetField(2, "Rainy Day Fund");
        cashAndInvestmentsFields[3] = new BalanceSheetField(3, "Savings For Fun");
        cashAndInvestmentsFields[4] = new BalanceSheetField(4, "Savings For Travel");
        cashAndInvestmentsFields[5] = new BalanceSheetField(5, "Savings For Personal Development");
        cashAndInvestmentsFields[6] = new BalanceSheetField(6, "Investment 1");
        cashAndInvestmentsFields[7] = new BalanceSheetField(7, "Investment 2");
        cashAndInvestmentsFields[8] = new BalanceSheetField(8, "Investment 3");
        cashAndInvestmentsFields[9] = new BalanceSheetField(9, "Investment 4");
        cashAndInvestmentsFields[10] = new BalanceSheetField(10, "Investment 5");

        BalanceSheetField[] longTermInvestmentsFields = new BalanceSheetField[3];
        longTermInvestmentsFields[0] = new BalanceSheetField(11, "Primary Home");
        longTermInvestmentsFields[1] = new BalanceSheetField(12, "Second Home");
        longTermInvestmentsFields[2] = new BalanceSheetField(13, "Other");

        BalanceSheetContent[] assetsSheetContent = new BalanceSheetContent[2];
        assetsSheetContent[0] = new BalanceSheetContent("Cash and Investments", cashAndInvestmentsFields);
        assetsSheetContent[1] = new BalanceSheetContent("Long Term Investments", longTermInvestmentsFields);

        assetsSheet = new BalanceSheet("Assets", assetsSheetContent, 0);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/assetsSheet")
    public BalanceSheet GetAssetsSheet() {
        return assetsSheet;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/assetsSheet")
    public void PostAssetsSheet(@RequestBody BalanceSheetField assetsSheetField) {
    }
}