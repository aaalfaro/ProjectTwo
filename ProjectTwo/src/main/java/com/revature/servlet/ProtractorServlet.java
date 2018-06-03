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

/**
 * Servlet implementation class ProtractorServlet
 */
public class ProtractorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProtractorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		Process p=Runtime.getRuntime().exec("cmd /c protractor C:\\Users\\Administrator\\.jenkins\\workspace\\ProjectTwo\\Protractor\\conf.js");
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServletOutputStream stream = null;
		BufferedInputStream buf = null;
		stream=response.getOutputStream();
		File file=new File("testresults/xmloutput.xml");
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
