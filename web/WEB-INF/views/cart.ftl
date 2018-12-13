<#--Example-->
<#--https://bootsnipp.com/snippets/featured/responsive-shopping-cart-->

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
    <table id="cart" class="table table-hover table-condensed">
        <thead>
        <tr>
            <th style="width:30%">Product</th>
            <th style="width:20%">Description</th>
            <th style="width:10%">Price</th>
            <th style="width:8%">Quantity</th>
            <th style="width:22%" class="text-center">Subtotal</th>
            <th style="width:10%"></th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td data-th="Product">
                <div class="row">
                    <div class="col-sm-2 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive"/></div>
                </div>
            </td>
            <td data-th="Description">
                <div class="col-sm-10">
                    <h4 class="nomargin">Product 1</h4>
                    <p>Product description</p>
                </div>
            </td>

            <td data-th="Price">$1.99</td>
            <td data-th="Quantity">
                <input type="number" class="form-control text-center" value="1">
            </td>
            <td data-th="Subtotal" class="text-center">1.99</td>
            <td class="actions" data-th="">
                <button class="btn btn-info btn-sm"><span class="fa fa-refresh"></span></button>
                <button class="btn btn-danger btn-sm"><span class="fa fa-trash-o"></span></button>
            </td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td><a href="#" class="btn btn-warning"><span class="fa fa-angle-left"></span> Continue Shopping</a></td>
            <td colspan="2" class="hidden-xs"></td>
            <td class="hidden-xs text-center"><strong>Total $1.99</strong></td>
            <td><a href="#" class="btn btn-success btn-block">Checkout <span class="fa fa-angle-right"></span></a></td>
        </tr>
        </tfoot>
    </table>
</div>