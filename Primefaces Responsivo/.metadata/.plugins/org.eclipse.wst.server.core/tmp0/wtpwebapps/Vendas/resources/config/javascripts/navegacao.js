//$(document).ready(function() {
	
//	$('.ve-teste').bind('click', function() {
//		$('.ve-teste').toggleClass('is-selecionado');
		
//	});
	
//});
$(document).ready(function(){
    $("ul li:first").click(function(){
    	$(".ve-menuLateralInterno > li:first").toggleClass('is-selecionado');
    });
});

