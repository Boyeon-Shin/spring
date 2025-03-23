<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Member List</title>
</head>
<body>
<a href="/index.html">메인</a>
<h2>Member List</h2>
<table border="1">
  <thead>
  <tr>
    <th>id</th>
    <th>username</th>
    <th>age</th>
  </tr>
  </thead>
  <tbody>
  <!-- c:forEach로 members 리스트 반복 -->
  <c:forEach var="item" items="${members}">
    <tr>
      <td>${item.id}</td>
      <td>${item.username}</td>
      <td>${item.age}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>