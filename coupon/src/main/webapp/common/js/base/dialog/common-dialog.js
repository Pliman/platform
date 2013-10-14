/***
自定义 confirm 对话框  
用法:jConfirm('確定要刪除？', '確定', function(){
            //....whatever you want to do.
	});
**/
var confirmfunc = function() {};
function jConfirm(msg, title, f) {
	confirmfunc = f;
	if(!title) title = '確认对话框';
	$.blockUI({ message: 
						'<div class="z">'
						+'<div style="border: 2px solid #F29572; margin: 0px auto; background: #ffffff none repeat scroll 0% 0%; width: 300px; text-align: center;">'
						+'<div style="padding: 5px 10px 0px; background: #F29572 none repeat scroll 0% 0%; height: 25px; text-align: left;"><strong style="color:#FFFFFF">'+title+'</strong></div>'
						+'<div class="section">'
						+'<div class="tac" style="padding-top:10px">'+msg+'</div>'
						+'<div class="tac" style="padding:15px 50px 5px 50px"><br>'
						+'<div >'
						+'<input class="inputbutton" style="width: 60px;" onclick="javascript: confirmfunc(); $.unblockUI();" onmouseover="this.className=\'inputbutton2\';" onmouseout="this.className=\'inputbutton\';" type="button" value="確定" />'
						+'&nbsp;&nbsp;&nbsp;&nbsp;<input class="inputbutton3" style="width: 60px;" onclick="javascript: $.unblockUI();" onmouseover="this.className=\'inputbutton4\';" onmouseout="this.className=\'inputbutton3\';" type="button" value="取消" /></div>'
						+'</div><br>'
						+'</div>'
						+'</div>'
						+'</div>'
						,
	            css:{
					border: 'none',
	                top:  ($(window).height() - 300) /2 + 'px',
	                left: ($(window).width() - 300) /2 + 'px',
	                width: '300px'
	            }
	});
 
}