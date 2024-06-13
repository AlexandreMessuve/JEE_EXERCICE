<% boolean logged = session.getAttribute("isLoggedIn") != null;%>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Mon site ouais</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}">Home</a>
                    </li>
                    <% if (!logged) {%>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/user/loginForm" >Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/user/registerForm" >Register</a>
                    </li>
                    <%}else{%>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/user/logout" >Logout</a>
                    </li>
                    <%}%>
                </ul>
            </div>
        </div>
    </nav>
</header>
