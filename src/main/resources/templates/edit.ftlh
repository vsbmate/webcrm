<!DOCTYPE html>
<#import "/spring.ftl" as spring />

<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>MAIN PAGE</title>
</head>
<body>
<h1>WebCRM | <a href="/login">Войти</a> </h1><hr>
<hr>
<h3>Изменить запись</h3>


<form action="/event/${event.id}/edit" method="post">

    Ваше имя: <br>
    <@spring.formInput "event.name"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Номер телефона: <br>
    <@spring.formInput "event.phoneNumber"/>
    <@spring.showErrors ""/>
    <br><br>
    Выберите услугу: <br>
    <@spring.formInput "event.service"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Выберите время: <br>
    <input type="datetime-local" name="time"/><br><br>
    <br><br>

    <form action="/event/${event.id}/edit" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" value="Изменить"/>
    </form><br><br><br>

</form>


</body>
</html>