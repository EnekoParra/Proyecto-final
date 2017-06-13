$(function() {
  $( "#autocomplete" ).autocomplete({
      source: function( request, response ) {
        $.ajax( {
          url: "/formacion/api/cursos?filtro=" + $("#autocomplete").val(),
          dataType: "json",
          success: function( data ) {
        	var aString = [];
            $.each(data, function(index, curso){
            	aString.push({"label":curso.nombre, "value":curso.nombre + " || " +  curso.codigo});
        	});
            response( aString );
          }
        } );
      },
      minLength: 2
    } ); 
});

function buscador() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("buscador");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("tabla");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[0];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}

window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("subir").style.display = "block";
    } else {
        document.getElementById("subir").style.display = "none";
    }
}


function subir() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}

