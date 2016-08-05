$('section .row > div:nth-child(2) div span').click(function() {
	$('section .row > div:nth-child(2) div span').each(function(i, o) {
		$(this).removeClass('active');
	});
	$(this).addClass('active');
	
	$.post('auth/roleSelection.html', {
		roleId : $(this).parent().attr('id')
	}, function(selections) {
		$('#selections').html(selections);
	});
});