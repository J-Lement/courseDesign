package com.nchu.hospital_system.controller.doctor;

import com.nchu.hospital_system.bean.Doctor;
import com.nchu.hospital_system.service.systemAdmin.DeptService;
import com.nchu.hospital_system.service.Doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoctorController {

    @Autowired
    DeptService deptService;
    @Autowired
    DoctorService doctorService;

    @RequestMapping("/doctor_index")
    public String index(){
        return "doctor/doctor_index";
    }

    @RequestMapping("/add_doctor")
    public String add_doctor(Model model){
        model.addAttribute("depts",deptService.getAll());
        return "systemAdmin/add_doctor";
    }

    @RequestMapping("/addDoctorDo")
    public String addDoctorDo(Doctor doctor){
        deptService.addDoctor(doctor);
        return "redirect:doctor_list";
    }

    @RequestMapping("/doctor_list")
    public String doctor_list(Model model){
        model.addAttribute("doctors",doctorService.getAll());
        return "systemAdmin/doctor_list";
    }

    @GetMapping("/edit_doctor")
    public String editDoctor(@RequestParam("account") String account,
                           Model model){
        Doctor doctor = doctorService.get(account);
        model.addAttribute("doctor",doctor);
        model.addAttribute("depts",deptService.getAll());
        return "systemAdmin/doctor_edit";
    }

    @GetMapping("/delete_doctor")
    public String deleteDoctor(@RequestParam("account") String account){
        doctorService.delete(account);
        return "redirect:/doctor_list";
    }

    @PostMapping("/editDoctorDo")
    public String editDoctorDo(Doctor doctor){
        doctorService.edit(doctor);
        return "redirect:/doctor_list";
    }
}
