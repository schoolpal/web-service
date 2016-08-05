$('button[data-type="LinkButton"]').click(function() {
	location.href = $(this).attr('data-action');
});

$('button[data-type="CancelButton"]').click(function() {
	history.back(-1);
});