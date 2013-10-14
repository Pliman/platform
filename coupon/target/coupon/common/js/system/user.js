/***
JS依赖/common/common.jsp
**/
var UserManager={
	formDivId:'#win_user_form',//表单DIV ID
	formId:'#user_form',//表单ID
	formEntityId:'#user_id',//表单实体记录ID
	formOkId:'#user_ok',//表单确认提交
	formCancelId:'#user_cancel',//表单取消提交
	gridId:'#user_List',//实体记录表格组件ID
	baseUrl:g_baseUrl+'/system/user',//模块其本路径
	initObj:{},
	objList:[],
	/**初始化*/
	init:function(){
			var idField='user_id';
			var disColumns=[
					{field:'user_name',title:'用户名称',width:100,sortable:true,dValue:''},
					{field:'nick_name',title:'昵称',width:100,sortable:true,dValue:''},
					{field:'user_type',title:'用户类型',width:60,sortable:false,dValue:'P'},
					{field:'last_visit',title:'最后访问时间',width:180,sortable:false,
						formatter:function(value,rec){return value; },dValue:''
					},
					{field:'disabled',title:'是否禁用',width:60,sortable:true,dValue:false},
					{field:'show_order',title:'顺序',width:60,sortable:true,dValue:0}
				];
			var i,colLen=disColumns.length;
			for(i=0;i<colLen;i++){
				this.initObj[disColumns[i].field]=disColumns[i].dValue;
			}
			//表单窗口初始化
			$(UserManager.formDivId+'_area').css('display','block');//为了隐藏表单窗口　避免加载页面时出现表单窗口视觉残留
			$(UserManager.formDivId).window({
								width: 500,
								height: 500,
								modal: true,
								shadow: true,
								closed: true,
								collapsible:false,
								minimizable:false,
								maximizable:false
								
			});
			//数据列表初始化
			$(UserManager.gridId).datagrid({
				nowrap: true,
				striped: true,
				url:UserManager.baseUrl+'Lis.html',
				fit: true,
				sortName: "show_order",
				sortOrder: 'asc',
				idField:idField,
				frozenColumns:[[
	                {field:'ck',checkbox:true}
				]],
				columns:[[
			        {title:'<B>用户管理</B>',colspan:disColumns.length},
					{field:idField,title:'操作',width:100,align:'center', rowspan:2,
						formatter:function(value,rec){
							var objIndex=UserManager.objList.length;
							UserManager.objList[objIndex]=rec;
							return '<a href="javascript:void(0);" onclick="UserManager.alertNEVForm(\'V\',\''+value+'\','+objIndex+')">查看</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" onclick="UserManager.alertNEVForm(\'E\',\''+value+'\','+objIndex+')">编辑</a>';
						}
					}
				],disColumns],
				pagination:true,
				rownumbers:true,
				singleSelect:false,
				toolbar:[{
					text:'添加',
					iconCls:'icon-add',
					handler:function(){
							//弹出添加记录窗口
							UserManager.alertNEVForm('N');
					}
				},'-',{
					text:'删除',
					iconCls:'icon-cut',
					disabled:false,
					handler:function(){
						UserManager.deleteRecords(null);//以选择方式删除否则以指定id删除
					}
				}]
			});
			
		return false;	

	},
	/**弹出表单窗口　以便新建，编辑，查Role/E/V */
	alertNEVForm:function(nev,id,objIndex){
		//表单数据处理
		var title='';
		if(nev=='N'){
			title='新建';
			$(UserManager.formEntityId).val('');//放入表单记录ID
			g_setPropToElements(UserManager.formId,UserManager.initObj,'',true);
			this.loadRoleCheckboxList(null,true);
		}else if(nev=='E'){
			title='编辑';
			$(UserManager.formEntityId).val(id);//放入表单记录ID
			g_setPropToElements(UserManager.formId,UserManager.objList[objIndex],'',true);
			this.loadRoleCheckboxList(id,true);
		}else if(nev=='V'){
			title='查看';
			$(UserManager.formEntityId).val(id);//放入表单记录ID
			g_setPropToElements(UserManager.formId,UserManager.objList[objIndex],'',false);
			this.loadRoleCheckboxList(id,false);
		}
		
		//表单按钮初始化
		$(UserManager.formOkId).unbind('click').click(function(){
			if(nev!='V'){
				UserManager.saveOrUpdate($(UserManager.formEntityId).val());
			}else{
				$(UserManager.formDivId).window('close');
			}
			
		});
		$(UserManager.formCancelId).unbind('click').click(function(){
			$(UserManager.formDivId).window('close');
			
		});
		$(UserManager.formDivId).window({title: title});
		$(UserManager.formDivId).window('open');//打开窗口
		return false;
	},
	/**保存或更新记录*/
	saveOrUpdate:function(id){
		var url='';
		if(id.length>0){//更新
			url=UserManager.baseUrl+'Edi.html?id='+id;
		}else{//保存
			url=UserManager.baseUrl+'Add.html';
		}
		//提交之前取得所选的角色
		var selectVals='';
		$('#roles_checkboxList input').each(function(i){
			 if(this.checked){
			 	selectVals+=this.value+':';
			 }
		});
		$('#user_form_roleids').val(selectVals.substring(0,selectVals.length-1));
		
		g_ajaxSubmit(UserManager.formId,url
				,function(){
					//验证
					return true;
				}
				,function(data){
					$(UserManager.formDivId).window('close');
					if(data.result){
						//reload列表
						$(UserManager.gridId).datagrid('reload');
					}else{
						alert('error:'+data.error);
					}
		});
		return false;
	},
	/**删除记录*/
	deleteRecords:function(byId){
			var ids = [];
			if(byId==null){
				var rows = $(UserManager.gridId).datagrid('getSelections');
				if(rows.length<1){
					$.messager.alert('提示','没有选择记录!','info');
					return;
				}
				for(var i=0;i<rows.length;i++){
					ids.push(rows[i].user_id);
				}
			}else{
				ids.push(byId);
			}
			var ids_str=ids.join(':');
			$.messager.confirm('确认', '确定要删除所选的'+ids.length+'条记录？', function(r){
				if (r){
					var rurl=UserManager.baseUrl+'Del.html?id='+ids_str;
					//删除后回调
					var callback=function(data){
						if(data.result){
							//reload列表
							$(UserManager.gridId).datagrid('reload');
						}else{
							alert('error:'+data.error);
						}
					}
					g_callAjax(rurl,callback,'json');
					
				}
			});
			return false;
	},
	loadRoleCheckboxList:function(userId,isEditable){
		var url=g_baseUrl+'/system/findRoleList.html';
		if(userId!=null){
			url+='?userId='+userId;
		}
		//角色列表
		var callback=function(data){
				if(data.isSuccess){
					//角色列表
					var content="";
					var length=data.roleList.length;
					var i,item;
					var checked='';
					for(i=0;i<length;i++){
						item=data.roleList[i];
						if(item.isSelected){
							checked='checked="true"';
						}else{
							checked='';
						}
						if(!isEditable){
							checked+=' disabled="true"';
						}
						content+='<input type="checkbox" value="'+item.roleId+'" '+checked+' >'+item.roleName+'</input>';			
					}
					$('#roles_checkboxList').html(content);		
				}else{
					alert('error:'+data.error);
				}
			}
		//请求取得数据
		g_callAjax(url,callback,'json');
	
	
	}





}



