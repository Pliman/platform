/***
JS依赖/common/common.jsp
**/
var FunctionManager={
	formDivId:'#win_function_form',//表单DIV ID
	formId:'#function_form',//表单ID
	formEntityId:'#function_id',//表单实体记录ID
	formOkId:'#function_ok',//表单确认提交
	formCancelId:'#function_cancel',//表单取消提交
	gridId:'#function_List',//实体记录表格组件ID
	baseUrl:g_baseUrl+'/system/function',//模块其本路径
	initObj:{},
	objList:[],
	qColumnList:[],
	query:function(){
		if(this.qColumnList.length>0){
			var queryParams = $(FunctionManager.gridId).datagrid('options').queryParams;
			for(var j=0;j<this.qColumnList.length;j++){
				var qInputObj=$('#q_'+this.qColumnList[j].field);
				if(qInputObj){
					queryParams[this.qColumnList[j].field] =qInputObj.val();    
				}
			}
			$(FunctionManager.gridId).datagrid('reload');
		}
	},
	/**初始化*/
	init:function(){
			var idField='function_id';
			var disColumns=[
					{field:'function_code',title:'资源编码',width:110,sortable:true,dValue:'',isQ:true},
					{field:'function_name',title:'资源名称',width:120,sortable:true,dValue:'',isQ:true},
					{field:'function_type',title:'类型',width:60,sortable:true,dValue:'MENU'},
					{field:'parent_name',title:'父级',width:60,sortable:false,dValue:''},
					{field:'url',title:'URL',width:200,sortable:false,dValue:''},
					{field:'show_order',title:'顺序',width:20,sortable:true,dValue:0}
				];
			var i,colLen=disColumns.length;
			for(i=0;i<colLen;i++){
				this.initObj[disColumns[i].field]=disColumns[i].dValue;
				//查询封装
				
				if(disColumns[i].isQ){
					this.qColumnList[this.qColumnList.length]=disColumns[i];
				}
			}
		
			//表单窗口初始化
			$(FunctionManager.formDivId+'_area').css('display','block');//为了隐藏表单窗口　避免加载页面时出现表单窗口视觉残留
			$(FunctionManager.formDivId).window({
								width: 500,
								height: 450,
								modal: true,
								shadow: true,
								closed: true,
								collapsible:false,
								minimizable:false,
								maximizable:false
								
			});
			//数据列表初始化
			$(FunctionManager.gridId).datagrid({
				nowrap: true,
				striped: true,
				url:FunctionManager.baseUrl+'Lis.html',
				fit: true,
				sortName: "show_order",
				sortOrder: 'asc',
				idField:idField,
				frozenColumns:[[
	                {field:'ck',checkbox:true}
				]],
				columns:[[
			        {title:'<B>功能点管理</B>',colspan:disColumns.length},
					{field:idField,title:'操作',width:100,align:'center', rowspan:2,
						formatter:function(value,rec){
							var objIndex=FunctionManager.objList.length;
							FunctionManager.objList[objIndex]=rec;
							return '<a href="javascript:void(0);" onclick="FunctionManager.alertNEVForm(\'V\',\''+value+'\','+objIndex+')">查看</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" onclick="FunctionManager.alertNEVForm(\'E\',\''+value+'\','+objIndex+')">编辑</a>';
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
							FunctionManager.alertNEVForm('N');
					}
				},'-',{
					text:'删除',
					iconCls:'icon-cut',
					disabled:false,
					handler:function(){
						FunctionManager.deleteRecords(null);//以选择方式删除否则以指定id删除
					}
				}
				]
			});
			
			//父级ID COMBOTREE初始化
			FunctionManager.refreshParentTree();
			
		return false;
	},
	refreshParentTree:function(){
		$('#function_form_parent_id').combotree({
			    url:g_baseUrl+'/system/findParentMenusTree.html'
			});
	},
	/**弹出表单窗口　以便新建，编辑，查看 传入参数为N/E/V */
	alertNEVForm:function(nev,id,objIndex){
		//表单数据处理
		var title='';
		if(nev=='N'){
			title='新建';
			$(FunctionManager.formEntityId).val('');//放入表单记录ID
			g_setPropToElements(FunctionManager.formId,FunctionManager.initObj,'',true);
		}else if(nev=='E'){
			title='编辑';
			$(FunctionManager.formEntityId).val(id);//放入表单记录ID
			g_setPropToElements(FunctionManager.formId,FunctionManager.objList[objIndex],'',true);
		}else if(nev=='V'){
			title='查看';
			$(FunctionManager.formEntityId).val(id);//放入表单记录ID
			g_setPropToElements(FunctionManager.formId,FunctionManager.objList[objIndex],'',false);
		}
		//表单按钮初始化
		$(FunctionManager.formOkId).unbind('click').click(function(){
			if(nev!='V'){
				FunctionManager.saveOrUpdate($(FunctionManager.formEntityId).val());
			}else{
				$(FunctionManager.formDivId).window('close');
			}
			
		});
		$(FunctionManager.formCancelId).unbind('click').click(function(){
			$(FunctionManager.formDivId).window('close');
			
		});
		$(FunctionManager.formDivId).window({title: title});
		$(FunctionManager.formDivId).window('open');//打开窗口
		return false;
	},
	/**保存或更新记录*/
	saveOrUpdate:function(id){
		var url='';
		if(id.length>0){//更新
			url=FunctionManager.baseUrl+'Edi.html?id='+id;
		}else{//保存
			url=FunctionManager.baseUrl+'Add.html';
		}
		g_ajaxSubmit(FunctionManager.formId,url,null
				,function(data){
					$(FunctionManager.formDivId).window('close');
					if(data.result){
						//reload列表
						$(FunctionManager.gridId).datagrid('reload');
						FunctionManager.refreshParentTree();//更新父级树
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
				var rows = $(FunctionManager.gridId).datagrid('getSelections');
				if(rows.length<1){
					$.messager.alert('提示','没有选择记录!','info');
					return;
				}
				for(var i=0;i<rows.length;i++){
					ids.push(rows[i].function_id);
				}
			}else{
				ids.push(byId);
			}
			var ids_str=ids.join(':');
			$.messager.confirm('确认', '确定要删除所选的'+ids.length+'条记录？', function(r){
				if (r){
					var rurl=FunctionManager.baseUrl+'Del.html?id='+ids_str;
					//删除后回调
					var callback=function(data){
						if(data.result){
							//reload列表
							$(FunctionManager.gridId).datagrid('reload');
						}else{
							alert('error:'+data.error);
						}
					}
					g_callAjax(rurl,callback,'json');
					
				}
			});
			return false;
	}





}





