package com.peterTSmith.netWorthCalcApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.peterTSmith.netWorthCalcApi.objects.BalanceValue.BalanceValue;
import com.peterTSmith.netWorthCalcApi.repos.BalanceValueRepository;

@RestController
public class AssetValuesController {

    private final BalanceValueRepository repository;

    AssetValuesController(BalanceValueRepository repositoryIn) {
        this.repository = repositoryIn;
        this.repository.save(new BalanceValue(0, 0, 5544, "asset", 0));
        this.repository.save(new BalanceValue(0, 0, 44, "asset", 0));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/assetValues")
    public List<BalanceValue> getAssetValues(@RequestParam(value="docId") long docId) {

        ArrayList<BalanceValue> returnValue = new ArrayList<BalanceValue>();
        List<BalanceValue> values = repository.findAll();

        for(int i = 0; i < values.size(); i++) {
            if(values.get(i).getDocId() == docId && values.get(i).getValueType() == "asset"){
                returnValue.add(values.get(i));
            }
        }
        return returnValue;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/assetValues")
    public void postAssetValues(@RequestBody BalanceValue value) {
        this.repository.save(value);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/totalAssetValue")
    public long getTotalAssetValue(@RequestParam(value="docId") long docId) {

        long totalValue = 0;
        List<BalanceValue> values = repository.findAll();

        for(int i = 0; i < values.size(); i++) {
            if(values.get(i).getDocId() == docId && values.get(i).getValueType() == "asset"){
                totalValue += values.get(i).getValue();
            }
        }

        return totalValue;
    }
}