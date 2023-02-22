<!DOCTYPE html>
<html>
<head>
    <title>MAIN PAGE</title>
</head>
<body>
<h1>WebCRM</h1><hr>
<h4>Информация о записи</h4>
<b>Имя клиента: </b>${event.name}<br>
<b>Номер телефона клиента: </b>${event.phoneNumber}<br>
<b>Наименование услуги: </b>${event.service}<br>
<b>Время: </b>${event.time}<br>
<b>Количество посещений: </b>${client.countOfVisits}<br>

<hr>

<form action="/event/delete/${event.id}" method="post">
    <input type="submit" value="Удалить запись"/>
</form>
</body>
</html>