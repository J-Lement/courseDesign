package com.nchu.hospital_system.service.patient;

import com.nchu.hospital_system.bean.*;


import java.util.List;

public interface RegisterService {
    public List<Doctor> queryAllDoctor();

    public List<Doctor> queryDoctorByDept(String dept);

    public List<Dept> queryAllDepartment();

    public int insertPatient(Patient patient);

    public int checkPatientAccount(String account);

    public List<OrderTime> queryOrderTime(String account);

    public List<Integer> queryOrderNumber(String doctorAccount, String date, int time);

    public int updateOrderInfo(String doctorAccount, String date, int time, int number, int is_order);

    public int updateOrderTime(String doctorAccount, int day, int time);

    public int insertAssignment(String patient, String doctorAccount, String date, int number);

    public List<Assignments> queryAssignmentByPatient(String patient);
}
