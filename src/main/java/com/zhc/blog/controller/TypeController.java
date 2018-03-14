package com.zhc.blog.controller;

import com.zhc.blog.pojo.Type;
import com.zhc.blog.service.TypeService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("admin/type")
public class TypeController {

    @Autowired
    TypeService typeService;

    @RequestMapping("delete")
    public String typeDelete(@RequestParam("id")String  id){
        typeService.typeDelete(Integer.parseInt(id));
        return "redirect:manage";
    }

    /*分类管理页面*/
    @RequestMapping("manage")
    public ModelAndView typeManage(){
        ModelAndView mv = new ModelAndView();
        List<Type> typeList = typeService.typeList();
        mv.addObject("typeList", typeList);
        mv.setViewName("blog/type_manage");
        return mv;
    }

    @RequestMapping("add")
    public String typeAdd(Type type, @RequestParam("name") String name){
        typeService.typeAdd(type);
        return "redirect:manage";
    }

}
