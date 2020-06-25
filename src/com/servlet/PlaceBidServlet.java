package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.claim.Buyer;
import com.claim.Dealership;
import com.claim.Vehicle;

/**
 * Servlet implementation class PlaceBidServlet
 */
@WebServlet("/PlaceBidServlet")
public class PlaceBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceBidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Vehicle vehicle = (Vehicle)session.getAttribute("vehicle");
		
		Boolean bidSuccessful = (Boolean)session.getAttribute("bidSuccessful");
		//reset bidSuccessful (may have been null and if so it's being set for the first time)
		bidSuccessful = false;
		
		Double offeredPrice = Double.parseDouble(request.getParameter("offeredPrice"));
		if (offeredPrice >= (vehicle.getaskingPrice()*.9)) {
			Dealership dealership = (Dealership)session.getAttribute("dealership");
			Buyer buyer = new Buyer();
			buyer.setFirstName(request.getParameter("firstName"));
			buyer.setLastName(request.getParameter("lastName"));
			buyer.setEmail(request.getParameter("email"));
			buyer.setPhoneNumber(Long.parseLong(request.getParameter("phone")));
			//sellcar method 
			dealership.sellVehicle(vehicle, buyer, offeredPrice);
			bidSuccessful = true;
			session.setAttribute("bidSuccessful", bidSuccessful);
			//send to success page
			RequestDispatcher rs = request.getRequestDispatcher("bid_successful.jsp");
			rs.forward(request, response);
		}
		else {
			//post this to session to access to decide whether give option to bid again
			session.setAttribute("bidSuccessful", bidSuccessful);
			//send back to same page with alert that price must be 90% or higher
			RequestDispatcher rs = request.getRequestDispatcher("place_bid.jsp");
			rs.forward(request, response);
		}
	}

}
