$(function() {
	if (self != top) {
		parent.document.location.reload();
	}
});

$('#btnLogin').click(function(e) {
	$('#name').attr('disabled', 'disabled');
	$('#pwd').attr('disabled', 'disabled');
	$(this).attr('disabled', 'disabled');
	
    $.post('login/salt.do', null, function(salt) {
    	$.post('login/access.do', {
    			'username': $('#name').val(),
    			'mixedPWD': MD5(MD5(MD5($('#pwd').val()))+salt)
		}, 
		function(result) {
			if (result != '') {
				$('#err .modal-body').html(result);
				$('#err').modal();
				
    			$('#name').removeAttr('disabled');
    			$('#pwd').removeAttr('disabled');
    			$('#btnLogin').removeAttr('disabled');
			} else {
				$('form').submit();
			}
    	});
    });
    e.preventDefault();
});
