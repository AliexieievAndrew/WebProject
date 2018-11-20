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
});