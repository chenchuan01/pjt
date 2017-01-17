package com.yidingliu.pjt.test;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import javax.management.MBeanServer;

import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.Scanner;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiBootStrap {
	// 连接端口
	private int port;
	// 路径
	private String context;
	// 项目路径
	private String webappPath;
	// 扫描间隔
	private int scanIntervalSeconds;
	// 是否管理扩展
	private boolean jmxEnabled;
	//
	private Server server;
	
	private WebAppContext webapp;
	//
	private final static String SEPARATOR_CHAR_SLASH = "/";
	
	private static final String PROJECT_NAM = "pjt-api";

	private static final String WEB_SRC = PROJECT_NAM + "/src/main/webapp";

	private final Logger logger = LoggerFactory
			.getLogger(ApiBootStrap.class);

	public ApiBootStrap(String webappPath, int port, String context) {
		this(webappPath, port, context, 0, false);
	}

	public ApiBootStrap(String webappPath, int port, String context,
			int scanIntervalSeconds, boolean jmxEnabled) {
		this.webappPath = webappPath;
		this.port = port;
		this.context = context;
		this.scanIntervalSeconds = scanIntervalSeconds;
		this.jmxEnabled = jmxEnabled;
		validateConfig();
	}

	/** 判断端口、环境和项目路径 */
	private void validateConfig() {
		if (port < 0 || port > 65536) {
			throw new IllegalArgumentException("错误的端口: " + port);
		}
		if (context == null) {
			throw new IllegalStateException("错误的上下文(context): " + context);
		}
		if (webappPath == null) {
			throw new IllegalStateException("错误的项目路径(webappPath): "
					+ webappPath);
		}
	}

	//
	public void start() {
		if (server == null || server.isStopped()) {
			try {
				doStart();
			} catch (Throwable e) {
				e.printStackTrace();
				logger.info("Jetty启动错误");
				System.exit(1);
			}
		} else {
			throw new RuntimeException("Jetty Server 已经启动.");
		}
	}

	//
	public void doStart() throws Throwable {
		if (!portAvailable(port)) {
			throw new IllegalStateException("端口: " + port + " 被占用!");
		}
		System.setProperty("org.eclipse.jetty.util.URI.charset", "UTF-8");
		System.setProperty("org.eclipse.jetty.util.log.class",
				"org.eclipse.jetty.util.log.Slf4jLog");
		webapp = new WebAppContext(webappPath, context);
		webapp.setDescriptor("/WEB-INF/web.xml");
		webapp.setConfigurationDiscovered(true);
		server = new Server(port);
		server.setHandler(webapp);
		if (jmxEnabled) {
			MBeanServer mBeanServer = ManagementFactory
					.getPlatformMBeanServer();
			MBeanContainer mBeanContainer = new MBeanContainer(mBeanServer);
			server.addBean(mBeanContainer);
		}
		if (scanIntervalSeconds > 0) {
			startFileWatchScanner();
		}
		long ts = System.currentTimeMillis();
		server.start();

		ts = System.currentTimeMillis() - ts;
		logger.info(" |Jetty servlet服务已启动|  运行程序: {}  启动耗时: {}",
				webapp.getDisplayName(), String.format("%.2f sec", ts / 1000d));
		server.join();
	}

	private void startFileWatchScanner() throws Exception {
		List<File> scanList = new ArrayList<File>();
		// 定义扫描路径，开始路径为webappPath下面的WebContent/WEB-INF
		scanList.add(new File(webappPath, "WEB-INF"));
		Scanner scanner = new Scanner();
		scanner.setReportExistingFilesOnStartup(false);
		// 定义扫描时间间隔
		scanner.setScanInterval(scanIntervalSeconds);
		scanner.setScanDirs(scanList);
		scanner.addListener(new Scanner.BulkListener() {
			@SuppressWarnings("rawtypes")
			public void filesChanged(List changes) {
				logger.info("jetty 检测到您的项目目录改变,正在重新加载 ........");
				try {
					webapp.stop();
					webapp.start();
					logger.info("jetty读取完成");
				} catch (Exception e) {
					logger.info("错误！ 请重新配置，或者重启服务");
					e.printStackTrace();
				}
			}
		});
		logger.info("间隔 " + scanIntervalSeconds + " 秒后开始扫描.");
		scanner.start();
	}
	/** 判断端口是否可用和创建服务 */
	private static boolean portAvailable(int port) {
		if (port <= 0) {
			throw new IllegalArgumentException("端口: " + port + "不能小于0");
		}
		ServerSocket ss = null;
		DatagramSocket ds = null;
		try {
			ss = new ServerSocket(port);
			ss.setReuseAddress(true);
			ds = new DatagramSocket(port);
			ds.setReuseAddress(true);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	/** 得到需要访问项目的路径 */
	
	private static String getResultPath() {
		String path = ApiBootStrap.class.getResource(SEPARATOR_CHAR_SLASH).getPath();
		String webPath = path.substring(1, path.indexOf(PROJECT_NAM)) + WEB_SRC;
		return "/"+webPath;
	}

	public static void main(String[] args) {
		new ApiBootStrap(getResultPath(), 8088, "//").start();
	}
}
