package com.wh.tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcTool {
    public static Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //配置文件导入
        Properties properties =new Properties();
        FileInputStream fis=null;
        try {
            fis=new FileInputStream("D:\\IdeaProjects\\Shop\\jdbc.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        //3、得到连接

        Connection connection= DriverManager.getConnection(url,user,password);

        return  connection;
    }

    public static void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        if(connection!=null){
            connection.close();
        }
        if(preparedStatement!=null){
            preparedStatement.close();
        }
        if(resultSet!=null){
            resultSet.close();
        }
    }
}
