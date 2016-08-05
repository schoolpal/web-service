$(function() {
	$(china).each(function(i, o) {
		$('<option value="' + i + '">' + o.province + '</option>').appendTo('#province');
	});
});

$('#province').change(function() {
	var ind = $(this).find('option:selected').val();
	$('#city').empty();
	$('#county').empty();
	if (ind != 0) {
		$.each($(china)[ind].cities, function(i, o) {
			$('<option value="' + i + '">' + o.city + '</option>').appendTo('#city');
		});
	}
});

$('#city').change(function() {
	var pInd = $('#province').find('option:selected').val();
	var ind = $(this).find('option:selected').val();
	$('#county').empty();
	if (ind != 0) {
		$.each($(china)[pInd].cities[ind].county, function(i, o) {
			$('<option value="' + i + '">' + o + '</option>').appendTo('#county');
		});
	}
});

$('section li:nth-child(3) span').click(function() {
	$.get('newSegment.html', function(page) {
		$('#orgList .orgsection').html(page);
		$('#orgList .orgsection a').click(function(e) {
			$('#parent').val($(this).text());
			$('#parent').attr('data-id', $(this).attr('id'));
			$('#orgList').modal('hide');
			e.preventDefault();
		});
	});
	$('#orgList').modal();
});

$('button[data-type="CommandButton"]').click(function() {
	if ($.trim($('#name').val()) == '') {
		$('#info .modal-body').html('请填写正确的组织名称！');
		$('#info').modal();
		return;
	}
	if ($.trim($('#code').val()) == '') {
		$('#info .modal-body').html('请填写正确的组织代码！');
		$('#info').modal();
		return;
	}
	if ($.trim($('#parent').val()) == '') {
		$('#info .modal-body').html('请选择父级组织！');
		$('#info').modal();
		return;
	}
	if (!validArea()) {
		return;
	}
	if ($.trim($('#address').val()) == '') {
		$('#info .modal-body').html('请填写正确的地址信息！');
		$('#info').modal();
		return;
	}
	if ($.trim($('#owner').val()) == '') {
		$('#info .modal-body').html('请填写正确的负责人！');
		$('#info').modal();
		return;
	}
	if ($.trim($('#phone').val()) == '') {
		$('#info .modal-body').html('请填写正确的联系电话！');
		$('#info').modal();
		return;
	}
	
	switch ($(this).attr('id')) {
	case 'new':
		addOrg();
		break;
	case 'mod':
		modOrg();
		break;
	}
});

function validArea() {
	var areaValid = true;
	$('#area select').each(function(i, o) {
		if ($(o).find('option:selected').val() == 0) {
			var errMsg = '地区信息不完整，';
			switch (i) {
			case 0:
				errMsg += '请选择省/直辖市！'; break;
			case 1:
				errMsg += '请选择城市！'; break;
			case 2:
				errMsg += '请选择区县！'; break;
			}

			$('#info .modal-body').html(errMsg);
			$('#info').modal();
			
			areaValid = fasle;
			return false;
		}
	});
	return areaValid;
}

var china = 
[
 	{
 		province: '省/直辖市...',
 	},
    {
    	province: '直辖市',
    	cities:
    	[
    	    {
    	    	city: '城市...'
    	    },
    	 	{
    	 		city: '北京市',
    	 		county: 
    	 		[
    	 		 	'区县...',
    	 		    '朝阳区',
    	 		    '海淀区',
    	 		    '门头沟'
    	 		]
    	 	},
    	 	{
    	 		city: '天津市',
    	 		county: 
    	 		[
    	 		    '区县...',
    	 		    '河西区',
    	 		]
    	 	}
    	]
    },
    {
    	province: '江西省',
    	cities:
    	[
			{
				city: '城市...'
			},
    	 	{
    	 		city: '南昌市',
    	 		county: 
    	 		[
    	 		    '区县...',
    	 		    '东湖区',
    	 		    '西湖区',
    	 		    '进贤市',
    	 		    '安义县'
    	 		]
    	 	},
    	 	{
    	 		city: '赣州市',
    	 		county: 
    	 		[
    	 		    '区县...',
    	 		    '章贡区',
    	 		    '宁都县',
    	 		    '瑞金市'
    	 		]
    	 	}
    	]
    }
];