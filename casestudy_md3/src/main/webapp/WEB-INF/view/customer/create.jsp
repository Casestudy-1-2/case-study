<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 12/29/2024
  Time: 11:32 PM
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
            margin-top: 135px;
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 600px;
        }

        body {
            background-color: #FFFACD;
            font-family: Arial, sans-serif;
            padding: 0;
            margin: 0;
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #007bff;
        }

        .form-group label {
            font-size: 1.1rem;
            color: #495057;
        }

        .form-control {
            border-radius: 5px;
            box-shadow: none;
            border: 1px solid #ced4da;
            font-size: 1rem;
            padding: 10px;
        }

        .form-control:focus {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        .btn {
            width: 100%;
            padding: 12px;
            font-size: 1.1rem;
            border-radius: 5px;
            background-color: #007bff;
            border: none;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        .mb-3 {
            margin-bottom: 1.5rem;
        }

        select.form-control {
            padding: 10px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        option {
            font-size: 1rem;
        }

    </style>
</head>
<body>
<div class="container">
    <form method="post" action="/customer">
        <input type="hidden" class="form-control" id="action" name="action" value="create">
        <div class="form-group">
            <label for="name">Tên:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="age">Tuổi:</label>
            <input type="number" class="form-control" id="age" name="age">
        </div>
        <div class="form-group">
            <label for="phone">Số điện thoại:</label>
            <input type="text" class="form-control" id="phone" name="phone">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" id="email" name="email">
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
