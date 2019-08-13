package com.nchu.hospital_system.bean;

/**
 * @ClassName Assignments
 * @Description TODO
 * @Author Lement
 * @Date 2019/6/2720:29
 */
public class Assignments {
    private Integer registerid;
    private String doctor;
    private String patient;
    private String time;
    private Integer num;

    public Integer getRegisterid() {
        return registerid;
    }

    public void setRegisterid(Integer registerid) {
        this.registerid = registerid;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
