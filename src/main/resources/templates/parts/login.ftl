<#macro login path>
${message?ifExists}
<form action="/${path}" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Имя пользователя : </label>
        <div class="col-sm-10">
            <label><input type="text" name="username" class="form-control"/> </label>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Пароль : </label>
        <div class="col-sm-10">
            <label><input type="text" name="password" class="form-control"/> </label>
        </div>
    </div>
    <div><input type="submit" value="Sign In"/></div>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>
</#macro>