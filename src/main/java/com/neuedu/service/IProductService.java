package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    /**
     * 添加类别
     * */
    public int addProduct(Product product) throws MyException;
    /**
     * 删除类别
     * */
    public int deleteProduct(int productId) throws MyException;
    /**
     * 修改类别
     * */
    public int updateProduct(Product product) throws MyException;
    /**
     * 查询类别
     * */
    public List<Product> findAll() throws MyException;


    /**
     * 根据类别id查询类别信息
     * */

    public Product findCategoryById(int productId);
}
