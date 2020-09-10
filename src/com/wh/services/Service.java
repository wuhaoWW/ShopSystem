package com.wh.services;

import com.wh.Dao.Dao;
import com.wh.entity.Check;
import com.wh.entity.PageBean;
import com.wh.entity.Provider;
import com.wh.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    /***登录的业务逻辑方法
     * @return***/
    public User loginservice(String username, String password){
        Dao dao=new Dao();
        User user=null;
        try {
             user = dao.loginDao(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;

    }

    /****查询用户的业务逻辑方法
     * @return**/
    public List<User> UserService(String name, PageBean pageBean){
        Dao dao=new Dao();
        List<User> list=new ArrayList<>();
        try {
            list = dao.UserDao(name,pageBean);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
    /****查询用户总数的业务逻辑方法
     * @return**/
    public int UserCountService(String name){
        Dao dao =new Dao();
        int i = 0;
        try {
            i = dao.SelectUserCountDao(name);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return i;
    }
    /***新增用户的业务逻辑方法
     * @return**/
    public boolean AddUserService(User user){
        Dao dao =new Dao();
        int i = 0;
        try {
            i = dao.AddUserDao(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (i != 0){
            return true;
        }else
        {
            return false;
        }


    }

    /**查询商品的业务逻辑方法
     * @return**/
    public List<Check> checkService(String name, String paymoney){
        Dao dao =new Dao();
        List<Check> checks=new ArrayList<>();
        try {
             checks= dao.Bill_List_Dao(name, paymoney);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return checks;
    }

    /***新增商品的业务逻辑方法
     * @return**/
    public int AddCheckService(Check check){
        Dao dao =new Dao();
        int i = 0;
        try {
           i = dao.AddCheckDao(check);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return i;
    }

    /***查询供货商的业务逻辑方法
     * @return**/
    public List<Provider> SupSelService(String providerName , String providerDesc ){
        Dao dao=new Dao();
        List<Provider> providers = null;
        try {
            providers = dao.SupLIstDao(providerName, providerDesc);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return providers;
    }

    /***新增供货商的业务逻辑方法
     * @return***/
    public int AddSupService(Provider provider){
        Dao dao=new Dao();
        int i=0;
        try {
            i = dao.AddSupDao(provider);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return i;
    }

    /***删除用户的业务逻辑方法
     * @return***/
    public boolean DeleteUserService(int id ){
        Dao dao=new Dao();
        int i=0;
        try {
            i = dao.deleteUserDao(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(i ==1){
            return true;
        }else {
            return false;
        }
    }

    /******通过Id查询用户信息的业务逻辑方法
     * @return***/
    public User SelectUserByIdService(int id) throws SQLException, ClassNotFoundException {
                    Dao dao=new Dao();
        User user = dao.selectUserByIdDao(id);
        return user;

    }

    /***修改用户信息的业务逻辑方法
     * @return***/
    public int UpDateService(User user){
        Dao dao=new Dao();
        int i = 0;
        try {
            i = dao.UpdateUserDao(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return i;
    }
}
