<%@ page import="com.yiwu.been.SumSortBeen" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lkoooox
  Date: 2019/11/4
  Time: 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <script type="text/javascript" src="js/echarts.min.js"></script>
    <title>Title</title>

</head>
<body>
<%
    List<SumSortBeen> sumSortBeens = (List<SumSortBeen>) request.getAttribute("SumSortBeens");
    List k = new ArrayList();
    List v = new ArrayList();
    for (int i=0;i<sumSortBeens.size();i++) {
        k.add(sumSortBeens.get(i).getRemark());
        v.add(sumSortBeens.get(i).getActivenumsum());
    }
    request.setAttribute("k",k);
    request.setAttribute("v",v);
%>
        <div  id ="activeSum" style="width: 900px;height: 700px"></div>
        <script type="text/javascript">
            var keylist = new Array();
            var valuelist = new Array();
            <c:forEach items="${k}" var="i" varStatus="sort" >
                keylist.push("${i}")
            </c:forEach>
            <c:forEach items="${v}" var="x" varStatus="sort" >
                valuelist.push("${x}")
            </c:forEach>

            var myEcharts = echarts.init(document.getElementById("activeSum"));
            myEcharts.setOption({
                title: {
                    text: '各类型活跃度排行'
                },
                tooltip: {},
                legend: {
                    data:['活跃度']
                },
                xAxis: {
                    data: keylist
                },

                yAxis: {},
                series: [{
                    name: '活跃度',
                    type: 'bar',
                    data: valuelist
                }]
            });

        </script>
</body>
</html>
