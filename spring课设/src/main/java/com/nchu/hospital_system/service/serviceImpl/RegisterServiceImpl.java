package com.nchu.hospital_system.service.serviceImpl;

import com.nchu.hospital_system.bean.Department;
import com.nchu.hospital_system.bean.Doctor;
import com.nchu.hospital_system.bean.OrderTime;
import com.nchu.hospital_system.bean.Patient;
import com.nchu.hospital_system.mapper.RegisterDao;
import com.nchu.hospital_system.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    RegisterDao registerDao;

    /**
     * @Author Lement
     * @Description //查询所有科室
     * @Date 21:03 2019/6/22
     * @Param []
     * @return java.util.List<com.nchu.hospital_system.bean.Department>
     **/
    @Override
    public List<Department> queryAllDepartment() {
        return registerDao.queryAllDepartment();
    }

    /**
     * @Author Lement
     * @Description //检测账号是否存在，返回数据库中与参数account相同的数据条数
     * @Date 21:04 2019/6/22
     * @Param [account]
     * @return int
     **/
    @Override
    public int checkPatientAccount(String account) {
        return registerDao.checkPatientAccount(account);
    }

    /**
     * @Author Lement
     * @Description //添加新病人的注册信息
     * @Date 21:06 2019/6/22
     * @Param [patient]
     * @return int
     **/
    @Override
    public int insertPatient(Patient patient) {
        return registerDao.insertPatient(patient);
    }

    /**
     * @Author Lement
     * @Description //查询所有医生
     * @Date 21:06 2019/6/22
     * @Param []
     * @return java.util.List<com.nchu.hospital_system.bean.Doctor>
     **/
    @Override
    public List<Doctor> queryAllDoctor() {
        return registerDao.queryAllDoctor();
    }

    /**
     * @Author Lement
     * @Description //通过科室名称，查询该科室下的所有医生信息
     * @Date 21:07 2019/6/22
     * @Param [dept]
     * @return java.util.List<com.nchu.hospital_system.bean.Doctor>
     **/
    @Override
    public List<Doctor> queryDoctorByDept(String dept) {
        return registerDao.queryDoctorByDept(dept);
    }

    /**
     * @Author Lement
     * @Description //通过医生账号，查询该医生可预约的时间信息
     * @Date 21:09 2019/6/22
     * @Param [account]
     * @return java.util.List<com.nchu.hospital_system.bean.OrderTime>
     **/
    @Override
    public List<OrderTime> queryOrderTime(String account) {
        List<OrderTime> list = registerDao.queryOrderTime(account);

        Date date = new Date();
        SimpleDateFormat fm = new SimpleDateFormat("YYYY-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(cal.DAY_OF_WEEK) - 1;       //获取今天是星期几
        if (w < 0)
            w = 0;          //0代表周日，1代表周一，以此类推

        int listLength = list.size();
        for (int i = 0; i < listLength; i ++){      //将今天之前的安排放在最后
            if(list.get(i).getWeek() == w){         //例如今天周三，将周日周一周二放在周六之后
                int k = 0;                      //将0到i-1的对象放在最后（即将从周日到昨天放到最后，0代表周日）
                for(int j = list.size(); j < listLength + i; j ++){
                    list.add(list.get(k ++));
                }

                for(int j = 0; j < k; k --)
                    list.remove(j);             //移除前面重复的k个对象

                break;
            }
        }
        String day;
        int d = cal.get(Calendar.DATE);
        for(int i = 0; i < list.size(); i ++) {         //设置未来一周的具体日期和星期几
            list.get(i).setWeekDay(weekDays[list.get(i).getWeek()]);        //给每个数据设置字符串‘星期几’

            cal.set(Calendar.DATE, d + i);              //设置从当前日期开始的一周日期
            day = fm.format(cal.getTime());             //获取具体日期并设定日期格式，YYYY-MM-dd
            list.get(i).setDay(day);                    //设置日期
        }

        return list;
    }

    /**
     * @Author Lement
     * @Description //根据医生账号、日期、上下午，查询这个时间可预约的号码
     * @Date 21:23 2019/6/22
     * @Param [doctorAccount, date, time]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> queryOrderNumber(String doctorAccount, String date, int time){
        return registerDao.queryOrderNumber(doctorAccount, date, time);
    }

    /**
     * @Author Lement
     * @Description //根据医生账号、日期、上下午、号码、是否预约，将号码表中的信息更新
     * @Date 21:24 2019/6/22
     * @Param [doctorAccount, date, time, number, is_order]
     * @return int
     **/
    public int updateOrderInfo(String doctorAccount, String date, int time, int number, int is_order){
        return registerDao.updateOrderInfo(doctorAccount, date, time, number, is_order);
    }

    /**
     * @Author Lement
     * @Description //根据医生账号、预约日期、上下午，更新号码数量（将号码数量减一）
     * @Date 18:09 2019/6/24
     * @Param [doctorAccount, day, time]
     * @return int
     **/
    @Override
    public int updateOrderTime(String doctorAccount, int day, int time) {
        if(time == 1)
            return registerDao.updateOrderTimeMor(doctorAccount, day);
        else
            return registerDao.updateOrderTimeAft(doctorAccount, day);
    }

    /**
     * @Author Lement
     * @Description //根据医生账号、预约日期、预约号码，将数据插入挂号表中
     * @Date 18:10 2019/6/24
     * @Param [doctorAccount, date, number]
     * @return int
     **/
    @Override
    public int insertAssignment(String doctorAccount, String date, int number) {
        return registerDao.insertAssignment(doctorAccount, date, number);
    }
}
