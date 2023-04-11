<!DOCTYPE html>
<html>
<head>
    <title>MAIN PAGE</title>
</head>
<body>
<h1>WebCRM | <a href="/logout">Выйти</a></h1><hr>
<div align="right">
<form action="/logout" method="get">
    <input type="hidden" name ="_scrf" value="${_csrf.token}"/>
    <input type="submit" value="Выйти">
</form>
</div>


<div align="left">
    <form action="admin" method="get">
        Поиск клиента по номеру телефона:<br><input type="text", name="phoneNumber">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Найти">
    </form>
</div><br><br>


<h4>Записи:</h4>

<#list events as event>

     <b>Имя клиента: </b>${event.name}<br>
        <b>Номер телефона клиента: </b>${event.phoneNumber}<br>
        <b>Наименование услуги: </b>${event.service}<br>
        <b>Время: </b>${event.time}> - ${event.timeOfEnd}<br><br>



    <form action="/event/delete/${event.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Удалить запись"/>
    </form>

    <form action="/event/${event.id}/edit" method="get">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Изменить запись"/>
    </form><br><br><br>
</#list>


<hr>
</body>
</html>