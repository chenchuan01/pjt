package com.yidingliu.pjt.web.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 
 * @Filename XssAndSqlFilter.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author chenchuan
 *
 * @Email 329985581@qq.com
 * 
 * @History
 * 			<li>Author: chenchuan</li>
 *          <li>Date: 2016年12月27日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class XssAndSqlFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 XssAndSqlHttpServletRequestWrapper xssRequest = new XssAndSqlHttpServletRequestWrapper((HttpServletRequest) request);  
	     chain.doFilter(xssRequest, response);  
	}

	@Override
	public void destroy() {
	}

	class XssAndSqlHttpServletRequestWrapper extends HttpServletRequestWrapper {
		HttpServletRequest orgRequest = null;

		public XssAndSqlHttpServletRequestWrapper(HttpServletRequest request) {
			super(request);
			orgRequest = request;
		}

		/**
		 * 覆盖getParameter方法，将参数名和参数值都做xss & sql过滤。<br/>
		 * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取<br/>
		 * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
		 */
		@Override
		public String getParameter(String name) {
			String value = super.getParameter(xssEncode(name));
			if (value != null) {
				value = xssEncode(value);
			}
			return value;
		}

		/**
		 * 覆盖getHeader方法，将参数名和参数值都做xss & sql过滤。<br/>
		 * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/>
		 * getHeaderNames 也可能需要覆盖
		 */
		@Override
		public String getHeader(String name) {

			String value = super.getHeader(xssEncode(name));
			if (value != null) {
				value = xssEncode(value);
			}
			return value;
		}

		/**
		 * 将容易引起xss & sql漏洞的半角字符直接替换成全角字符
		 * 
		 * @param s
		 * @return
		 */
		private String xssEncode(String s) {
			if (s == null || s.isEmpty()) {
				return s;
			} else {
				s = stripXSSAndSql(s);
			}
			StringBuilder sb = new StringBuilder(s.length() + 16);
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				switch (c) {
				case '>':
					sb.append("＞");// 转义大于号
					break;
				case '<':
					sb.append("＜");// 转义小于号
					break;
				case '\'':
					sb.append("＇");// 转义单引号
					break;
				case '\"':
					sb.append("＂");// 转义双引号
					break;
				case '&':
					sb.append("＆");// 转义&
					break;
				case '#':
					sb.append("＃");// 转义#
					break;
				default:
					sb.append(c);
					break;
				}
			}
			return sb.toString();
		}

		/**
		 * 获取最原始的request
		 * 
		 * @return
		 */
		public HttpServletRequest getOrgRequest() {
			return orgRequest;
		}

		/**
		 * 获取最原始的request的静态方法
		 * 
		 * @return
		 */
		public HttpServletRequest getOrgRequest(HttpServletRequest req) {
			if (req instanceof XssAndSqlHttpServletRequestWrapper) {
				return ((XssAndSqlHttpServletRequestWrapper) req).getOrgRequest();
			}

			return req;
		}

		/**
		 * 
		 * 防止xss跨脚本攻击（替换，根据实际情况调整）
		 */

		public String stripXSSAndSql(String value) {
			if (value != null) {
				// NOTE: It's highly recommended to use the ESAPI library and
				// uncomment the following line to
				// avoid encoded attacks.
				// value = ESAPI.encoder().canonicalize(value);
				// Avoid null characters
				// Avoid anything between script tags
				Pattern scriptPattern = Pattern.compile(
						"<[\r\n| | ]*script[\r\n| | ]*>(.*?)</[\r\n| | ]*script[\r\n| | ]*>", Pattern.CASE_INSENSITIVE);
				value = scriptPattern.matcher(value).replaceAll("");
				// Avoid anything in a
				// src="http://www.yihaomen.com/article/java/..." type of
				// e-xpression
				scriptPattern = Pattern.compile("src[\r\n| | ]*=[\r\n| | ]*[\\\"|\\\'](.*?)[\\\"|\\\']",
						Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				value = scriptPattern.matcher(value).replaceAll("");
				// Remove any lonesome </script> tag
				scriptPattern = Pattern.compile("</[\r\n| | ]*script[\r\n| | ]*>", Pattern.CASE_INSENSITIVE);
				value = scriptPattern.matcher(value).replaceAll("");
				// Remove any lonesome <script ...> tag
				scriptPattern = Pattern.compile("<[\r\n| | ]*script(.*?)>",
						Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				value = scriptPattern.matcher(value).replaceAll("");
				// Avoid eval(...) expressions
				scriptPattern = Pattern.compile("eval\\((.*?)\\)",
						Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				value = scriptPattern.matcher(value).replaceAll("");
				// Avoid e-xpression(...) expressions
				scriptPattern = Pattern.compile("e-xpression\\((.*?)\\)",
						Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				value = scriptPattern.matcher(value).replaceAll("");
				// Avoid javascript:... expressions
				scriptPattern = Pattern.compile("javascript[\r\n| | ]*:[\r\n| | ]*", Pattern.CASE_INSENSITIVE);
				value = scriptPattern.matcher(value).replaceAll("");
				// Avoid vbscript:... expressions
				scriptPattern = Pattern.compile("vbscript[\r\n| | ]*:[\r\n| | ]*", Pattern.CASE_INSENSITIVE);
				value = scriptPattern.matcher(value).replaceAll("");
				// Avoid onload= expressions
				scriptPattern = Pattern.compile("onload(.*?)=",
						Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				value = scriptPattern.matcher(value).replaceAll("");
			}
			return value;
		}
	}
}
