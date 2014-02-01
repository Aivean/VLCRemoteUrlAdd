<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VLC Remote add URL</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="static/css/bootstrap-theme.min.css"/>
</head>
<body>
    <form method="post" action="add/">
        <div class="form-group">
            <label for="linksTextArea">Specify one or more links (one per line)</label>
            <textarea id="linksTextArea" name="links" class="form-control" rows="5"></textarea>
        </div>
        <button type="submit" class="btn btn-default">Enqueue</button>
    </form>
</body>
</html>