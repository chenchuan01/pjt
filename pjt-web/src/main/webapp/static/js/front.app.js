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
	apiServer:'',
	tools:[
	       'common',
	       'request'
	]
}
function _import(toolName){
	var toolRoot = "/static/js/tools/";
	var toolPath = toolRoot+toolName+".js";
	document.write('<script type="text/javascript" src="'+toolPath+'"><\/script>')
}
function _loadConfig(){
	var toolNames =Global_Var.tools;
	for(var i =0 ; i<toolNames.length;i++){
		_import(toolNames[i]);
	}
}

_loadConfig();