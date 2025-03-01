package com.zumba.controller;
// I think I finished the project but these things giving me errors :(
// yes
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zumba.bean.Batch;
import com.zumba.dao.BatchDao;

@WebServlet("/BatchController")
public class BatchController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BatchDao batchDao;

    public void init() {
        batchDao = new BatchDao();  // Initialize DAO
    }

    // Retrieve all batches (for ViewBatch.jsp)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Batch> batchList = batchDao.viewAllBatch();
        request.setAttribute("batches", batchList);
        request.getRequestDispatcher("ViewBatch.jsp").forward(request, response);
    }

    // Add new batch (from AddBatch.jsp)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String typeofbatch = request.getParameter("typeofbatch");
        String time = request.getParameter("time");

        Batch batch = new Batch(0, typeofbatch, time);  // Create Batch object
        int status = batchDao.addBatch(batch);  // Add to DB

        if (status > 0) {
            response.sendRedirect("ViewBatch.jsp");  // Redirect to View Batches
        } else {
            response.getWriter().println("Error");
        }
    }
}
