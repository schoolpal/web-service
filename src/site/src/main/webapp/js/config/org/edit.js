$(function() {
	$('#state option').each(function(i, o) {
		if ($(o).text() == stateVal) {
			$(o).attr('selected', true);
			$(o).parent().change();
			return false;
		}
	});
	$('#city option').each(function(i, o) {
		if ($(o).text() == cityVal) {
			$(o).attr('selected', true);
			$(o).parent().change();
			return false;
		}
	});
	$('#county option').each(function(i, o) {
		if ($(o).text() == countyVal) {
			$(o).attr('selected', true);
			return false;
		}
	});
});

function modOrg() {
	$.post('mod.do', {
		id: orgId,
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
			$('#confirm .modal-body').html("修改组织机构成功！");
			$('#confirm').modal();
		}
	});
}

