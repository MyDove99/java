let room;
let hotelnum;
let date;
let onprice;
let start;
let end;
let peo;
$(document)
.ready(function(){
loadRoom();
})
.on('click',"#btn1",function(){
	if($('#date1').val()==''){
		alert("체크인이 없습니다");
		return;
	} else if($('#date2').val()==''){
		alert("체크아웃이 없습니다");
		return;
	} else if($('#people1').val()==''){
		alert("숙박인원이 없습니다");
		return;
	}else if($('#date1').val()!='' && $('#date2').val()!='' && $('#people1').val()!='' && $('#room1').text()!=''){
			$.ajax({
      		type:'get',
      		url:'orderlist',
      		data:'&checkin='+$('#date1').val()+'&checkout='+$('#date2').val()+'&bpeople='+$('#people1').val()+
      		'&hoteltype='+$('#room1').val(),
      		dataType:'json',
      		success:function(data){
			$('#order').empty();
			for(let i=0; i<data.length; i++){
				let jo=data[i];
				let str='<option value='+jo['preorder']+'>'+jo['hotelname']+"/"+jo['leader']+"/"+
					jo['mobile']+"/"+jo['checkin']+"/"+jo['checkout']+"/"+jo['bpeople']+"/"+jo['price']+"/"+jo['people']+'</option>';
				$('#order').append(str);
			}
      		},
      		error:function(){
      		},
      		complete:function(){
      		}
   		});
   		  $.ajax({
      		type:'get',
      		url:'notlist',
      		data:'&checkin='+$('#date1').val()+'&checkout='+$('#date2').val()+
      		'&hoteltype='+$('#room1').val(),
      		dataType:'json',
      		success:function(data){
			$('#hotel1').empty();
			for(let i=0; i<data.length; i++){
				let jo=data[i];
				let str='<option value='+jo['hotel_num']+'>'+jo['hotelname']+"/"+jo['roomname']+"/"+
					jo['people']+"/"+jo['price']+'</option>';
				$('#hotel1').append(str);
			}
      		},
      		error:function(){
      		},
      		complete:function(){
      		}
   		});
		}else{
			return;
		}
	$('#date3').val($('#date1').val());
	$('#date4').val($('#date2').val());
	room = $('#room1').val();
})

.on('click',"#hotel1",function(){
    a = $("#hotel1 option:selected").text();
    b = a.split("/");
    $("#roomname").val(b[0]);
    $("#room2").val(room).prop("selected", true);
    $("#people").val(b[2]);
    $("#price").val(b[3]);
    hotelnum=$("#hotel1 option:selected").val();
    onprice = $("#price").val();
    $("#ordernum").val('');
	$('#date3').val($('#date1').val());
	$('#date4').val($('#date2').val());
    $("#leader").val('');
    $("#mobile").val('');
    $("#btn2").text("예약등록");
    c=parseInt(b[2]);
    peo = c;
    
    a = new Date($("#date3").val());
	b = new Date($("#date4").val());
	c = Math.abs(b-a);
	d = c/(1000*3600*24)
	if(d==0){
		f = onprice / 2;
	}else{
		f = onprice * d;
	}
	$("#price").val(f);
})

.on('click',"#order",function(){
    a = $("#order option:selected").text();
    b = a.split("/");
    $("#ordernum").val($("#order option:selected").val());
    $("#roomname").val(b[0]);
    $("#room2").val(room).prop("selected", true);
    $("#people").val(b[5]);
    $("#price").val(b[6]);
    $("#date3").val(b[3]);
    $("#date4").val(b[4]);
    $("#leader").val(b[1]);
    $("#mobile").val(b[2]);
    $("#btn2").text("예약수정");
    onprice=$("#price").val();
    
    c=parseInt(b[7]);
    peo = c;
})

