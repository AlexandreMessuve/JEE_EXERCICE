<%--
  Created by IntelliJ IDEA.
  User: alexandremessuve
  Date: 12/06/2024
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@page import="org.exercice05.entity.Dog" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<jsp:useBean id="dogs" type="java.util.List<org.exercice05.entity.Dog>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DogList</title>
    <%@include file="/WEB-INF/bootstrap.html"%>
</head>
<body>
<main>
    <div class="container bg-dark text-light">
        <h1>Liste des chiens</h1>
        <hr  />
        <table class="table table-striped table-dark">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Race</th>
                    <th>Date de naissance</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% if (!dogs.isEmpty()) {
                   for (Dog dog : dogs) {
                %>
                    <tr>
                        <th><%=dog.getId()%></th>
                        <td><%=dog.getName()%></td>
                        <td><%=dog.getSpecie()%></td>
                        <td><%=dog.getBirthday().format(DateTimeFormatter.ISO_DATE)%></td>
                        <td>
                            <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/dog/<%=dog.getId()%>">Detail</a>
                        </td>
                    </tr>
                <%}}else{ %>
                    <tr>
                        <td colspan="5">Aucune donnée</td>
                    </tr>
                <% }%>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/dog/addDog" class="btn btn-outline-primary">Ajouter un chien</a>
    </div>
</main>
</body>
</html>
