package com.nchu.hospital_system.controller.pharmacyAdmin;

import com.nchu.hospital_system.bean.Drugstore;
import com.nchu.hospital_system.service.pharmacyAdmin.DrugstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DrugstoreController {

    @Autowired
    DrugstoreService drugstoreService;

    @PostMapping("/addDrugstoreDo")
    public String addDrugstoreDo(Drugstore drugstore){
        drugstoreService.add(drugstore);
        return "redirect:/drugstore_list";
    }

    @RequestMapping("/drugstore_list")
    public String drugstoreList(Model model){
        model.addAttribute("stores",drugstoreService.getDrugstores());
        return "pharmacyAdmin/drugstore_list";
    }

    @GetMapping("/edit_drugstore")
    public String editDrugstore(@RequestParam("id") int id,
                                Model model){
        Drugstore drugstore = drugstoreService.get(id);
        model.addAttribute("drugstore",drugstore);
        return "pharmacyAdmin/drugstore_edit";
    }

    @GetMapping("/delete_drugstore/{id}")
    public String deleteDrugstore(@PathVariable("id") int id){
        drugstoreService.delete(id);
        return "redirect:/drugstore_list";
    }

    @PostMapping("/editDrugstoreDo")
    public String editDrugstoreDo(Drugstore drugstore){
        drugstoreService.edit(drugstore);
        return "redirect:/drugstore_list";
    }

}
