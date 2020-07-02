package com.peterTSmith.netWorthCalcApi.objects.BalanceValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(BalanceValueId.class)
public class BalanceValue {
    /*@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;*/
    @Id
    private long docId;
    @Id
    private long fieldId;
    private long value;
    private String valueType;
    private long dateModified;

    public BalanceValue() {
        docId = 0;
        fieldId = 0;
        value = 0;
        dateModified = 0;
    }

    public BalanceValue(long docIdIn, long fieldIdIn, long valueIn, String valueTypeIn, long dateModifiedIn) {
        docId = docIdIn;
        fieldId = fieldIdIn;
        value = valueIn;
        valueType = valueTypeIn;
        dateModified = dateModifiedIn;
    }

    /*public long getId() {
        return id;
    }

    public void setId(long idIn) {
        id = idIn;
    }*/

    public long getDocId() {
        return docId;
    }

    public long getFieldId() {
        return fieldId;
    }

    public long getValue() {
        return value;
    }

    public String getValueType() {
        return valueType;
    }

    public long getDateModified() {
        return dateModified;
    }
}