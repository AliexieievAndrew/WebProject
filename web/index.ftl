<!DOCTYPE html>
<html lang="en">

<#assign context = springMacroRequestContext.getContextPath()/>

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


    <script>
        <#--for lights buttons-->
        window.menu = '${title}';

        window.contextRoot = ${context}

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
