package com.neuedu.controller;

import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/user/category/")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @RequestMapping("find")
    public  String  findAll(HttpSession session){

        List<Category> categoryList=categoryService.findAll();

        session.setAttribute("categorylist",categoryList);
        return "category/list";
    }


    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public  String  update(@PathVariable("id") Integer categoryId, HttpServletRequest request){


        Category category=categoryService.findCategoryById(categoryId);

        request.setAttribute("category",category);

        return "category/index";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public  String  update(Category category, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

       //
       int count= categoryService.updateCategory(category);

       if(count>0){
           //修改成功
           return "redirect:/user/category/find";
       }

        return "category/index";
    }

    @RequestMapping(value="update_delete/{id}",method = RequestMethod.GET)
    public String update_delete(@PathVariable("id") Integer categoryId){
        categoryService.deleteCategory(categoryId);
        return "redirect:/user/category/find";
    }
    @RequestMapping(value="update_delete/{id}",method = RequestMethod.POST)
    public String update_deleter(@PathVariable("id") Integer categoryId){
        categoryService.deleteCategory(categoryId);
        return "redirect:/user/category/find";
    }
//增加类别
    /**
     *
     * 添加类别
     * */
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public  String  add(HttpServletResponse response, HttpServletRequest request){

            return "category/add";

    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public  String  add(Category category, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");



            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            category.setCreateTime(new Date());
            category.setUpdateTime(new Date());

            int count= categoryService.addCategory(category);

            if(count>0){
                //修改成功
                return "redirect:/user/category/find";
            }

            return "redirect:/user/category/find";


    }




/*@RequestMapping("categoryinser")
public String update_insert(){


      return "categoryupdate";
}*/


}
