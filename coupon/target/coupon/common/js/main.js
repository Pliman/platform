function killErrors() {return true;}
window.onerror = killErrors;
var Ajax_msg="获取失败";
function Get_counts()
{
	$.ajax({
	type: "get",
	cache: false,
	url : "?action=counts",
	timeout: 20000,
	error: function(){},
	success: function(t0){$('#counts').html(t0); setTimeout("window.location.href='?';" , "1000");}
	});
}

function getBoxHtml(data)
{
	var t2 = "<dl>";
	for(var e in data)
	{ 
		t2 += "<dt>" + data[e] + "</dt>";
	}
	t2 += "</dl>";
	return t2;
}
function getBoxlink(url,title){
    return '<div><a href="'+url+'" target="_blank">'+title+'</a></div>';
}


var lastCtrl = new Object();
function DoLocation(ctrl)
{
	if(ctrl != lastCtrl){
		lastCtrl.className = "left_link";
	}
	ctrl.className = "left_link_over";
	lastCtrl = ctrl;
}
function Pinyin(en, id) { id.value = getSpell(en, ""); }

function pucker_show(name, no, hiddenclassname, showclassname) {    
    //name:命名前缀
    //no:当前鼠标所处对象的序号
    //showclassname:展开状态样式名
    //hiddenclassname:折叠状态样式名
    for (var i = 1; i <= $('#left ul').length; i++)
    {
        $('#'+name+i)[0].className = hiddenclassname;
    }
    $('#'+name+no)[0].className=showclassname;
}

function reinitIframe(t0){
	var iframe=$("#"+t0)[0];
	if(document.all&&window.XMLHttpRequest!=undefined)
	{
		
		var wWidth=document.documentElement.offsetWidth-222;// >ie6
		}
	else
	{
		var wWidth=document.documentElement.offsetWidth-247;
		}
	try{
		var wHeight=window.document.documentElement.offsetHeight-95;
		var bHeight=iframe.contentWindow.document.body.scrollHeight;
		var dHeight=iframe.contentWindow.document.documentElement.scrollHeight;
		var height=Math.max(bHeight,dHeight);
		iframe.width=wWidth;
		if(height<=wHeight)
		{
			iframe.height=wHeight;
		}
		else
		{
			iframe.height=height;
		}
	}catch (ex){}
}

function selectTag(showContent,selfObj){
	// 操作标签
	var tag = $("#innouni_sub_title")[0].getElementsByTagName("li");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "unsub";
	}
	selfObj.parentNode.className = "sub";
	// 操作内容
	for(i=0; j=$("#tagContent"+i)[0]; i++){
		j.style.display = "none";
	}
	$('#'+showContent)[0].style.display = "block";
}

function CheckAll(form)
{
  alert("x");
  for (var i=0;i<form.elements.length;i++)
    {
    var e = form.elements[i];
    if (e.Name != "chkAll")
       e.checked = form.chkAll.checked;
    }
}

function checkselect(obj,form){ 
 
 var bool=(obj.checked)?true:false;
 for(var i=0;i<form.length;i++){ 
  form.all[i].selected=bool;
 } 
}

function CopyUrl(target)
{ 
	target.value=get_c.value; 
	target.select();   
	js=get_c.createTextRange();   
	js.execCommand("Copy"); 
	alert("复制成功!"); 
} 

function Display(ID){
	if ($('#'+ID)[0].style.display == "none"){
		$('#'+ID)[0].style.display="block";
	}else{
	    $('#'+ID)[0].style.display="none";
	}
}
function Open_w(t0,t1,t2,t3,t4)
{
	var t5=showModalDialog(t0,t3,'dialogWidth:'+t1+'pt;dialogHeight:'+t2+'pt;status:no;help:no;;');
	if (t5!=null) t4.value=t5;
}

function Get_info(seturl, divid) {    
    $.ajax({
        type: "get",
        cache: false,
        url: seturl,
        timeout: 20000,
        error: function() { },
        success: function(data) { $('#' + divid).attr("innerHTML",data); }
    });
}

function formsubmit(form, url) {
    form.action = url;
    if (confirm('确定要执行吗？')) {
        form.submit();
    }
}

function selectTag(showContent, selfObj) {
    // 操作标签
    var tag = $("#innouni_sub_title")[0].getElementsByTagName("li");
    var taglength = tag.length;
    for (i = 0; i < taglength; i++) {
        tag[i].className = "unsub";
    }
    selfObj.parentNode.className = "sub";
    // 操作内容
    for (i = 0; j = $("#tagContent" + i)[0]; i++) {
        j.style.display = "none";
    }
    $('#' + showContent)[0].style.display = "block";
}