package com.yiwu.servlet;

import com.yiwu.been.Top10forBeen;
import com.yiwu.service.EchartService;
import com.yiwu.service.impl.EchartsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EchartsTop10Servlet extends HttpServlet {
    EchartService e = new EchartsServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("sel");
        String[] columnCate = {"中医","环保","公安","体育","科技","情感","育儿","风水","股票","军事","娱乐","漫画","房地产"};
        String cate=null;
        for(int i = 1;i<14;i++){
            if(Integer.parseInt(value)==i){
                cate=columnCate[i-1];
            }
        }
        if(cate!=null){
            System.out.println(cate);
        }else {
            throw new ClassCastException();
        }
        List<Top10forBeen> top10forBeens = e.GetTop10(cate);
        req.setAttribute("top10",top10forBeens);
        req.getRequestDispatcher("/top10Demo.jsp").forward(req,resp);
    }
}
