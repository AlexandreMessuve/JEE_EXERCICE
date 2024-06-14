<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: alexandremessuve
  Date: 13/06/2024
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="product" class="org.exercice06.entity.Product" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Repository</title>
    <%@include file="/WEB-INF/bootstrap.html"%>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<main>

    <div class="container d-flex justify-content-center">
        <% if (product != null){%>
        <div class="card bg-dark " style="width: 50em;">
            <%if (product.getImage() != null){%>
            <img src="${pageContext.request.contextPath}/image/<%=product.getImage()%>" class="card-img-top" alt="<%=product.getReference()%>">
            <%}%>
            <div class="card-body bg-dark text-light">

                <div class="d-flex justify-content-between align-content-center my-1">
                    <h6 class="text-light">Created at : <%=product.getCreatedAt().format(DateTimeFormatter.ISO_DATE)%></h6>
                    <h1 class="card-title">Brand :  <%=product.getBrand() != null ? product.getBrand() : ""%></h1>
                    <h6 class="text-light">Updated at: <%=product.getUpdatedAt().format(DateTimeFormatter.ISO_DATE)%></h6>
                </div>
                <div class="fs-3 my-3">
                    <p class="card-text">Ref: <%=product.getReference() != null ? product.getReference() : ""%></p>
                    <hr/>
                    <p class="card-text">Price: <%=product.getPrice() != null ? product.getPrice() : ""%>$</p>
                    <hr/>
                    <p class="card-text">Stock: <%=product.getStock() != 0 ? product.getStock() : ""%></p>
                    <hr/>
                    <p class="card-text">Purchase date: <%=product.getPurchaseDate() != null ? product.getPurchaseDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) : ""%></p>
                </div>
                <hr/>
                <div class="d-flex justify-content-between">
                    <a href="${pageContext.request.contextPath}/products/list" class="btn btn-secondary">Return</a>
                    <a class="btn btn-info" href="${pageContext.request.contextPath}/products/updateForm?id=<%=product.getId()%>">Update</a>
                    <a onclick="return confirm('Are you sure ?')" class="btn btn-danger" href="${pageContext.request.contextPath}/products/delete?id=<%=product.getId()%>">Delete</a>
                </div>
            </div>
        </div>
        <%}%>
    </div>
</main>
</body>
</html>
