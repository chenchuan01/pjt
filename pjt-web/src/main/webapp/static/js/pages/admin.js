layui.config({
	base: 'static/layui/js/'
}).use(['element', 'layer', 'navbar', 'tab'], function() {
	window.jQuery = window.$ = layui.jquery;
	
	var element = layui.element(),
		layer = layui.layer,
		navbar = layui.navbar(),
		tab = layui.tab({
			elem: '.admin-nav-card' //设置选项卡容器
		});
	//iframe自适应
	$(window).on('resize', function() {
		var $content = $('.admin-nav-card .layui-tab-content');
		$content.height($(this).height() - 147);
		$content.find('iframe').each(function() {
			$(this).height($content.height());
		});
	}).resize();
	
	var req=new Request();
	
	req.post({
		url:"auth/menu.htm",
		async:false,
		suc:function(rslt){
			var data = rslt.data;
			var index=1;
			var navs=[{
				title:'后台首页',
				icon:'fa fa-dashboard',
				spread:true,
				href:'dashboard.htm'
			}];
			for(var i =0;i<data.length;i++){
				if(!data[i].parentId&&data[i].displayMenu){
					var parentItem = data[i];
					navs[index]={
							title:parentItem.menuName,
							icon:parentItem.icon,
							spread:false,
					}
					var childs=[];
					var jndex=0;
					for(var j=0;j<data.length;j++){
						if(parentItem.id==data[j].parentId&&data[j].displayMenu){
							var child = data[j];
							childs[jndex]={
									title:child.menuName,
									icon:child.icon,
									spread:false,
									href:child.url
							}
							jndex++;
						}
					}
					if(childs.length>0){
						navs[index]['children']=childs;
					}
					index++;
				}
			}
			
			
			//设置navbar
			navbar.set({
				spreadOne: true,
				elem: '#admin-navbar-side',
				cached: true,
				data:navs
			});
			//渲染navbar
			navbar.render();
			//监听点击事件
			navbar.on('click(side)', function(data) {
				tab.tabAdd(data.field);
			});
		}
	});
	

	$('.admin-side-toggle').on('click', function() {
		var sideWidth = $('#admin-side').width();
		if(sideWidth === 200) {
			$('#admin-body').animate({
				left: '0'
			}); //admin-footer
			$('#admin-footer').animate({
				left: '0'
			});
			$('#admin-side').animate({
				width: '0'
			});
		} else {
			$('#admin-body').animate({
				left: '200px'
			});
			$('#admin-footer').animate({
				left: '200px'
			});
			$('#admin-side').animate({
				width: '200px'
			});
		}
	});
	//手机设备的简单适配
	var treeMobile = $('.site-tree-mobile'),
		shadeMobile = $('.site-mobile-shade');
	treeMobile.on('click', function() {
		$('body').addClass('site-mobile');
	});
	shadeMobile.on('click', function() {
		$('body').removeClass('site-mobile');
	});
});










































/*'use strict';
layui.use(['jquery','layer','element'],function(){
	window.jQuery = window.$ = layui.jquery;
	window.layer = layui.layer;
  var element = layui.element();
  

 
$(function(){
	var req = new Request();
	var element = layui.element();
	// 刷新iframe操作
    $("#refresh_iframe").click(function(){
       $(".layui-tab-content .layui-tab-item").each(function(){
          if($(this).hasClass('layui-show')){
             $(this).children('iframe')[0].contentWindow.location.reload(true);
          }
       });
    });
    //监听菜单点击跳转
    $('a[menu-href]').click(function(){
		var href=$(this).attr('menu-href');
		var name=$(this).attr('menu-name');
		var close=$(this).attr('menu-close');
		if(CommonUtil.isNotNull(href)){
			var li=$('li[menu-id="'+href+'"]');
			li.remove();
			var div=$('div[menu-id="'+href+'"]');
			div.remove();
			$('.layui-tab-title .layui-this').removeClass('layui-this');
			$('.layui-tab-content .layui-show').removeClass('layui-show');
			$('.layui-tab-title').append('<li menu-id="'+href+'" menu-close="'+close+'" class="layui-this" >'+name+'</li>');
			$('.layui-tab-content').append('<div menu-id="'+href+'" class="layui-tab-item layui-show"></div>');
			req.goPage({
				url:href,
				suc:function(html){
					var content = $('div[menu-id="'+href+'"]');
					content.html(html);
				}
			});
			element.init();
			$('li[menu-close="false"] i').remove();
		}
	});
    $('#homePage a').trigger('click');
    
});


});*/
