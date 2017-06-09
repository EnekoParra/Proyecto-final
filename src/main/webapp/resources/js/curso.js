$(function() {
  $( "#autocomplete" ).autocomplete({
      source: function( request, response ) {
        $.ajax( {
          url: "/formacion/api/cursos?filtro=" + $("#autocomplete").val(),
          dataType: "json",
          success: function( data ) {
        	var aString = [];
            $.each(data, function(index, curso){
            	aString.push({"label":curso.nombre, "value":curso.nombre + " | " +  curso.codigo});
        	});
            response( aString );
          }
        } );
      },
      minLength: 2
    } ); 
});