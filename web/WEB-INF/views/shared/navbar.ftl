<#--Get the request context in a freemaker template in spring-->
<#assign context = springMacroRequestContext.getContextPath()/>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${context}/home">Delivery food</a>
        <button
                class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarResponsive"
                aria-controls="navbarResponsive"
                aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li id = "home">
                    <a class="nav-link" href="${context}/home">Home</a>
                </li>
                <li id = "about">
                    <a class="nav-link" href="${context}/about">About</a>
                </li>
                <li id = "allproducts">
                    <a class="nav-link" href="${context}/show/all/products">All Products</a>
                </li>
                <li id = "contact">
                    <a class="nav-link" href="${context}/contact">Contact</a>
                </li>
                <li id = "manageproducts">
                    <a class="nav-link" href="${context}/manage/products">Manage Products</a>
                </li>
            </ul>

            <#--Registering new user-->
            <ul class = "nav navbar-nav navbar-right">
                <li id = "register">
                    <#--  /register - FLOW ID -->
                    <a class="nav-link" href="${context}/register">Registration</a>
                </li>
                <li id = "login">
                    <a class="nav-link" href="${context}/login">Login</a>
                </li>
            </ul>
        </div>
    </div>
</nav>