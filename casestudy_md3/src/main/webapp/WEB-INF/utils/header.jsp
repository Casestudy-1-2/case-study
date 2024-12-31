<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 12/28/2024
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .header {
            background-color: #303030;
            padding: 8px;
            text-align: center;
            width: 98.4%;
            position: fixed;
            top: 0;
        }
        .nav-link {
            color: white;
        }

        .navbar-nav .nav-link:hover {
            color: black;
            background-color: yellow;
        }
    </style>
</head>
<body>
<header class="header">
    <nav style=" background-color: #303030;" class="navbar navbar-expand-lg bg-body-tertiary">
        <div style="background-color: #303030;" class="container-fluid">
            <a style="color: white" class="navbar-brand" href="#">Trang chủ</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/customer">Khách hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Huấn luyện viên</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            Dropdown
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                </ul>
<%--                <form class="d-flex" role="search">--%>
<%--                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--                    <button class="btn btn-outline-success" type="submit">Search</button>--%>
<%--                </form>--%>
            </div>
        </div>
    </nav>
</header>
</body>
</html>
