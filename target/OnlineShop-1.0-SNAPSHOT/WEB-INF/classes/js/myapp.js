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
       default:
           $('#home').addClass('active');
           $('#a_'+menu).addClass('active');
           break;
   }

   // code for jquery table
    // create a dataset (for testing)
    var products =
        [
            ['1',"ABC"],
            ['2',"DFS"],
            ['3',"GFD"],
            ['4',"SSS"],
            ['5',"PRO"],
            ['6',"QWE"],
            ['7',"KOP"],
            ['8',"LOP"]
    ];

   // using char $ - because indicating in jquery element
    // productListTable - id Data Tables object in the allproducts.ftl
   var $table = $('#productListTable');

   // execute the below code only where we have this table
    if($table.length) {
        // console.log('Inside the table!');
        $table.DataTable({

            // configure show expandable list
            lengthMenu: [[3,5,10,-1],["3 products","5 products","10 products","all products"]],
            pageLength: 5, // default
            data: products
        });
    }

});