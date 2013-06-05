package com.osgicn.demo.webentry.servlet;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.BundleContext;

public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BundleContext context;

	public WeatherServlet(BundleContext context) {
		this.context = context;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		doGet(request, response);
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {		
		
		String queryWord = request.getParameter("query_word");
		response.setContentType("text/html");
		ServletOutputStream output = response.getOutputStream();

		
		try {
			output.println("Result is " + queryWeather(queryWord));
			output.close();
			return;
		} catch (Exception e) {
			output.println("Error occurs");
			output.println(e.toString());
			output.close();
			return;
		}
	}
	
	private String queryWeather(String city) {
		
		if(city.equals("SZ"))
			return "cool";
		return "hot";
		
	}

}
