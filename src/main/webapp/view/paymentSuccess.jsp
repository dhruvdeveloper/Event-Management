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
            <img src="../static/ihr_qr_code_ohne_logo.jpg" />
            <p class="card-text label label-warning"><b>Your payment is successful. Please save this barcode!</b></p>

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
    let i = 0;
    pay.onclick = function () {
        if (i === 0){
            if (paymentOptions.style.display !== "none") {
                paymentOptions.style.display = "none";
            } else {
                paymentOptions.style.display = "block";
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