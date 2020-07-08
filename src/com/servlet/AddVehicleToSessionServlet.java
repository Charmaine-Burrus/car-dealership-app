package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.claim.Dealership;
import com.claim.Vehicle;

/**
 * Servlet implementation class AddVehicleToSessionServlet
 */
@WebServlet("/AddVehicleToSessionServlet")
public class AddVehicleToSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicleToSessionServlet() {
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
		Vehicle vehicle = dealership.getVehicleById(Long.parseLong(request.getParameter("vehicleId")));
		session.setAttribute("vehicle", vehicle);
		RequestDispatcher rs = request.getRequestDispatcher("place_bid.jsp");
		rs.forward(request, response);
	}

}
