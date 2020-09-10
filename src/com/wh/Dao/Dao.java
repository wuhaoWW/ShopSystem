package com.wh.Dao;
import com.wh.entity.Check;
import com.wh.entity.PageBean;
import com.wh.entity.Provider;
import com.wh.entity.User;
import  com.wh.tool.jdbcTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    /***登录（返回boolean）
     * @return***/
    public User loginDao(String username, String password) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcTool.connection();
        String sql="SELECT * from `user` where name=? and pwd =?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,password);

        ResultSet resultSet = ps.executeQuery();
        User user=null;
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name1 = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            long tel = resultSet.getLong("tel");
            String address = resultSet.getString("address");
            String role = resultSet.getString("role");
            user=new User(id,name1,sex,age,tel,address,role);
        }

        jdbcTool.closeAll(connection,ps,resultSet);
        return  user;
    }

    /***查询商品列表
     * @return***/
    public List<Check> Bill_List_Dao(String name, String paymoney) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcTool.connection();
        String sql="select * from check_table where name like ? and paymoney like ?;  ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,"%"+name+"%");
        ps.setString(2,"%"+paymoney+"%");

        ResultSet resultSet = ps.executeQuery();
        List<Check> list =new ArrayList<>();
        while (resultSet.next()){
            int id = Integer.parseInt(resultSet.getString("id"));
            String name1 = resultSet.getString("name");
            int number = resultSet.getInt("number");
            double money = Double.parseDouble(resultSet.getString("money"));
            String paymoney1 = resultSet.getString("paymoney");
            String supname = resultSet.getString("supname");
            String notice = resultSet.getString("notice");
            String date = resultSet.getString("date");
            Check check=new Check(id,name1,number,money,paymoney1,supname,notice,date);

            list.add(check);
        }
        jdbcTool.closeAll(connection,ps,resultSet);
        return list;
    }

    /***查询用户列表
     * @return***/
    public List<User> UserDao(String name, PageBean pageBean) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcTool.connection();
        String sql="select * from user where name like ? limit ?,?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,"%"+name+"%");
        ps.setInt(2,pageBean.getSelectXiaBiao());
        ps.setInt(3,pageBean.getPageSize());
        ResultSet resultSet = ps.executeQuery();
        List<User> list=new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name1 = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            long tel = resultSet.getLong("tel");
            String address = resultSet.getString("address");
            String role = resultSet.getString("role");
            User user=new User(id,name1,sex,age,tel,address,role);
            list.add(user);
        }
        jdbcTool.closeAll(connection,ps,resultSet);
        return  list;
    }
    /***查询用户信息总记录数
     * @return***/
    public int SelectUserCountDao(String name) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcTool.connection();
        String sql1="select count(*)  as 总记录数 from user where name like ?";
        PreparedStatement ps1 = connection.prepareStatement(sql1);
        ps1.setString(1,"%"+name+"%");
        ResultSet resultSet1 = ps1.executeQuery();
        int total=0;
        if (resultSet1.next()){
            total= resultSet1.getInt("总记录数");
        }
        jdbcTool.closeAll(connection,ps1,resultSet1);
        return total;
    }
    /****新增用户信息
     * @return***/
    public int AddUserDao(User user) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcTool.connection();
        String sql="INSERT INTO `USER`(id,name,sex,age,tel,address,role,pwd) VALUES(null ,?,?,?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,user.getName());
        ps.setString(2,user.getSex());
        ps.setInt(3,user.getAge());
        ps.setLong(4,user.getTel());
        ps.setString(5,user.getAddress());
        ps.setString(6,user.getRole());
        ps.setString(7,user.getPwd());

        int i = ps.executeUpdate();
        return i;


    }

    /***新增商品信息
     * @return**/
    public int AddCheckDao(Check check) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcTool.connection();
        String sql="insert into check_table(id,name,number,money,paymoney,supname,notice,date) values(null,?,?,?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,check.getName());
        ps.setLong(2,check.getNumber());
        ps.setDouble(3,check.getMoney());
        ps.setString(4,check.getPaymoney());
        ps.setString(5,check.getSupname());
        ps.setString(6,check.getNotice());
        ps.setString(7,check.getDate());

        int i = ps.executeUpdate();
        jdbcTool.closeAll(connection,ps,null );
        return i;

    }

    /****查询供货商信息
     * @return**/
    public List<Provider> SupLIstDao(String providerName, String providerDesc) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcTool.connection();
        String sql="select * from provider where supname like ? and supnotice like ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,"%"+providerName+"%");
        ps.setString(2,"%"+providerDesc+"%");

        ResultSet resultSet = ps.executeQuery();
        List<Provider> list =new ArrayList<>();
         while (resultSet.next()){
            int id = resultSet.getInt("id");
            String supname = resultSet.getString("supname");
            String supnotice = resultSet.getString("supnotice");
            String name = resultSet.getString("name");
            long suptel = resultSet.getLong("suptel");
            String supaddress = resultSet.getString("supaddress");
            Provider provider =new Provider(id,supname,supnotice,name,suptel,supaddress);

            list.add(provider);
        }
        jdbcTool.closeAll(connection,ps,resultSet);
         return list;
    }

    /***新增供货商信息
     * @return**/
    public int AddSupDao(Provider provider) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcTool.connection();
        String sql="insert into Provider(id,supname,supnotice,name,suptel,supaddress) values(null,?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,provider.getSupname());
        ps.setString(2,provider.getSupnotice());
        ps.setString(3,provider.getName());
        ps.setLong(4,provider.getSuptel());
        ps.setString(5,provider.getSupaddress());

        int i = ps.executeUpdate();
        jdbcTool.closeAll(connection,ps,null);
        return  i;
    }

    /**删除用户信息
     * @return****/
    public int deleteUserDao(int id) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcTool.connection();
        String sql="delete from user where  id = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);

        int i = ps.executeUpdate();
        jdbcTool.closeAll(connection,ps,null);
        return i;
    }

    /****通过修改用户信息
     * @return***/
    public int UpdateUserDao(User user) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcTool.connection();
        String sql="update user set name=? , sex=? , age =? , tel = ? , address=? , role =? where id =?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,user.getName());
        ps.setString(2,user.getSex());
        ps.setString(3, String.valueOf(user.getAge()));
        ps.setString(4, String.valueOf(user.getTel()));
        ps.setString(5,user.getAddress());
        ps.setString(6,user.getRole());
        ps.setString(7, String.valueOf(user.getId()));
        int i = ps.executeUpdate();

        jdbcTool.closeAll(connection,ps,null);
        return i;
    }

    /***通过id查询用户信息
     * @return**/
    public User selectUserByIdDao(int id) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcTool.connection();
        String sql="select * from user where id= ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        User user =null;
        while (resultSet.next()) {
            int id1 = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            long tel = resultSet.getLong("tel");
            String address = resultSet.getString("address");
            String role = resultSet.getString("role");
            user = new User(id1, name, sex, age, tel, address, role);
            System.out.println(user.toString());
        }
        jdbcTool.closeAll(connection,ps,resultSet);
        return user;
    }


    //
}
