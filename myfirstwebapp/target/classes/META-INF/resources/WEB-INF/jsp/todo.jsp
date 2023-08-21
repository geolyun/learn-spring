<%-- 현재 JSP 페이지에 표현 언어(EL), JSTL, 사용자 정의 태그(custom tag)와 같은
태그 라이브러리를 설정하는 태그임 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Using Spring form tag library --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
    <head>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet" >
        <title>Add Todo Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Enter Todo Details</h1>
            <form:form method="post" modelAttribute="todo">
                Description: <form:input type="text" path="description" required="required"/>
                <form:input type="text" path="id"/>
                <form:input type="text" path="done"/>
                <input type="submit" class="btn btn-success"/>
            </form:form>
        </div>
        <script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
        <script src="webjars\jquery\3.6.0\jquery.min.js"></script>

    </body>
</html>

