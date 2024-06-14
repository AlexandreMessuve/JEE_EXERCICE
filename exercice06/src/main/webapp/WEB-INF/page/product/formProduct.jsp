<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: alexandremessuve
  Date: 12/06/2024
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<jsp:useBean id="product" type="org.exercice06.entity.Product" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String title = mode.substring(0,1).toUpperCase() + mode.substring(1).toLowerCase();
    boolean isUpdate = mode.equals("update") && product != null;
%>
<html>
<head>
    <title><%=title%> a product
    </title>
    <%@include file="/WEB-INF/bootstrap.html"%>
</head>
<body>
<div class="container bg-dark text-light">
    <h1><%=title%> a product
    </h1>
    <hr />
    <form method="post" action="${pageContext.request.contextPath}/products/<%=mode%>" enctype="multipart/form-data">
        <div class="my-3">
            <label class="form-label my-1" for="brand">
                Brand
            </label>
            <input <% if (isUpdate){%> value="<%=product.getBrand()%>"<%}%> required class="form-control" name="brand" id="brand" type="text" placeholder="Apple" />
        </div>
        <div class="my-3">
            <label class="form-label my-1" for="ref">
                Reference
            </label>
            <input <% if (isUpdate){%> value="<%=product.getReference()%>"<%}%> required class="form-control" name="ref" id="ref" type="text" placeholder="Iphone 15 Pro"/>
        </div>
        <div class="my-3">
            <label class="form-label my-1" for="purchaseDate">Purchase date</label>
            <input class="form-control" <%if (isUpdate){%> value="<%=product.getPurchaseDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)%>"<%}%> type="datetime-local" name="purchaseDate" id="purchaseDate" required>
        </div>
        <div class="my-3">
            <label class="form-label my-1" for="price">Price</label>
            <input class="form-control" <%if (isUpdate){%> value="<%=product.getPrice()%>"<%}%>  step="0.01" type="number" name="price" id="price" required>
        </div>
        <div class="my-3">
            <label class="form-label my-1" for="stock">Stock</label>
            <input class="form-control" <%if (isUpdate){%> value="<%=product.getStock()%>"<%}%> type="number" name="stock" id="stock" required>
        </div>
        <div class="my-3">
            <label class="form-label my-1" for="image">Image</label>
            <input class="form-control" type="file" accept="image/*" name="image" id="image" required>
        </div>
        <%if (isUpdate){%>
            <input hidden="hidden" name="id" id="id" value="<%=product.getId()%>" type="text">
        <%}%>
        <div class="d-flex justify-content-center my-3">
            <button onclick="return confirm('Are you sure ?')" class="btn btn-primary mx-1"><%=isUpdate ? "Update" : "Add"%></button>
            <a onclick="return confirm('Are you sure ?')" class="btn btn-danger mx-1" href="${pageContext.request.contextPath}/products/list">Cancel</a>
        </div>


    </form>
</div>
</body>
</html>
