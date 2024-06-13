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
                <% if (!dogs.isEmpty()) {
                    int i = 1;
                   for (Dog dog : dogs) {
                %>
                    <tr>
                        <th><%=i++%></th>
                        <td><%=dog.getName()%></td>
                        <td><%=dog.getSpecie()%></td>
                        <td><%=dog.getBirthday().format(DateTimeFormatter.ISO_DATE)%></td>
                        <td class="d-flex justify-content-center">
                            <div class="mx-1">
                                <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/dog/<%=dog.getId()%>">Detail</a>
                            </div>
                            <form method="post" action="${pageContext.request.contextPath}/dog/delete">
                                <input hidden="hidden" type="text" value="<%=dog.getId()%>" name="id" >
                                <input hidden="hidden" type="text" value="delete" name="_method">
                                <button class="btn btn-outline-danger">Supprimer</button>
                            </form>
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
</main>
</body>
</html>
