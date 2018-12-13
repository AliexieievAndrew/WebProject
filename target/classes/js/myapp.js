$(function () {

    // for handling CSRF token
    // https://stackoverflow.com/questions/30012318/403-forbidden-invalid-csrf
    // var token = $('meta[name="_csrf"]').attr('content');
    // var header = $('meta[name="_csrf_header"]').attr('content');
    //
    // if((token!=undefined && header !=undefined) && (token.length > 0 && header.length > 0)) {
    //     // set the token header for the ajax request
    //     $(document).ajaxSend(function(e, xhr, options) {
    //         xhr.setRequestHeader(header,token);
    //     });
    // }


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

    /*
     * DataTable for admin
     */

    var $adminProductsTable = $('#adminProductsTable');
        var jsonUrl = window.contextRoot + "/json/data/admin/all/products";

        $adminProductsTable.DataTable ({
            lengthMenu: [[3,5,10,-1],["3 products","5 products","10 products","all products"]],
            pageLength: 5, // default
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                // column id
                {
                    data: 'id'
                },
                //column image (using code)
                {
                    data: 'code',
                    bSortable: false,
                    mRender: function (data,type,row) {
                        return '<img ' +
                            //loading static resources
                            'src ="' + window.contextRoot +'/resources/images/'+ data +'.jpg" ' +
                            // to get little (custom) size
                            'style="width:50px;height:50px;"/>'
                    }
                },
                //column name
                {
                    data: 'name'
                },
                // column description
                {
                    data: 'description',
                    bSortable: false
                },
                // column price
                {
                    data: 'unitPrice',
                    mRender: function (data,type,row) {
                        return data + ' UAH';
                    }
                },
                // column active
                {
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';

                        if (data){
                            // testing
                            str += '<label class="checkbox">';
                            str += '<input type="checkbox" checked = "checked" value="' + row.id + '"/>';
                            str += '<div class = "checkbox__text"/>';
                            str += '</label>';


                            // str += '<input type="checkbox" name = "'+ row.id +'" class="checkbox" id="'+ row.id +'" checked = "checked" value="'+ row.id +'"/>';
                        } else {

                            // testing
                            str += '<label class="checkbox">';
                            str += '<input type="checkbox" value="' + row.id + '"/>';
                            str += '<div class = "checkbox__text"/>';
                            str += '</label>';


                            // str += '<input type="checkbox" name = "'+ row.id +'" class="checkbox" id="'+ row.id +'" checked = "" value="'+ row.id +'"/>';
                        }
                        return str;
                    }
                },
                // column edit
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="'+window.contextRoot+'/manage/'+ data +'/product" class="btn btn-warning">'
                        str += '<span class="fas fa-edit"/>\n';
                        str += '</a>';
                        return str;
                    }
                }
            ],
            // initComplete must be used !!!
            // activation and deactivation product
            initComplete: function() {
                var api = this.api();
                console.log('test string in console');
                api.$('.checkbox input').on('change',function(){
                    var checkbox = $(this);
                    var value = checkbox.prop('value');

                    var activationUrl = window.contextRoot + '/manage/product/'+ value + '/activation';
                    $.post(activationUrl);
                });
            }
        });


    // --------------- jQuery Validation Code
    //methods required for validation
    function errorPlacement(error, element) {
        // Add the 'help-block' class to the error element
        error.addClass("help-block");

        // add the error label after the input element
        error.insertAfter(element);


        // add the has-feedback class to the
        // parent div.validate in order to add icons to inputs
        element.parents(".validate").addClass("has-feedback");

    }

    // --------------- validation code for the loginForm
    var $loginForm = $('#loginForm');
    if($loginForm.length){
        console.log('inside login form');
        $loginForm.validate({
            rules: {
                username: {
                    required: true,
                    email: true
                },
                password: {
                    required:true
                }
            },
            messages: {
                username: {
                    required: 'please enter email',
                    email: 'please enter valid email'
                },
                password: {
                    required: 'please enter the password'
                }
            },
            errorElement : "em",
            errorPlacement : function(error, element) {
                // Add the 'help-block' class to the error element
                error.addClass("help-block");

                // add the error label after the input element
                error.insertAfter(element);
            }
        });
    }
});