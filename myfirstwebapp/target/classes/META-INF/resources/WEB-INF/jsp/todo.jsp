<%-- 현재 JSP 페이지에 표현 언어(EL), JSTL, 사용자 정의 태그(custom tag)와 같은
태그 라이브러리를 설정하는 태그임 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet" >
        <title>Add Todos Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Enter Todo Details</h1>
            <form method="post">
                Description: <input type="text" name="description"/>
                <input type="submit" class="btn btn-success"/>
            </form>
        </div>
        <script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
        <script src="webjars\jquery\3.6.0\jquery.min.js"></script>

    </body>
</html>

