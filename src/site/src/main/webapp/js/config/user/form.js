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
	
	if ($('#loginName').val() == '') {
		$('#info .modal-body').html('请填写用户名！');
		$('#info').modal();
		return;
	}
	if ($('#loginPass').val() == '' && !isEdit) {
		$('#info .modal-body').html('请填写登陆密码！');
		$('#info').modal();
		return;
	}
	if ($('#realName').val() == '') {
		$('#info .modal-body').html('请填写姓名！');
		$('#info').modal();
		return;
	}
	if ($('#phone').val() == '') {
		$('#info .modal-body').html('请填写电话！');
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
	if (!isEdit || $('#loginPass').val() != '') {
		passwd = MD5(MD5($('#loginPass').val()));
	}
	
	$.post(isEdit ? 'edit.do' : 'new.do', {
		userId	 : $('#userId').val(),
		orgId 	 : $('#orgId').val(),
		loginName : $('#loginName').val(),
		loginPass 	 : passwd,
		realName 	 : $('#realName').val(),
		nickName 	 : $('#nickName').val(),
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