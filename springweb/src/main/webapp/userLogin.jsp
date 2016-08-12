<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>userLogin</title>
  </head>
  <body>
  ${sessionScope.msg}<br/>
  <form action="userLogin" method="post">
      用户名: <input type="text" name="name"/><br/>
      密&nbsp;码: <input type="password" name="password"/><br/>
      自动登录  <input type="checkbox" name="mark" value="mark"/>
      <input type="submit" value="登陆"/>
  </form>
  </body>
</html>
