## 易鼎流data模块
### 目录结构
	src/main/java
	|-com.yidingliu.pjt.data
		|-base
			|-bean
			|-dto
			|-exception
			|-mapper
			|-service
		|-bean
			|-example
		|-mapper
		|-service
	src/main/resources
		|-mapping
	src/test/java
	|-com.yidingliu.pjt.data
	src/test/resources
	
### mybatis逆向生成实体、dao、example
	1.创建数据库表
	2.在src/test/resources中创建gennerator.xml文件，并配置链接数据库信息及代码生成位置(实体生成到bean中，example生成到example中，dao生成到mapper中，xml文件生成到mapping中)及表格信息
	3.运行src/test/java中GenerratorTest.java文件生成代码
	4.抽取代码中能重复使用的代码到base中
	5.创建service
	6.在src/test/resources中创建单元测试配置文件
	7.在src/test/java中创建测试文件进行单元测试