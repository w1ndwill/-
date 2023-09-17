<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>查询页面</title>
    <style>
        body{
            text-align: center;
            font-family: Arial, sans-serif;
            background-color: #F5F5F5;
        }
        .btn{
            width: 120px;
            height: 25px;
            background-color: #b2bbbe;
            color: #fff;
            font-size: 16px;
            font-family: Arial, Helvetica, sans-serif;
            border-radius: 5px;
            box-shadow: 2px 2px 5px #888888;
        }
        .btn1{
            width: 120px;
            height: 25px;
            background-color: #b2bbbe;
            color: #fff;
            font-size: 16px;
            font-family: Arial, Helvetica, sans-serif;
            border-radius: 5px;
            box-shadow: 2px 2px 5px #888888;
        }
        table{
            margin: 0 auto;
            border-collapse: collapse;
            width: 800px;
            background-color: #FFFFFF;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 25px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
        }
        th {
            background-color: #DFF0D8;
        }
        td {
            background-color: #F2F2F2;
        }
        input[type="text"] {
            border: none;
            border-bottom: 2px solid #ccc;
            padding: 5px;
            font-size: 16px;
            outline: none;
            background-color: #F2F2F2;
            color: #666;
            transition: all 0.3s ease-in-out;
            border-radius: 20px;
        }

        input[type="text"]:focus {
            border-bottom: 2px solid #5cb85c;
            background-color: #fff;
            color: #333;
        }
    </style>
</head>
<body>
<form action="goods" method="post">
    <h3>查询页面</h3>
    <p>请输入商品id：<input type="text" name="id"/><br/></p>
    <input type="hidden" name="method" value="findById"/>
    <input class="btn" type="submit" value="查询">
    <br/>
    <br/>
    <table>
        <tr>
            <th>商品序号</th>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>商品重量</th>
        </tr>
        <tr>
            <td>${goods.id}</td>
            <td>${goods.goodsName}</td>
            <td>${goods.goodsPrice}</td>
            <td>${goods.goodsWeight}</td>
        </tr>
    </table>
    <br/>
    <br/>
    <a href="index.jsp" class="btn1">返回</a>
</form>
</body>
</html>
