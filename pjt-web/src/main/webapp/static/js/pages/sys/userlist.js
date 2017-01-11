layui.use(['form'], function() {
	var $ = layui.jquery;
	var form = layui.form();
	form.on('submit(search)',function(data){
		debugger;
		var search = $('input[name="search"]').val();
		if(CommonUtil.isNotNull(search)){
			var req = new Request();
			req.post({
				url:data.form.action,
				param:data.field
			});
		}
		return false;
	});
});