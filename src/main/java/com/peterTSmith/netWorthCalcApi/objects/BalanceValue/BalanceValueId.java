package com.peterTSmith.netWorthCalcApi.objects.BalanceValue;

import java.io.Serializable;

public class BalanceValueId implements Serializable {
    private long docId;
    private long fieldId;

    public BalanceValueId(){
        docId = 0;
        fieldId = 0;
    }

    public BalanceValueId(long docIdIn, long fieldIdIn){
        docId = docIdIn;
        fieldId = fieldIdIn;
    }
}