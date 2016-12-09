package com.hpe.avaya.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><title>A Servlet</title></head>");
		out.println("<body>");
		out.println("请查看控制台");
		
		
		System.out.println("This is a password validate when you register!!");
		
		boolean booleanValue = true;			//该值标记是否注册成功
		if(!userName.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")) {
			out.print("<script language='javascript'>alert('You input a Wrong username, please input a email.');" + "window.location.href='login.html';</script>");
			
			System.out.println("错误提示-----请输入邮箱作为你的用户名！");
		}
		else if(!passWord.matches("^[0-9a-zA-Z_]{6,18}$")) {
			System.out.println("密码提示-----请输入字母（区分大小写）、数字");
			booleanValue = false;
		}
		else if (passWord.matches("^\\d+$") || passWord.matches("[a-zA-Z]+$") || passWord.matches("[_]+$")) {
			//全数字、全字母
			System.out.println("密码强度-----弱");
			booleanValue = false;
			
			out.print("<script language='javascript'>alert('You input a weakless password, please input a stronger one.');" + "window.location.href='login.html';</script>");
			
			System.out.println("请输入字母、数字以及下划线的组合！");
		}
		else if (Pattern.compile(".*[a-z]+.*").matcher(passWord).matches() && Pattern.compile(".*[A-Z]+.*").matcher(passWord).matches() && 
				Pattern.compile(".*[0-9]+.*").matcher(passWord).matches() && Pattern.compile(".*[_]+.*").matcher(passWord).matches()) {
			System.out.println("密码强度-----强");
		}
		else {
			System.out.println("密码强度-----中");
		}
		
		if (booleanValue) {
			out.print("<script language='javascript'>alert('Register Success, Welcome to our portal, click yes to join us.');" + "window.location.href='loginSuccess.html';</script>");
			System.out.println("注册成功，恭喜你！");
			//MD5加密密码，并保存到数据库
			MD5Test mD5 = new MD5Test();
			mD5.toMD5(passWord);
			
			System.out.println("账户密码加密后保存到数据库。");
		}else {
			out.print("<script language='javascript'>alert('PassWord Wrong. Please input your password again!');" + "window.location.href='login.html';</script>");
			System.out.println("未注册成功，请重新提交信息。");
		}
				
		out.println("</body>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
