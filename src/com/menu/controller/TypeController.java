package com.menu.controller;


import com.menu.pojo.Type;
import com.menu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class TypeController {
	
	@Autowired
	private TypeService typeService;

    /**
     * 分类列表
     * @param model
     * @return
     */
	@RequestMapping("type/typeList.html")
	public String getTypeList(Model model) {

        List<Type> typeList = typeService.getTypeList();
        for (Type type : typeList) {
            Integer count = typeService.getTypeCount(type);
            type.setTypeNum(count);
            typeService.editType(type);
        }
        model.addAttribute("typeList", typeList);
        return "jsp/type/list";
	}

    /**
     * 删除分类
     * @param typeId
     * @return
     */
	@RequestMapping("type/deleteType{typeId}.html")
    public String deleteType(@PathVariable String typeId) {

	    typeService.deleteTypeById(typeId);

	    return "redirect:/type/typeList.html";
    }

    /**
     * 查询分类，跳转到编辑界面回显
     * @param typeId
     * @param model
     * @return
     */
    @RequestMapping("type/toEdit{typeId}.html")
    public String toEdit(@PathVariable String typeId, Model model) {

	    Type type = new Type();
        type.setTypeId(typeId);
        Type type1 = typeService.getType(type);
        model.addAttribute("type", type1);
        return "jsp/type/edit";
    }

    /**
     * 编辑分类
     * @param type
     * @param model
     * @return
     */
    @RequestMapping("type/editType.html")
    public String editType(Type type, Model model) {

	    typeService.editType(type);

        return "redirect:/type/typeList.html";
    }

    /**
     * 新增类型
     * @param type
     * @return
     */
    @RequestMapping("type/addType.html")
    public String addType(Type type) {

        typeService.addType(type);

        return "redirect:/type/typeList.html";
    }
	
}
