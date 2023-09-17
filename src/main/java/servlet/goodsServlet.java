package servlet;

import goods.Goods;
import Dao.GoodsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/goods")
public class goodsServlet extends HttpServlet {
    //调用goodsRepository中的增删改查方法
    private GoodsRepository goodsRepository=new GoodsRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断前端传来的标记，以此执行相对应的增删改查操作
        String method=req.getParameter("method");
        if (method==null){
            method="findAll";
        }
        switch (method){
            case "findAll"://查询所有数据
                List<Goods> list = goodsRepository.findAll();//调用goodsRepository中的findAll()方法
                req.setAttribute("list",list);//存入request中
                req.getRequestDispatcher("index.jsp").forward(req,resp);//转发到index.jsp中
            case "delete"://删除操作
                String idStr=req.getParameter("id");
                Integer id=Integer.parseInt(idStr);
                goodsRepository.deleteById(id);//根据id删除
                resp.sendRedirect("/goods");
                break;
            case "findById":
                idStr=req.getParameter("id");
                id=Integer.parseInt(idStr);
                req.setAttribute("goods",goodsRepository.findById(id));
                req.getRequestDispatcher("search.jsp").forward(req,resp); //转发到search.jsp中
                break;
            case "add":
                req.getRequestDispatcher("add.jsp").forward(req,resp);
                break;
            case "update":
                req.getRequestDispatcher("update.jsp").forward(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method=req.getParameter("method");
        switch (method){
            case "add"://添加操作
                //获取前端传来的数据
                String idStr=req.getParameter("id");
                String goodsName=req.getParameter("goodsName");
                String goodsPriceStr=req.getParameter("goodsPrice");
                String goodsColor=req.getParameter("goodsColor");
                String goodsWeightStr=req.getParameter("goodsWeight");
                int id=Integer.parseInt(idStr);
                double goodsPrice=Integer.parseInt(goodsPriceStr);
                double goodsWeight=Integer.parseInt(goodsWeightStr);
                goodsRepository.add(id, goodsName, goodsPrice, goodsColor, goodsWeight);//调用add方法
                break;
            case "update"://更新操作
                idStr=req.getParameter("id");
                goodsName=req.getParameter("goodsName");
                goodsPriceStr=req.getParameter("goodsPrice");
                goodsWeightStr=req.getParameter("goodsWeight");
                id=Integer.parseInt(idStr);
                goodsPrice=Integer.parseInt(goodsPriceStr);
                goodsWeight=Integer.parseInt(goodsWeightStr);
                goodsRepository.update(id, goodsName, goodsPrice, goodsWeight);//调用update方法
                break;
            case "delete"://删除操作
                idStr=req.getParameter("id");
                id=Integer.parseInt(idStr);
                goodsRepository.deleteById(id);//调用deleteById方法
                break;
            case "findById"://查询操作
                idStr=req.getParameter("id");
                id=Integer.parseInt(idStr);
                req.setAttribute("goods",goodsRepository.findById(id));//调用findById方法
                req.getRequestDispatcher("search.jsp").forward(req,resp); //转发到update.jsp页面
                break;
        }
        resp.sendRedirect("index.jsp");//重定向到index.jsp页面
    }
}
