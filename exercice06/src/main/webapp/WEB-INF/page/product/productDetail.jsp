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
<body class="vh-100 bg-dark text-light overflow-hidden">
<%@include file="/WEB-INF/header.jsp"%>
<main>
    <div class="container d-flex justify-content-center">
        <% if (product != null){%>
        <div class="card bg-light mt-5" style="width: 50em;">

            <div class="card-body text-dark">

                <div class="d-flex justify-content-between align-content-center my-1">
                    <p class="text-muted">Created at : <%=product.getCreatedAt().format(DateTimeFormatter.ISO_DATE)%></p>
                    <h1 class="card-title">Brand :  <%=product.getBrand() != null ? product.getBrand() : ""%></h1>
                    <p class="text-muted">Updated at: <%=product.getUpdatedAt().format(DateTimeFormatter.ISO_DATE)%></p>
                </div>
                <div class="d-flex fs-5 my-3">
                    <div class="mx-2">
                        <%if (product.getImage() != null){%>
                        <img src="${pageContext.request.contextPath}/images/<%=product.getImage()%>" width="300" alt="<%=product.getReference()%>">
                        <%}else{%>
                        <img src="https://nayemdevs.com/wp-content/uploads/2020/03/default-product-image.png" width="300" alt="default product" />
                        <%}%>
                    </div>
                    <div>
                        <p class="card-text">Ref: <%=product.getReference() != null ? product.getReference() : ""%></p>
                        <p class="card-text">Price: <%=product.getPrice() != null ? product.getPrice() : ""%>$</p>
                        <p class="card-text">Stock: <%=product.getStock() != 0 ? product.getStock() : ""%></p>
                        <p class="card-text">Purchase date: <%=product.getPurchaseDate() != null ? product.getPurchaseDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) : ""%></p>
                    </div>
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
