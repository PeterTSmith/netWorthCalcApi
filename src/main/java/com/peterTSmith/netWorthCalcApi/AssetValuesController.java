package com.peterTSmith.netWorthCalcApi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.peterTSmith.netWorthCalcApi.objects.BalanceValue.BalanceValue;

@RestController
public class AssetValuesController {

    private BalanceValue[] assetValues;

    AssetValuesController() {
        assetValues = new BalanceValue[1];
        assetValues[0] = new BalanceValue("chequing", 5544, 0);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/assetValues")
    public BalanceValue[] getAssetValues() {
        return assetValues;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/assetValues")
    public void postAssetValues(@RequestBody BalanceValue value) {
        System.out.println(value.getId());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/totalAssetValue")
    public long getTotalAssetValue() {
        long totalAssets = 0;
        for(int i = 0; i < assetValues.length; i++) {
            totalAssets += assetValues[i].getValue();
        }
        return totalAssets;
    }
}