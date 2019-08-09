package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
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
@RequestMapping("/user/product/")
public class ProductController {
    @Autowired
    IProductService productService;



    @RequestMapping("find")
   public  String  findAll(HttpSession session, HttpServletRequest request, HttpServletResponse response){



            /**
             * 实现查找所有类别
             * */
            List<Product> productList=productService.findAll();

            session.setAttribute("productlist",productList);
            return "product/list";


    }

    /**
     *
     * 更新类别
     *
     **/
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public  String  update(@PathVariable("id") Integer id,HttpServletResponse response, HttpServletRequest request){


            Product product=productService.findCategoryById(id);

            request.setAttribute("product",product);

            return "product/update";
        }


    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public  String  update(@PathVariable("id") Integer id,Product product, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //System.out.println("1111111111");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        product.setMainImage("zanwu");
        product.setSubImages("zanwu");
       // System.out.println("22222222222");
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        product.setId(id);
            int count= productService.updateProduct(product);
        //System.out.println("3333333333333");
            if(count>0){
                //修改成功
                System.out.println("修改成功");
                return "redirect:/user/product/find";
            }
            System.out.println("没有修改成功");
            return "product/update";


    }

    /***
     *
     * 删除类别
     *
     * */
    @RequestMapping(value = "delete/{id}",method=RequestMethod.GET)
    public  String  delete(@PathVariable("id") Integer id, HttpServletResponse response, HttpServletRequest request){


            int count= productService.deleteProduct(id);
            return "redirect:/user/product/find";

    }


    @RequestMapping(value = "delete/{id}",method=RequestMethod.POST)
    public  String  delete(Product product, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");



            int count= productService.deleteProduct(product.getId());

            if(count>0){
                //修改成功
                return "redirect:/user/product/find";
            }


        return "redirect:/user/product/find";
    }
    /**
     *
     * 添加类别
     * */
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public  String  add(HttpServletResponse response, HttpServletRequest request){


            return "product/add";


    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public  String  add(Product product, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
          System.out.println("===============进入ADD POST===============");


            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            product.setCreateTime(new Date());
            product.setUpdateTime(new Date());
           // System.out.println(product.toString());
            int count= productService.addProduct(product);

            if(count>0){
                //修改成功
                System.out.println("修改成功！");
                return "redirect:/user/product/find";

            }

            return "redirect:/user/product/add";
        }






}
