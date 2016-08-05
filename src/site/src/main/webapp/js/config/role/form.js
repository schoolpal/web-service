$('#funcs li:not(:last-child) input').click(function() {
	if ($('#funcs li:not(:last-child) input:checked').length == 0
		&& $('#roles li:not(:last-child) input:checked').length == 0) {
		$('#funcs li:last-child input').removeAttr('disabled');
	} else {
		$('#funcs li:last-child input').removeAttr('checked');
		$('#funcs li:last-child input').attr('disabled', 'disabled');
	}
	
	if ($('#roles li:not(:last-child):not(:first-child) input:checked').length > 0) {
		var selectedText = $(this).parent().text();
		$('#funcs li:not(:last-child) input').each(function(i, o) {
			if (selectedText != $(o).parent().text()) {
				$(o).removeAttr('checked');
			}
		});
	}
});

$('#funcs li:last-child input').click(function() {
	$('#roles li:nth-child(4) input').click();
});

$('#roles li:not(:last-child) input').click(function() {
	$('#funcs li:last-child input').removeAttr('checked');
	$('#funcs li:last-child input').attr('disabled', 'disabled');
	$('#funcs li:not(:last-child) input').each(function(i, o) {
		$(o).removeAttr('disabled');
	});
	
	var selectedText = $(this).parent().text();
	if ($('#roles li:nth-child(2)').text() == selectedText
		|| $('#roles li:nth-child(3)').text() == selectedText) {
		$('#funcs li:not(:last-child) input:checked').each(function(i, o) {
			if (i != 0) {
				$(o).removeAttr('checked');
			}
		});
	}
});

$('#roles li:nth-child(4) input').click(function() {
	$('#funcs li:last-child input').removeAttr('disabled');
	if (!$('#funcs li:last-child input').is(':checked')) {
		$('#funcs li:last-child input').click();
	}
	$('#funcs li:not(:last-child) input').each(function(i, o) {
		$(o).attr('checked', false);
		$(o).attr('disabled', 'disabled');
	});
});

$('button[data-type="CommandButton"]').click(function() {
	if ($('#funcs li input:checked').length == 0) {
		$('#info .modal-body').html('请选择角色职能！');
		$('#info').modal();
		return;
	}
	if ($('#roles li input:checked').length == 0) {
		$('#info .modal-body').html('请选择角色职级！');
		$('#info').modal();
		return;
	}
	if ($('#name').val() == '') {
		$('#info .modal-body').html('请填写角色名称！');
		$('#info').modal();
		return;
	}
	
	switch ($(this).attr('id')) {
	case 'new':
		submitRole('new.do', '新增角色成功！');
		break;
	case 'edit':
		submitRole('mod.do', '编辑角色成功！');
		break;
	}
});

function submitRole(url, successTip) {
	var funcIds = '';
	$('#funcs input:checked').each(function(i, o) {
		funcIds += $(o).val() + ',';
	});
	funcIds = funcIds.substr(0, funcIds.length - 1);
	
	$.post(url, {
		id : $('#roleId').val(),
		orgId : $('#orgId').val(),
		strFuncIds : funcIds,
		rankId : $('#roles input:checked').val(),
		name : $('#name').val(),
		desc : $('#desc').val()
	}, function(result) {
		if (result != '') {
			$('#err .modal-body').html(result);
			$('#err').modal();
		} else {
			$('#confirm .modal-body').html(successTip);
			$('#confirm').modal();
		}
	});
}