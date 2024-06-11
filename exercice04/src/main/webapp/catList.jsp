<%--
  Created by IntelliJ IDEA.
  User: alexandremessuve
  Date: 11/06/2024
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@page import="org.exercice04.entity.Cat" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<jsp:useBean id="cats" type="java.util.List<org.exercice04.entity.Cat>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cat list</title>
    <%@include file="WEB-INF/bootstrap.html"%>
</head>
<body>
<header>
    <h1 class="text-center">Tableau de Chat</h1>
</header>
<main>
    <div class="container">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Nom</th>
                <th>Espèce</th>
                <th>Repas préféré</th>
                <th>Date de naissance</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <form method="post" action="${pageContext.request.contextPath}/cat">
                    <td>
                        <input required name="name" type="text" class="form-control" placeholder="Nom">
                    </td>
                    <td>
                        <input required name="specie" type="text" class="form-control" placeholder="Espèce">
                    </td>
                    <td>
                        <input required name="favoriteFood" type="text" class="form-control" placeholder="Repas préféré">
                    </td>
                    <td>
                        <input required name="birthDate" type="date" class="form-control">
                    </td>
                    <td>
                        <button class="btn btn-primary">Add</button>
                    </td>
                </form>

            </tr>
            <% for (Cat c : cats) { %>
            <tr>
                <td><%=c.getName()%></td>
                <td><%=c.getSpecie()%></td>
                <td><%=c.getFavoriteFood()%></td>
                <td><%=c.getDateOfBirth().format(DateTimeFormatter.ISO_LOCAL_DATE)%></td>
                <td><button class="btn btn-success">Modifier</button></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <div class="d-flex justify-content-center">
        <a class="fs-4 link-dark link-opacity-50-hover link-underline-opacity-0 text-center" href="${pageContext.request.contextPath}/index.jsp">Retour</a>
    </div>
</main>
</body>
</html>
