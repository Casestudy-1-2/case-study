<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 1/3/2025
  Time: 10:37 AM
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
      margin-top: 200px;
    }
  </style>
</head>
<body>
<div class="container">
  <form method="post">
    <input type="hidden" name="id" value="${trainer.id}">
    <div class="form-group">
      <label for="updatedName">Tên:</label>
      <input type="text" class="form-control" id="updatedName" name="updatedName" value="${trainer.name}">
    </div>
    <div class="form-group">
      <label for="updatedSpecialization">Chuyên môn:</label>
      <input type="text" class="form-control" id="updatedSpecialization" name="updatedSpecialization" value="${trainer.specialization}">
    </div>
    <div class="form-group">
      <label for="updatedPhone">Phone:</label>
      <input type="text" class="form-control" id="updatedPhone" name="updatedPhone" value="${trainer.phone}">
    </div>
    <div class="form-group">
      <label for="updatedClassId">Class:</label>
      <select class="form-control" id="updatedClassId" name="updatedClassId">
        <c:forEach var="gymClass" items="${gymClasses}">
          <option value="${gymClass.classId}"
            ${gymClass.classId == trainer.idClass ? 'selected' : ''}>
              ${gymClass.className}
          </option>
        </c:forEach>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Cập nhật</button>
  </form>
</div>
</body>
</html>
