package com.peterTSmith.netWorthCalcApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.peterTSmith.netWorthCalcApi.objects.BalanceValue.BalanceValue;
import com.peterTSmith.netWorthCalcApi.repos.BalanceValueRepository;

@RestController
public class NetWorthController {

    private final BalanceValueRepository repository;

    public NetWorthController(BalanceValueRepository repositoryIn) {
        repository = repositoryIn;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/netWorthValue")
    public long getNetWorthValue(@RequestParam(value="docId") long docId) {
        long totalValue = 0;
        List<BalanceValue> values = repository.findAll();

        for(int i = 0; i < values.size(); i++) {
            if(values.get(i).getDocId() == docId){
                if(values.get(i).getIsAsset()){
                    totalValue += values.get(i).getValue();
                }else if(values.get(i).getIsLiability()){
                    totalValue -= values.get(i).getValue();
                }
            }
        }

        return totalValue;
    }
}