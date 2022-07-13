$(document)
.ready(function(){
	loadData();
})
.on('click',"#hotel",function(){
    a = $("#hotel option:selected").text();
    b = a.split("/");
    $("#name").val(b[0]);
    $("#type option:eq(0)").prop("selected",true);
    $("#hotel option").css('color','red');
    $("#people").val(b[2]);
    $("#price").val(b[3]);
    $("#btn1").text("등록");
})

.on('click',"#btn1",function(){
	if($('#btn1').text()=='추가'){
		if($('#name').val()!='' && $('#type').text()!='' && $('#people').val()!='' && $('#price').val()!=''){
			$.ajax({
      		type:'get',
      		url:'addhotel',
      		data:'&name='+$('#name').val()+'&type='+$('#type option:selected').val()+'&people='+$('#people').val()+
      		'&price='+$('#price').val(),
      		dataType:'text',
      		success:function(data){
			loadData();
         	$('#btn3').trigger('click');
      		},
      		error:function(){
      		},
      		complete:function(){
      		}
   		});
		}else{
			return;
		}
		
	}
	else if($('#btn1').text()=='등록'){
		a = $("#hotel option:selected").text();
		if($('#name').val()!='' && $('#type').text()!='' && $('#people').val()!='' && $('#price').val()!=''){
			$.ajax({
      		type:'get',
      		url:'hotelUpdate',
      		data:'&name='+$('#name').val()+'&type='+$('#type option:selected').val()+'&people='+$('#people').val()+
      		'&price='+$('#price').val()+'&hotel_num='+$('#hotel option:selected').val(),
      		dataType:'text',
      		success:function(data){
			loadData();
         	$('#btn3').trigger('click');
      		},
      		error:function(){
      		},
      		complete:function(){
      		}
   		});
		}
		else{
			return;
		}
	}
})

.on('click',"#btn2",function(){
	if($('#name').val()!='' && $('#type').text()!='' && $('#people').val()!='' && $('#price').val()!=''){
		let answer = confirm('정말로 지우시겠습니까?');
		if(!answer) return false;
		
		$.ajax({
			type:'get',
			url:'deletehotel',
			data:'&hotel_num='+$('#hotel option:selected').val(),
			dataType:'text',
			success:function(data){
				loadData();
         		$('#btn3').trigger('click');
	      	 },
		   	 error:function(){
		   		 alert('삭제 실패');
		      },complete:function(){
		      }
		})

		}else {
			return;
		}
})

.on('click',"#btn3",function(){
    $("#name").val('');
    $("#type").val('');
    $("#people").val('');
    $("#price").val('');
    $("#btn1").text("추가");
})

function loadData(){
	   $.ajax({
		   type:'get',
      	   url:'hotellist',
      	   dataType:'json',
      	 success:function(data){
			$('#hotel').empty();
			for(let i=0; i<data.length; i++){
				let jo=data[i];
				let str='<option value='+jo['hotel_num']+'>'+jo['hotelname']+'/'+jo['hoteltype']+'/'+jo['people']+
				'/'+jo['price']+'</option>';
				$('#hotel').append(str);
			}
      	 },
	   	 error:function(){
	      },complete:function(){
	      }
	   })
}
