package com.nchu.hospital_system.service.pharmacyAdmin;

import com.nchu.hospital_system.bean.*;
import com.nchu.hospital_system.mapper.pharmacyAdmin.DrugClassifyMapper;
import com.nchu.hospital_system.mapper.pharmacyAdmin.DrugMapper;
import com.nchu.hospital_system.mapper.pharmacyAdmin.DrugPurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService {

    @Autowired
    DrugMapper drugMapper;
    @Autowired
    DrugClassifyMapper drugClassifyMapper;
    @Autowired
    DrugPurchaseMapper drugPurchaseMapper;

    public int add(Drug drug) {
        return drugMapper.add(drug);
    }


    public List<Drug> getDrugs() {
        return drugMapper.getAll();
    }

    public Drug get(int id) {
        return drugMapper.get(id);
    }

    public int delete(int id) {
        return drugMapper.delete(id);
    }

    public int edit(Drug drug) {
        return drugMapper.update(drug);
    }

    public List<Drug> classifyDrugs(String classify) {
        return drugMapper.classifyDrugs(classify);
    }

    public List<DrugClassify> getClassify() {
        return drugClassifyMapper.getClassify();
    }

    public int purchaseDrug(DrugPurchase drugPurchase) {
        return drugPurchaseMapper.purchaseDrug(drugPurchase);
    }

    public List<Drug> getInjectDrugs() {
        return drugMapper.getInjectDrugs();
    }

    public List<DrugPurchase> getPurchases() {
        return drugMapper.getPurchases();
    }

    public List<Prescription> getPrescriptions() {
        return drugMapper.getPrescription();
    }

    public int deletePrescription(String doctor, String patient, int drugid) {
        return drugMapper.deletePrescription(doctor,patient,drugid);
    }

    public int addGetDrug(int drugid, String patient,int quantity) {
        return drugMapper.addGetDrug(drugid,patient,quantity);
    }

    public List<GetDrug> getGetdrugHistory() {
        return drugMapper.getGetdrugHistory();
    }
}
