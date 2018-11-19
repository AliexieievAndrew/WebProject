<!DOCTYPE html>
<html lang="en">


<#assign css = "/resources/css"/>
<#assign js = "/resources/js"/>
<#assign images = "/resources/images"/>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Delivery food homepage - ${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<#include "WEB-INF/views/shared/navbar.ftl">

<#include "WEB-INF/views/${userClick}.ftl">

<#--<#switch userClick>-->
    <#--<#case "home">-->
        <#--<#include "WEB-INF/views/home.ftl">-->
        <#--<#break>-->
    <#--<#case "about">-->
        <#--<#include "WEB-INF/views/about.ftl">-->
        <#--<#break>-->
    <#--<#case "allproducts">-->
        <#--<#include "WEB-INF/views/allproducts.ftl">-->
        <#--<#break>-->
    <#--<#case "contact">-->
        <#--<#include "WEB-INF/views/contact.ftl">-->
        <#--<#break>-->
<#--</#switch>-->

<!-- /.container -->

<!-- Footer -->
<#include "WEB-INF/views/shared/footer.ftl">

<!-- Bootstrap core JavaScript -->
<script src="${js}/jquery.min.js"></script>
<script src="${js}/bootstrap.bundle.min.js"></script>

</body>

</html>
