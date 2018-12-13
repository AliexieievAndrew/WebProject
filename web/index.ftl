<!DOCTYPE html>
<html lang="en">

<#assign context = springMacroRequestContext.getContextPath()/>

<#assign css = "/resources/css"/>
<#assign js = "/resources/js"/>
<#assign images = "/resources/images"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <#--glyph Font Awesome-->
        <link
                rel="stylesheet"
                href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
                integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
                crossorigin="anonymous">


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <#-- CSRF -->
    <#-- configured in myapp.js -->
    <#--<meta name="_csrf" content="${_csrf.token}">-->
    <#--<meta name="_csrf_header" content="${_csrf.headerName}">-->

    <title>Delivery food homepage - ${title}</title>

    <#--window is a JS global object-->
    <script>
        <#--for lights buttons-->
        window.menu = '${title}';

        window.contextRoot = '${context}';

    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap minty theme -->
    <link href="${css}/bootstrap-minty-theme.css" rel="stylesheet">

    <#--Bootstrap DataTables-->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <#--Bootstrap DataTables jquery-->
    <link href="${css}/jquery.dataTables.css" rel="stylesheet">

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

    <#--Jquery validate-->
    <#--from https://github.com/jquery-validation/jquery-validation/releases/tag/1.19.0 -->
    <script src="${js}/jquery.validate.js"></script>

    <script src="${js}/bootstrap.bundle.min.js"></script>

<#--DataTable plugin-->
    <script src="${js}/jquery.dataTables.js"></script>

<#--DataTable boottrap -->
    <#--<script src="${js}/dataTables.bootstrap.js"></script>-->

<#--Self coded javascript (lights buttons)-->
    <script src="${js}/myapp.js"></script>

</div>
</body>

</html>
