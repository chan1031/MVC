$(document).ready(function () {

	/****************************************************/
	// Open 시 입력모드 설정
	/****************************************************/
	$('#insert').attr('disabled', false);
	$('#update').attr('disabled', true);
	$('#delete').attr('disabled', true);
	

	/****************************************************/
	// 편집모드 시 자동조회
	/****************************************************/
		
	// 편집하기 위하여 선택한 id
	var id = $('#id').val();

	// Open 시 편집모드 설정
	if (id > "0") {
		$('#insert').attr('disabled', true);
		$('#update').attr('disabled', false);
		$('#delete').attr('disabled', false);
	}

	// jQuerry와 AJAX, 요청은 POST 방식이고 응답은 JSON
	// URL을 "select"로 Setting
	$.ajax({
		url: 'select',
		type: 'post',
		data: {
			id: $('#id').val()
		},
		dataType: 'JSON',
		success: function (data) {
			var DiaryJSON = data;
//			// 배열로 받음
//			$(accountTransferJSON).each(function (index, item) {
//			$('#id').val(item.id);
//			$('#fromAccountNumber').val(item.fromAccountNumber);
//			$('#toAccountNumber').val(item.toAccountNumber);
//			$('#transferDate').val(item.transferDate);
//			$('#transferAmmount').val(item.transferAmmount);

			// 객체로 받음
			$.each(DiaryJSON, function (key, value) {
//				if (key == "id") {
//				$('#id').val(value);
//				}
				if (key == "title") {
					$('#title').val(value);
				}
				if (key == "writeDate") {
					$('#writeDate').val(value);
				}
				if (key == "content") {
					$('#content').val(value);
				}
			});

		}
	});

	
	/****************************************************/
	// 입력 이벤트처리
	/****************************************************/
	$('#insert').on('click', function () {
		
		// jQuerry와 AJAX 처리함수  호출
		requestDiary("insert");
		
	}); // insert
	
	
	/****************************************************/
	// 수정 이벤트처리
	/****************************************************/
    $('#update').on('click', function () {
    	
       	// jQuerry와 AJAX 처리함수  호출
    	requestDiary("update");
    	
    }); // udpate

    
	/****************************************************/
	// 삭제 이벤트처리
	/****************************************************/
    $('#delete').on('click', function () {
    	
    	result = confirm("정말로 삭제하시겠습니까 ?");

    	if(result != true){
    		return;
    	} 
    	
       	// jQuerry와 AJAX 처리함수  호출
    	requestDiary("delete");
    	
    }); // delete

    
	/****************************************************/
	// 돌아가기 이벤트처리
	/****************************************************/
    $('#back').on('click', function () {
    	
    	// action을 "back"로 Setting, submit
    	$('#form1').attr('action', "list_open");
    	$('#form1').submit();
    }); // back
    
    
    /****************************************************/
	// 입력, 수정, 삭제  jQuerry와 AJAX 공통처리
    /****************************************************/
    function requestDiary(action) {
  
    	
    	// jQuerry와 AJAX, 요청은 POST 방식이고 응답은 JSON
        $.ajax({
            url: action,
            type: 'post',
            data: {
//              	action: $('#action').val(),
            	id: $('#id').val(),
            	title: $('#title').val(),
            	writeDate: $('#writeDate').val(),
            	content: $('#content').val(),
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
              	$('#form1').attr('action', "list_open");
            	$('#form1').submit();
            }
        });

    } // requestAccountTransfer
});


