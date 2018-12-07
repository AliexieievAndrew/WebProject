<#include "/WEB-INF/views/flows/shared/flows-header.ftl">

    <div class="container">

        <div class="row">
            <div class="col-md-offset-2 col-md-8">

                <div class ="panel panel-primary">
                    <div class="panel-heading">
                        <h4>Registering new user</h4>
                    </div>

                    <div class="panel-body">
                        <#--modelAttribute takken from signup-flow.xml (..var name = "user"..) -->
                        <form class="form-horizontal" method="post" id="registerForm" modelAttribute ="user">

                        <#--line first name-->
                            <div class="form-group">
                                <label class = "control-label col-md-4" for="firstName">
                                    Your first name
                                </label>
                                <div class="col-md-8">
                                    <@spring.formInput "user.firstName", "class = 'form-control'","text"/>
                                    <@spring.showErrors "<br/>",""/>
                                </div>
                            </div>

                        <#--line last name -->
                            <div class="form-group">
                                <label class = "control-label col-md-4" for="lastName">
                                    Your last name
                                </label>
                                <div class="col-md-8">
                                    <@spring.formInput "user.lastName", "class = 'form-control'","text"/>
                                    <@spring.showErrors "<br/>",""/>
                                </div>
                            </div>

                        <#--line passsword -->
                            <div class="form-group">
                                <label class = "control-label col-md-4" for="password">
                                    Your password
                                </label>
                                <div class="col-md-8">
                                    <@spring.formInput "user.password", "class = 'form-control'","text"/>
                                    <@spring.showErrors "<br/>",""/>
                                </div>
                            </div>

                        <#--line email -->
                            <div class="form-group">
                                <label class = "control-label col-md-4" for="email">
                                    Your email
                                </label>
                                <div class="col-md-8">
                                    <@spring.formInput "user.email", "class = 'form-control'","text"/>
                                    <@spring.showErrors "<br/>",""/>
                                </div>
                            </div>

                        <#--line contact number -->
                            <div class="form-group">
                                <label class = "control-label col-md-4" for="contactNumber">
                                    Your contact number
                                </label>
                                <div class="col-md-8">
                                    <@spring.formInput "user.contactNumber", "class = 'form-control'","text"/>
                                    <@spring.showErrors "<br/>",""/>
                                </div>
                            </div>

                        <#--btn submit-->
                            <div class="form-group">
                                <div class="col-lg-offset-4 col-md-8">
                                    <#--important name = "_eventId_billing" where billing id of <view-state> in signup-flow.xml-->
                                    <button type="submit" name ="_eventId_billing"  class = "btn btn-primary">
                                        Next - Billing
                                        <span class="fas fa-chevron-right"/>
                                    </button>

                                    <#--hidden fields for user-->
                                    <#--<@spring.formHiddenInput "user.id",""/>-->
                                    <#--<@spring.formHiddenInput "user.enabled",""/>-->
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>



    </div>

<#include "/WEB-INF/views/flows/shared/flows-footer.ftl">