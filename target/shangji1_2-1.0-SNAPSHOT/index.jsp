<!DOCTYPE html>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="util.JDBCTools" %>
<%@ page contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>商品列表</title>
    <style>
        body{
            text-align: center;
            font-family: Arial, sans-serif;
            background-color: #F5F5F5;
        }
        .welcome{
            margin: 50px;
        }
        .welcome h1{
            font-size: 30px;
            color: #666666;
        }
        table{
            margin: 0 auto;
            border-collapse: collapse;
            width: 800px;
            background-color: #FFFFFF;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 25px;
        }
        th, td{
            padding: 10px;
            text-align: center;
            border: 1px solid #CCCCCC;
        }
        th{
            background-color: #F5F5F5;
        }
        .btn{
            text-decoration: none;
            color:#666;
            display: inline-block;
            padding:5px;
            background-color: #DFF0D8;
            font-size:14px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .btn-add{
            width: 120px;
            height: 25px;
            background-color: #b2bbbe;
            color: #fff;
            font-size: 16px;
            font-family: Arial, Helvetica, sans-serif;
            border-radius: 5px;
            box-shadow: 2px 2px 5px #888888;
            position: absolute;
            right: 300px;
        }
        .btn-search{
            width: 120px;
            height:25px;
            background-color: #b2bbbe;
            color: #fff;
            font-size: 16px;
            font-family: Arial, Helvetica, sans-serif;
            border-radius: 5px;
            box-shadow: 2px 2px 5px #888888;
            position: absolute;
            right: 430px;
        }
        .btn:hover {
            background-color: #2775b6;
            cursor: pointer;
        }
        .btn:active {
            background-color: #93b5cf;
        }
        .btn:hover{
            background-color: #B3E5FC;
        }
        .box h3{
            float:left;
            margin: 0;
            font-size: 20px;
            color: #666666;
        }
        .box a{
            float: right;
            margin: 0 0 0 20px;
            padding: 10px 20px;
            background-color: #2196F3;
            color: #FFFFFF;
            font-size: 14px;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        .box a:hover{
            background-color: #1976D2;
        }
    </style>
</head>
<body>
<div class="welcome">
    <h1>欢迎来到商品管理系统</h1>
</div>
<div>
    <h3>商品列表信息</h3>
</div>
<table>
    <tr>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品重量</th>
        <th>操作</th>
    </tr>
    <%
        JDBCTools ct=new JDBCTools();
        ResultSet rs=ct.getDataFromDatabase();
        while(true){
            try{
                if(!rs.next())break;
            }catch(Exception e){
                e.printStackTrace();
            }
            String id;
            id = rs.getString("id");
    %>
    <tr>
        <td><%=id%></td>
        <td><%=rs.getString("goodsName")%></td>
        <td><%=rs.getString("goodsPrice")%></td>
        <td><%=rs.getString("goodsWeight")%></td>
        <td>
            <a class="btn btn-delete" href="update.jsp">修改</a>
            <a class="btn btn-delete" href="goods?method=delete&id">删除</a>
        </td>
    </tr>
    <%
        } %>
</table>
<br/>
<div>
<a class="btn btn-add" href="add.jsp">新增商品</a>
<a class="btn btn-search" href="search.jsp">查询商品</a>
</div>
</body>
</html>