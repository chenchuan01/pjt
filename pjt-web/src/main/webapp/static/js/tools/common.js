/**
 * 系统js公共方法类 
 * 时间：2016年09月 
 * 作者：cc 
 * 版本：1.1
 * 描述：封装系统JS公共方法
 */
var CommonUtil={
	/**
	 * 判断元素或元素val非空
	 */
	isNotNull : function(obj) {
		if (obj=='undefined'||typeof (obj) == 'undefined'||obj==null||obj=='null') {
			return false;
		}
		/** 判断元素是否有值 */
		if (typeof (obj.val) != 'undefined') {
			if (obj.val() != '' && obj.val() != 'null' && obj.val() != null) {
				return true;
			}
		}else if(typeof (obj.length) != 'undefined'){
			
			return obj.length>0;
			
		} else {
			if (obj !== '' && obj != 'null' && obj != null) {
				return true;
			}
		}
		return false;
	}
}
/**
 * 前端提示工具封装
 */
var MsgUtil={
	/**
	 * 提示信息
	 * @param msg
	 */
	info:function(msg){
		layer.alert(msg);
	},
	success:function(msg){
		layer.alert(msg,{'icon':1});
	},
	error:function(msg){
		layer.alert(msg,{'icon':2});
	},
	warning:function(msg){
		layer.alert(msg,{'icon':7});
	},
	/**
	 * 确认信息
	 * @param cfm{
	 * 	msg:确认信息
	 * 	yes:[确定]执行方法
	 * }
	 */
	cfm:function(cfm){
		layer.confirm(cfm.msg, {icon: 3, title:'确认信息'}, function(index){
		  if(cfm.yes&&typeof(cfm.yes)=='function'){
			  cfm.yes();
		  }
		  layer.close(index);
		});
	},
}