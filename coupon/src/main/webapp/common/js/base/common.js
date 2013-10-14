
		/**动态加载 JS 或 CSS 文件 
		*file 格式 ../xxx/yyy/sss.js  或../xxx/yyy/sss.css
		*公共函数
		*/
		function g_load(file){
			 var index=file.lastIndexOf('/'); 
 			 var idStr=file.substring(index+1).replace('.','_'); 
 			 
			 var att = file.split('.');
	         var ext = att[att.length - 1].toLowerCase();
	         var isCss = ext == "css";
			 if(!isCss){
			 	 var head = $('head').remove('#load_'+idStr);//id=load_sss_js  
		   		 $("<scr"+"ipt></scr"+"ipt>").attr({src:file,type:'text/javascript',id:'load_'+idStr}).appendTo(head);
			 }else{
			 	var head = $('head').remove('#load_'+idStr);//id=load_sss_css  
		   		$('<link rel="stylesheet" type="text/css" href="" />').attr({href:file,type:'text/css',id:'load_'+idStr}).appendTo(head);
			 }  
		}
		
		/**js公共 变量*/
		var g_baseUrl = "/coupon";	
		
		/**异步调用 公共函数
		url:请求url
		callFunName:回调函数名称 或带一个参数的回调函数 function(d){}
		dataType:返回数据类型 text,html,json
		*/
		function g_callAjax(url,callFunName,dataType){
			$.ajax({
						type:'POST',
						url:url,
						dataType:dataType,
						success: function(data){
							var func=callFunName;
							if(typeof(func)=='function'){//如果传入的是函数则直接执行
								if(dataType=='json'){
									func(data);
								}else{
									func("'"+data+"'");
								}
							}
						}
			});	
		}
		
		/* 
		* 用来遍历指定对象所有的属性名称和值 
		* obj 需要遍历的对象 
		*/ 
		function g_allPrpos( obj ) { 
			// 用来保存所有的属性名称和值 
			var props = "" ; 
			// 开始遍历 
			for ( var p in obj ){ 
				// 方法 
				if ( typeof ( obj [ p ]) == " function " ){ 
					obj [ p ]() ; 
				} else { 
					// p 为属性名称，obj[p]为对应属性的值 
					props += p + " = " + obj [ p ] + " \t " ; 
				} 
			} 
			// 最后显示所有的属性 
			alert ( props ) ; 
		}
		/* 
		* 将JS对象obj所有的属性值 设置到HTML元素(HTML元素ID为JS对象obj属性名)
		* formId:HTML表单form id 注意  以#开头
		* obj:JS对象obj包含属性及值
		* notProps:不需要设置的属性串用:分格  prop1:prop2:prop3
		* isEditable:HTML元素设置为是否可编辑
		*/ 
		function g_setPropToElements(formId, obj,notProps,isEditable) { 
			for ( var p in obj ){ 
				// 方法 
				if ( typeof ( obj [ p ]) == " function " ){ 
					obj [ p ]() ; 
				} else { 
					// p 为属性名称，obj[p]为对应属性的值 
					var elementId=formId+'_'+p;//合成元素ID
					if(notProps){
						if(notProps.indexOf(p)==-1){
							g_setElementValue(formId,elementId,obj [ p ],isEditable);
						}
					}else{
						g_setElementValue(formId,elementId,obj [ p ],isEditable);
					}
				} 
			} 
		}
		/**
		*设置某个HTML元素的值(text,password,hidden,textarea,checkbox,radio,select-one)  radio单选时　其中一个设置ID即可　其它name相同
		*formId:HTML表单form id 注意  以#开头
		*isEditable:HTML元素设置为是否可编辑
		*/
		function g_setElementValue(formId,elementId,value,isEditable){
			var eObj=$(elementId);
			var type=eObj.attr('type');
			switch(type){
					case "text":eObj.val(value);break;
					case "hidden":eObj.val(value);break;
					case "password":eObj.val(value);break;
					case "textarea":$(eObj).val(value);break;
					case "checkbox":
						var flag=false;
						if(value=='true'||value==true){flag=true;}
						if(flag){eObj.attr('checked','true');}else{eObj.attr('checked','');} 
						break;
					case "radio":
						var radioname=eObj.attr('name');
						$(formId+" input[name='"+radioname+"']").each(function(){ 
							var val=$(this).attr("value");
							if(val==value){
								$(this).attr('checked','true');
							}else{
								$(this).attr('checked','');
							}
							if(isEditable){
								$(this).removeAttr('disabled');		
							}else{
								$(this).attr('disabled',true); 		
							} 
							
						});
						break;
					case "select-one":
						//默认使用easyui-combobox,or combotree
						try{
							var className=eObj.attr('class');
							if(className=='easyui-combobox'){
								$(eObj).combobox('setValue',value);
								$(formId+' input.combobox-text').each(function(){ 
									if(isEditable){
										$(this).removeAttr('disabled');	
										$(this).next().children().show();
									}else{
										$(this).attr('disabled',true);
										$(this).next().children().hide();
									}
								});
							}else{//combotree
								$(eObj).combotree('setValue',{id:value});
								$(formId+' input.combotree-text').each(function(){ 
									if(isEditable){
										$(this).removeAttr('disabled');	
										$(this).next().children().show();
									}else{
										$(this).attr('disabled',true);
										$(this).next().children().hide();
									}
								});
							}
							
						}catch(err){
							eObj.val(value);
						}
						break;
			}
			if(isEditable){
					eObj.removeAttr('disabled');		
			}else{
					eObj.attr('disabled',true); 		
			} 
		}  
		/***
		*公共函数　异步表单提交 beforeSubmitFunc为不带参数的函数 callbackFunc为带一个参数的函数
		**/
		function g_ajaxSubmit(formId,url,beforeSubmitFunc,callbackFunc){
			$(formId).ajaxSubmit({ 
				url:url,
		        	dataType: 'json', 
		        	type: 'POST',
		        	beforeSubmit:function(){
		        		var beforeSub=beforeSubmitFunc;
		        		if(typeof(beforeSub)=='function'){
		        			return beforeSub();
		        		}else{
		        			//默认easyui-validatebox验证
		        			var check=true;
		        			try{
								$(formId+' .easyui-validatebox').each(function(){
									var valid=$(this).validatebox('isValid');
									check=valid&&check;
								});
								if(!check){
									$.messager.alert('提示','请确保输入正确完整!','warning');
								}
							}catch(err){}
							return check;
		        		}
		        		return true;
		        	},
		        	success: function(data){
		        		var callback=callbackFunc;
		        		callback(data);	
		        		$(formId).clearForm();//清除表单数据	
		        	} 
		    	});
		
		}


