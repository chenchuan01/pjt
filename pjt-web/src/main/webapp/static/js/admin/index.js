'use strict';
layui.use(['jquery','layer','element'],function(){
	window.jQuery = window.$ = layui.jquery;
	window.layer = layui.layer;
  var element = layui.element();
  
// larry-side-menu向左折叠
$('.larry-side-menu').click(function() {
  var sideWidth = $('#larry-side').width();
  if(sideWidth === 200) {
      $('#larry-body').animate({
        left: '0'
      }); //admin-footer
      $('#larry-footer').animate({
        left: '0'
      });
      $('#larry-side').animate({
        width: '0'
      });
      $('.larry-side-menu i').html("&#xe602;");
  } else {
      $('#larry-body').animate({
        left: '200px'
      });
      $('#larry-footer').animate({
        left: '200px'
      });
      $('#larry-side').animate({
        width: '200px'
      });
      $('.larry-side-menu i').html("&#xe603;");
  }
});

 
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
		if(CommonUtil.isNotNull(href)){
			
			$('.layui-tab-title li[menu-id="'+href+'"]').remove();
			$('.layui-tab-item  div[menu-id="'+href+'"]').remove();
			$('.layui-tab-title .layui-this').removeClass('layui-this');
			$('.layui-tab-content .layui-show').removeClass('layui-show');
			$('.layui-tab-title').append('<li menu-id="'+href+'" class="layui-this" >'+name+'</li>');
			$('.layui-tab-content').append('<div menu-id="'+href+'" class="layui-tab-item layui-show"></div>');
			req.goPage({
				url:href,
				suc:function(html){
					$('div[menu-id="'+href+'"]').html(html);
				}
			});
			element.init();
		}
	});
    $('#homePage').trigger('click');
});


});
