<%--
  Created by IntelliJ IDEA.
  User: Thao
  Date: 1/5/2025
  Time: 7:19 PM
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
        .container {
            margin-top: 200px;
        }
    </style>
</head>
<body>
<div class="container">
    <form method="post">
        <input type="hidden" name="purchaseId" value="${purchase.purchaseId}">
        <div class="form-group">
            <label for="customerId">Chọn Khách Hàng</label>
            <select class="form-control" name="customerId" id="customerId" required>
                <c:forEach var="customer" items="${customers}">
                    <option value="${customer.id}"
                        ${customer.id == purchase.customerId ? 'selected' : ''}>${customer.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="cardId">Chọn Thẻ</label>
            <select class="form-control" name="cardId" id="cardId" required>
                <c:forEach var="gymCard" items="${gymCards}">
                    <option value="${gymCard.cardId}" ${gymCard.cardId == purchase.cardId ? 'selected' : ''}>
                            ${gymCard.cardName}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="purchaseDate">Ngày đăng ký:</label>
            <input type="date" class="form-control" id="purchaseDate" name="purchaseDate" value="${purchase.purchaseDate}" required/>
        </div>
        <div class="form-group">
            <label for="totalPrice">Tổng giá trị:</label>
            <input type="number" class="form-control" id="totalPrice" name="totalPrice" step="0.01" value="${purchase.totalPrice}" required/>
        </div>
        <div class="form-group">
            <label for="validUntil">Ngày hết hạn:</label>
            <input type="date" class="form-control" id="validUntil" name="validUntil" value="${purchase.validUntil}" required/>
        </div>
        <button type="submit">Cập nhật</button>
    </form>
</div>

</body>
</html>