<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 12/29/2024
  Time: 4:02 PM
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
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            max-width: 80%;
            margin-left: auto;
            margin-right: auto;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #FAFAD2;
            color: #333;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #007bff;
            font-size: 2rem;
            text-align: center;
            margin-bottom: 20px;
        }

        .btn {
            font-size: 1rem;
            padding: 10px 15px;
            border-radius: 5px;
        }

        .table {
            margin-top: 20px;
            border-collapse: collapse;
            width: 100%;
        }

        .table th,
        .table td {
            text-align: left;
            padding: 12px;
            border: 1px solid black;
        }

        .table thead {
            background-color: #f1f1f1;
        }

        .table tbody tr:hover {
            background-color: #f9f9f9;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            color: white;
        }

        .btn-warning {
            background-color: #ffc107;
            border-color: #ffc107;
            color: white;
        }

        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
            color: white;
        }

        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }

        .btn-warning:hover {
            background-color: #e0a800;
            border-color: #e0a800;
        }

        .btn-danger:hover {
            background-color: #c82333;
            border-color: #c82333;
        }

        button {
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Danh Sách Khách Hàng</h1>
    <button class="btn btn-primary m-4" onclick="window.location.href='/customer?action=create'">Thêm mới</button>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Điện Thoại</th>
            <th>Email</th>
            <th>Lớp</th>
            <th style="text-align: center" colspan="2">Chức năng</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${customer.name}</td>
                <td>${customer.age}</td>
                <td>${customer.phone}</td>
                <td>${customer.email}</td>
                <td>${customer.className}</td>
                <td>
                    <button class="btn btn-warning"
                            onclick="window.location.href='/customer?action=update&id=${customer.id}'">Update
                    </button>
                </td>
                <td>
                    <button class="btn btn-danger"
                            onclick="window.location.href='/customer?action=delete&id=${customer.id}'">Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>