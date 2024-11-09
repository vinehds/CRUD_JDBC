<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sucesso</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-light bg-light">
    <a href="<c:url value='/index.html'/>" class="navbar-brand">
        <button class="btn btn-outline-primary">Voltar ao Menu</button>
    </a>
    <span class="navbar-text">
        User Created
    </span>
</nav>

<div class="container mt-5">
    <div class="alert alert-success text-center" role="alert">
        <strong>Sucesso!</strong> Usuário ${param.name} adicionado com sucesso.
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
