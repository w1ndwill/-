<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>新增商品</title>
    <style>
        body{
            text-align: center;
            font-family: Arial, sans-serif;
            background-color: #F5F5F5;
        }
        .btn-show{
            text-decoration: none;
            color:#666;
            display: inline-block;
            padding:10px;
            background-color: #DFF0D8;
            border-radius:5px;
            font-size:14px;
        }
        .btn-submit{
            border:none;
            padding:10px;
            border-radius:5px;
            width: 60px;
            background-color: #DFF0D8;
            color:#666;
        }
        .btn-show:hover{
            background-color: #DFF0E8;
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
    <h3>新增商品</h3>
    <p>
        商品编号：<input type="text" name="id" required="required"  autocomplete="off">
    </p>
    <p>
        商品名称：<input type="text" name="goodsName" required="required" autocomplete="off">
    </p>
    <p>
        商品价格：<input type="text" name="goodsPrice" required="required" autocomplete="off" >
    </p>
    <p>
        商品重量：<input type="text" name="goodsWeight" required="required" autocomplete="off">
    </p>
    <input type="hidden" name="method" value="add"/>
    <input class="btn-submit" type="submit" value="提交">&emsp;
    <a class="btn-show" href="index.jsp">查看商品信息</a>
</form>
</body>
</html>