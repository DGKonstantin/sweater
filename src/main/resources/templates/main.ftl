<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<@l.logout/>
<span><a href="/user">Все пользователи</a></span>
    <div>
        <form method="post" action="main">
            <input type="text" name="text" placeholder="Введите текст">
            <input type="text" name="tag" placeholder="Введите tag">
            <button type="submit">Добавить</button>
        </form>
    </div>

    <div>Список сообщений</div>
    <form method="get" action="main">
        <input type="text" name="filter" value="${filter?ifExist}">
        <button type="submit">Найти</button>
    </form>

    <#list messages as message>
    <div>
        <strong>${message.authorName}</strong>
        <i>${message.id}</i>
        <span >${message.text}</span>
        <b >${message.tag}</b>
    </div>
    <#else>
    Нет сообщений
    </#list>
</@c.page>