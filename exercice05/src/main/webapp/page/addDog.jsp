<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: alexandremessuve
  Date: 12/06/2024
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="pathInfo" type="java.lang.String" scope="request" />
<jsp:useBean id="dog" type="org.exercice05.entity.Dog" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><% if (pathInfo.isEmpty()){%>
        Ajout de chien
        <%} else{%>
        Detail du chien
        <%}%>
    </title>
    <%@include file="/WEB-INF/bootstrap.html"%>
</head>
<body>
<div class="container bg-dark text-light">
    <h1><% if (pathInfo.isEmpty()) {%>
        Ajout de chien
        <%}else {%>
        Detail du chien
        <%}%>
    </h1>
    <hr />
    <form method="post" action="${pageContext.request.contextPath}/dog/addDog">
        <div>
            <label class="form-label" for="name">
                Nom
            </label>
            <input <% if (!pathInfo.isEmpty() && dog != null){%> readonly value="<%=dog.getName()%>"<%}%> required class="form-control" name="name" id="name" type="text" placeholder="Rufus" />
        </div>
        <div>
            <label class="form-label" for="specie">
                Race
            </label>
            <input <% if (!pathInfo.isEmpty() && dog != null){%> readonly value="<%=dog.getSpecie()%>"<%}%> required class="form-control" name="specie" id="specie" type="text" placeholder="Labrador" />
        </div>
        <div>
            <label class="form-label" for="birthDate">
                Date de naissance
            </label>
            <% if (!pathInfo.isEmpty() && dog != null){%>
            <input id="birthDate" readonly class="form-control" name="birthDate" type="text" value="<%=dog.getBirthday().format(DateTimeFormatter.ISO_DATE)%>">
            <%} else{%>
            <input class="form-control" name="birthDate" id="birthDate" type="date" required />
            <%}%>
        </div>
        <% if (pathInfo.isEmpty()){%>
        <button class="btn btn-primary">Ajouter</button>
        <%} else {%>
        <a href="doglist" class="btn btn-outline-primary">Retour</a>
        <%}%>
    </form>
</div>
</body>
</html>
