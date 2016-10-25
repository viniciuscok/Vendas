$(document).ready(function() {
	
	$('.js-botaoMudarMenu').bind('click', function() {
		$('.js-menuLateral').toggleClass('is-selecionado');
		$('.js-corpo').toggleClass('is-selecionado');
	});
	
});