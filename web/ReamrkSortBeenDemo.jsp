<%@ page import="com.yiwu.been.SumSortBeen" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yiwu.been.Top10forBeen" %>
<%@ page import="com.yiwu.been.RemarkSortBeen" %><%--
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
    List<RemarkSortBeen> RemarkSortBeens = (List<RemarkSortBeen>) request.getAttribute("ReamrkSortBeens");
    List k = new ArrayList();
    List v = new ArrayList();
    String name = RemarkSortBeens.get(0).getRemark();
    System.out.println(RemarkSortBeens.size());
    for (int i=0;i<RemarkSortBeens.size();i++) {
        System.out.println(RemarkSortBeens.get(i).toString());
        k.add(RemarkSortBeens.get(i).getUid());
        v.add(RemarkSortBeens.get(i).getActivenum());
    }
    request.setAttribute("name",name);
    request.setAttribute("k",k);
    request.setAttribute("v",v);
%>
<div  id ="remarksort" style="width: 1500px;height: 600px"></div>
<script type="text/javascript">
    var keylist = new Array();
    var valuelist = new Array();
    <c:forEach items="${k}" var="i" varStatus="sort" >
    keylist.push("${i}")
    </c:forEach>
    <c:forEach items="${v}" var="x" varStatus="sort" >
    valuelist.push("${x}")
    </c:forEach>

    var myEcharts = echarts.init(document.getElementById("remarksort"));
    myEcharts.setOption({
        title: {
            text: '${name}类型评论回复量排行'
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
