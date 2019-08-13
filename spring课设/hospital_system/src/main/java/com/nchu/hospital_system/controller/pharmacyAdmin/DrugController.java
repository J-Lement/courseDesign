package com.nchu.hospital_system.controller.pharmacyAdmin;

import com.nchu.hospital_system.bean.Drug;
import com.nchu.hospital_system.bean.DrugPurchase;
import com.nchu.hospital_system.service.pharmacyAdmin.DrugService;
import com.nchu.hospital_system.service.pharmacyAdmin.DrugstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DrugController {

    @Autowired
    DrugService drugService;

    @Autowired
    DrugstoreService drugstoreService;
/**
 * create by: msmw
 * description: 添加药品
 * create time:
 *

 * @return
 */
    @RequestMapping("/add_drug")
    public String addDrug(Model model){
        model.addAttribute("classifies",drugService.getClassify());
        return "pharmacyAdmin/add_drug";
    }

    /**
     * create by: msmw
     * description: 完成添加药品
     * create time:
     *

     * @return
     */
    @PostMapping("/addDrugDo")
    public String addDrugDo(Drug drug){
        drugService.add(drug);
        return "redirect:/drug_list";
    }

    /**
     * create by: msmw
     * description: 药品列表
     * create time:
     *

     * @return
     */
    @RequestMapping("/drug_list")
    public String drugList(Model model){
        model.addAttribute("drugs",drugService.getDrugs());
        model.addAttribute("classifies",drugService.getClassify());
        return "pharmacyAdmin/drug_list";
}

    /**
     * create by: msmw
     * description: 药品列表分类
     * create time:
     *

     * @return
     */
    @GetMapping("/drug_classify")
    public String drugList(@RequestParam("classify") String classify,
                           Model model){
        model.addAttribute("classified",classify);
        model.addAttribute("drugs",drugService.classifyDrugs(classify));
        model.addAttribute("classifies",drugService.getClassify());
        return "pharmacyAdmin/drug_list";
    }

    /**
     * create by: msmw
     * description: 修改药品
     * create time:
     *

     * @return
     */
    @GetMapping("/edit_drug")
    public String editDrug(@RequestParam("id") int id,
                                Model model){
        Drug drug = drugService.get(id);
        model.addAttribute("classifies",drugService.getClassify());
        model.addAttribute("drug",drug);
        return "pharmacyAdmin/drug_edit";
    }

    /**
     * create by: msmw
     * description: 删除药品
     * create time:
     *

     * @return
     */
    @GetMapping("/delete_drug")
    public String deleteDrug(@RequestParam("id") int id){
        drugService.delete(id);
        return "redirect:/drug_list";
    }

    /**
     * create by: msmw
     * description: 完成修改药品
     * create time:
     *

     * @return
     */
    @PostMapping("/editDrugDo")
    public String editDrugDo(Drug drug){
        drugService.edit(drug);
        return "redirect:/drug_list";
    }

    /**
     * create by: msmw
     * description: 药品采购
     * create time:
     *

     * @return
     */
    @RequestMapping("/drug_purchase")
    public String drug_purchase(Model model){
        model.addAttribute("drugstores",drugstoreService.getDrugstores());
        model.addAttribute("drugs",drugService.getDrugs());
        model.addAttribute("classifies",drugService.getClassify());
        return "pharmacyAdmin/drug_purchase";
    }
    /**
     * create by: msmw
     * description: 分类药品采购
     * create time:
     *

     * @return
     */
    @GetMapping("/drug_purchase_classify")
    public String drug_purchase_classify(@RequestParam("classify") String classify,
                               Model model){
        model.addAttribute("drugstores",drugstoreService.getDrugstores());
        model.addAttribute("classified",classify);
        model.addAttribute("drugs",drugService.classifyDrugs(classify));
        model.addAttribute("classifies",drugService.getClassify());
        return "pharmacyAdmin/drug_purchase";
    }
    /**
     * create by: msmw
     * description: 处理药品采购
     * create time:
     *

     * @return
     */
    @PostMapping("/drugPurchase")
    public String drugPurchase(DrugPurchase drugPurchase){
        drugService.purchaseDrug(drugPurchase);
        return "redirect:/drug_list";
    }

    @GetMapping("/get_drug")
    public String getDrug(String doctor,String patient,int drugid,int quantity){
        drugService.addGetDrug(drugid,patient,quantity);
        drugService.deletePrescription(doctor,patient,drugid);
        return "redirect:/drug_list";
    }


}
