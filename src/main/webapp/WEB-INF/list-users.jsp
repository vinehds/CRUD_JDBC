<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Usuários</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
        function enableEditing(userId) {
            document.getElementById("name_" + userId).disabled = false;
            document.getElementById("cpf_" + userId).disabled = false;
            document.getElementById("email_" + userId).disabled = false;
            document.getElementById("password_" + userId).disabled = false;
            document.getElementById("dateOfBirth_" + userId).disabled = false;
            document.getElementById("updateBtn_" + userId).style.display = "inline";
        }
    </script>
</head>

<body>

<!-- Cabeçalho com link para o menu -->
<nav class="navbar navbar-light bg-light">
    <a href="<c:url value='/index.html'/>" class="navbar-brand">
        <button class="btn btn-outline-primary">Voltar ao Menu</button>
    </a>
    <span class="navbar-text">
        Usuários salvos no banco de dados
    </span>
</nav>

<div class="container mt-5">
    <h2 class="text-center mb-4">Lista de Usuários</h2>

    <table class="table table-bordered table-striped table-hover">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>Email</th>
            <th>Senha</th>
            <th>Data de Nascimento</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <form action="controller" method="POST">
                <tr>
                    <td><input type="text" class="form-control" name="id" id="id_${user.id}" value="${user.id}" disabled /></td>
                    <td><input type="text" class="form-control" name="name" id="name_${user.id}" value="${user.name}" disabled /></td>
                    <td><input type="text" class="form-control" name="cpf" id="cpf_${user.id}" value="${user.cpf}" disabled /></td>
                    <td><input type="email" class="form-control" name="email" id="email_${user.id}" value="${user.email}" disabled /></td>
                    <td><input type="password" class="form-control" name="password" id="password_${user.id}" value="${user.password}" disabled /></td>
                    <td><input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth_${user.id}" value="${user.dateOfBirth}" disabled /></td>
                    <td>
                        <a href="controller?action=DeleteUser&id=${user.id}" class="btn btn-danger btn-sm mb-1">Excluir</a>
                        <button type="button" class="btn btn-warning btn-sm mb-1" onclick="enableEditing(${user.id})">Editar</button>
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="hidden" name="action" value="UpdateUser">
                        <input type="submit" id="updateBtn_${user.id}" class="btn btn-success btn-sm" style="display: none;" value="Atualizar">
                    </td>
                </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
