'use strict';
layui.use(['jquery'],function(){
	window.jQuery = window.$ = layui.jquery;
	$(function(){
		layui.use(['form'], function(){
			  var form = layui.form(),layer = layui.layer;
			  //自定义验证规则
			  form.verify({
			   	pass: [/(.+){6,12}$/, '密码必须6到12位']
			  });
			  //监听提交
			  form.on('submit(sigin)', function(data) {
				var req = new Request();
				req.post({
					url:data.form.action,
					param:data.field,
					suc:function(rslt){
						debugger;
						if(rslt.code==200){
							window.location.href=rslt.data;
						}else{
							layer.msg(rslt.msg);
						}
						
					}
				});
				return false;
			  });
		});
		
	});
});
