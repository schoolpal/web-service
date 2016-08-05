$('.nav-pills > li').click(function() {
	if ($(this).hasClass('active')) {
		return;
	}
	
	$('.nav-pills > li').each(function(i, o) {
		$(o).removeClass('active');
	});
	$(this).addClass('active');
});

var lastMenuItem = null;
$('.collapse a').click(function(e) {
	if (lastMenuItem != null) {
		$(lastMenuItem).removeClass('bg-info');
	}
	lastMenuItem = $(this).parent();
	$(lastMenuItem).addClass('bg-info');
	
	$('iframe').attr('src', $(this).attr('href'));
	e.preventDefault();
});
