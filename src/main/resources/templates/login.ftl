<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
Логин
<@l.login "login"/>
<a href="/registration">Регистрация</a>
</@c.page>