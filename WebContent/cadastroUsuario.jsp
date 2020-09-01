<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Cadastro Usu�rio</title>
    <link rel="stylesheet" href="./resources/css/cadastro.css" />
  </head>
  <body>
    <h1>Cadastro de usu�rio</h1>

    <form>
      <ul class="form-style-1">
        <li>
          <label>Email <span class="required">*</span></label>
          <input type="email" name="field3" class="field-long" />
        </li>
        <li>
          <label>Senha <span class="required">*</span></label>
          <input type="password" name="field3" class="field-long" />
        </li>
        <li>
          <input type="submit" value="Excluir" />
          <input type="submit" value="Editar" />
        </li>
      </ul>
    </form>

    <table>
      <c:forEach items="${usuarios}" var="user">
        <tr>
          <td style="width: 150px"><c:out value="${user.id }"></c:out></td>
          <td style="width: 150px"><c:out value="${user.login }"></c:out></td>
          <td><c:out value="${user.senha }"></c:out></td>

          <td>
            <a href="salvarUsuario?acao=delete&user=${user.login}">Excluir</a>
          </td>
          <td>
            <a href="salvarUsuario?acao=editar&user=${user.login}">Editar</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
