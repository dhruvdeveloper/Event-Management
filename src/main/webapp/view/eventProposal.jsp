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
<div class="container" style="margin: 5%">

    <h2 style="color: #03cafc; text-align: center" > Event Proposal! </h2>

    <c:url var="eventProposalSuccess" value="/eventProposalSuccess"/>

    <form:form action="${eventProposalSuccess}" method="post" modelAttribute="eventProposal">

        <div class="mb-3">
            <form:label for="name" class="form-label" path="name">Event Name: </form:label>
            <form:input type="text" class="form-control" id="name" path="name"/>
        </div>

        <div class="mb-3">
            <form:label for="email" class="form-label" path="email">Email: </form:label>
            <form:input type="email" class="form-control" id="email" aria-describedby="emailHelp"  path="email"/>
        </div>

        <div class="mb-3">
            <form:label for="domain" class="form-label" path="domain">Domain: </form:label>
            <form:input type="text" class="form-control" id="domain" path="domain"/>
        </div>

        <div class="mb-3">
            <form:label for="description" class="form-label" path="description">Description: </form:label>
            <form:input type="text" class="form-control" id="role" path="description"/>
        </div>

        <input type="submit" class="btn btn-outline-info" value="submit"/>
    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>