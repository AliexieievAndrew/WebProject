<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-3">

            <#-- Side bar-->
            <#include "shared/sidebar.ftl">


        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">
            <div class="row">
                <div class="container">
                    <div id="carouselExampleIndicators" class="carousel slide span12" data-ride="carousel">
                        <div class="row">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active" ></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                            </ol>
                        </div>
                        <div class="row">
                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active">
                                    <a href="${context}/show/6/product">
                                        <img class="d-block img-fluid" src="${context}/resources/images/Pizza Hawaiian.jpg" alt="First slide">
                                    </a>
                                </div>

                                <div class="carousel-item">
                                    <a href="${context}/show/12/product">
                                        <img class="d-block img-fluid" src="${context}/resources/images/Pizza Carbonara.jpg" alt="Second slide">
                                    </a>
                                </div>
                                <div class="carousel-item">
                                    <a href="${context}/show/8/product">
                                        <img class="d-block img-fluid" src="${context}/resources/images/Pizza Margherita.jpg" alt="Third slide">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>

            <#--<div class="row">-->

                <#--<div class="col-lg-4 col-md-6 mb-4">-->
                    <#--<div class="card h-100">-->
                        <#--<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>-->
                        <#--<div class="card-body">-->
                            <#--<h4 class="card-title">-->
                                <#--<a href="#">Item One</a>-->
                            <#--</h4>-->
                            <#--<h5>$24.99</h5>-->
                            <#--<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>-->
                        <#--</div>-->
                        <#--<div class="card-footer">-->
                            <#--<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->

                <#--<div class="col-lg-4 col-md-6 mb-4">-->
                    <#--<div class="card h-100">-->
                        <#--<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>-->
                        <#--<div class="card-body">-->
                            <#--<h4 class="card-title">-->
                                <#--<a href="#">Item Two</a>-->
                            <#--</h4>-->
                            <#--<h5>$24.99</h5>-->
                            <#--<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur! Lorem ipsum dolor sit amet.</p>-->
                        <#--</div>-->
                        <#--<div class="card-footer">-->
                            <#--<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->

                <#--<div class="col-lg-4 col-md-6 mb-4">-->
                    <#--<div class="card h-100">-->
                        <#--<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>-->
                        <#--<div class="card-body">-->
                            <#--<h4 class="card-title">-->
                                <#--<a href="#">Item Three</a>-->
                            <#--</h4>-->
                            <#--<h5>$24.99</h5>-->
                            <#--<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>-->
                        <#--</div>-->
                        <#--<div class="card-footer">-->
                            <#--<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->

                <#--<div class="col-lg-4 col-md-6 mb-4">-->
                    <#--<div class="card h-100">-->
                        <#--<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>-->
                        <#--<div class="card-body">-->
                            <#--<h4 class="card-title">-->
                                <#--<a href="#">Item Four</a>-->
                            <#--</h4>-->
                            <#--<h5>$24.99</h5>-->
                            <#--<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>-->
                        <#--</div>-->
                        <#--<div class="card-footer">-->
                            <#--<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->

                <#--<div class="col-lg-4 col-md-6 mb-4">-->
                    <#--<div class="card h-100">-->
                        <#--<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>-->
                        <#--<div class="card-body">-->
                            <#--<h4 class="card-title">-->
                                <#--<a href="#">Item Five</a>-->
                            <#--</h4>-->
                            <#--<h5>$24.99</h5>-->
                            <#--<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur! Lorem ipsum dolor sit amet.</p>-->
                        <#--</div>-->
                        <#--<div class="card-footer">-->
                            <#--<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->

                <#--<div class="col-lg-4 col-md-6 mb-4">-->
                    <#--<div class="card h-100">-->
                        <#--<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>-->
                        <#--<div class="card-body">-->
                            <#--<h4 class="card-title">-->
                                <#--<a href="#">Item Six</a>-->
                            <#--</h4>-->
                            <#--<h5>$24.99</h5>-->
                            <#--<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>-->
                        <#--</div>-->
                        <#--<div class="card-footer">-->
                            <#--<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->

            <#--</div>-->
            <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

</div>