.on('click',"#btn2",function(){
	a=parseInt($('#people').val());
	if($("#btn2").text()=="예약등록"){
		if($('#date3').val()==''){
		alert("체크인이 없습니다");
		return;
	} else if($('#date4').val()==''){
		alert("체크아웃이 없습니다");
		return;
	} else if($('#people').val()==''){
		alert("숙박인원이 없습니다");
		return;
	}else if($('#leader').val()==''){
		alert("대표자가 없습니다");
		return;
	}else if($('#mobile').val()==''){
		alert("모바일 번호가 없습니다");
		return;
	}else if(a>peo){
		alert("예정인원이 방 최대인원보다 많습니다.");
		return;
	}else if($('#roomname').val()!='' && $('#room2').text()!='' && $('#people').val()!='' && $('#checkin').val()!=''&& $('#checkin').val()!=''
		&& $('#checkout').val()!=''&& $('#leader').val()!=''&& $('#mobile').val()!=''&& $('#price').val()!='')
	{
		$.ajax({
      	type:'get',
      	url:'orderadd',
      	data:'&hotel_num='+hotelnum+'&type='+$('#room2 option:selected').val()+'&bpeople='+$('#people').val()+
      	'&checkin='+$('#date3').val()+'&checkout='+$('#date4').val()+'&leader='+$('#leader').val()+
      	'&mobile='+$('#mobile').val()+'&bprice='+$('#price').val(),
      	dataType:'text',
      	success:function(data){
		loadhotel()
		loadData()
        $('#btn4').trigger('click');
      	},
      	error:function(){
      	},
      	complete:function(){
      	}
   		});
	}
	}else if($("#btn2").text()=="예약수정"){
		if($('#date3').val()==''){
		alert("체크인이 없습니다");
		return;
	} else if($('#date4').val()==''){
		alert("체크아웃이 없습니다");
		return;
	} else if($('#people').val()==''){
		alert("숙박인원이 없습니다");
		return;
	}else if($('#leader').val()==''){
		alert("대표자가 없습니다");
		return;
	}else if($('#mobile').val()==''){
		alert("모바일 번호가 없습니다");
		return;
	}else if(a>peo){
		alert("예정인원이 방 최대인원보다 많습니다.");
		return;
	}else if($('#roomname').val()!='' && $('#room2').text()!='' && $('#people').val()!='' && $('#checkin').val()!=''&& $('#checkin').val()!=''
		&& $('#checkout').val()!=''&& $('#leader').val()!=''&& $('#mobile').val()!=''&& $('#price').val()!='')
	{
		$.ajax({
      	type:'get',
      	url:'orderupdate',
      	data:'&bpeople='+$('#people').val()+'&checkin='+$('#date3').val()+
      	'&checkout='+$('#date4').val()+'&leader='+$('#leader').val()+
      	'&mobile='+$('#mobile').val()+'&bprice='+$('#price').val()+
      	'&preorder='+$('#ordernum').val(),
      	dataType:'text',
      	success:function(data){
	loadhotel()
		loadData()
        $('#btn4').trigger('click');
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
})

.on('click',"#btn3",function(){
	if($('#ordernum').val()!='' && $('#roomname').val()!=''){
		let answer = confirm('예약을 취소합니까?');
		if(!answer) return false;
		
		$.ajax({
			type:'get',
			url:'orderdelete',
			data:'&preorder='+$('#ordernum').val(),
			dataType:'text',
			success:function(data){
				loadhotel()
				loadData();
         		$('#btn4').trigger('click');
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

.on('click',"#btn4",function(){
	$("#ordernum").val('');
    $("#roomname").val('');
    $("#room2").val('');
    $("#people").val('');
    $("#date3").val('');
    $("#date4").val('');
    $("#leader").val('');
    $("#mobile").val('');
    $("#price").val('');
    $("#btn2").text("예약등록");
})

$("#people1").change( function() {
	if($("#people1").val()<1){
		alert("숙박인원이 1보다 작습니다.");
		$("#people1").val("1");
	}
})

$("#date1 , #date2").change( function() {
    a = new Date($("#date1").val());
	b = new Date($("#date2").val());
	if(a>b){
		alert("체크인 날짜가 체크아웃보다 큽니다.");
		$("#date1").val('');
		$("#date2").val('');
	}
})

$("#date3 , #date4").change( function() {
    a = new Date($("#date3").val());
	b = new Date($("#date4").val());
	if(a>b){
		alert("체크인 날짜가 체크아웃보다 큽니다.");
		$("#date3").val('');
		$("#date4").val('');
	}
})

function loadhotel(){
	   $.ajax({
      		type:'get',
      		url:'notlist',
      		data:'&checkin='+$('#date1').val()+'&checkout='+$('#date2').val()+
      		'&hoteltype='+$('#room1').val(),
      		dataType:'json',
      		success:function(data){
			$('#hotel1').empty();
			for(let i=0; i<data.length; i++){
				let jo=data[i];
				let str='<option value='+jo['hotel_num']+'>'+jo['hotelname']+"/"+jo['roomname']+"/"+
					jo['people']+"/"+jo['price']+'</option>';
				$('#hotel1').append(str);
			}
      		},
      		error:function(){
      		},
      		complete:function(){
      		}
   		})
}

function loadData(){
	   $.ajax({
      		type:'get',
      		url:'orderlist',
      		data:'&checkin='+$('#date1').val()+'&checkout='+$('#date2').val()+'&bpeople='+$('#people1').val()+
      		'&hoteltype='+$('#room1').val(),
      		dataType:'json',
      		success:function(data){
			$('#order').empty();
			for(let i=0; i<data.length; i++){
				let jo=data[i];
				let str='<option value='+jo['preorder']+'>'+jo['hotelname']+"/"+jo['leader']+"/"+
					jo['mobile']+"/"+jo['checkin']+"/"+jo['checkout']+"/"+jo['bpeople']+"/"+jo['price']+"/"+jo['people']+'</option>';
				$('#order').append(str);
			}
      		},
      		error:function(){
      		},
      		complete:function(){
      		}
   		})
}

function loadRoom(){
	   $.ajax({
		   type:'get',
      	   url:'roomlist',
      	   dataType:'json',
      	 success:function(data){
			$('#room1').empty();
			$('#room2').empty();
			for(let i=0; i<data.length; i++){
				let jo=data[i];
				let str='<option value='+jo['typenum']+'>'+jo['hotel_type']+'</option>';
				$('#room1').append(str);
				$('#room2').append(str);
			}
      	 },
	   	 error:function(){
	      },complete:function(){
	      }
	   })
}
