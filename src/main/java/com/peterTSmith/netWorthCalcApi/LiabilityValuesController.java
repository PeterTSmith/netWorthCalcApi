package com.peterTSmith.netWorthCalcApi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.peterTSmith.netWorthCalcApi.objects.BalanceValue.BalanceValue;

@RestController
public class LiabilityValuesController {

    private BalanceValue[] liabilityValues;

    public LiabilityValuesController() {
        liabilityValues = new BalanceValue[1];
        liabilityValues[0] = new BalanceValue("mortgage1", 5744, 0);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/liabilityValues")
    public BalanceValue[] getLiabilityValues() {
        return liabilityValues;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/liabilityValues")
    public void postLiabilityValues(@RequestBody BalanceValue value) {
        System.out.println(value.getId());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/totalLiabilityValue")
    public long getTotalLiabilityValue() {
        long totalAssets = 0;
        for(int i = 0; i < liabilityValues.length; i++) {
            totalAssets += liabilityValues[i].getValue();
        }
        return totalAssets;
    }
}