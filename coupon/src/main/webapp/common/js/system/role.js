/***
JS依赖/common/common.jsp
**/
var RoleManager={
	formDivId:'#win_role_form',//表单DIV ID
	formId:'#role_form',//表单ID
	formEntityId:'#role_id',//表单实体记录ID
	formOkId:'#role_ok',//表单确认提交
	formCancelId:'#role_cancel',//表单取消提交
	gridId:'#role_List',//实体记录表格组件ID
	baseUrl:g_baseUrl+'/system/role',//模块其本路径
	initObj:{},
	objList:[],
	/**初始化*/
	init:function(){
			var idField='role_id';
			var disColumns=[
					{field:'role_name',title:'角色名称',width:150,sortable:true,dValue:''},
					{field:'role_desc',title:'描述',width:350,sortable:false,
						formatter:function(value,rec){return value; },dValue:''
					},
					{field:'show_order',title:'顺序',width:60,sortable:true,dValue:0}
				];
			var i,colLen=disColumns.length;
			for(i=0;i<colLen;i++){
				this.initObj[disColumns[i].field]=disColumns[i].dValue;
			}
			//表单窗口初始化
			$(RoleManager.formDivId+'_area').css('display','block');//为了隐藏表单窗口　避免加载页面时出现表单窗口视觉残留
			$(RoleManager.formDivId).window({
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
			$(RoleManager.gridId).datagrid({
				nowrap: true,
				striped: true,
				url:RoleManager.baseUrl+'Lis.html',
				fit: true,
				sortName: "show_order",
				sortOrder: 'asc',
				idField:idField,
				frozenColumns:[[
	                {field:'ck',checkbox:true}
				]],
				columns:[[
			        {title:'<B>角色管理</B>',colspan:disColumns.length},
					{field:idField,title:'操作',width:100,align:'center', rowspan:2,
						formatter:function(value,rec){
							var objIndex=RoleManager.objList.length;
							RoleManager.objList[objIndex]=rec;
							return '<a href="javascript:void(0);" onclick="RoleManager.alertNEVForm(\'V\',\''+value+'\','+objIndex+')">查看</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" onclick="RoleManager.alertNEVForm(\'E\',\''+value+'\','+objIndex+')">编辑</a>';
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
							RoleManager.alertNEVForm('N');
					}
				},'-',{
					text:'删除',
					iconCls:'icon-cut',
					disabled:false,
					handler:function(){
						RoleManager.deleteRecords(null);//以选择方式删除否则以指定id删除
					}
				}
				]
			});
			
		return false;	

	},
	/**弹出表单窗口　以便新建，编辑，查Role/E/V */
	alertNEVForm:function(nev,id,objIndex){
		//表单数据处理
		var title='';
		if(nev=='N'){
			title='新建';
			$(RoleManager.formEntityId).val('');//放入表单记录ID
			g_setPropToElements(RoleManager.formId,RoleManager.initObj,'',true);
			this.loadResourceTree(null,true);
		}else if(nev=='E'){
			title='编辑';
			$(RoleManager.formEntityId).val(id);//放入表单记录ID
			g_setPropToElements(RoleManager.formId,RoleManager.objList[objIndex],'',true);
			this.loadResourceTree(id,true);
		}else if(nev=='V'){
			title='查看';
			$(RoleManager.formEntityId).val(id);//放入表单记录ID
			g_setPropToElements(RoleManager.formId,RoleManager.objList[objIndex],'',false);
			this.loadResourceTree(id,false);
			
		}
		
		//表单按钮初始化
		$(RoleManager.formOkId).unbind('click').click(function(){
			if(nev!='V'){
				RoleManager.saveOrUpdate($(RoleManager.formEntityId).val());
			}else{
				$(RoleManager.formDivId).window('close');
			}
			
		});
		$(RoleManager.formCancelId).unbind('click').click(function(){
			$(RoleManager.formDivId).window('close');
			
		});
		$(RoleManager.formDivId).window({title: title});
		$(RoleManager.formDivId).window('open');//打开窗口
		return false;
	},
	/**保存或更新记录*/
	saveOrUpdate:function(id){
		var url='';
		if(id.length>0){//更新
			url=RoleManager.baseUrl+'Edi.html?id='+id;
		}else{//保存
			url=RoleManager.baseUrl+'Add.html';
		}
		//提交之前取得所选的树结点资源
		var selectObjArray=$("#resources_tree").getTSNs();
		var selectVals='';
		for(var i=0;i<selectObjArray.length;i++){
				selectVals+=selectObjArray[i].id+':';
		}
		$('#role_form_resources').val(selectVals.substring(0,selectVals.length-1));
		
		g_ajaxSubmit(RoleManager.formId,url
				,function(){
					//验证
					return true;
				}
				,function(data){
					$(RoleManager.formDivId).window('close');
					if(data.result){
						//reload列表
						$(RoleManager.gridId).datagrid('reload');
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
				var rows = $(RoleManager.gridId).datagrid('getSelections');
				if(rows.length<1){
					$.messager.alert('提示','没有选择记录!','info');
					return;
				}
				for(var i=0;i<rows.length;i++){
					ids.push(rows[i].role_id);
				}
			}else{
				ids.push(byId);
			}
			var ids_str=ids.join(':');
			$.messager.confirm('确认', '确定要删除所选的'+ids.length+'条记录？', function(r){
				if (r){
					var rurl=RoleManager.baseUrl+'Del.html?id='+ids_str;
					//删除后回调
					var callback=function(data){
						if(data.result){
							//reload列表
							$(RoleManager.gridId).datagrid('reload');
						}else{
							alert('error:'+data.error);
						}
					}
					g_callAjax(rurl,callback,'json');
					
				}
			});
			return false;
	},
	loadResourceTree:function(roleId,isEditable){
		var url=g_baseUrl+'/system/findRoleResourceList.html';
		if(roleId!=null){
			url+='?roleId='+roleId;
		}
		//资源列表
		g_callAjax(url,function(data){
					var option = { 
			            	showcheck:true,
			            	data:data,
			            	cbiconpath:g_baseUrl+'/common/js/base/tree/images/',
			            	oncheckboxclick:function(et, item){
			            		if(isEditable){
			            			return true;
			            		}else{
			            			return false;
			            		}
			            	 },
			            	cascadecheck: true,
			            	readonly:!isEditable,
			            	showleaficon:false  
			        };
			        $("#resources_tree").treeview(option);
			},'json');
	
	
	}





}



