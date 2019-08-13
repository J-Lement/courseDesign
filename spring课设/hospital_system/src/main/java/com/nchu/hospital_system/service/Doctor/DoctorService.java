package com.nchu.hospital_system.service.Doctor;

import com.nchu.hospital_system.bean.Diagnose;
import com.nchu.hospital_system.bean.Doctor;
import com.nchu.hospital_system.bean.Prescription;
import com.nchu.hospital_system.bean.Patient;
import com.nchu.hospital_system.mapper.patient.PatientMapper;
import com.nchu.hospital_system.mapper.doctor.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    PatientMapper patientMapper;

    public List<Doctor> getAll() {
        return doctorMapper.getAll();
    }

    public Doctor get(String account) {
        return doctorMapper.get(account);
    }

    public int delete(String account) {
        return doctorMapper.delete(account);
    }

    public int edit(Doctor doctor) {
        return doctorMapper.update(doctor);
    }

    public List<Patient> getDiagnosePatients(String account) {
        return patientMapper.getDiagnosePatients(account);
    }

    public int addDiagnose(Diagnose diagnose) {
        return doctorMapper.addDiagnose(diagnose);
    }

    public int addExam(Diagnose diagnose) {
        return doctorMapper.addExam(diagnose);
    }

    public int addInjection(Prescription prescription) {
        return doctorMapper.addInjection(prescription);
    }

    public int addPrescription(Prescription prescription) {
        return doctorMapper.addPrescription(prescription);
    }

    public int completeDiagnose(String doctor, String patient) {
        return doctorMapper.completeDiagnose(doctor,patient);
    }
}
