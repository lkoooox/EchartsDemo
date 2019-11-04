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

public class EchartsSortServlet extends HttpServlet {
    EchartService e = new EchartsServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SumSortBeen> sumSortBeens = e.GetSumSort();
        req.setAttribute("SumSortBeens",sumSortBeens);
        for (int i =0;i<sumSortBeens.size();i++){
            System.out.println(sumSortBeens.get(i).getRemark());
            System.out.println(sumSortBeens.get(i).getActivenumsum());
        }
        req.getRequestDispatcher("/SumSortBeenDemo.jsp").forward(req,resp);
    }
}
