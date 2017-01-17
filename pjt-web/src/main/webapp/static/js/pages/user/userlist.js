layui.use(['jquery'], function() {
	window.jQuery = window.$ = layui.jquery;
	$('.delUser').click(function(){
		var id = $(this).attr('data-id');
		MsgUtil.cfm({msg:"是否删除编号是"+id+"的记录？",
			yes:function(){
				var req = new Request();
				req.post({
					url:"/user/deleteuser.htm",
					param:{userId:id},
					suc:function(rslt){
						CommonUtil.refreshCurPage();
					}
				});
			}
		});
	});
});
