package com.swati;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AgeServlet")

public class AgeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");

		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day"));

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		try {

			LocalDate dob = LocalDate.of(year, month, day);

			LocalDate today = LocalDate.now();

			Period age = Period.between(dob, today);

			String birthDay = dob.getDayOfWeek().toString();

			out.println("<html>");
			out.println("<head>");

			out.println("<style>");

			out.println("body{");
			out.println("font-family:Arial,sans-serif;");
			out.println("background:linear-gradient(to right,#4facfe,#00f2fe);");
			out.println("margin:0;");
			out.println("padding:0;");
			out.println("}");

			out.println(".result{");
			out.println("width:450px;");
			out.println("background:white;");
			out.println("margin:auto;");
			out.println("margin-top:100px;");
			out.println("padding:30px;");
			out.println("border-radius:15px;");
			out.println("box-shadow:0px 0px 20px rgba(0,0,0,0.3);");
			out.println("text-align:center;");
			out.println("}");

			out.println("h1{color:#007bff;}");

			out.println("h3{color:#333;}");

			out.println("</style>");

			out.println("</head>");

			out.println("<body>");

			out.println("<div class='result'>");

			out.println("<h1>Age Calculation Result</h1>");

			out.println("<h3>Name : " + name + "</h3>");

			out.println("<h3>Age : "
					+ age.getYears() + " Years "
					+ age.getMonths() + " Months "
					+ age.getDays() + " Days</h3>");

			out.println("<h3>Born On : " + birthDay + "</h3>");

			out.println("</div>");

			out.println("</body>");
			out.println("</html>");

		}

		catch(Exception e) {

			out.println("<html><body style='font-family:Arial;'>");
			out.println("<h2 style='color:red;text-align:center;'>Invalid Date Entered!</h2>");
			out.println("</body></html>");
		}
	}
}
