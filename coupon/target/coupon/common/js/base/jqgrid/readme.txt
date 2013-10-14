
<table id="role_List"></table>
<div id="role_List_pager"></div> 


/**初始化*/
function roleInit(){
	//生成用户jqGrid组件
	jQuery("#role_List").jqGrid({ 
				height:'80%',
				url:g_baseUrl+'/system/roleAction.html', 
				editurl:g_baseUrl+'/system/roleAction.html', 
				mtype:"POST",
				datatype: "json", 
				colNames:['id','角色名称','资源集合','禁用','创建时间','修改时间','标注'], 
				colModel:[	
					{name:'id',index:'id',width:55,hidden:true,editable:false,editoptions:{readonly:true,size:10}},
					{name:'roleName',index:'roleName', width:80,editable:true,editoptions:{size:32}, formoptions:{ rowpos:2, label: "角色名称", elmsuffix:"<font color='red'>&nbsp;*</font>"},editrules:{required:true}},
					{name:'resources',index:'resources', width:90,editable:true,editoptions:{}, formoptions:{ rowpos:4, label: "资源集合"}},
					{name:'disabled',index:'disabled', width:38,editable:true,edittype:'checkbox',editoptions:{value:"true:false"}, formoptions:{ rowpos:5, label: "禁用"}},
					{name:'createDate',index:'createDate', width:80,searchoptions:{
											dataInit:function(el){$(el).datepicker({dateFormat:'yy-mm-dd'})}
										},
									editable:false,
									formoptions:{ rowpos:8,label:'创建时间' }
								},
					{name:'modifyDate',index:'modifyDate', width:80,searchoptions:{
											dataInit:function(el){$(el).datepicker({dateFormat:'yy-mm-dd'})}
										},
									editable:false,
									formoptions:{ rowpos:9,label:'修改时间' }
								},
					{name:'description',index:'description', width:100,editable:true,edittype:"textarea",editoptions:{size:500}, formoptions:{ rowpos:11, label: "标注"}}	
			   	],
				rowNum:10, 
				rowList:[10,20,30], 
				multiselect: true,
				viewrecords: true,
				pager: '#role_List_pager', 
				sortname: 'id', 
				sortorder: "desc", 
				//caption:"测试表格",
				onRightClickRow:function(){}	
			});
	
	
			jQuery("#role_List").jqGrid('navGrid','#role_List_pager',
			{view:true,edit:true,add:true,del:true,search:true,refresh:true }, 
			{width:400,reloadAfterSubmit:false, jqModal:false, closeOnEscape:true, bottominfo:"标记<font color='red'>&nbsp;*</font> 为必需项"}, // edit options
			{width:400,reloadAfterSubmit:false,jqModal:false, closeOnEscape:true,bottominfo:"标记<font color='red'>&nbsp;*</font> 为必需项", closeAfterAdd: true}, // add options
			{reloadAfterSubmit:false,jqModal:false, closeOnEscape:true}, // del options
			{closeOnEscape:true}, // search options
			{width:400,jqModal:false,closeOnEscape:true} // view options
			
			);
			//).searchGrid({multipleSearch:true});// .searchGrid({multipleSearch:true})多字段查询
			


}
