package util;

import java.sql.*;

public class JDBCTools {
    private static Connection connection;
    private static String url="jdbc:mysql://localhost:3306/goods";
    private static String user="root";//用户名
    private static String pass="Gao200310";//密码

    public ResultSet getDataFromDatabase() {
        Connection connection;
        Statement stmt;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from goods");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static Connection getConnection(){
        try {
            connection= DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (connection!=null) {
                connection.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

