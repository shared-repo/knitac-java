package com.examplesweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HttpServlet 클래스는 ServletConfig, Servlet, Serializable 인터페이스를 구현한 클래스
// HttpServlet 클래스 상속 -> ServletConfig, Servlet, Serializable 인터페이스를 간접 구현
public class HelloServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter(); // 클라이언트에게 데이터를 응답하는 통로 (Stream)
		
		// 클라이언트에게 HTML 응답
		out.write("<html>");
		out.write("<head>");
		out.write("<title>Hello, Servlet</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Hello, Servlet Programming World !!!</h1>");
		out.write("<h1>" + new Date() +"</h1>");
		out.write("</body>");
		out.write("</html>");
		
	}

	

}









