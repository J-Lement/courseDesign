package com.nchu.hospital_system.controller.pharmacyAdmin;



import com.nchu.hospital_system.bean.*;
import com.nchu.hospital_system.service.Doctor.DoctorService;
import com.nchu.hospital_system.service.patient.PatientService;
import com.nchu.hospital_system.service.pharmacyAdmin.DrugService;
import com.nchu.hospital_system.service.pharmacyAdmin.DrugstoreService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PharmacyAdminController {

    @Autowired
    DrugService drugService;
    @Autowired
    DrugstoreService drugstoreService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    PatientService patientService;

    @RequestMapping("/pharmacy_admin_index")
    public String index(){
        return "pharmacyAdmin/pharmacy_admin_index";
    }

    @RequestMapping("/add_drugstore")
    public String addDrugstore(){
        return "pharmacyAdmin/add_drugstore";
    }

    @RequestMapping("/getdrug")
    public String getDrug(Model model){
        List<Prescription> prescriptions = drugService.getPrescriptions();
        List<Drug> drugs = new ArrayList<>();
        List<Doctor> doctors = new ArrayList<>();
        List<Patient> patients = new ArrayList<>();
        for (int i=0;i<prescriptions.size();i++) {
            drugs.add(drugService.get(prescriptions.get(i).getDrugid()));
            doctors.add(doctorService.get(prescriptions.get(i).getDoctor()));
            patients.add(patientService.get(prescriptions.get(i).getPatient()));
        }
        model.addAttribute("prescriptions",prescriptions);
        model.addAttribute("drugs",drugs);
        model.addAttribute("doctors",doctors);
        model.addAttribute("patients",patients);
        return "pharmacyAdmin/getdrug";
    }

    @RequestMapping("/purchase_history")
    public String purchaseHistory(Model model){
        List<DrugPurchase> drugPurchases = drugService.getPurchases();
        List<Drug> drugs = new ArrayList<>();
        List<Drugstore> drugstores = new ArrayList<>();
        for(int i=0;i<drugPurchases.size();i++){
            drugs.add(drugService.get(drugPurchases.get(i).getDrugid()));
            drugstores.add(drugstoreService.get(drugPurchases.get(i).getDrugstoreid()));
        }
        model.addAttribute("drugPurchases",drugPurchases);
        model.addAttribute("drugs",drugs);
        model.addAttribute("drugstores",drugstores);
        return "pharmacyAdmin/purchase_history";
    }


    @RequestMapping("/getdrug_history")
    public String getdrugHistroy(Model model){
        List<GetDrug> getDrugs = drugService.getGetdrugHistory();
        model.addAttribute("getDrugs",getDrugs);
        List<Patient> patients = new ArrayList<>();
        List<Drug> drugs = new ArrayList<>();
        for(int i=0;i<getDrugs.size();i++){
            patients.add(patientService.get(getDrugs.get(i).getPatient()));
            drugs.add(drugService.get(getDrugs.get(i).getDrugid()));
        }
        model.addAttribute("patients",patients);
        model.addAttribute("drugs",drugs);
        return "pharmacyAdmin/getdrug_history";
    }


}
