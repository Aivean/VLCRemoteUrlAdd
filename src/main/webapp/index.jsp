<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>VLC Remote add URL</title>
  </head>
  <body>
        <form method="post" action="add/">
            <label>Specify one or more links: <br/>
                <textarea name="links"></textarea>
            </label>
            <input type="submit" value="Queue">
        </form>
  </body>
</html>