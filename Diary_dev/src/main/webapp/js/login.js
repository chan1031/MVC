$(document).ready(function() {

	$('#submit2').on('click', function() {
		// jQuerry와 AJAX, 요청은 POST 방식이고 응답은 JSON
		$.ajax({
			url : 'do_login',
			type : 'post',
			data : {
				// action: $('#action').val(),
				memberId : $('#memberId').val(),
				memberPw : $('#memberPw').val()
			},
			dataType : 'JSON',
			success : function(response) {
				if (response.status == "success") {
					alert('Login successful');
					window.location.href = "./list_open";
				} else {
					alert('Login failed: ');
					// 로그인이 실패했을 때의 추가 동작을 수행할 수 있습니다.
				}
			},
			error : function() {
				alert('Error during login request');
				// Ajax 요청이 실패했을 때의 동작을 수행할 수 있습니다.
			}

		});

	});

});