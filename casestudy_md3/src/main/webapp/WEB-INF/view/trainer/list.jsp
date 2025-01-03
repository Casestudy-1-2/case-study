
<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 1/2/2025
  Time: 8:32 PM
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

        .table th{
            text-align: center;
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
    <h1>Danh Sách Huấn Luyện Viên</h1>
    <button class="btn btn-primary m-4" onclick="window.location.href='/trainer?action=create'">Thêm mới</button>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Chuyên môn</th>
            <th>Điện thoại</th>
            <th>Lớp</th>
            <th style="text-align: center" colspan="2">Chức năng</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="trainer" items="${trainers}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${trainer.name}</td>
                <td>${trainer.specialization}</td>
                <td>${trainer.phone}</td>
                <td>${trainer.className}</td>
                <td>
                    <button class="btn btn-warning"
                            onclick="window.location.href='/trainer?action=update&id=${trainer.id}'">Cập nhật
                    </button>
                </td>
                <td>
                    <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modalDelete${trainer.id}">
                        Xóa
                    </button>
                </td>
                <div class="modal fade" id="modalDelete${trainer.id}" tabindex="-1"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Xóa Huấn Luyên Viên</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <p>Bạn có chắc muốn xóa huấn luyên viên có tên là ${trainer.name} và id là ${trainer.id}?</p>
                                <small style="color: red; font-style: italic">Lưu ý hành động này không thể hoàn
                                    tác!</small>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                                <button type="button" class="btn btn-danger"
                                        onclick="window.location.href='/trainer?action=delete&id=${trainer.id}'">Xác
                                    nhận
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${message != null}">
        <div class="alert alert-success" role="alert" id="message">
                ${message}
        </div>
    </c:if>
</div>
</body>
<script>
    setTimeout(function () {
        document.getElementById("message").remove();
    },3000)
</script>
</html>
