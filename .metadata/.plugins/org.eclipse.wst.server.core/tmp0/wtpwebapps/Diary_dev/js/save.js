
$(document).ready(function () {
    
	$('#submit').on('click', function () {
		// jQuerry와 AJAX, 요청은 POST 방식이고 응답은 JSON
        $.ajax({
            url: 'memberSave',
            type: 'post',
            data: {
            	memberId: $('#memberId').val(),
            	memberPw: $('#memberPw').val(),
            	memberName: $('#memberName').val(),
            },
            dataType: 'JSON',
            success: function (data) {
            	var atResponse = data;
            	// 객체로 받음
                $.each(atResponse, function (key, value) {
                	
                	if(key == "message" && value == "") {
                		alert(action + "가 처리되었습니다.");
                	} 
                	// message 존재 시
                	if(key == "message" && value != "") {
                		alert(action + " 시 오류가 발생하였습니다. : " + value);
                	}
               	});
                
            	// URL을 "list_open"로 Setting, submit
              	$('#form1').attr('action', "login");
            	$('#form1').submit();
            }
        });

		
	}); 
	


}); 
