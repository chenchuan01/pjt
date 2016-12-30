'use strict';
layui.use(['jquery'],function(){
	window.jQuery = window.$ = layui.jquery;
});
$(function(){
	layui.use(['form'], function(){
		  var form = layui.form(),
		  layer = layui.layer;
		  //自定义验证规则
		  form.verify({
		   	pass: [/(.+){6,12}$/, '密码必须6到12位']
		  });
		  
		});
});