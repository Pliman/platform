/****
动态Tab控件
1)支持异步AJAX加载数据
2)支持html()方式加载数据
3)支持TAB关闭,滚动动态显示TAB
4)打开时只加载一次,切换时只显示 不重新加载数据,一个TAB对应一个DIV,每个TAB内容相对独立,切换互不影响
5)无限制 newTab();
modify:lit
用法:
  //内容TAB初始化
        var myTab=$("#main_content_tabs").Tab({items:[],
				width:800,
				height:400,
				tabcontentWidth:800,
				tabScroll:true,
				tabWidth:80,
				tabHeight:25
		});

		myTab.newTab({
			id:id,//唯一的divId
			title:label,//Tab标题
			closed:true,//是否可关闭
			icon:'',//不用
			html:'',//有值则为 HTML方式加载数据
			load:url,//有值则为 AJAX方式加载数据
			callback:function(){alert(0);}//第一次加载后或切换后执行的方法
			});


***/


$.fn.Tab = function(opt){
	var cfg={
		items:[{'title':'tab','closed':true,'icon':'','html':'',load:'','callback':function(){}}],//tab的属性
		width:500,
		height:500,
		tabcontentWidth:498,
		tabWidth:66,
		tabHeight:25,
		tabScroll:true,
		tabScrollWidth:19,
		tabClass:'tab',
		tabContentClass:'tab-div-content',
		tabClassOn:'on',
		tabClassOff:'off',
		tabClassClose:'close',
		tabClassInner:'inner',
		tabClassText:'text',
		tabClassScrollLeft:'scroll-left',
		tabClassScrollRight:'scroll-right',
		tabClassDiv:'tab-div',
		tabClassHtmlDiv:'tab-div-html',
		tabHtml:'',
		tabAutoSelect:false//是否自动选中打开的TAB
	};
	$.extend(cfg,opt);
	//判断是不是有隐藏的tab
	var tW=cfg.tabWidth*cfg.items.length;
	cfg.tabScroll?tW-=cfg.tabScrollWidth*2:null;
	//tabDiv,该div是自动增加的
	var tab=$('<div />').attr('id','jquery_tab_div').height(cfg.tabHeight).addClass(cfg.tabClass).append('<ul />');
	//tab target content
	//var tabContent=[];
	//$('<div />').attr('id','jquery_tab_div_content').width(cfg.tabcontentWidth).height(cfg.height-cfg.tabHeight).addClass(cfg.tabContentClass);
	var ccW=(cfg.items.length*cfg.tabWidth)-cfg.width;
	//var tabH=$('<div />').append(cfg.tabHtml).addClass(cfg.tabClassHtmlDiv).height(cfg.tabHeight);
	var tabH='';
	var scrollTab=function(o,flag){
		var left;
		flag?left=Number(tab.css('left').replace('px',''))+cfg.tabWidth:left=Number(tab.css('left').replace('px',''))-cfg.tabWidth;
		$(o).unbind('click');
		left>0?left=0:null;
		tab.animate({'left':left},function(){
			var tmp_o,tmp_ccW;
			ccW<0?tmp_ccW=0:tmp_ccW=ccW;
			if(left >= 0 || Math.abs(left)>tmp_ccW) {
				return;
			}
			$(o).click(function(){
				scrollTab(this,flag);
			});
			if($(o).hasClass(cfg.tabClassScrollLeft)){
				tmp_o=srcollRight;
				tmp_o.click(function(){
					scrollTab(this,!flag);
				});
			}
			else{
				tmp_o=scrollLeft;
				tmp_o.click(function(){
					scrollTab(this,!flag);
				});
			}
		});
	}
  function addTab(item){
		//close
		var close='';
		if(item.closed){
			close=$('<a class="'+cfg.tabClassClose+'" onclick="return false;" name="'+item.id+'" />').click(function(){
				var _self=$(this);
				//only one tab
				if(tab.find('li').length<2){
					_self.parent().remove();
					_self.remove();
					
				}
				else{
					//first tab delete
					var prev=_self.parent().prev();
					var next=_self.parent().next();
					_self.parent().remove();
					ccW-=cfg.tabWidth;
					var left=Number(tab.css('left').replace('px',''));
					if(left<0){
						tab.animate({'left':left+cfg.tabWidth});
					}
					else{
						cfg.tabScroll&&scrollLeft.unbind('click');
					}
					if(_self.parent().hasClass('on')){
						if(prev.html()){
							prev.click();
						}
						else{
							next.click();
						}
					}
					if(ccW<=cfg.tabWidth){
						cfg.tabScroll&&srcollRight.unbind('click');
					}
				}
				//删除item对象
				//alert(this.name);
				deleteItemObject(findTabItemObject(this.name));
				$('#'+this.name).remove();//删除Tab对应的内容DIV对象
			});
		}
		var inner=$('<a class="'+cfg.tabClassInner+'" onclick="return false;">'+'<span class="'+cfg.tabClassText+'">'+item.title+'</span></a>');
		$('<li></li>').attr('name',item.id).addClass(cfg.tabClassOff).click(function(){
			var _self=$(this);
			if(_self.hasClass(cfg.tabClassOn)) return;
			_self.parent().find('li').removeClass().addClass(cfg.tabClassOff);
			_self.removeClass().addClass(cfg.tabClassOn);
			//控制显示选中的TAB内容
			displayOneTabContent(_self.attr('name'));
			//回调函数是什么
			if(item.callback) item.callback(_self);
		}).append(close).append(inner).appendTo(tab.find('ul'));
		//添加TAB要显示的内容
		//判断是显示html代码还是ajax请求内容
		var newTabContent=$('<div />').attr('id',item.id).css('display','none').width(cfg.tabcontentWidth).height(cfg.height-cfg.tabHeight).addClass(cfg.tabContentClass);		
		if(item.html){
				newTabContent.html(item.html);
		}else{
			if(item.load){
				newTabContent.load(item.load);
			}
		}
		//添加到TAB对象中
		scrollTabObj.append(newTabContent);
	}
	//查找tabitem
	function findTabItemObject(itemId){
		var tabItem=null;
		for(var i=0;i<cfg.items.length;i++){
			if(cfg.items[i].id==itemId){
				tabItem=cfg.items[i];
			}
		}
		return tabItem;
	}
	//删除数组元素,dx为元素下标
	function deleteArrayElementByIndex(itemArray,dx){
		if(isNaN(dx)||dx>itemArray.length){return false;}
    	itemArray.splice(dx,1);
	}
	//删除数组元素,item为元素
	function deleteItemObject(item){
		for(var i=0;i<cfg.items.length;i++){
			if(cfg.items[i].id==item.id){
				deleteArrayElementByIndex(cfg.items,i);
			}
		}
	}
	//显示一个TAB内容
	function displayOneTabContent(itemId){
		for(var i=0;i<cfg.items.length;i++){
			if(cfg.items[i].id==itemId){
				$('#'+itemId).css('display','block');
			}else{
				var otherItem=$('#'+cfg.items[i].id);
				if(otherItem.css('display')!='none'){
					otherItem.css('display','none');
				}
			}
		}
	}
	
	function newTab(item){
		var findItem=findTabItemObject(item.id);
		if(findItem!=null) return;
		cfg.items.push(item);
		
		var liLength=tab.find('li').length;
		var nW=liLength*cfg.tabWidth;
		ccW+=cfg.tabWidth;
		//(ccW>0&&ccW<cfg.tabWidth)?ccW=cfg.tabWidth:null;
		if(nW>cfg.width){
			if(!cfg.tabScroll){
				cfg.tabScroll=true;
				scrollLeft=$('<div class="'+cfg.tabClassScrollLeft+'"></div>').click(function(){
					scrollTab(this,true);
				});
				srcollRight=$('<div class="'+cfg.tabClassScrollRight+'"></div>');
				cW-=cfg.tabScrollWidth*2;
				tabContenter.width(cW);
				scrollLeft.insertBefore(tabContenter);
				srcollRight.insertBefore(tabContenter);
			}
			addTab(item);
			//scrollLeft.click();
			scrollTab(srcollRight,false);
		}
		else{
			addTab(item);
		}
	}
	$.each(cfg.items,function(i,o){
		addTab(o);
	});
	var cW=cfg.width;
	var scrollLeft,srcollRight;
	
	if(cfg.tabScroll){
		scrollLeft=$('<div class="'+cfg.tabClassScrollLeft+'"></div>');
		if(tW>cW){
			srcollRight=$('<div class="'+cfg.tabClassScrollRight+'"></div>').click(function(){
				scrollTab(this,false);
			});
		}
		else{
			srcollRight=$('<div class="'+cfg.tabClassScrollRight+'"></div>');
		}
		cW-=cfg.tabScrollWidth*2;
	}
	var container=$('<div />').css({
		'overflow':'hidden',
		'position':'relative',
		'width':cfg.width,
		'height':cfg.tabHeight
	}).append(scrollLeft).append(srcollRight).addClass(cfg.tabClassDiv);
	var tabContenter=$('<div />').css({
		'overflow':'hidden',
		'width':cW,
		'height':cfg.tabHeight,
		'float':'left'
	}).append(tab);
	var scrollTabObj=$(this).append(tabH).append(container.append(tabContenter));//.append(tabContent);
	//点击第一
	tab.find('li:first').click();
	return scrollTabObj.extend({'addTab':addTab,'newTab':newTab});
};