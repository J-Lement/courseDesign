package com.nchu.hospital_system.service.pharmacyAdmin;

import com.nchu.hospital_system.bean.Drugstore;
import com.nchu.hospital_system.mapper.pharmacyAdmin.DrugstoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugstoreService {

    @Autowired
    DrugstoreMapper drugstoreMapper;


    public int add(Drugstore drugstore) {
        return drugstoreMapper.addDrugstore(drugstore);
    }

    public List<Drugstore> getDrugstores() {
        return drugstoreMapper.getAllDrugstores();
    }

    public Drugstore get(int id) {
        return drugstoreMapper.get(id);
    }

    public int edit(Drugstore drugstore) {
        return drugstoreMapper.updateDrug(drugstore);
    }

    public int delete(int id) {
        return drugstoreMapper.delete(id);
    }
}
