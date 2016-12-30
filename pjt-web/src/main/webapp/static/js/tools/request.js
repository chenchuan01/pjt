/**
 * 前端请求类
 * 时间：2016年12月 
 * 作者：cc 
 * 版本：1.1
 * 描述：封装前端请求功能模块
 */
var Request = function(){
	var DATA_TYPE_JSON="json";
	var DATA_TYPE_JSONP="jsonp";
	var DATA_TYPE_HTML="html";
	
	var REQTYPE_POST="post";
	var REQTYPE_GET="get";
	/**
	 * POST 请求
	 */
	var post = function(reqMap){
		if(reqMap){
			reqMap['reqType']=REQTYPE_POST;
			ajax(reqMap);
		}
	};
	/**
	 * GET 请求
	 */
	var get = function(reqMap){
		if(reqMap){
			reqMap['reqType']=REQTYPE_GET;
			ajax(reqMap);
		}
	}
	/**
	 * PAGE 跳转请求
	 */
	var page = function(url){
		if(reqMap){
			reqMap['dataType']=DATA_TYPE_HTML;
			reqMap['suc']=function(rslt){
				
			};
			reqMap['err']=function(rslt){
				
			};
			ajax(reqMap);
		}
	}
	
	var success = function(){
		
	};
	var error   = function(){
		
	};
	/**
	 * 前台网络请求封装 param 
	 * reqMap{ 
	 * 		url:请求地址（非空） 
	 * 		reqType：请求类型（默认POST）
	 * 		async:是否异步（默认true） 
	 * 		param：请求参数（{}） 
	 * 		dataType：返回数据类型（默认json） 
	 * 		suc:执行成功函数
	 * 		err:执行失败函数 
	 * }
	 */
	var ajax = function(reqMap){
		var jsonp = false;
		if (CommonUtil.isNotNull(Global_Var.apiServer)) {
			reqMap.url = Global_Var.apiServer + reqMap.url;
			jsonp = true;
		}
		reqMap.async = CommonUtil.isNotNull(reqMap.async) ? reqMap.async : true;
		reqMap.reqType = CommonUtil.isNotNull(reqMap.reqType) ? reqMap.reqType: REQTYPE_POST;
		reqMap.data = CommonUtil.isNotNull(reqMap.param) ? reqMap.param : {};
		reqMap.dataType = jsonp ? DATA_TYPE_JSONP : CommonUtil.isNotNull(reqMap.dataType) ? reqMap.dataType : DATA_TYPE_JSON;

		if (jsonp) {
			ajaxJsonP(reqMap);
			return;
		}
		$('.submit').prop('disabled',true);
		if (reqMap.async == false) {
			var result = $.ajax({
								url : reqMap.url,
								async : reqMap.async,
								type : reqMap.reqType,
								data : reqMap.data,
								dataType : reqMap.dataType,
							}).responseText;
			var data = eval('(' + result + ')');
			if (data!='undefined'&&data['code']!='undefined'&&data['code'] == 200) {
				success(data, reqMap.suc);
			} else {
				error(data, reqMap.err);
			}
		} else {
			$.ajax({
				url : reqMap.url,
				type : reqMap.reqType,
				data : reqMap.data,
				dataType : reqMap.dataType,
				success : function(data) {
					success(data, reqMap.suc);
				},
				error : function(data) {
					error(data, reqMap.err);
				}
			});
		}
	};
	return {
		post:post,
		get:get,
		goPage:page,
		test:function(){
			alert("test");
		}
	};
};