package com.nchu.hospital_system.bean;

public class DrugPurchase {
    private int drugid;
    private int drugstoreid;
    private int amount;

    public int getDrugid() {
        return drugid;
    }

    public void setDrugid(int drugid) {
        this.drugid = drugid;
    }

    public int getDrugstoreid() {
        return drugstoreid;
    }

    public void setDrugstoreid(int drugstoreid) {
        this.drugstoreid = drugstoreid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
