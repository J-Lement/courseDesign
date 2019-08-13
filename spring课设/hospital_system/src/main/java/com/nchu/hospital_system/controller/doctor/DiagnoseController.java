package com.nchu.hospital_system.controller.doctor;

import com.nchu.hospital_system.bean.Diagnose;
import com.nchu.hospital_system.bean.OrderTime;
import com.nchu.hospital_system.bean.Prescription;
import com.nchu.hospital_system.service.Doctor.DoctorService;
import com.nchu.hospital_system.service.patient.RegisterService;
import com.nchu.hospital_system.service.pharmacyAdmin.DrugService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DiagnoseController {

    @Autowired
    DoctorService doctorService;
    @Autowired
    DrugService drugService;
    @Autowired
    RegisterService registerService;

    @RequestMapping("/set_order_time")
    public String set_order_time(@RequestParam("account") String account,
                               Model model){
        List<OrderTime> list = registerService.queryOrderTime(account);
        model.addAttribute("orderList",list);
        return "doctor/setOrderTime";
    }

    @RequestMapping("/patient_list")
    public String patient_list(@RequestParam("account") String account,
                               Model model){
        model.addAttribute("patients",doctorService.getDiagnosePatients(account));
        return "doctor/patient_list";
    }

    @RequestMapping("/diagnose_patient")
    public String diagnosePatient(HttpSession session){
        String account = (String)session.getAttribute("user");
        session.setAttribute("patient",account);
        return "doctor/diagnose_patient";
    }

    @RequestMapping("/addDiagnose")
    public String addDiagnose(Diagnose diagnose){
        doctorService.addDiagnose(diagnose);
        return "doctor/exam_patient";
    }

    @RequestMapping("/addExam")
    public String addExam(Diagnose diagnose,Model model){
        model.addAttribute("injectDrugs",drugService.getInjectDrugs());//取得注射剂类药品
        doctorService.addExam(diagnose);
        return "doctor/injection";
    }

    @RequestMapping("/add_injection")
    public String addInjection(Prescription prescription, Model model){
        doctorService.addInjection(prescription);
        model.addAttribute("injectDrugs",drugService.getInjectDrugs());//取得注射剂类药品
        return "doctor/injection";
    }

    @RequestMapping("/completeInjection")
    public String completeInjection(Model model){
        model.addAttribute("classifies",drugService.getClassify());
        model.addAttribute("drugs",drugService.getDrugs());
        return "doctor/prescription";
    }

    @GetMapping("/prescription_classify")
    public String prescription_classify(@RequestParam("classify") String classify,
                                         Model model){
        model.addAttribute("classified",classify);
        model.addAttribute("drugs",drugService.classifyDrugs(classify));
        model.addAttribute("classifies",drugService.getClassify());
        return "doctor/prescription";
    }

    @PostMapping("/drugPrescription")
    public String addPrescription(Prescription prescription, Model model){
        doctorService.addPrescription(prescription);
        model.addAttribute("classifies",drugService.getClassify());
        model.addAttribute("drugs",drugService.getDrugs());
        return "doctor/prescription";
    }

    @RequestMapping("/completeDiagnose")
    public String completeDiagnose(HttpSession session){
        String doctor = (String)session.getAttribute("user");
        String patient = (String)session.getAttribute("patient");
        doctorService.completeDiagnose(doctor,patient);
        return "doctor/completeDiagnose";
    }
}
