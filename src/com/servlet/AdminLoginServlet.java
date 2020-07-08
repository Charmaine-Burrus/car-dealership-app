package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.claim.Dealership;
import com.claim.Employee;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Dealership dealership = (Dealership)session.getAttribute("dealership");
		//this boolean is used to decide whether or not to display message on login page
		boolean loginSuccessful = false;
		
		//try to find employee with these criteria
		ArrayList<Employee> employees = dealership.getEmployees();
		for (Employee currEmployee : employees) {
			//if he exists & password is correct, add him to the session and change loginSuccessful to true
			if (Integer.parseInt(request.getParameter("employeeId")) == currEmployee.getEmployeeId() 
					&& request.getParameter("password").equals(currEmployee.getPassword())) {
				Employee employee = currEmployee;
				session.setAttribute("employee", employee);
				loginSuccessful = true;
				session.setAttribute("loginSuccessful", loginSuccessful);
				//send to admin login
				RequestDispatcher rs = request.getRequestDispatcher("admin_home.jsp");
				rs.forward(request, response);
				return;
			}
		}
		session.setAttribute("loginSuccessful", loginSuccessful);
		//send back to same page with alert that login has failed
		RequestDispatcher rs = request.getRequestDispatcher("admin_login.jsp");
		rs.forward(request, response);	
	}
}
