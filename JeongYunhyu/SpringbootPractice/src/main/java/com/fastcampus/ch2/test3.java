package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test3 {
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) {

		int a = (int)(Math.random()*6)+1;
		int b = (int)(Math.random()*6)+1;

		response.setContentType("text/html");	// url내용형식 지정
		response.setCharacterEncoding("utf-8");	// 인코딩
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<img src='이미지 경로"+a+"'>");
			out.println("<img src='이미지 경로"+b+"'>");
			out.println("</body>");
			out.println("</html>");
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
}
