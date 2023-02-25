<!DOCTYPE html>
<html>
<head>
    <title>MAIN PAGE</title>
</head>
<body>
<h1>WebCRM</h1><hr>
<h4>Записи: </h4><br>


<form action="admin" method="get">
    Поиск клиента по номеру телефона: <input type="text", name="phoneNumber">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" value="Найти">
</form>
<form action="admin" method="get">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" value="Назад">
</form>
<form action="/logout" method="get">
    <input type="hidden" name ="_scrf" value="${_csrf.token}"/>
    <input type="submit" value="Выйти">
</form>

<#list events as event>

     <b>Имя клиента: </b>${event.name}<br>
        <b>Номер телефона клиента: </b>${event.phoneNumber}<br>
        <b>Наименование услуги: </b>${event.service}<br>
        <b>Время: </b>${event.time}> - ${event.timeOfEnd}<br><br>



    <form action="/event/delete/${event.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Удалить запись"/>
    </form><br><br><br>
</#list>


<hr>
</body>
</html>