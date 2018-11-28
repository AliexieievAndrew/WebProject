<#assign context = springMacroRequestContext.getContextPath()/>

<#--need to use freemarker version 2.3.28 -->
<#import "/spring.ftl" as spring/>

<div class="container">
    <div class="row">
        <div class ="col-md-offset-2 col-md-8">
            <div class ="panel panel-primary">
                <div class = "panel-heading">
                    <h4>Product Management</h4>

                </div>
                <div class="panel-body">

                    <#--Form elements-->
                    <form class = "form-horizontal" modelAttribute ="product" action="${context}/manage/products" method = "post">

                        <#--line name-->
                        <div class="form-group">
                            <label class = "control-label col-md-4" for="name">
                                Enter Product Name
                            </label>
                            <div class="col-md-8">
                                <@spring.formInput "product.name", "class = 'form-control' required","text"/>
                            </div>
                        </div>

                        <#--line description-->
                        <div class="form-group">
                            <label class = "control-label col-md-4" for="description">
                                Enter product description
                            </label>
                            <div class="col-md-8">
                            <@spring.formTextarea "product.description","class = 'form-control' required"/>
                            </div>
                        </div>

                        <#--line unitPrice-->
                        <div class="form-group">
                            <label class = "control-label col-md-4" for="unitPrice">
                                Enter unit price in UAH
                            </label>
                            <div class="col-md-8">
                            <@spring.formInput "product.unitPrice", "class = 'form-control ' step='0.01' required","number"/>
                            </div>
                        </div>

                        <#--line Category choice-->
                        <div class="form-group">
                            <label class = "control-label col-md-4" for="categoryId">
                                Select category
                            </label>
                            <div class="col-md-8">

                                <select class="form-control" id="categoryId" name="categoryId">
                                    <#list categories as key, value>
                                        <option value="${value}">${key}</option>
                                    </#list>
                                </select>
                                <#--dont know why not working-->
                                <#--<@spring.formSingleSelect "product.categoryId", "categories","class = 'form-control"/>-->
                            </div>
                        </div>

                    <#--btn submit-->
                        <#--btn submit-->
                            <div class="form-group">
                                <div class="col-lg-offset-4 col-md-8">
                                    <input type="submit" name ="submit" id ="submit" value="submit" class = "btn btn-primary"/>

                                <#--hidden fields for product-->
                                    <@spring.formHiddenInput "product.id",""/>
                                    <@spring.formHiddenInput "product.code",""/>
                                    <@spring.formHiddenInput "product.active",""/>
                                    <@spring.formHiddenInput "product.supplierId",""/>
                                    <@spring.formHiddenInput "product.purchases",""/>
                                </div>
                            </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>