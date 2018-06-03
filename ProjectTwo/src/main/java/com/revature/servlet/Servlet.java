package com.revature.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.revature.runners.TestNGRunner;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { TestNGRunner.class });
		testng.addListener(tla);
		testng.run();
		
		ServletOutputStream stream = null;
		BufferedInputStream buf = null;
		stream=response.getOutputStream();
		File file=new File("test-output/testng-results.xml");
		response.setContentType("text/xml");
		response.setContentLength((int)file.length());
		FileInputStream fis=new FileInputStream(file);
		buf=new BufferedInputStream(fis);
		int readBytes=0;
		while((readBytes=buf.read())!=-1) {
			stream.write(readBytes);
		}
		buf.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
