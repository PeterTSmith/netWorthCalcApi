package com.peterTSmith.netWorthCalcApi.objects.BalanceValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BalanceValue {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private long docId;
    private long fieldId;
    private long value;
    private boolean isAsset;
    private boolean isLiability;
    private long dateModified;

    public BalanceValue() {
        docId = 0;
        fieldId = 0;
        value = 0;
        dateModified = 0;
    }

    public BalanceValue(long docIdIn, long fieldIdIn, long valueIn, boolean isAssetIn, boolean isLiabilityIn, long dateModifiedIn) {
        docId = docIdIn;
        fieldId = fieldIdIn;
        value = valueIn;
        isAsset = isAssetIn;
        isLiability = isLiabilityIn;
        dateModified = dateModifiedIn;
    }

    public long getId() {
        return id;
    }

    public long getDocId() {
        return docId;
    }

    public long getFieldId() {
        return fieldId;
    }

    public long getValue() {
        return value;
    }

    public boolean getIsAsset() {
        return isAsset;
    }

    public boolean getIsLiability() {
        return isLiability;
    }

    public long getDateModified() {
        return dateModified;
    }
}