<%@ page import="com.yiwu.been.SumSortBeen" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yiwu.been.Top10forBeen" %><%--
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
    List<Top10forBeen> Top10forBeens = (List<Top10forBeen>) request.getAttribute("top10");
    List k = new ArrayList();
    List v = new ArrayList();
    String name = Top10forBeens.get(0).getRemark();
    System.out.println(Top10forBeens.size());
    for (int i=0;i<Top10forBeens.size();i++) {
        System.out.println(Top10forBeens.get(i).toString());
        k.add(Top10forBeens.get(i).getUid());
        v.add(Top10forBeens.get(i).getCommentsCount());
    }
    request.setAttribute("name",name);
    request.setAttribute("k",k);
    request.setAttribute("v",v);
%>
    <div  id ="top10" style="width: 1500px;height: 600px"></div>
<script type="text/javascript">
    var keylist = new Array();
    var valuelist = new Array();
    <c:forEach items="${k}" var="i" varStatus="sort" >
    keylist.push("${i}")
    </c:forEach>
    <c:forEach items="${v}" var="x" varStatus="sort" >
    valuelist.push("${x}")
    </c:forEach>

    var myEcharts = echarts.init(document.getElementById("top10"));
    myEcharts.setOption({
        title: {
            text: '${name}类型top10'
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
