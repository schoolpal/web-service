function addOrg() {
	$.post('new.do', {
		Name: $('#name').val(),
		orgCode: $('#code').val(),
		parentId: $('#parent').attr('data-id'),
		state: $('#state option:selected').text(),
		city: $('#city option:selected').text(),
		county: $('#county option:selected').text(),
		address: $('#address').val(),
		owner: $('#owner').val(),
		phone: $('#phone').val()
	}, function(result) {
		if (result != '') {
			$('#err .modal-body').html(result);
			$('#err').modal();
		} else {
			$('#confirm .modal-body').html("新增组织机构成功！");
			$('#confirm').modal();
		}
	});
}

