<%-- 
    Document   : novo
    Created on : 11/04/2016, 21:49:25
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Atividade</title>
    </head>
    <body>
        <jsp:include page="fragments/menu.jspf" />
        <h1>Nova Atividade</h1>
        <form method="post">
            <div>
                <label>Funcionario:
                    <input type="text" name="funcionario" />
                </label>
            </div>
            <div>
                <label>Descricao:
                    <textarea name="descricao" /></textarea>
                </label>
            </div>
            <div>
                <label>Tipo:
                    <input type="text" name="tipo" />
                </label>
            </div>
            <div>
                <label>Horas:
                    <input type="text" name="horas" />
                </label>
            </div>
            <div>
                <input type="submit" />
            </div>
        </form>
    </body>
</html>
