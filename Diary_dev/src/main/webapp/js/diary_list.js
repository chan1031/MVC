
$(document).ready(function () {
	
	/****************************************************/
	// 목록조회 이벤트처리
	/****************************************************/
	$('#list').on('click', function () {
    	
		// 이전 조회리스트 초기화
    	$('#ajaxTable').html("");
    	
       	// jQuerry와 AJAX, 요청은 POST 방식이고 응답은 JSON
    	// URL을 "list"로 Setting
        $.ajax({
            url: 'list',
            type: 'post',
            data: {
              	searchTitleName: $('#searchTitleName').val()
            },
            dataType: 'JSON',
            success: function (data) {
            	var diaryListJSON = data;

                $.each(diaryListJSON, function (index, item) {
                    
            		var output = '';
                    output += '<tr>';
                    output += '    <td> <a href="javascript:">' + item.id + '</td>';
                    output += '    <td>' + item.title + '</td>';
                    output += '    <td>' + item.writeDate + '</td>';
                    output += '</tr>';
                    $('#ajaxTable').append(output);
                    
                });
            	
            }
        });

      }); //list

    
	/****************************************************/
    // Open 시 자동 조회 처리
	/****************************************************/
	$('#list').trigger('click');
	
	
	/****************************************************/
    // keyup 시  자동 조회 처리
	/****************************************************/
    $('#searchTitleName').on('keyup', function (event) {

    	// if(event.which == 13) {
    		// return
    	// }
		$('#list').trigger('click');
   }); // keyup
	

	/****************************************************/
    // 추가 이벤트 처리
	/****************************************************/
    $('#add').on('click', function () {

    	// URL을 "add"로 Setting, submit
    	$('#form1').attr('action', "add");
    	$('#form1').submit();
    }); // add



	/****************************************************/
    // 편집 이벤트 처리

    $('#ajaxTable').on('click', 'a', function () {

    	// 선택한 id 값
    	var id = $(this).text();
    	$('#id').attr('value', id);
    	// id action을 "add"로 Setting, submit
    	$('#form1').attr('action', "edit");
    	$('#form1').submit();
    	
    	
      }); // edit


}); // ready
