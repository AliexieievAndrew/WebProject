<#assign context = springMacroRequestContext.getContextPath()/>

<div class="container">
    <div class="row">

        <#--Would be to displae sidebar-->
        <div class="col-lg-3">

        <#-- Side bar-->
            <#include "shared/sidebar.ftl">

        </div>

        <#--to display the actual products-->
        <div class = "col-lg-9">

            <#--Added breadcrumb component-->
            <div class="row">
                <div class="col-lg-12">

                <#if  category ??>

                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${context}/home">Home</a>
                        </li>
                        <li class="breadcrumb-item active">Category</li>
                        <li class="breadcrumb-item active">${category.name}</li>
                    </ol>
                    <#else>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${context}/home">Home</a>
                        </li>
                        <li class="breadcrumb-item active">All Products</li>
                    </ol>
                </#if>
                </div>
            </div>
        </div>
    </div>
</div>