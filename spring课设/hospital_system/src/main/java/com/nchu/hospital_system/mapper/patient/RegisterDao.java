package com.nchu.hospital_system.mapper.patient;


import com.nchu.hospital_system.bean.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RegisterDao {
    public List<Doctor> queryAllDoctor();

    public List<Doctor> queryDoctorByDept(String dept);

    public List<Dept> queryAllDepartment();

    public int insertPatient(Patient patient);

    public int checkPatientAccount(String account);

    public List<OrderTime> queryOrderTime(String account);

    public List<Integer> queryOrderNumber(@Param("doctorAccount") String doctorAccount, @Param("date") String date, @Param("time") int time);

    public int updateOrderInfo(@Param("doctorAccount") String doctorAccount, @Param("date") String date, @Param("time") int time, @Param("number") int number, @Param("is_order") int is_order);

    public int updateOrderTimeMor(@Param("doctorAccount") String doctorAccount, @Param("day") int day);

    public int updateOrderTimeAft(@Param("doctorAccount") String doctorAccount, @Param("day") int day);

    public int insertAssignment(@Param("patient")String patient, @Param("doctorAccount") String doctorAccount, @Param("date") String date, @Param("number") int number);

    public List<Assignments> queryAssignmentByPatient(String patient);
}
