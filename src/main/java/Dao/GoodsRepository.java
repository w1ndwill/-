package Dao;

import goods.Goods;
import util.JDBCTools;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsRepository {
    public List<Goods> findAll(){
        List<Goods> list=new ArrayList<>();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            //调用JDBCTools连接mysql数据库
            connection= JDBCTools.getConnection();
            String sql="select * from goods";//查询语句
            preparedStatement=connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //从resultSet拿出每个属性数据
                int id=resultSet.getInt(1);
                String goodsName=resultSet.getString(2);
                double goodsPrice=resultSet.getInt(3);
                double goodsWeight=resultSet.getInt(5);
                //这里可以理解为，resultSet拿出每个属性数据赋予student对象，形成一个有数据的student对象
                Goods goods = new Goods(id, goodsName, goodsPrice, goodsWeight);
                list.add(goods);//可能多条数据，放到集合中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //调用JDBCTools，关闭connection，preparedStatement，resultSet
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }
    //添加操作
    public void add(int id,String goodsName,double goodsPrice,
                     String goodsColor,double goodsWeight){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection= JDBCTools.getConnection();
            String sql="insert into goods(id,goodsName,goodsPrice,goodsWeight) values (?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            //这里注意第一个参数对应sql语句问号的序号，
            preparedStatement.setInt(1,id);//就是把id替代sql的第一个问号，id由前端传过来
            preparedStatement.setString(2,goodsName);
            preparedStatement.setDouble(3,goodsPrice);
            preparedStatement.setDouble(4,goodsWeight);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }

    //删除操作
    public void deleteById(int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection= JDBCTools.getConnection();
            String sql="delete from goods where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }

    //根据id查询
    public Goods findById(int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Goods goods=null;
        try {
            connection= JDBCTools.getConnection();
            String sql="select * from goods where id=?";
            preparedStatement=connection.prepareStatement(sql); //预编译
            preparedStatement.setInt(1,id); //设置参数
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id2=resultSet.getInt(1);
                String goodsName=resultSet.getString(2);
                double goodsPrice=resultSet.getInt(3);
                double goodsWeight=resultSet.getInt(4);
                goods = new Goods(id2, goodsName, goodsPrice,goodsWeight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return goods;
    }

    //更新操作
    public void update(int id,String goodsName,double goodsPrice, double goodsWeight){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection= JDBCTools.getConnection();
            String sql="update goods set goodsName=?,goodsPrice=?,goodsWeight=? where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,goodsName);
            preparedStatement.setDouble(2,goodsPrice);
            preparedStatement.setDouble(3,goodsWeight);
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }
}

//123
//dlh454612

//gx