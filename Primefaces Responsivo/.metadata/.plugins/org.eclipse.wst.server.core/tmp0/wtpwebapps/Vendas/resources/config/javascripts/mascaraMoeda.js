function configurarMoeda() {
	$(".js-moeda").maskMoney({ decimal: ",", thousands: ".", allowZero: true });
	}
	$(document).ready(function() {
		configurarMoeda();
	});
	