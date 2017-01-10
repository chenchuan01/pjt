layui.use(['form'], function() {
	window.jQuery = window.$ = layui.jquery;
	var form = layui.form();
	 //自定义验证规则
	form.verify({
	   pass: [/(.+){6,12}$/, '密码必须6到12位']
	});
	form.on('submit(sigin)',function(data){
		var req = new Request();
		req.post({
			url:data.form.action,
			param:data.field,
			suc:function(rslt){
				window.location.href=rslt.data;
			}
		});
		return false;
	});
});
