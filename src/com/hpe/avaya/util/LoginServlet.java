package com.hpe.avaya.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		out.println("请查看控制台");
		System.out.println("This is a password validate when you login!!");
		
		MD5Test mD5 = new MD5Test();
		String str = mD5.toMD5(passWord);
		if (passWord.isEmpty() || username.isEmpty()) {
			
			System.out.println("无效输入，请重新输入！");
		}
		else if(  str.equals("580c9c3326d5b964a856f5000f89a079")  ) {
			
			System.out.println("登录成功");
		}
		else{
			System.out.println("登录失败，请重新输入");
		}
	}

}
