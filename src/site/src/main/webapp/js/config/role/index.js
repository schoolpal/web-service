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
	$.post('role/segment.html', {
		orgId : $(this).attr('id')
	}, function(roles) {
		$('#roles').html(roles);
	});
});

$('#7-2-1').click(function() {
	location.href = $(this).attr('data-action') + '?orgId=' + $('section .row > div:nth-child(1) .active').attr('id');
});

$('#7-2-2').click(function() {
	if ($('input:checked').size() == 0) {
		$('#info .modal-body').html('请选择需要编辑的角色！');
		$('#info').modal();
	} else {
		location.href = $(this).attr('data-action') 
			+ '?orgId=' + $('section .row > div:nth-child(1) .active').attr('id') 
			+ '&roleId=' + $('input:checked').attr('id');
	}
});

$('#7-2-3').click(function() {
	if ($('input:checked').size() == 0) {
		$('#info .modal-body').html('请选择需要删除的角色！');
		$('#info').modal();
	} else {
		var id = $('input:checked').attr('id');
		$('#confirm .modal-body').html('是否确认删除角色！<br/><strong>' + $('tr[data-role="' + id + '"] > td:nth-child(4)').text() + '</strong>');
		$('#confirm').modal();
	}
});

$('#btnConfirm').click(function() {
	$('#info').modal('hide');
	$.post($('#7-2-3').attr('data-action'), { 
		roleId: $('input:checked').attr('id') 
	}, function(result) {
		if (result != '') {
			$('#err .modal-body').html(result);
			$('#err').modal();
		} else {
			location.href = location.href;
		}
	});
});