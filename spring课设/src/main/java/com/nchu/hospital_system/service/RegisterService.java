package com.nchu.hospital_system.service;

import com.nchu.hospital_system.bean.Department;
import com.nchu.hospital_system.bean.Doctor;
import com.nchu.hospital_system.bean.OrderTime;
import com.nchu.hospital_system.bean.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegisterService {
    public List<Doctor> queryAllDoctor();

    public List<Doctor> queryDoctorByDept(String dept);

    public List<Department> queryAllDepartment();

    public int insertPatient(Patient patient);

    public int checkPatientAccount(String account);

    public List<OrderTime> queryOrderTime(String account);

    public List<Integer> queryOrderNumber(String doctorAccount, String date, int time);

    public int updateOrderInfo(String doctorAccount, String date, int time, int number, int is_order);

    public int updateOrderTime(String doctorAccount, int day, int time);

    public int insertAssignment(String doctorAccount, String date, int number);
}
