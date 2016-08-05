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
	
	$('#title').text($(this).text());
	$.post('user/list.html', {
		orgId : $(this).attr('id')
	}, function(list) {
		$('#users').html(list);
	});
});

$('#7-4-1').click(function() {
	location.href = $(this).attr('data-action') + "?orgId=" + $('section .row > div:nth-child(1) .name.active').attr('id');
});

$('#7-4-2').click(function() {
	if ($('input:radio:checked').length == 0) {
		$('#err .modal-body').html("请选择要操作的用户！");
		$('#err').modal();
		return;
	}
	
	location.href = $(this).attr('data-action') 
		+ "?userId=" + $('input:radio:checked').attr('id')
		+ "&orgId=" + $('section .row > div:nth-child(1) .name.active').attr('id');
});

$('#7-4-3, #7-4-4, #7-4-5').click(function() {
	if ($('input:radio:checked').length == 0) {
		$('#err .modal-body').html("请选择要操作的用户！");
		$('#err').modal();
		return;
	}
	
	$.post($(this).attr('data-action'), {
		userId : $('input:radio:checked').attr('id')
	}, function(result) {
		if (result != '') {
			$('#err .modal-body').html(result);
			$('#err').modal();
		} else {
			$('section .row > div:nth-child(1) .name.active').click();
		}
	});
});