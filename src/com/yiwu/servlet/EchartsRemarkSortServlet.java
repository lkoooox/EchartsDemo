package com.yiwu.servlet;

import com.yiwu.been.RemarkSortBeen;
import com.yiwu.been.SumSortBeen;
import com.yiwu.service.EchartService;
import com.yiwu.service.impl.EchartsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EchartsRemarkSortServlet extends HttpServlet {
    EchartService e = new EchartsServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("select2");
        String[] colCate = {"中医","环保","公安","体育","科技","情感","育儿","风水","股票","军事","娱乐","漫画","房地产"};
        String cate1=null;
        for(int i = 1;i<14;i++){
            if(Integer.parseInt(value)==i){
                cate1=colCate[i-1];
            }
        }
        List<RemarkSortBeen> ReamrkSortBeens = e.GetReamrkSort(cate1);
        req.setAttribute("ReamrkSortBeens",ReamrkSortBeens);
        req.getRequestDispatcher("/ReamrkSortBeenDemo.jsp").forward(req,resp);
    }
}
