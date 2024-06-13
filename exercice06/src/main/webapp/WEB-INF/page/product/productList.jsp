<%--
  Created by IntelliJ IDEA.
  User: alexandremessuve
  Date: 13/06/2024
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.exercice06.entity.Product" %>
<jsp:useBean id="products" type="java.util.List<org.exercice06.entity.Product>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
    <%@include file="/WEB-INF/bootstrap.html"%>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<div class="container bg-dark text-light">
    <div class="d-flex justify-content-between my-2">
        <h1>Liste des chiens</h1>
        <div class="align-content-center">
            <a href="${pageContext.request.contextPath}/dog/addDog" class="btn btn-outline-primary">Ajouter un chien</a>
        </div>
    </div>

    <hr  />
    <table class="table table-dark table-bordered table-striped  my-3 text-center">
        <thead>
        <tr>
            <th>#</th>
            <th>Nom</th>
            <th>Race</th>
            <th>Date de naissance</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody class="align-baseline">
        <% if (!products.isEmpty()) {
        int i = 1;
        for (Product product : products) {
        %>
        <tr>
            <th><%=i++%></th>
            <td><%=product.getBrand()%></td>
            <td><%=product.getReference()%></td>
            <td><%=product.getPrice()%>$</td>
            <td class="d-flex justify-content-center">
                <div class="mx-1">
                    <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/products/detail?id=<%=dog.getId()%>">Detail</a>
                </div>
                <div>
                    <a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/products/delete?id=<%=product.getId()%>"></a>
                </div>
            </td>
        </tr>
        <%}}else{ %>
        <tr>
            <th colspan="5">Aucune donnée</th>
        </tr>
        <% }%>
        </tbody>
    </table>
    <hr />
</div>
</body>
</html>
