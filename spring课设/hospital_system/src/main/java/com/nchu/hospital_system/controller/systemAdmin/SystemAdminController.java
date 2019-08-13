package com.nchu.hospital_system.controller.systemAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemAdminController {

    @RequestMapping("/system_admin_index")
    public String index(){
        return "systemAdmin/system_admin_index";
    }

    @RequestMapping("/add_dept")
    public String add_dept(){
        return "systemAdmin/add_dept";
    }

}
