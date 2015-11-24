package com.codetests.supermarket.catalog.starter;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Starter {

	 private static Server server = new Server(8081);

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		startIt();
	}
	public static void startIt() throws Exception {
		String webappDirLocation = "src/main/resources/";
	    WebAppContext root = new WebAppContext();
	    root.setContextPath("/");
	    root.setDescriptor(webappDirLocation + "web.xml");
	    root.setResourceBase(webappDirLocation);
	    root.setParentLoaderPriority(true);
	    server.setHandler(root);
	    server.start();
	}
	public static void stopIt() throws Exception {
		server.stop();
	}
	public static boolean isRunning() {
		return server.isRunning();
	}

}
