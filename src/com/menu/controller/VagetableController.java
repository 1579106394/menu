package com.menu.controller;

import com.menu.pojo.Type;
import com.menu.pojo.Vagetable;
import com.menu.service.TypeService;
import com.menu.service.VagetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VagetableController {

    @Autowired
    private VagetableService vagetableService;

    @Autowired
    private TypeService typeService;

    /**
     * 获取菜品列表
     * @param model
     * @return
     */
    @RequestMapping("vage/vageList.html")
    public String vageList(Model model, Vagetable vage) {

        List<Vagetable> vageList = vagetableService.getVageList(vage);
        List<Type> typeList = typeService.getTypeList();

        model.addAttribute("typeList", typeList);
        model.addAttribute("vageList", vageList);
        model.addAttribute("vage", vage);

        return "jsp/vagetable/list";
    }

    /**
     * 获取菜品分类，跳转到添加界面
     */
    @RequestMapping("vage/toAdd.html")
    public String toAdd(Model model) {

        List<Type> typeList = typeService.getTypeList();

        model.addAttribute("typeList", typeList);

        return "jsp/vagetable/add";
    }

    /**
     * 添加菜品
     * @param vage
     * @return
     */
    @RequestMapping("vage/addVage.html")
    public String addVage(Vagetable vage) {

        vagetableService.addVage(vage);

        return "redirect:/vage/vageList.html";
    }

    /**
     * 编辑菜品
     * @param vage
     * @return
     */
    @RequestMapping("vage/editVage.html")
    public String editVage(Vagetable vage) {

        vagetableService.editVage(vage);

        return "redirect:/vage/vageList.html";
    }

    /**
     * 删除菜品
     */
    @RequestMapping("vage/deleteVage{vageId}.html")
    public String deleteVage(@PathVariable String vageId) {

        vagetableService.deleteVage(vageId);

        return "redirect:/vage/vageList.html";
    }

    /**
     * 获取菜品信息，跳转到编辑界面
     * @param vageId
     * @param model
     * @return
     */
    @RequestMapping("vage/toEdit{vageId}.html")
    public String toEdit(@PathVariable String vageId, Model model) {

        Vagetable vage = vagetableService.getVageById(vageId);
        List<Type> typeList = typeService.getTypeList();

        model.addAttribute("typeList", typeList);

        model.addAttribute("vage", vage);

        return "jsp/vagetable/edit";
    }

}
