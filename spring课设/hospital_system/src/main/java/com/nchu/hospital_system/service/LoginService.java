package com.nchu.hospital_system.service;

import com.nchu.hospital_system.bean.Doctor;
import com.nchu.hospital_system.bean.Patient;
import com.nchu.hospital_system.bean.PharmacyAdmin;
import com.nchu.hospital_system.bean.SystemAdmin;
import com.nchu.hospital_system.mapper.doctor.DoctorMapper;
import com.nchu.hospital_system.mapper.patient.PatientMapper;
import com.nchu.hospital_system.mapper.pharmacyAdmin.PharmacyAdminMapper;
import com.nchu.hospital_system.mapper.systemAdmin.SystemAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private PharmacyAdminMapper pharmacyAdminMapper;
    @Autowired
    private SystemAdminMapper systemAdminMapper;

    public boolean checkUser(String account, String password, String type) {
        switch (type) {
            case "医生":
                Doctor doctor = doctorMapper.getDoctorByAccount(account);
                if(doctor==null){
                    return false;
                }
                return doctor.getPassword().equals(password);
            case "病人":
                Patient patient = patientMapper.getPatientByAccount(account);
                if(patient==null){
                    return false;
                }
                return patient.getPassword().equals(password);
            case "药房管理员":
                PharmacyAdmin pharmacyAdmin = pharmacyAdminMapper.getPharmacyAdminByAccount(account);
                if(pharmacyAdmin==null){
                    return false;
                }
                return pharmacyAdmin.getPassword().equals(password);
            case "系统管理员":
                SystemAdmin systemAdmin = systemAdminMapper.getSystemAdminByAccount(account);
                if(systemAdmin==null){
                    return false;
                }
                return systemAdmin.getPassword().equals(password);

            default:
                return false;
        }
    }

}
