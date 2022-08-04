package com.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>Fetch Your Product Details:-<h3>");
		try {
			Connection con = DBConnection.getMyConnection();
			int pd = Integer.parseInt(request.getParameter("pId"));
			String str = "select * from product";
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(str);
			out.println("<table border=2 padding=2>");
			out.println("<tr><th>pID</th><th>Productname</th><th>Price</th><th>Category</th></tr>");
			while (res.next()) {
				if (res.getInt("pId") == pd) {
					out.println("<tr>");
					out.print("<td>" + res.getInt("pId") + "</td>");
					out.print("<td>" + res.getString("productname") + "</td>");
					out.print("<td>" + res.getInt("price") + "</td>");
					out.print("<td>" + res.getString("category") + "</td>");
					out.println("</tr>");
				}
				}
			out.println("</table>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
