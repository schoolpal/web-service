$(function() {
	$.get('org/segment.html?' + Math.random(), function(orgs) {
		$('#orgs').html(orgs);
		
		$('td span.glyphicon').click(function() {
			var isPlusClass = $(this).hasClass('glyphicon-plus-sign');
			$(this).removeClass(isPlusClass ? 'glyphicon-plus-sign' : 'glyphicon-minus-sign');
			$(this).addClass(isPlusClass ? 'glyphicon-minus-sign' : 'glyphicon-plus-sign');
			
			var parentIds = new Array($(this).attr('id'));
			$('tr[data-group][class="father"]').each(function(i, o) {
				var id = $(o).find('input').attr('id');
				if ($.inArray($(o).attr('data-group'), parentIds) != -1 
					&& $.inArray(id, parentIds) == -1) {
					parentIds.push(id);
				}
			});
			
			$.each(parentIds, function(i, o) {
				var tr = $('tr[data-group="' + o + '"]');
				$(tr).find('td span.glyphicon').removeClass(isPlusClass ? 'glyphicon-plus-sign' : 'glyphicon-minus-sign');
				$(tr).find('td span.glyphicon').addClass(isPlusClass ? 'glyphicon-minus-sign' : 'glyphicon-plus-sign');
				if (isPlusClass) {
					$(tr).show();
				} else {
					$(tr).hide();
				}
			});
		});
	});
});

$('#7-1-2').click(function() {
	if ($('input:checked').size() == 0) {
		$('#info .modal-body').html('请选择需要编辑的机构！');
		$('#info').modal();
	} else {
		location.href = $(this).attr('data-action') + '?id=' + $('input:checked').attr('id');
	}
});

$('#7-1-3').click(function() {
	if ($('input:checked').size() == 0) {
		$('#info .modal-body').html('请选择需要删除的机构！');
		$('#info').modal();
	} else {
		var id = $('input:checked').attr('id');
		$('#confirm .modal-body').html('是否确认删除机构！<br/><strong>' + $('span[data-org="' + id + '"]').text() + '</strong>');
		$('#confirm').modal();
	}
});

$('#btnConfirm').click(function() {
	$('#info').modal('hide');
	$.post($('#7-1-3').attr('data-action'), { 
		id: $('input:checked').attr('id') 
	}, function(result) {
		if (result != '') {
			$('#err .modal-body').html(result);
			$('#err').modal();
		} else {
			location.href = location.href;
		}
	});
});