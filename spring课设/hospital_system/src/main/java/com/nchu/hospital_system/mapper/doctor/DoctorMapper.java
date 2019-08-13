package com.nchu.hospital_system.mapper.doctor;

import com.nchu.hospital_system.bean.Diagnose;
import com.nchu.hospital_system.bean.Doctor;
import com.nchu.hospital_system.bean.Prescription;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorMapper {

    @Select("select * from doctor where account=#{account}")
    public Doctor getDoctorByAccount(String account);

    @Insert("insert into doctor values(#{account},#{name},#{phone},#{position},#{password},#{dept})")
    int add(Doctor doctor);

    @Select("select * from doctor")
    List<Doctor> getAll();

    @Select("select * from doctor where account=#{account}")
    Doctor get(String account);

    @Delete("delete from doctor where account=#{account}")
    int delete(String account);

    @Update("update doctor set name=#{name},password=#{password},phone=#{phone},position=#{position},dept=#{dept} where account=#{account}")
    int update(Doctor doctor);

    @Insert("insert into diagnose values(#{doctor},#{patient},#{result})")
    int addDiagnose(Diagnose diagnose);

    @Insert("insert into exam values(#{doctor},#{patient},#{result})")
    int addExam(Diagnose diagnose);

    @Insert("insert into injection values(#{doctor},#{patient},#{drugid},#{amount})")
    int addInjection(Prescription prescription);

    @Insert("insert into prescription values(#{doctor},#{patient},#{drugid},#{amount})")
    int addPrescription(Prescription prescription);

    @Delete("delete from assignment where doctor=#{arg0} and patient=#{arg1}")
    int completeDiagnose(String doctor, String patient);
}
