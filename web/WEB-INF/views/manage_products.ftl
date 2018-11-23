<#--adding taglib-->
<#--<#assign sf = [""]>-->

<div class="container">
    <div class="row">
        <div class ="col-md-offset-2 col-md-8">
            <div class ="panel panel-primary">
                <div class = "panel-heading">
                    <h4>Product Management</h4>

                </div>
                <div class="panel-body">

                    <#--Form elements-->
                    <form class = "form-horizontal">

                        <#--line name-->
                        <div class="form-group">
                            <label class = "control-label col-md-4" for="name">
                                Enter Product Name
                            </label>
                            <div class="col-md-8">
                                <input type="text" name ="name" id ="name" placeholder="Product Name" class = "form-control"/>
                                <#--<em class = "help-block">Please enter product name</em>-->
                            </div>
                        </div>

                        <#--line description-->
                        <div class="form-group">
                            <label class = "control-label col-md-4" for="description">
                                Enter product description
                            </label>
                            <div class="col-md-8">
                                <textarea name ="description" id ="description" rows="4" placeholder="Description" class = "form-control"></textarea>
                                <#--<em class = "help-block">Please enter some description</em>-->
                           </div>
                        </div>

                        <#--line unitPrice-->
                        <div class="form-group">
                            <label class = "control-label col-md-4" for="unitPrice">
                                Enter unit price
                            </label>
                            <div class="col-md-8">
                                <input type="number" name ="unitPrice" id ="unitPrice" placeholder="Unit price in UAH" class = "form-control"/>
                            <#--<em class = "help-block">Please enter some description</em>-->
                            </div>
                        </div>

                            <#--line Category choice-->
                            <div class="form-group">
                                <label class = "control-label col-md-4" for="categoryId">
                                    Select category
                                </label>
                                <div class="col-md-8">
                                    <select class="form-control" id="categoryId" name="categoryId">
                                        <option value="1">Category one test</option>
                                        <option value="2">Category two test</option>
                                    </select>
                                <#--<em class = "help-block">Please enter some description</em>-->
                                </div>
                            </div>

                            <#--btn submit-->
                            <div class="form-group">
                                <div class="col-lg-offset-4 col-md-8">
                                    <input type="submit" name ="submit" id ="submit" value="submit" class = "btn btn-primary"/>
                                </div>
                            </div>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>