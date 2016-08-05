$('input:checkbox').click(function() {
	if ($(this).is(':checked')) {
		for (var i = 0; i < excludedIds.length; i++) {
			if (excludedIds[i] == $(this).attr('id')) {
				excludedIds.splice(i, 1);
				break;
			}
		}
	} else {
		excludedIds.push($(this).attr('id'));
	}
});

$('#title').text($('#roles span.active').text());