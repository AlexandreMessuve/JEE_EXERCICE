<%--
  Created by IntelliJ IDEA.
  User: alexandremessuve
  Date: 10/06/2024
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../WEB-INF/boostrap.html"%>
</head>
<body class="bg-black">
<header>
        <h1 class="text-center text-danger">
            Mon titre page 1
        </h1>
</header>
<main>
    <div class="container-fluid">
        <form>
            <div>
                <label class="form-label text-danger">Prenom</label>
                <input type="text" name="prenom" class="form-control">
            </div>
            <div>
                <label class="form-label text-danger">Nom</label>
                <input type="text" name="nom" class="form-control">
            </div>
            <div>
                <label class="form-check-label text-danger">Check me</label>
                <input type="checkbox" class="form-check-input">
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
</main>
</body>
</html>
