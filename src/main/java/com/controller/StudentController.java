package com.controller; 

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.dao.StudentDao;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert")) {
			Student s=new Student();
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setMobile(request.getParameter("mobile"));
			s.setAddress(request.getParameter("address"));
			s.setGender(request.getParameter("gender"));
			StudentDao.insertStudent(s);
			response.sendRedirect("show.jsp");
		//	request.setAttribute("msg", "Data Inserted Successfully");
		//	request.getRequestDispatcher("insert.jsp").forward(request, response);
		}
	}

}
	