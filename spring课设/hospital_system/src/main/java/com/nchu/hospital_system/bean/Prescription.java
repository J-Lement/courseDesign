package com.nchu.hospital_system.bean;

public class Prescription {
    private String doctor;
    private String patient;
    private int drugid;
    private int amount;

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public int getDrugid() {
        return drugid;
    }

    public void setDrugid(int drugid) {
        this.drugid = drugid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
