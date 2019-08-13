package com.nchu.hospital_system.mapper.patient;

import com.nchu.hospital_system.bean.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PatientMapper {

    @Select("select * from patient where account=#{account}")
    public Patient getPatientByAccount(String account);

    @Select("SELECT patient.* FROM patient,assignment,doctor WHERE doctor.account=assignment.doctor AND patient.account=assignment.patient AND doctor.account=#{account}")
    List<Patient> getDiagnosePatients(String account);

}
