package com.nchu.hospital_system.controller.systemAdmin;

import com.nchu.hospital_system.bean.Dept;
import com.nchu.hospital_system.bean.Drug;
import com.nchu.hospital_system.service.systemAdmin.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeptController {

    @Autowired
    DeptService deptService;

    /**
     * create by: msmw
     * description: 添加科室
     * create time:
     *

     * @return
     */
    @RequestMapping("/addDeptDo")
    public String addDeptDo(Dept dept){
        deptService.addDept(dept);
        return "redirect:dept_list";
    }

    /**
     * create by: msmw
     * description: 科室列表
     * create time:
     *

     * @return
     */
    @RequestMapping("/dept_list")
    public String dept_list(Model model){
        model.addAttribute("depts",deptService.getAll());
        return "systemAdmin/dept_list";
    }

    /**
     * create by: msmw
     * description: 修改科室
     * create time:
     *

     * @return
     */
    @GetMapping("/edit_dept")
    public String editDept(@RequestParam("id") int id,
                           Model model){
        Dept dept = deptService.get(id);
        model.addAttribute("dept",dept);
        return "systemAdmin/dept_edit";
    }

    /**
     * create by: msmw
     * description: 删除科室
     * create time:
     *

     * @return
     */
    @GetMapping("/delete_dept")
    public String deleteDept(@RequestParam("id") int id){
        deptService.delete(id);
        return "redirect:/dept_list";
    }

    /**
     * create by: msmw
     * description: 完成修改科室
     * create time:
     *

     * @return
     */
    @PostMapping("/editDeptDo")
    public String editDeptDo(Dept dept){
        deptService.edit(dept);
        return "redirect:/dept_list";
    }
}
