$(function () {
   // solving the active menu problem (button lights)
   switch (menu) {
       case 'About':
           $('#about').addClass('active');
           break;
       case 'Contact':
           $('#contact').addClass('active');
           break;
       case 'All Products':
           $('#allproducts').addClass('active');
           break;
       case 'Manage Products':
           $('#manageproducts').addClass('active');
           break;
       default:
           $('#home').addClass('active');
           $('#a_'+menu).addClass('active');
           break;
   }

   // code for jquery table

    // create a dataset (for testing)
    // var products =
    //     [
    //         ['1',"ABC"],
    //         ['2',"DFS"],
    //         ['3',"GFD"],
    //         ['4',"SSS"],
    //         ['5',"PRO"],
    //         ['6',"QWE"],
    //         ['7',"KOP"],
    //         ['8',"LOP"],
    //         ['9',"LOP"]
    // ];

   // using char $ - because indicating in jquery element
    // productListTable - id Data Tables object in the allproducts.ftl
   var $table = $('#productListTable');

   // execute the below code only where we have this table
    if($table.length) {
        // console.log('test string in console');

        // getting JSON url for dataTable
        // if categoryId = '' will show all products category else - products by category id
        var jsonUrl = '';
        if(window.categoryId == '') {
            jsonUrl = window.contextRoot + '/json/data/all/products';
        } else{
            jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
        }
        $table.DataTable({

            // configure show expandable list
            lengthMenu: [[3,5,10,-1],["3 products","5 products","10 products","all products"]],
            pageLength: 5, // default
            // data: products // for testing
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                // name of the date: according to the structure JSON/dto objects 'Category'
                {
                    data: 'code',
                    mRender: function (data,type,row) {
                        return '<img ' +
                            //loading static resources
                            'src ="' + window.contextRoot +'/resources/images/'+ data +'.jpg" ' +
                            // to get little (custom) size
                            'style="width:100px;height:100px;"/>'
                    }
                },
                {
                    data: 'name'
                },
                {
                    data: 'description',
                    bSortable: false
                },
                {
                    data: 'unitPrice',
                    mRender: function (data,type,row) {
                        return data + ' UAH';
                    }
                },
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data,type,row) {
                        var str = '';

                        // here added buttons icons(eye and cart icon)
                        str += '<a href="' + window.contextRoot + '/show/'+data+'/product" ' +
                            'class="btn btn-primary">' +
                            '<span class="fas fa-eye"></span>' +
                            '</a> &#160;'; // &#160; gives space between elements

                        str += '<a href ="' + window.contextRoot + '/cart/add/'+data+'/product" ' +
                            'class="btn btn-success">' +
                            '<span class="fas fa-shopping-cart"></span>' +
                            '</a>';

                        return str;
                    }
                }
            ]
        });
    }

    // dismissing alert after 3 seconds
    var $alert = $('.alert');
    if ($alert.length){
        setTimeout(function() {
            $alert.fadeOut('slow');
        },3000)
    }
});