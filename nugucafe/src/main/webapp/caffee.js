let coffee=0;
let f=0;
let seqname=[];
let seqqty=[];
let seqprice=[];
let all=0;
let pp=0;

$(document)
.ready(function(){
	loadData();
})
.ready(function(){
    $("#dvMenu").dialog({
        autoOpen:false,
        width:600,
        height:500,
        open: function(event,ui){
	
	   $.ajax({
		   type:'get',
      	   url:'menulist',
      	   dataType:'json',
      	 success:function(data){
      		$('#selMenu1').empty();
			for(let i=0; i<data.length; i++){
				let jo=data[i];
				let str='<option>'+jo['name']+':'+jo['price']+'</option>';
				$('#selMenu1').append(str);
			}
      	 },
	   	 error:function(){
	      },complete:function(){
	      }
	   })
	   
        },
        close:function(event,ui){
            $('#coffee').empty();
            $('#selMenu1 option').each(function(){
                let str = '<option>'+$(this).text()+'</option>';
                $('#coffee').append(str);
            })
        }

    })
})
.on('click',"#coffee",function(){
    a = $("#coffee option:selected").text();
    b = a.split(":");
    c=b[1];
    cof=b[0];
    $("#cofme").val(cof);
    $("#cofco").val("1");
    $("#coffee option").css('color','red');
    $("#cofsel").val(c);
})

.on('click',"#cofco",function(){
	q = $("#coffee option:selected").text();
    a = $("#cofme").text();
    b=$("#cofco").val();
    b=parseInt(b);
    d = q.split(":");
    c=d[1];
    cof=d[0];

    $("#cofsel").val(b*c);
})

.on('click',"#btn1",function(){
    a = $("#cofme").val();
    b = $("#cofco").val();
    c = 0;
    let cof ='';
    let sell ='';
    c=$("#cofsel").val();
    cof=a;
    sell = cof + ' x ' + b + ' = ' + c + '원';
    c=parseInt(c);
    coffee = coffee + c;
    $("#cofsel").val(c);
    $("#call").append('<option>'+sell+'</option>');
    $("#sell").val(coffee);
    
    seqname.push($("#cofme").val());
    seqqty.push($("#cofco").val());
    seqprice.push($("#cofsel").val());

    $("#cofme").val('');
    $("#cofsel").val('');
    $("#cofco").val('');
})

.on('click',"#btn2",function(){
    $("#cofme").val('');
    $("#cofco").val('');
    $("#cofsel").val('');
})
.on('click',"#btn3",function(){
    c=$("#sell").val();
    seqcof='';
    seqqty2='';
    seqprice2='';
    for(var p=0; p<seqname.length; p++){
		seqcof=seqname[p];
		seqqty2=seqqty[p];
		seqprice2=seqprice[p];
			$.ajax({
		      	type:'get',
		      	url:'inadd',
		      	data:'&seqno='+seqcof+'&mobile='+$('#num').val()+'&qty='+seqqty2+'&price='+seqprice2,
		      	dataType:'text',
		      	success:function(data){
			         $.ajax({
						   type:'get',
				      	   url:'inlist',
				      	   dataType:'json',
				      	 success:function(data){
				      		$('#money').empty();
								for(let i=0; i<data.length; i++){
									let jo=data[i];
									let str='<option>'+jo['income_date']+"/"+jo['mobile']+"/"+jo['name']+"/"+jo['qty']+"/"+jo['price']+'</option>';
									$('#money').append(str);
									pp=parseInt(jo['price'])
									all=pp+all;
									$("#last").text(all);
								}
				      	 },
					   	 error:function(){
					      },complete:function(){
					      }
					   })
		      	},
		      	error:function(){
		      	},
		      	complete:function(){
		      	}
		   	});
	}
    d= a+'&nbsp;&nbsp;'+b+'&nbsp;&nbsp;'+c;
    $("#money").append('<option>'+d+'</option>');
    
    c=parseInt(c);
    f=f+c;
    seqname.splice(0,seqname.length);
    seqqty.splice(0,seqqty.length);
    seqprice.splice(0,seqprice.length);
    coffee=0;
    $("#num").val('');
    $("#sell").val('');
    $("#call option").remove();
})

.on('click',"#btn4",function(){
    $("#num").val('');
    $("#sell").val('');
    $('#call option').remove();
    coffee=0;
    seqname.splice(0,seqname.length);
    seqqty.splice(0,seqqty.length);
    seqprice.splice(0,seqprice.length);
})

.on('click',"#btn6",function(){
    $('#dvMenu').dialog("open");
})

.on('click',"#btnCancel",function(){
	$('#btnAdd').val('추가');
    $('#dvMenu').dialog("close");
})

.on('click',"#btnRemove",function(){
	$('#btnAdd').val('추가');
    $('#_name').val('');
    $('#_price').val('');
    $("#optype").val('add');
})

.on('click',"#btnAdd",function(){
	if($('#btnAdd').val()=='추가'){
		if($('#_name').val()!='' && $('#_price').val()!=''){
			$.ajax({
      		type:'get',
      		url:'add',
      		data:'&name='+$('#_name').val()+'&price='+$('#_price').val(),
      		dataType:'text',
      		success:function(data){
         	$("#selMenu1").append('<option>'+$('#_name').val()+':'+$('#_price').val()+'</option>');
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
	else if($('#btnAdd').val()=='등록'){
		a = $("#selMenu1 option:selected").val();
		if($('#_name').val()!='' && $('#_price').val()!=''){
			$.ajax({
      		type:'get',
      		url:'update',
      		data:'&name='+$('#_name').val()+'&price='+$('#_price').val()+'&id='+b[0],
      		dataType:'text',
      		success:function(data){
			$("#selMenu1 option:selected").remove();
         	$("#selMenu1").append('<option>'+$('#_name').val()+':'+$('#_price').val()+'</option>');
         	$('#_name').val('');
   			$('#_price').val('');
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

.on('click',"#btnDelete",function(){
	if($('#_name').val()!='' && $('#_price').val()!=''){
		a = $("#selMenu1 option:selected").val();
	b = a.split(":");
	
	let answer = confirm('정말로 지우시겠습니까?');
	if(!answer) return false;
	
	let name=b[0];
	//let ndx=$(this).index();
	$.ajax({
		type:'get',
		url:'delete',
		data:'name='+name,
		dataType:'text',
		success:function(data){
			$("#selMenu1 option:selected").remove();
      	 },
	   	 error:function(){
	   		 alert('삭제 실패');
	      },complete:function(){
	      }
	})
	$('#_name').val('');
   	$('#_price').val()
	}else {
		return;
	}
})

.on('click',"#selMenu1",function(){
	$('#btnAdd').val('등록');
	
    a = $("#selMenu1 option:selected").val();
    b = a.split(":");
    c=0;
    cof='';
    cof = b[0];
    c= b[1];
    $("#_name").val(cof);
    $("#selMenu1 option").css('color','red');
    $("#_price").val(c);

    $("#optype").val('update');
    console.log($('#optype').val())
})

function loadData(){
	   $.ajax({
		   type:'get',
      	   url:'menulist',
      	   dataType:'json',
      	 success:function(data){
			$('#coffee').empty();
			for(let i=0; i<data.length; i++){
				let jo=data[i];
				let str='<option value='+jo['seqno']+'>'+jo['name']+':'+jo['price']+'</option>';
				$('#coffee').append(str);
			}
      	 },
	   	 error:function(){
	      },complete:function(){
	      }
	   })
}
