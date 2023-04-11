<!DOCTYPE html>
<#import "/spring.ftl" as spring />

<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>MAIN PAGE</title>
</head>
<body>
<h1>WebCRM | <a href="/login">Вход</a></h1><hr><hr>

<div align="center">

<h3>Создать онлайн запись</h3>

<form action="/" method="post">


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


    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" value="Записаться"/>

</form>

</div>
</body>
</html>