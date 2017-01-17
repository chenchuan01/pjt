/**
 * 前端提示工具封装
 * 时间：2016年09月 
 * 作者：cc 
 * 版本：1.1
 * 描述：封装系统JS公共方法
 */

var MsgUtil={
	/**
	 * 提示信息
	 * @param msg
	 */
	info:function(msg){
		layui.use(['layer'],function(){
			var layer=layui.layer;
			layer.alert(msg);
		});
	},
	success:function(msg){
		layui.use(['layer'],function(){
			var layer=layui.layer;
			layer.alert(msg,{'icon':1});
		});
		
	},
	error:function(msg){
		layui.use(['layer'],function(){
			var layer=layui.layer;
			layer.alert(msg,{'icon':2});
		});
		
	},
	warning:function(msg){
		layui.use(['layer'],function(){
			var layer=layui.layer;
			layer.alert(msg,{'icon':7});
		});
	},
	/**
	 * 确认信息
	 * @param cfm{
	 * 	msg:确认信息
	 * 	yes:[确定]执行方法
	 * }
	 */
	cfm:function(cfm){
		layui.use(['layer'],function(){
			var layer=layui.layer;
			layer.confirm(cfm.msg, {icon: 3, title:'确认信息'}, function(index){
				  if(cfm.yes&&typeof(cfm.yes)=='function'){
					  cfm.yes();
				  }
				  layer.close(index);
				});
		});
	},
}