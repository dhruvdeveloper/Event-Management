<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="container" style="margin: 2%">

    <h2 style="color: #03cafc; margin: 2%" >Events</h2>

    <c:url var="payment" value="/payment"/>

    <c:forEach items="${events}" var="event">
        <form:form action="${payment}" method="post" modelAttribute="eventId">
            <div class="card border-info mb-3" style="max-width: 100%;">
                <div class="card-header">${event.name}</div>
                <div class="card-body">
                    <p class="card-text">${event.description}</p>
                    <form:input path="eventId" cssStyle="display: none;" value="${event.eventId}"/>
                        <input type="submit" value="Register" class="btn btn-outline-info"/>
                </div>
            </div>
        </form:form>
    </c:forEach>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
