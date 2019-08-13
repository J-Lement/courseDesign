package com.nchu.hospital_system.service.systemAdmin;

import com.nchu.hospital_system.bean.Dept;
import com.nchu.hospital_system.bean.Doctor;
import com.nchu.hospital_system.mapper.doctor.DoctorMapper;
import com.nchu.hospital_system.mapper.systemAdmin.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    DeptMapper deptMapper;
    @Autowired
    DoctorMapper doctorMapper;

    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    public List<Dept> getAll() {
        return deptMapper.getAll();
    }

    public Dept get(int id) {
        return deptMapper.getDeptById(id);
    }

    public int edit(Dept dept) {
        return deptMapper.update(dept);
    }

    public int delete(int id) {
        return deptMapper.delete(id);
    }

    public int addDoctor(Doctor doctor) {
        return doctorMapper.add(doctor);
    }
}
