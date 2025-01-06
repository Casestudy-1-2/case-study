<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 1/4/2025
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/utils/bootstrap.jsp" %>
<html>
<head>
    <title>Title</title>
    <style>
        body, h2, form {
            margin: 0;
            padding: 0;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            color: #555;
            text-align: left;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="checkbox"] {
            margin-left: 10px;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #45a049;
        }

        .error-message {
            color: red;
            margin-top: 10px;
            font-size: 14px;
        }
    </style>
</head>
<body>
<h2>Đăng nhập</h2>
<form action="login" method="post">
    <label for="username">Tên người dùng:</label>
    <input type="text" id="username" name="username" value="${param.username}" required><br><br>

    <label for="password">Mật khẩu:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="remember">Ghi nhớ đăng nhập</label>
    <input type="checkbox" id="remember" name="remember" <%-- Thêm kiểm tra nếu có cookie --%> ${not empty param.username ? 'checked' : ''}><br><br>

    <button type="submit">Đăng nhập</button>
</form>

<!-- Hiển thị thông báo lỗi nếu có -->
<c:if test="${not empty errorMessage}">
    <div style="color: red; font-size: 16px; margin-top: 15px;">${errorMessage}</div>
</c:if>

</body>
</html>
