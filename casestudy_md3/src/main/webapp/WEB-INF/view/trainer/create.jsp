<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 1/2/2025
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/utils/bootstrap.jsp" %>
<%@include file="/WEB-INF/utils/header.jsp" %>
<html>
<head>
    <title>Title</title>
    <style>
        .container{
            margin-top: 150px;
        }
    </style>
</head>
<body>
<div class="container">
    <form method="post" action="/trainer">
        <input type="hidden" class="form-control" id="action" name="action" value="create">
        <div class="mb-3">
            <label for="name" class="form-label">Tên: </label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="specialization" class="form-label">Chuyên môn: </label>
            <input type="text" class="form-control" id="specialization" name="specialization">
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Điện thoại </label>
            <input type="text" class="form-control" id="phone" name="phone">
        </div>
        <div class="mb-3">
            <label for="className" class="form-label">Tên lớp: </label>
            <select id="className" name="idClass" class="form-control">
                <option value="">------Chọn lớp-------</option>
                <c:forEach items="${gymClasses}" var="gymClass">
                    <option value="${gymClass.classId}">${gymClass.className}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Thêm mới</button>
    </form>
</div>
</body>
</html>
