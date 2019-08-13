package com.nchu.hospital_system.controller.patient;

import com.nchu.hospital_system.bean.*;
import com.nchu.hospital_system.service.patient.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @RequestMapping("/patient_index")
    public String index(){
        return "patient/patient_index";
    }
    /**
     * @Author Lement
     * @Description //检测是否由相同用户名，返回相同用户名的个数
     * @Date 20:49 2019/6/22
     * @Param [account]
     * @return java.lang.String
     **/
    @RequestMapping("/patientRegiste")
    @ResponseBody
    public String register(@RequestParam("account")String account){
        int i = registerService.checkPatientAccount(account);
        return i + "";
    }

    /**
     * @Author Lement
     * @Description //注册功能，由于thymeleaf的值不能为空，所以第一次访问给页面送一个空的patient对象，跳到注册界面
     * 如果注册信息经过了前端的验证跳转到此，就直接存入数据库，完成后跳转到登录界面
     * @Date 20:50 2019/6/22
     * @Param [patient, model]
     * @return java.lang.String
     **/
    @RequestMapping("/doRegiste")
    public String doRegiste(Patient patient, Model model){
        System.out.println("patientName:" + patient.getName());
        if(patient.getName() == null){
            model.addAttribute("patient",patient);
            return "patient/register";
        }
        else {
            registerService.insertPatient(patient);
            System.out.println("病人姓名：" + patient.getName());
            return "login";
        }
    }

    /**
     * @Author Lement
     * @Description //从数据库中查询获取所有科室的信息，然后跳转到科室选择界面
     * @Date 20:53 2019/6/22
     * @Param [model]
     * @return java.lang.String
     **/
    @RequestMapping("/selectDepartment")
    public String selectDepartment(Model model){
        List<Dept> list = registerService.queryAllDepartment();
        model.addAttribute("deptList",list);
        return "patient/selectDepartment";
    }

    /**
     * @Author Lement
     * @Description //通过点击某一个科室跳转到此，查询此科室下的所有医生信息，然后跳转到医生选择界面
     * @Date 20:55 2019/6/22
     * @Param [dept, model]
     * @return java.lang.String
     **/
    @RequestMapping("/selectDoctor")
    public String selectDoctor(@RequestParam("dept")String dept, Model model){
        List<Doctor> list = registerService.queryDoctorByDept(dept);
        model.addAttribute("dList",list);
        return "patient/selectDoctor";
    }

    /**
     * @Author Lement
     * @Description //Test，测试数据库
     * @Date 12:59 2019/6/22
     * @Param [model]
     * @return java.lang.String
     **/
    @RequestMapping("/Doctor")
    public String selectDoctor(Model model){
        List<Doctor> list = registerService.queryAllDoctor();
        model.addAttribute("dList",list);
        return "patient/selectDoctor";
    }

    /**
     * @Author Lement
     * @Description //在医生选择界面点击某个医生，传入医生账号，通过账号查询该医生的可预约时间信息，跳转到预约界面
     * @Date 20:57 2019/6/22
     * @Param [account, model]
     * @return java.lang.String
     **/
    @RequestMapping("/orderTime")
    public String orderTime(@RequestParam("account")String account, Model model){
        List<OrderTime> orderList =  registerService.queryOrderTime(account);
        model.addAttribute("orderList", orderList);
        return "patient/orderTime";
    }

    /**
     * @Author Lement
     * @Description //通过ajax访问此类，根据传入的医生账号、日期、上下午时间，查询可预约的号码，返回号码数组
     * @Date 20:59 2019/6/22
     * @Param [doctorAccount, date, time]
     * @return java.util.List<java.lang.Integer>
     **/
    @RequestMapping("/allOrderNumber")
    @ResponseBody
    public List<Integer> allOrderNumber(@RequestParam("doctorAccount") String doctorAccount, @RequestParam("date") String date, @RequestParam("time") int time){
        System.out.println("account:" + doctorAccount + " date:" + date + " time:" + time);
        return registerService.queryOrderNumber(doctorAccount, date, time);
    }

    /**
     * @Author Lement
     * @Description //确认预约，将数据存入数据库中
     * @Date 21:02 2019/6/22
     * @Param [number, doctorAccount, date, time]
     * @return java.lang.String
     **/
    @RequestMapping("/doOrder")
    public String doOrder(@RequestParam("number") int number, @RequestParam("doctorAccount") String doctorAccount, @RequestParam("date") String date, @RequestParam("week") int week, @RequestParam("time") int time,@RequestParam("patient")String patient, Model model){
        int is_order = 1;                      //修改号码预约状态
        registerService.updateOrderInfo(doctorAccount, date, time, number,is_order);
        registerService.updateOrderTime(doctorAccount, week, time);
        registerService.insertAssignment(patient ,doctorAccount, date, number);
        System.out.println("bingrena 病人啊：" + patient);
        List<Assignments> aList = registerService.queryAssignmentByPatient(patient);
        model.addAttribute("aList",aList);
        return "patient/patient_index";
    }
}
