<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRUD de Usuário</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<!-- Cabeçalho com link para o menu -->
<nav class="navbar navbar-light bg-light">
<a href="<c:url value='/index.html'/>" class="navbar-brand">
    <button class="btn btn-outline-primary">Voltar ao Menu</button>
    </a>
    <span class="navbar-text">
    User Creation
    </span>
    </nav>

<div class="container mt-5">
    <h1 class="text-center mb-4">User Creation</h1>

    <!-- Formulário para inserir ou atualizar um usuário -->
    <form action="controller" method="POST" class="p-4 border rounded shadow-sm bg-light">
        <div class="form-group">
            <label for="name">Nome:</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="Digite o nome" required>
        </div>

        <div class="form-group">
            <label for="cpf">CPF:</label>
            <input type="text" class="form-control" name="cpf" id="cpf" placeholder="Digite o CPF" required>
        </div>

        <div class="form-group">
            <label for="email">E-mail:</label>
            <input type="email" class="form-control" name="email" id="email" placeholder="Digite o e-mail" required>
        </div>

        <div class="form-group">
            <label for="password">Senha:</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="Digite a senha" required>
        </div>

        <div class="form-group">
            <label for="dateOfBirth">Data de Nascimento:</label>
            <input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth" required>
        </div>

        <input type="hidden" name="action" value="InsertUser">
        <button type="submit" class="btn btn-primary btn-block">Enviar</button>
    </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
