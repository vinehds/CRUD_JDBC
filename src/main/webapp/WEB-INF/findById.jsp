<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuário Encontrado</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>

<nav class="navbar navbar-light bg-light">
    <a href="<c:url value='/index.html'/>" class="navbar-brand">
        <button class="btn btn-outline-primary">Voltar ao Menu</button>
    </a>
    <span class="navbar-text">
        User filtered by id
    </span>
</nav>

<div class="container mt-5">
    <h2 class="text-center mb-4">Usuário com o ID ${userFound.id}</h2>

    <table class="table table-bordered table-striped table-hover">
        <thead class="thead-dark">
        <tr>
            <th>Nome</th>
            <th>CPF</th>
            <th>Email</th>
            <th>Senha</th>
            <th>Data de Nascimento</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${userFound.name}</td>
            <td>${userFound.cpf}</td>
            <td>${userFound.email}</td>
            <td>${userFound.password}</td>
            <td>${userFound.dateOfBirth}</td>
            <td><a href="controller?action=DeleteUser&id=${userFound.id}" class="btn btn-danger btn-sm">Excluir</a></td>
        </tr>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
