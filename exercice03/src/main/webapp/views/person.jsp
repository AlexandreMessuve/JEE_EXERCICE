<%--
  Created by IntelliJ IDEA.
  User: alexandremessuve
  Date: 11/06/2024
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="persons" type="java.util.List<exercice03.exercice03.entity.Person>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="exercice03.exercice03.entity.Person" %>
<html>
<head>
    <title>Person</title>
    <%@include file="../WEB-INF/bootstrap.html"%>
</head>
<body>
<header>
    <h1 class="text-center">Tableau de personne</h1>
</header>
<main>
    <div class="container">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>NOM</th>
                    <th>Prénom</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
            <% for (Person p : persons) { %>
            <tr>
                <td><%=p.getLastname().toUpperCase()%></td>
                <td><%=p.getFirstname()%></td>
                <td><%=p.getAge()%></td>
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
