$('#roles input:radio').click(function() {
	$('#roles input:checkbox').each(function(i, o) {
		$(this).removeAttr('checked');
	});
});

$('#roles input:checkbox').click(function() {
	$('#roles input:radio').each(function(i, o) {
		$(this).removeAttr('checked');
	});
});

$('button[data-type=CommandButton]').click(function() {
	var isEdit = $(this).attr('id') == 'edit';
	
	if ($('#username').val() == '') {
		$('#info .modal-body').html('请填写用户名！');
		$('#info').modal();
		return;
	}
	if ($('#passwd').val() == '' && !isEdit) {
		$('#info .modal-body').html('请填写登陆密码！');
		$('#info').modal();
		return;
	}
	if ($('#nameCN').val() == '') {
		$('#info .modal-body').html('请填写姓名！');
		$('#info').modal();
		return;
	}
	if ($('#roles input:checked').length == 0) {
		$('#info .modal-body').html('请选择用户角色！');
		$('#info').modal();
		return;
	}
	
	submitUser(isEdit);
});

function submitUser(isEdit) {
	var roleIds = '';
	$('#roles input:checked').each(function(i, o) {
		roleIds += $(o).val() + ',';
	});
	roleIds = roleIds.substr(0, roleIds.length - 1);
	
	var passwd = '';
	if (!isEdit || $('#passwd').val() != '') {
		passwd = MD5(MD5($('#passwd').val()));
	}
	
	$.post(isEdit ? 'edit.do' : 'new.do', {
		userId	 : $('#userId').val(),
		orgId 	 : $('#orgId').val(),
		username : $('#username').val(),
		passwd 	 : passwd,
		nameCN 	 : $('#nameCN').val(),
		nameEN 	 : $('#nameEN').val(),
		phone 	 : $('#phone').val(),
		email 	 : $('#email').val(),
		im 		 : $('#im').val(),
		roles	 : roleIds
	}, function(result) {
		if (result != '') {
			$('#err .modal-body').html(result);
			$('#err').modal();
		} else {
			$('#confirm .modal-body').html(isEdit ? '修改用户成功！' : '新增用户成功！');
			$('#confirm').modal();
		}
	});
}