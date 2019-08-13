package com.nchu.hospital_system.service.patient;



import com.nchu.hospital_system.bean.Patient;
import com.nchu.hospital_system.mapper.patient.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    PatientMapper patientMapper;

    public Patient get(String account) {
        return patientMapper.getPatientByAccount(account);
    }
}
