package com.zumba.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zumba.bean.Participants;
import com.zumba.dao.ParticipantsDao;

import java.io.IOException;
import java.util.List;


/**
 * Servlet implementation class ParticipantsController
 */
@WebServlet("/ParticipantsController")
public class ParticipantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ParticipantsDao participantsDao;
    
    public void init() {
    	participantsDao = new ParticipantsDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParticipantsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Participants> pList = participantsDao.viewParticipants();
		request.setAttribute("participants", pList);
		request.getRequestDispatcher("ViewParticipants.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int age = Integer.parseInt(request.getParameter("age"));
		String phonenumber = request.getParameter("phonenumber");
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		Participants participant = new Participants(0, fname, lname, age, phonenumber, bid);
		int status = participantsDao.addParticipants(participant);
		
		if (status > 0 ) {
			response.sendRedirect("ViewParticipants.jsp");
		} else {
			response.getWriter().println("Error");
		}
	}

}
