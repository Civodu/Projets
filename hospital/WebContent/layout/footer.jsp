<script
  src="https://code.jquery.com/jquery-3.4.0.js"
  integrity="sha256-DYZMCC8HTC+QDr5QNaIcfR7VSPtcISykd+6eSmBW5qo="
  crossorigin="anonymous"></script>
  <script type="text/javascript">
  <%@include file="/asset/js/jquery-1.11.1.min.js" %>
  <%@include file="/asset/js/bootstrap.min.js" %>
  <%@include file="/asset/js/bootstrap-table.js" %>
  <%@include file="/asset/js/bootstrap-datepicker.js" %>
  $(function () {
      $('#hover, #striped, #condensed').click(function () {
          var classes = 'table';

          if ($('#hover').prop('checked')) {
              classes += ' table-hover';
          }
          if ($('#condensed').prop('checked')) {
              classes += ' table-condensed';
          }
          $('#table-style').bootstrapTable('destroy')
              .bootstrapTable({
                  classes: classes,
                  striped: $('#striped').prop('checked')
              });
      });
  });


  function rowStyle(row, index) {
      var classes = ['active', 'success', 'info', 'warning', 'danger'];

      if (index % 2 === 0 && index / 2 < classes.length) {
          return {
              classes: classes[index / 2]
          };
      }
      return {};
      
  }
  
</script>
  <script type="text/javascript">

      !function ($) {
          $(document).on("click","ul.nav li.parent > a > span.icon", function(){        
              $(this).find('em:first').toggleClass("glyphicon-minus");      
          }); 
          $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
      }(window.jQuery);

      $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
      })
      $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
      })

 </script>



					
     
   
   
 