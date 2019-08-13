package com.nchu.hospital_system.controller;

import com.nchu.hospital_system.bean.Assignments;
import com.nchu.hospital_system.service.LoginService;
import com.nchu.hospital_system.service.patient.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    @PostMapping("/login")
    public String login(@RequestParam("account") String  account,
                        @RequestParam("password") String password,
                        @RequestParam("type") String type,
                        Map<String,String> map,
                        HttpSession session,
                        Model model) {

        if (loginService.checkUser(account, password, type)) {
            switch (type) {
                case "医生":
                    session.setAttribute("user",account);
                    return "doctor/doctor_index";
                case "病人":
                    List<Assignments> aList = registerService.queryAssignmentByPatient(account);
                    model.addAttribute("aList",aList);
                    session.setAttribute("user",account);
                    return "patient/patient_index";
                case "药房管理员":
                    session.setAttribute("user",account);
                    return "pharmacyAdmin/pharmacy_admin_index";
                case "系统管理员":
                    session.setAttribute("user",account);
                    return "systemAdmin/system_admin_index";
            }
        }
        map.put("msg","用户名或密码错误");
        return "login";
    }

    @RequestMapping({"/", "/login"})
    public String login() {
        return "login";
    }
}
