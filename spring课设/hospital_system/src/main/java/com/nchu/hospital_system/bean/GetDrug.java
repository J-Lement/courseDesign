package com.nchu.hospital_system.bean;

public class GetDrug {
    private int drugid;
    private String patient;
    private int quantity;

    public int getDrugid() {
        return drugid;
    }

    public void setDrugid(int drugid) {
        this.drugid = drugid;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
