<%--
  Created by IntelliJ IDEA.
  User: lkoooox
  Date: 2019/11/3
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="sumsort" method="post">
    <input type="submit" value="查看各类型活跃度排名">
  </form>
  <form action="top10" method="post">
    <select  id="select" name="sel" style="width: 100px;height: 30px">
      <option value="1" selected>中医</option>
      <option value="2">环保</option>
      <option value="3">公安</option>
      <option value="4">体育</option>
      <option value="5">科技</option>
      <option value="6">情感</option>
      <option value="7">育儿</option>
      <option value="8">风水</option>
      <option value="9">股票</option>
      <option value="10">军事</option>
      <option value="11">娱乐</option>
      <option value="12">漫画</option>
      <option value="13">房地产</option>
    </select>
    <input type="submit" value="查看该类型评论量top10">
  </form>
  <form action="sort" method="post">
    <select name="select2" style="width: 100px;height: 30px">
      <option value="1" selected>中医</option>
      <option value="2">环保</option>
      <option value="3">公安</option>
      <option value="4">体育</option>
      <option value="5">科技</option>
      <option value="6">情感</option>
      <option value="7">育儿</option>
      <option value="8">风水</option>
      <option value="9">股票</option>
      <option value="10">军事</option>
      <option value="11">娱乐</option>
      <option value="12">漫画</option>
      <option value="13">房地产</option>
    </select>
    <input type="submit" value="查看各类型活跃度排名">
  </form>
  </body>
</html>
