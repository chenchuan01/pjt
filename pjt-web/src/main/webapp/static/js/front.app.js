/**
 * 系统js依赖配置
 * 时间：2016年12月 
 * 作者：cc 
 * 版本：1.1
 * 描述：配置系统需要的工具模块
 */

var Global_Var ={
	/**图片服务器地址*/
	imgServerUrl:'http://file.static.kantakj.com:10000/',
	/**后台数据请求地址*/
	webServer:'',
	tools:[
	       'common',
	       'message',
	       'request'
	]
}
function _import(path){
	document.write('<script type="text/javascript" src="'+path+'"><\/script>')
}
function _importTools(toolName){
	var toolRoot = "static/js/tools/";
	var toolPath = toolRoot+toolName+".js";
	_import(toolPath);
}
function _loadConfig(){
	var toolNames =Global_Var.tools;
	//引入前端框架JS
	_import("static/layui/plugins/layui/layui.js");
	for(var i =0 ; i<toolNames.length;i++){
		_importTools(toolNames[i]);
	}
}
_loadConfig();

