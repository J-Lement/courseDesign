package com.nchu.hospital_system.bean;

/**
 * @ClassName OrderTime
 * @Description 预约时间类
 * @Author Lement
 * @Date 2019/6/1817:24
 */
public class OrderTime {
    private String doctorAccount;
    private String day;//日期
    private String weekDay;//星期几
    private int week;//0表示周日，1表示周一，以此类推
    private int morning;//早上是否可预约
    private int morAllNum;//早上可预约的数量
    private int morLeftNum;//早上剩下预约的数量
    private int afternoon;
    private int aftAllNum;
    private int aftLeftNum;

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getDoctorAccount() {
        return doctorAccount;
    }

    public void setDoctorAccount(String doctorAccount) {
        this.doctorAccount = doctorAccount;
    }

    public int getMorning() {
        return morning;
    }

    public void setMorning(int morning) {
        this.morning = morning;
    }

    public int getMorAllNum() {
        return morAllNum;
    }

    public void setMorAllNum(int morAllNum) {
        this.morAllNum = morAllNum;
    }

    public int getMorLeftNum() {
        return morLeftNum;
    }

    public void setMorLeftNum(int morLeftNum) {
        this.morLeftNum = morLeftNum;
    }

    public int getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(int afternoon) {
        this.afternoon = afternoon;
    }

    public int getAftAllNum() {
        return aftAllNum;
    }

    public void setAftAllNum(int aftAllNum) {
        this.aftAllNum = aftAllNum;
    }

    public int getAftLeftNum() {
        return aftLeftNum;
    }

    public void setAftLeftNum(int aftLeftNum) {
        this.aftLeftNum = aftLeftNum;
    }
}
