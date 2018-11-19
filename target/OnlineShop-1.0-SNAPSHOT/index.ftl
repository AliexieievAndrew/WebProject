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

    <#--for lights buttons-->
    <script>
        window.menu = '${title}';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap minty theme -->
    <link href="${css}/bootstrap-minty-theme.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

<div class="wrapper">

    <!-- Navigation -->
    <#include "WEB-INF/views/shared/navbar.ftl">

    <#--Page content-->
    <div class="content">
        <#include "WEB-INF/views/${userClick}.ftl">
    </div>

    <!-- Footer -->
    <#include "WEB-INF/views/shared/footer.ftl">

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>

    <#--Self coded javascript-->
    <script src="${js}/myapp.js"></script>

</div>
</body>

</html>
