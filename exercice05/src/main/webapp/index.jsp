<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil</title>
    <%@include file="/WEB-INF/bootstrap.html"%>
</head>
<body>
<header>
    <h1 class="text-center">Accueil
    </h1>
</header>
<hr />
<main>
    <div class="container d-flex justify-content-center">
        <a href="${pageContext.request.contextPath}/dog/doglist" class="link-dark link-opacity-50-hover link-underline-opacity-0">
            <p class="text-center fs-4">Liste des chiens</p>
            <img src="https://i.pinimg.com/736x/fc/4a/3b/fc4a3b241f4edb9a7aab9fe8f73bb485.jpg" alt="chien"/>
        </a>
    </div>

</main>

</body>
</html>