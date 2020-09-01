<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <meta charset="UTF-8" />
    <title>Curso JSP</title>
    <link rel="stylesheet" href="./resources/css/estilo.css" />
  </head>
  <body>
    <h1>P�gina index</h1>

    <div class="login-page">
      <div class="form">
        <form action="LoginServlet" method="post" class="login-form">
          <input placeholder="login" type="text" id="login" name="login" />
          <br />
          <input placeholder="Senha" type="password" id="senha" name="senha" />
          <br />
          <button type="submit" Logar value="logar">Logar</button>
        </form>
      </div>
    </div>
  </body>
</html>
