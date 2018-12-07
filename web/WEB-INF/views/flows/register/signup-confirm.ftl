<#include "/WEB-INF/views/flows/shared/flows-header.ftl">
<div class="container">

    <div class="row">
        <div class="col-md-offset-2 col-md-8">

            <div class ="panel panel-primary">
                <div class="panel-heading">
                    <h4>Personal details</h4>
                </div>
                <div class="panel-body">

                </div>
            </div>


            <div class ="panel panel-primary">
                <div class="panel-heading">
                    <h4>Personal address</h4>
                </div>
                <div class="panel-body">

                </div>
            </div>


                <div class="panel-body">
                    <#--btn submit-->
                        <div class="form-group">
                            <div class="col-lg-offset-4 col-md-8">

                            <#--go back-->
                                <a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">
                                    <span class="fas fa-chevron-left"/>
                                    Back - Billing
                                </a>

                            <#--Success-->
                                <a href="${flowExecutionUrl}&_eventId_success" class="btn btn-primary">
                                    Confirm
                                    <span class="fas fa-check"/>
                                </a>
                            </div>
                        </div>
                </div>

        </div>
    </div>
<#include "/WEB-INF/views/flows/shared/flows-footer.ftl">

