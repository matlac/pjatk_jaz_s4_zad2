package servlets;

import java.io.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import models.CalculateModel;
import models.CalculateRowModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;


@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();

		if(!checkData(request)){
			session.setAttribute("FormError", true);

			response.sendRedirect("/");
		} else {
			CalculateModel calculate = new CalculateModel();
			calculate.setData(Integer.parseInt(request.getParameter("amount")),
					Integer.parseInt(request.getParameter("rates_count")),
					Float.parseFloat(request.getParameter("percent")),
					request.getParameter("rates_type"));
			ArrayList<CalculateRowModel> ratesData = calculate.getData();
			session.setAttribute("rates_data", ratesData);
			request.setAttribute("calculate", ratesData);
			RequestDispatcher view = request.getRequestDispatcher("calculate.jsp");
			view.forward(request, response);
		}
	}

	private boolean checkData(HttpServletRequest request){
		String amount = request.getParameter("amount");
		String rates_count = request.getParameter("rates_count");
		String percent = request.getParameter("percent");
		String rates_type = request.getParameter("rates_type");

		return !(amount == null || amount.equals("") || rates_count == null || rates_count.equals("") ||
				percent == null || percent.equals("") || rates_type == null || rates_type.equals(""));
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		ArrayList<CalculateRowModel> ratesData = (ArrayList<CalculateRowModel>) session.getAttribute("rates_data");
		String actionValue = request.getParameter("action");

		if(actionValue != null && actionValue.equals("download_pdf") && ratesData != null && ratesData.size() > 0) {
			Document document = new Document();
			try{
				response.setContentType("application/pdf");
				PdfWriter.getInstance(document, response.getOutputStream());
				document.open();
				document.add(new Paragraph("Kalkulator rat kredytu - wynik kalkulacji"));

				PdfPTable ratesPdfTable = createRatesPdfTable(ratesData);
				document.add(ratesPdfTable);

			}catch(Exception e){
				e.printStackTrace();
			}
			document.close();

		} else {
			response.sendRedirect("/");
		}

	}

	private PdfPTable createRatesPdfTable(ArrayList<CalculateRowModel> ratesData){
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100);
		table.setSpacingBefore(10f);
		table.setSpacingAfter(10f);

		DecimalFormat df = new DecimalFormat("#0.00");

		PdfPCell cell_number_title = new PdfPCell(new Paragraph("Nr raty"));
		PdfPCell cell_amount_title = new PdfPCell(new Paragraph("Czesc kapitalowa"));
		PdfPCell cell_interest_title = new PdfPCell(new Paragraph("Odsetki"));
		PdfPCell cell_sum_title = new PdfPCell(new Paragraph("Rata"));
		cell_number_title.setPadding(10);
		cell_amount_title.setPadding(10);
		cell_interest_title.setPadding(10);
		cell_sum_title.setPadding(10);
		table.addCell(cell_number_title);
		table.addCell(cell_amount_title);
		table.addCell(cell_interest_title);
		table.addCell(cell_sum_title);

		for(CalculateRowModel row : ratesData) {
			PdfPCell cell_number = new PdfPCell(new Paragraph(Integer.toString(row.getRate_number())));
			PdfPCell cell_amount = new PdfPCell(new Paragraph(df.format((float) row.getRate_amount() / 100)));
			PdfPCell cell_interest = new PdfPCell(new Paragraph(df.format((float)row.getRate_interest() / 100)));
			PdfPCell cell_sum = new PdfPCell(new Paragraph(df.format((float)row.getRate_sum() / 100)));
			cell_number.setPadding(10);
			cell_amount.setPadding(10);
			cell_interest.setPadding(10);
			cell_sum.setPadding(10);
			table.addCell(cell_number);
			table.addCell(cell_amount);
			table.addCell(cell_interest);
			table.addCell(cell_sum);
		}

		return table;
	}
}
