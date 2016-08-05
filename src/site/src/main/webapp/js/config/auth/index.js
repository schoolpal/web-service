$(function() {
	$('section .row > div:nth-child(1) > div:first-child .name').click();
});

$('section .row div:first-child span.glyphicon').click(function() {
	var isPlusClass = $(this).hasClass('glyphicon-plus-sign');
	$(this).removeClass(isPlusClass ? 'glyphicon-plus-sign' : 'glyphicon-minus-sign');
	$(this).addClass(isPlusClass ? 'glyphicon-minus-sign' : 'glyphicon-plus-sign');
	
	var parentIds = new Array($(this).next().attr('id'));
	$('section .row div[class="father"]').each(function(i, o) {
		var id = $(o).find('span.name').attr('id');
		if ($.inArray($(o).attr('data-group'), parentIds) != -1 
			&& $.inArray(id, parentIds) == -1) {
			parentIds.push(id);
		}
	});
	
	$.each(parentIds, function(i, o) {
		var div = $('div[data-group="' + o + '"]');
		if (isPlusClass) {
			$(div).show();
		} else {
			$(div).hide();
		}
	});
});

$('section .row > div:nth-child(1) .name').click(function() {
	$('section .row > div:nth-child(1) .name').each(function(i, o) {
		$(this).removeClass('active');
	});
	$(this).addClass('active');
	
	$('#selections').html('');
	
	$.post('auth/roleSegment.html', {
		orgId : $(this).attr('id')
	}, function(roles) {
		$('#roles').html(roles);
	});
});

$('#7-3-1').click(function() {
	$.post($(this).attr('data-action'), {
		'roleId' : $('#roles span.active').parent().attr('id'),
		'excludedIdString' : excludedIds.join(',')
	}, function(result) {
		if (result != '') {
			$('#err .modal-body').html(result);
			$('#err').modal();
		} else {
			$('#info .modal-body').html("授权成功，用户下次登录后即生效！");
			$('#info').modal();
		}
	});
});