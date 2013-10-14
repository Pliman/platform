/****************************************
功能:节点树Jquery tree view
用法:
<link rel="stylesheet" type="text/css" href="${baseUrl}/js/base/tree/ui.tree.css">
<script type="text/javascript" src="${baseUrl}/js/base/tree/ui.tree.js"></script>
//菜单树
			var treedata = [{
				    id: "0_1",//唯一的ID即可
				    text: "系统管理",
				    value:null,
				    url:null,
				    hasChildren: true,
				    isexpand: true,
				    complete: true,
				    showcheck:false,
				    childNodes: [{
				        id: "0_1_1",
				        text: "用户管理",
				        value:"系统管理-用户管理",
				        url:'/system/toUserList.html',
				        hasChildren: false,
				        isexpand: false,
				        complete: true,
				        showcheck:false,
				        childNodes: null},{
				        id: "0_1_2",
				        text: "角色管理",
				        value:"系统管理-角色管理",
				        url:'/system/findRoles.html',
				        hasChildren: false,
				        isexpand: false,
				        complete: true,
				        showcheck:false,
				        childNodes: null},{
				        id: "0_1_3",
				        text: "资源管理",
				        value:"系统管理-资源管理",
				        url:'/system/findFunctions.html',
				        hasChildren: false,
				        isexpand: false,
				        complete: true,
				        showcheck:false,
				        childNodes: null}]
				        
					}
			];
				        
            var option = { 
            	showcheck:true,
            	data:treedata,
            	cbiconpath:'${baseUrl}/js/base/tree/images/',
            	//oncheckboxclick:function(et, item){alert(et.id+' checked:'+item);  return true;},
            	cascadecheck: true,
            	onnodeclick:function(item){alert(item.id+item.text);}       
            };
            $("#tree").treeview(option);

 $("#tree").

//获取所有选中的节点的Value数组
  var selectValueArray=$("#tree").getTSVs();
//获取所有选中的节点对象数组
  var selectObjArray=$("#tree").getTSNs();
//获取当前选中的节点对象
 var selectObj=$("#tree").getTCT();
//获取搜索到的节点
 var selectObj=$("#tree").searchNode('node2');
   

author:xuanye.wan@gmail.com
amend:ljt
page:http://xuanye.cnblogs.com/
***************************************/
(function($) {
    $.fn.swapClass = function(c1, c2) {
        return this.removeClass(c1).addClass(c2);
    }
    $.fn.switchClass = function(c1, c2) {
        if (this.hasClass(c1)) {
            return this.swapClass(c1, c2);
        }
        else {
            return this.swapClass(c2, c1);
        }
    }
    $.fn.treeview = function(settings) {
    	var currentFoundDivId=null;//用于记忆当前 搜索到的节点的DIV ID 
        var dfop =
            {
                method: "POST",
                datatype: "json",
                url: false,
                cbiconpath: "/images/icons/",
                icons: ["checkbox_0.gif", "checkbox_1.gif", "checkbox_2.gif","checkbox_1_disable.gif","checkbox_2_disable.gif"],
                showcheck: false, //是否显示选择            
                oncheckboxclick: false, //当checkstate状态变化时所触发的事件，但是不会触发因级联选择而引起的变化
                onnodeclick: false,
                cascadecheck: true,
                data: null,
                clicktoggle: true, //点击节点展开和收缩子节点
                theme: "bbit-tree-arrows", //bbit-tree-lines ,bbit-tree-no-lines,bbit-tree-arrows
                readonly:false,
                showleaficon:true
            }

        $.extend(dfop, settings);
        var treenodes = dfop.data;
        var me = $(this);
        var id = me.attr("id");
        if (id == null || id == "") {
            id = "bbtree" + new Date().getTime();
            me.attr("id", id);
        }

        var html = [];
        buildtree(dfop.data, html);
        me.addClass("bbit-tree").html(html.join(""));
        InitEvent(me);
        html = null;
        //预加载图片
        if (dfop.showcheck) {
            for (var i = 0; i < 3; i++) {
                var im = new Image();
                im.src = dfop.cbiconpath + dfop.icons[i];
            }
        }
        //region 
        function buildtree(data, ht) {
            ht.push("<div class='bbit-tree-bwrap'>"); // Wrap ;
            ht.push("<div class='bbit-tree-body'>"); // body ;
            ht.push("<ul class='bbit-tree-root ", dfop.theme, "'>"); //root
            var l = data.length;
            for (var i = 0; i < l; i++) {
                buildnode(data[i], ht, 0, i, i == l - 1);
            }
            ht.push("</ul>"); // root and;
            ht.push("</div>"); // body end;
            ht.push("</div>"); // Wrap end;
        }
        //endregion
        function buildnode(nd, ht, deep, path, isend) {
            ht.push("<li class='bbit-tree-node'>");
            ht.push("<div id='", id, "_", nd.id, "' tpath='", path, "' unselectable='on'");
            var cs = [];
            cs.push("bbit-tree-node-el");
            if (nd.hasChildren) {
                cs.push(nd.isexpand ? "bbit-tree-node-expanded" : "bbit-tree-node-collapsed");
            }
            else {
                if(dfop.showleaficon){ cs.push("bbit-tree-node-leaf");}
            }
            if (nd.classes) { cs.push(nd.classes); }

            ht.push(" class='", cs.join(" "), "'>");
            //span indent
            ht.push("<span class='bbit-tree-node-indent'>");
            if (deep == 1) {
                ht.push("<img class='bbit-tree-icon' src='"+dfop.cbiconpath+"s.gif'/>");
            }
            else if (deep > 1) {
                ht.push("<img class='bbit-tree-icon' src='"+dfop.cbiconpath+"s.gif'/>");
                for (var j = 1; j < deep; j++) {
                    ht.push("<img class='bbit-tree-elbow-line' src='"+dfop.cbiconpath+"s.gif'/>");
                }
            }
            ht.push("</span>");
            //img
            cs.length = 0;
            if (nd.hasChildren) {
                if (nd.isexpand) {
                    cs.push(isend ? "bbit-tree-elbow-end-minus" : "bbit-tree-elbow-minus");
                }
                else {
                    cs.push(isend ? "bbit-tree-elbow-end-plus" : "bbit-tree-elbow-plus");
                }
            }
            else {
                cs.push(isend ? "bbit-tree-elbow-end" : "bbit-tree-elbow");
            }
            ht.push("<img class='bbit-tree-ec-icon ", cs.join(" "), "' src='"+dfop.cbiconpath+"s.gif'/>");
            ht.push("<img class='bbit-tree-node-icon' src='"+dfop.cbiconpath+"s.gif'/>");
            //checkbox
            if (dfop.showcheck && nd.showcheck) {
                if (nd.checkstate == null || nd.checkstate == undefined) {
                    nd.checkstate = 0;
                }
                if(nd.checkstate==1&&dfop.readonly){
                	nd.checkstate=3;
            	}
            	if(nd.checkstate==2&&dfop.readonly){
                	nd.checkstate=4;
            	}
            	ht.push("<img  id='",id,"_", nd.id, "_cb' class='bbit-tree-node-cb' src='", dfop.cbiconpath, dfop.icons[nd.checkstate], "'/>");
            	//alert(id+'_'+nd.id+'_cb');
            }
            //a
            ht.push("<a hideFocus class='bbit-tree-node-anchor' tabIndex=1 href='javascript:void(0);'>");
            ht.push("<span unselectable='on'>", nd.text, "</span>");
            ht.push("</a>");
            ht.push("</div>");
            //Child
            if (nd.hasChildren) {
                if (nd.isexpand) {
                    ht.push("<ul  class='bbit-tree-node-ct'  style='z-index: 0; position: static; visibility: visible; top: auto; left: auto;'>");
                    if (nd.childNodes) {
                        var l = nd.childNodes.length;
                        for (var k = 0; k < l; k++) {
                            nd.childNodes[k].parent = nd;
                            buildnode(nd.childNodes[k], ht, deep + 1, path + "." + k, k == l - 1);
                        }
                    }
                    ht.push("</ul>");
                }
                else {
                    ht.push("<ul style='display:none;'></ul>");
                }
            }
            ht.push("</li>");
            nd.render = true;
        }
        function getItem(path) {
            var ap = path.split(".");
            var t = treenodes;
            for (var i = 0; i < ap.length; i++) {
                if (i == 0) {
                    t = t[ap[i]];
                }
                else {
                    t = t.childNodes[ap[i]];
                }
            }
            return t;
        }
        function check(item, state, type) {
            var pstate = item.checkstate;
            if (type == 1) {
                item.checkstate = state;
            }
            else {// 上溯
                var cs = item.childNodes;
                var l = cs.length;
                var ch = true;
                for (var i = 0; i < l; i++) {
                    if ((state == 1 && cs[i].checkstate != 1) || state == 0 && cs[i].checkstate != 0) {
                        ch = false;
                        break;
                    }
                }
                if (ch) {
                    item.checkstate = state;
                }
                else {
                    item.checkstate = 2;
                }
            }
            //change show           
            if (item.render && pstate != item.checkstate) {
                var et = $("#" + id + "_" + item.id + "_cb");
                if (et.length == 1) {
                    et.attr("src", dfop.cbiconpath + dfop.icons[item.checkstate]);
                }
            }
        }
        //遍历子节点
        function cascade(fn, item, args) {
            if (fn(item, args, 1) != false) {
                if (item.childNodes != null && item.childNodes.length > 0) {
                    var cs = item.childNodes;
                    for (var i = 0, len = cs.length; i < len; i++) {
                        cascade(fn, cs[i], args);
                    }
                }
            }
        }
        //冒泡的祖先
        function bubble(fn, item, args) {
            var p = item.parent;
            while (p) {
                if (fn(p, args, 0) === false) {
                    break;
                }
                p = p.parent;
            }
        }
        function nodeclick(e) {
            var path = $(this).attr("tpath");
            var et = e.target || e.srcElement;
            var item = getItem(path);

            //debugger;
            if (et.tagName == "IMG") {
                // +号需要展开
                if ($(et).hasClass("bbit-tree-elbow-plus") || $(et).hasClass("bbit-tree-elbow-end-plus")) {
                    var ul = $(this).next(); //"bbit-tree-node-ct"
                    if (ul.hasClass("bbit-tree-node-ct")) {
                        ul.show();
                    }
                    else {
                        var deep = path.split(".").length;
                        if (item.complete) {
                            item.childNodes != null && asnybuild(item.childNodes, deep, path, ul, item);
                        }
                        else {
                            $(this).addClass("bbit-tree-node-loading");
                            asnyloadc(ul, item, function(data) {
                                item.complete = true;
                                item.childNodes = data;
                                asnybuild(data, deep, path, ul, item);
                            });
                        }
                    }
                    if ($(et).hasClass("bbit-tree-elbow-plus")) {
                        $(et).swapClass("bbit-tree-elbow-plus", "bbit-tree-elbow-minus");
                    }
                    else {
                        $(et).swapClass("bbit-tree-elbow-end-plus", "bbit-tree-elbow-end-minus");
                    }
                    $(this).swapClass("bbit-tree-node-collapsed", "bbit-tree-node-expanded");
                }
                else if ($(et).hasClass("bbit-tree-elbow-minus") || $(et).hasClass("bbit-tree-elbow-end-minus")) {  //- 号需要收缩                    
                    $(this).next().hide();
                    if ($(et).hasClass("bbit-tree-elbow-minus")) {
                        $(et).swapClass("bbit-tree-elbow-minus", "bbit-tree-elbow-plus");
                    }
                    else {
                        $(et).swapClass("bbit-tree-elbow-end-minus", "bbit-tree-elbow-end-plus");
                    }
                    $(this).swapClass("bbit-tree-node-expanded", "bbit-tree-node-collapsed");
                }
                else if ($(et).hasClass("bbit-tree-node-cb")) // 点击了Checkbox
                {
                    var s = item.checkstate != 1 ? 1 : 0;
                    var r = true;
                    if (dfop.oncheckboxclick) {
                        r = dfop.oncheckboxclick.call(et, item, s);
                    }
                    if (r != false) {
                        if (dfop.cascadecheck) {
                            //遍历
                            cascade(check, item, s);
                            //上溯
                            bubble(check, item, s);
                        }
                        else {
                            check(item, s, 1);
                        }
                    }
                }
            }
            else {
                if (dfop.citem) {
                    $("#" + id + "_" + dfop.citem.id).removeClass("bbit-tree-selected");
                }
                dfop.citem = item;
                $(this).addClass("bbit-tree-selected");
                if (dfop.onnodeclick) {
                    dfop.onnodeclick.call(this, item);
                    //清除查询到的记忆节点ID 样式
                    if(currentFoundDivId!=null){
                    	$(currentFoundDivId).removeClass("bbit-tree-selected");
                    	currentFoundDivId=null;
                    }
                }
            }
        }
        function asnybuild(nodes, deep, path, ul, pnode) {
            var l = nodes.length;
            if (l > 0) {
                var ht = [];
                for (var i = 0; i < l; i++) {
                    nodes[i].parent = pnode;
                    buildnode(nodes[i], ht, deep, path + "." + i, i == l - 1);
                }
                ul.html(ht.join(""));
                ht = null;
                InitEvent(ul);
            }
            ul.addClass("bbit-tree-node-ct").css({ "z-index": 0, position: "static", visibility: "visible", top: "auto", left: "auto", display: "" });
            ul.prev().removeClass("bbit-tree-node-loading");
        }
        function asnyloadc(pul, pnode, callback) {
            if (dfop.url) {
                var param = builparam(pnode);
                $.ajax({
                    type: dfop.method,
                    url: dfop.url,
                    data: param,
                    dataType: dfop.datatype,
                    success: callback,
                    error: function(e) { alert("error occur!"); }
                });
            }
        }
        function builparam(node) {
            var p = [{ name: "id", value: encodeURIComponent(node.id) }
                    , { name: "text", value: encodeURIComponent(node.text) }
                    , { name: "value", value: encodeURIComponent(node.value) }
                    , { name: "checkstate", value: node.checkstate}];
            return p;
        }
        function InitEvent(parent) {
            var nodes = $("li.bbit-tree-node>div", parent);
            nodes.each(function(e) {
                $(this).hover(function() {
                    $(this).addClass("bbit-tree-node-over");
                }, function() {
                    $(this).removeClass("bbit-tree-node-over");
                })
                .click(nodeclick)
                .find("img.bbit-tree-ec-icon").each(function(e) {
                    if (!$(this).hasClass("bbit-tree-elbow")) {
                        $(this).hover(function() {
                            $(this).parent().addClass("bbit-tree-ec-over");
                        }, function() {
                            $(this).parent().removeClass("bbit-tree-ec-over");
                        });
                    }
                });
            });
        }
        function getck(items, c, fn) {
            for (var i = 0, l = items.length; i < l; i++) {
            	if(items[i].checkstate == 1||items[i].checkstate == 2){
            		//alert(items[i].checkstate+' '+items[i].text+' '+items[i].id);
            		c.push(fn(items[i]));
            	}
                if (items[i].childNodes != null && items[i].childNodes.length > 0) {
                    getck(items[i].childNodes, c, fn);
                }
            }
        }
        me[0].t = {
            getSelectedNodes: function() {
                var s = [];
                getck(treenodes, s, function(item) { return item });
                return s;
            },
            getSelectedValues: function() {
                var s = [];
                getck(treenodes, s, function(item) { return item.value });
                return s;
            },
            getCurrentItem: function() {
                return dfop.citem;
            },
            //递归搜索节点
            findOneNode: function(nodesArray,nodeName){
            	var fnode=null;
    			var items=nodesArray;
    			for (var i = 0, l = items.length; i < l; i++) {
    				if(items[i].text.indexOf(nodeName)!=-1){//找到后
    					fnode=items[i];
    					break;
    				}else{
    					if(items[i].hasChildren){
    						fnode=this.findOneNode(items[i].childNodes,nodeName);
    					}
    				}
	            }
	            return fnode;
            },
            //根据节点名字查询节点
    		findOneNodeByName: function(nodeName){
    			var fnode=this.findOneNode(treenodes,nodeName);
    			if(fnode==null){
    				alert('Not found node like:'+nodeName);
    			}else{
    				var fnodeDivId='#'+id+'_'+fnode.id;
    					//更新查询到的节点样式
    				if(currentFoundDivId!=null){
    						$(currentFoundDivId).removeClass("bbit-tree-selected");
    				}
    				currentFoundDivId=fnodeDivId;
    				$(currentFoundDivId).addClass("bbit-tree-selected");
    				//alert('Found node:'+fnode.id+" "+fnode.text+' class='+$(currentFoundDivId).attr('class'));
    				if(fnode.hasChildren){
    					if($(currentFoundDivId).hasClass("bbit-tree-node-collapsed")){
    						alert('need open children');
    						//展开下一级子节点
    						var ul = fnode.next(); //"bbit-tree-node-ct"
		                    if (ul.hasClass("bbit-tree-node-ct")) {
		                        ul.show();
		                    }
    						//设置为选中样式
    						$(currentFoundDivId).swapClass("bbit-tree-node-collapsed", "bbit-tree-node-expanded");
    						
    					}
    					
    					
    				}
    			}
	            return fnode;
   			}
        };
        return me;
    }
    //获取所有选中的节点的Value数组
    $.fn.getTSVs = function() {
        if (this[0].t) {
            return this[0].t.getSelectedValues();
        }
        return null;
    }
    //获取所有选中的节点对象数组
    $.fn.getTSNs = function() {
        if (this[0].t) {
            return this[0].t.getSelectedNodes();
        }
        return null;
    }
    //获取当前选中的节点对象
    $.fn.getTCT = function() {
        if (this[0].t) {
            return this[0].t.getCurrentItem();
        }
        return null;
    }
    //获取搜索到的节点(未完善,不建议使用)
    $.fn.searchNode = function(nodeName) {
        if (this[0].t) {
            return this[0].t.findOneNodeByName(nodeName);
        }
        return null;
    }
    

})(jQuery);
