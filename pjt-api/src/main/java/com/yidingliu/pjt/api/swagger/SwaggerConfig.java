/**
 * ifenduo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yidingliu.pjt.api.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Ordering;
import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.ApiListingReference;
import com.mangofactory.swagger.models.dto.ResponseMessage;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * 
 * @Filename SwaggerConfig.java
 *
 * @Description api doc 自动生成器配置
 *
 * @Version 1.0
 *
 * @Author edyang
 *
 * @Email edyang123@gmail.com
 * 
 * @History
 * 			<li>Author: edyang</li>
 *          <li>Date: 2015年12月14日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
@EnableSwagger
@ComponentScan("com.yidingliu.pjt.api.web")
public class SwaggerConfig {

	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;

	/**
	 * Required to autowire SpringSwaggerConfig
	 */
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	/**
	 * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
	 * framework - allowing for multiple swagger groups i.e. same code base
	 * multiple swagger resource listings.
	 */
	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		SwaggerSpringMvcPlugin swaggerSpringMvcPlugin = new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
				.apiInfo(apiInfo());

		swaggerSpringMvcPlugin.includePatterns(".api.*");

		List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();
		responseMessages.add(new ResponseMessage(500, "系统错误", null));
		swaggerSpringMvcPlugin.globalResponseMessage(RequestMethod.POST, responseMessages);
		swaggerSpringMvcPlugin.apiVersion("2.0");
		swaggerSpringMvcPlugin.apiListingReferenceOrdering(new APIListingLexicographicalOrdering());// 重置排序规则
		Ordering<ApiListingReference> apiListingReferenceOrdering = new Ordering<ApiListingReference>() {
			@Override
			public int compare(ApiListingReference left, ApiListingReference right) {
				return left.getPosition() - right.getPosition();
			}
		};
		swaggerSpringMvcPlugin.apiListingReferenceOrdering(apiListingReferenceOrdering);

		return swaggerSpringMvcPlugin;
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("易鼎流APP 接口文档", // My Apps API Title,
				"<h3>1.注意文件服务器是独立的 </h3>"
						+ "<p>&nbsp;&nbsp;&nbsp;&nbsp;<a href='http://cq196.cn:10000'>文件服务器接口文档</a></p>"
						+ "<h3>2.公共请求结构：</h3>" + "</br><table>"
						+ "<tr><th style='width: 50px;'>参数</th> <th style='width: 150px;'>名称</th>  <th style='width: 100px;'>类型</th>    <th>说明</th></tr>"
						+ "<tr><td style='color:red;'>a</td>   <td>(accountId)用户ID</td> <td>Long</td>   <td>（唯一的，用户登陆成功后获得，若未登陆，传入0）</td></tr>"
						+ "<tr><td style='color:red;'>d</td>   <td>(deviceId)设备号</td>   <td>String</td> <td>（唯一的，硬件物理地址或者设备ID）</td></tr>"
						+ "<tr><td style='color:red;'>s</td>   <td>(Sign)MD5码</td>       <td>String</td> <td>参见接口加密校验规则</td></tr>"
						+ "<tr><td style='color:red;'>t</td>   <td>(sendTime)发送时间</td> <td>String</td>   <td>请求发送的时间(13位的时间戳)</td></tr>"
						+ "<tr><td>pageNow</td>   <td>页码</td> <td>Integer</td>   <td>请求显示分页的页码，从1开始</td></tr>"
						+ "<tr><td>pageSize</td>   <td>页面大小</td> <td>Integer</td>   <td>请求显示分页的页面大小（一次给多少条数据）默认大小为5，最大20</td></tr>"
						+ "</table>" + "<h3>3.接口加密校验规则：</h3>"
						+ "<p>将参数根据参数的升序排序，通过&进行拼接，前后去掉&，末尾加上yidingliu.com，形成待签名字符串，对待签名字符串进行MD5(32位小写)形成s值。</p>"
						+ "<p>如业务要传递的参数为：</p>"
						+ "<pre><code class='json' style='font-size: 12px;'>userName=100，password=121dsafa1239</code></pre>"
						+ "<p>排序拼接后的待签名字符串为：</p>"
						+ "<pre><code class='json' style='font-size: 12px;'>a=0&d=skfjak3990afdjeiiwjsd23&password=121dsafa1239&t=1450421839597&userName=100yidingliu.com</code></pre>"
						+ "<p>对待签名字符串MD5后：26c190cf8754d533c87d1f601987a36b，则最终请求的参数(不需要排序)为：</p>"
						+ "<pre><code class='json' style='font-size: 12px;'>userName=100&password=121dsafa1239&a=0&d=skfjak3990afdjeiiwjsd23&t=1450421839597&s=299367fec2bb1b8902f4d4dde6ff6cf5</code></pre>"
						+ "<h3>4.公共响应结构：</h3>" + "</br><table>"
						+ "<tr><th style='width: 50px;'>参数</th> <th style='width: 150px;'>名称</th>  <th style='width: 100px;'>类型</th>    <th>说明</th></tr>"
						+ "<tr><td style='color:red;'>code</td>   <td>响应代码</td>   <td>String</td>   <td>详见响应代码</td></tr>"
						+ "<tr><td style='color:red;'>msg</td>    <td>响应信息</td>   <td>String</td>   <td>辅助响应代码的提示内容</td></tr>"
						+ "<tr><td style='color:red;'>time</td>   <td>响应时间</td>   <td>String</td>   <td>请求响应时间yyyyMMddhhmmss</td></tr>"
						+ "<tr><td style='color:red;'>token</td>   <td>会话标志</td>   <td>String</td>   <td>（一次会话唯一，若要保持会话，请在http请求头中设置cookie为该值）</td></tr>"
						+ "<tr><td>size</td>   <td>页面数据大小</td>   <td>Integer</td>   <td>若返回的是list，则此项表示返回的list长度，常用于分页</td></tr>"
						+ "<tr><td>total</td>  <td>总数据大小</td>   <td>Long</td>   <td>若返回的是list，则此项表示请求参数所筛选的结果数量，常用于分页</td></tr>"
						+ "<tr><td>data</td>   <td>数据信息</td>   <td>Object/List</td>   <td>最终数据，形态为object或者list<td></tr>"
						+ "</table>" + "<h3>5.公共响应代码：</h3>" + "</br><table>"
						+ "<tr><th style='width: 50px;'>代码</th> <th>说明</th></tr>"
						+ "<tr><td>200</td>   <td>执行成功（所有业务逻辑全部通过）</td></tr>" + "<tr><td>300</td>   <td>未知异常</td></tr>"
						+ "<tr><td>301</td>   <td>数据库异常</td></tr>" + "<tr><td>302</td>   <td>json数据解析错误</td></tr>"
						+ "<tr><td>303</td>   <td>参数自检失败（必传参数缺失，参数个数不对）</td></tr>"
						+ "<tr><td>304</td>   <td>请求参数异常（请求参数格式或者类型不对）</td></tr>"
						+ "<tr><td>401</td>   <td>认证（签名）失败</td></tr>" + "<tr><td>403</td>   <td>执行失败（业务失败）</td></tr>"
						+ "<tr><td>404</td>   <td>接口未找到</td></tr>" + "<tr><td>500</td>   <td>系统错误</td></tr>"
						+ "</table>", // My Apps API Description,
				"yidingliu.com", // My Apps API terms of service,
				"edyang123@gmail.com", // My Apps API Contact Email,
				"Apache Licence", // My Apps API Licence Type,
				"");// My Apps API License URL
		return apiInfo;
	}
}
