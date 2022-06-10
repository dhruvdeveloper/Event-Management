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
    <div class="card text-center">
        <div class="card-header">
            Featured
        </div>
        <div class="card-body">
            <h5 class="card-title">${event.name}</h5>
            <br />
            <p class="card-text">${event.description}</p>
            <p class="card-text"><b>${event.domain}</b></p>
            <p class="card-text"><b>$10</b></p>


            <div id="paymentOptions" style="display: none">
                <div class="row" style="margin: 2%">
                    <div class="col">
                        <label>
                            <input type="radio" name="demo" class="" id="demo1" value="card" checked>
                            <div class="card">
                                <div class="card-header">
                                    Payment Option
                                </div>
                                <div class="card-body">
                                    <blockquote class="blockquote mb-0">
                                        <p>Credit Card / Debit Card</p>
                                    </blockquote>
                                </div>
                            </div>
                        </label>
                    </div>
                    <div class="col">
                        <label>
                            <input type="radio" name="demo" class="" id="demo2" value="net banking">
                            <div class="card">
                                <div class="card-header">
                                    Payment Option
                                </div>
                                <div class="card-body">
                                    <blockquote class="blockquote mb-0">
                                        <p>Net banking</p>
                                    </blockquote>
                                </div>
                            </div>
                        </label>
                    </div>
                    <div class="col">
                        <label>
                            <input type="radio" name="demo" class="" id="demo3" value="wallet">
                            <div class="card">
                                <div class="card-header">
                                    Payment Option
                                </div>
                                <div class="card-body">
                                    <blockquote class="blockquote mb-0">
                                        <p>Wallet</p>
                                    </blockquote>
                                </div>
                            </div>
                        </label>
                    </div>
                </div>
            </div>


            <a href="#" class="btn btn-outline-info" id="payId">Pay now!</a>

            <div style="display: none" id="payNowNewId">
                <c:url var="paymentSuccess" value="/paymentSuccess"/>
                <form:form action="${paymentSuccess}" method="post" modelAttribute="paymentDetails">
                    <form:input path="paymentType" id="paymentTypeId" cssStyle="display: none;" />
                    <form:input path="eventId" cssStyle="display: none;" value="${event.eventId}" />
                    <form:input path="userId" id="userId" cssStyle="width: 60%; margin: 3% auto" placeholder="Enter user id" class="form-control" />
                    <input type="submit" value="Pay now!" class="btn btn-outline-info" />
                </form:form>
            </div>

        </div>
        <div class="card-footer text-muted">
            On, ${event.date}.
        </div>

    </div>

</div>

<script>
    const payments = document.getElementById("paymentOptions");
    const pay = document.getElementById("payId");
    const payNowNew = document.getElementById("payNowNewId");
    const demo1 = document.getElementById("demo1");
    const demo2 = document.getElementById("demo2");
    const demo3 = document.getElementById("demo3");
    const paymentType = document.getElementById("paymentTypeId");

    demo1.onclick = function () {
        paymentType.value = demo1.value;
    }

    demo2.onclick = function () {
        paymentType.value = demo2.value;
    }

    demo3.onclick = function () {
        paymentType.value = demo3.value;
    }

    let i = 0;
    pay.onclick = function () {
        if (i === 0){
            if (payments.style.display !== "none") {
                payments.style.display = "none";
            } else {
                payments.style.display = "block";
                pay.style.display = "none";
                payNowNew.style.display = "block";
            }
            i++;
        }

    };
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>