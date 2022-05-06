package com.mahendra.demo4;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;


public class Application {

	public static void main(String[] args) {
		URI uri;
		try {
			uri = new URI("http://localhost:4000");
			HttpServer myServer = GrizzlyHttpServerFactory.createHttpServer(uri, new MyConfig());
			myServer.start();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
