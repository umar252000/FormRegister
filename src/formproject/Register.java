package formproject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import formbean.Registerbean;

@MultipartConfig(maxFileSize = 16177215)
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int count = 1;
		InputStream inputStream = null;
		Registerbean registerbean = new Registerbean();
		registerbean.setDate(req.getParameter("date"));
		registerbean.setApplicantName(req.getParameter("applicantName"));
		registerbean.setAddress(req.getParameter("address"));
		registerbean.setGender(req.getParameter("gender"));
		registerbean.setMaritalStatus(req.getParameter("maritalStatus"));
		registerbean.setDob(req.getParameter("dob"));
		registerbean.setPan(req.getParameter("pan"));
		registerbean.setAadhar(req.getParameter("aadhar"));
		registerbean.setEmail(req.getParameter("email"));
		registerbean.setPhone(req.getParameter("contact"));
		registerbean.setQualification(req.getParameter("qualification"));
		registerbean.setSSC(req.getParameter("SSC"));
		registerbean.setSSC_Percentage(req.getParameter("SSC_Percentage"));
		registerbean.setSSC_Year(req.getParameter("SSC_Year"));
		registerbean.setHSC(req.getParameter("HSC"));
		registerbean.setHSC_Percentage(req.getParameter("HSC_Percentage"));
		registerbean.setHSC_Year(req.getParameter("HSC_Year"));
		registerbean.setGraduate(req.getParameter("Graduate"));
		registerbean.setGraduate_Percentage(req.getParameter("Graduate_Percentage"));
		registerbean.setGraduate_Year(req.getParameter("Graduate_Year"));
		registerbean.setPost_Graduate(req.getParameter("Post_Graduate"));
		registerbean.setPost_Graduate_Percentage(req.getParameter("Post_Graduate_Percentage"));
		registerbean.setPost_Graduate_Year(req.getParameter("Post_Graduate_Year"));
		registerbean.setSign(req.getParameter("sign"));

		// obtains the upload file part in this multipart request
		Part filePart = req.getPart("photo");
		System.out.println(filePart);
		if (filePart != null) {
			// prints out some information for debugging
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());

			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/formproject", "root", "umar25");

			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM formregister WHERE  aadhar_detail= ? AND pancard_detail = ?");

			statement.setString(1, registerbean.getAadhar());
			statement.setString(2, registerbean.getPan());

			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					count++;
					if (count == 2) {
						out.print("<h2>" + "" + "<h2>");
						out.print("<h2>" + " please enter the correct addhar_no and pancard_no" + "<h2>");
						RequestDispatcher rd = req.getRequestDispatcher("NewFile.jsp");
						rd.include(req, resp);
					}
				}
			}

			if (count == 1) {
				PreparedStatement psmt = con.prepareStatement(
						"insert into formregister( Date, name, address, gender, maritalstatus, dob, pancard_detail, aadhar_detail, email_detail, phone_detail, qulification_detail, ssc_detail, ssc_percentage, ssc_year, hsc, hsc_percentage, hsc_year, graduate, graduate_percentage, graduate_year, post_graduate, post_graduate_percentage, post_graduate_year, sign_detail,photo) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
				psmt.setString(1, registerbean.getDate());
				psmt.setString(2, registerbean.getApplicantName());
				psmt.setString(3, registerbean.getAddress());
				psmt.setString(4, registerbean.getGender());
				psmt.setString(5, registerbean.getMaritalStatus());
				psmt.setString(6, registerbean.getDob());
				psmt.setString(7, registerbean.getPan());
				psmt.setString(8, registerbean.getAadhar());
				psmt.setString(9, registerbean.getEmail());
				psmt.setString(10, registerbean.getPhone());
				psmt.setString(11, registerbean.getQualification());
				psmt.setString(12, registerbean.getSSC());
				psmt.setString(13, registerbean.getSSC_Percentage());
				psmt.setString(14, registerbean.getSSC_Year());
				psmt.setString(15, registerbean.getHSC());
				psmt.setString(16, registerbean.getHSC_Percentage());
				psmt.setString(17, registerbean.getHSC_Year());
				psmt.setString(18, registerbean.getGraduate());
				psmt.setString(19, registerbean.getGraduate_Percentage());
				psmt.setString(20, registerbean.getGraduate_Year());
				psmt.setString(21, registerbean.getPost_Graduate());
				psmt.setString(22, registerbean.getPost_Graduate_Percentage());
				psmt.setString(23, registerbean.getPost_Graduate_Year());
				psmt.setString(24, registerbean.getSign());

				if (inputStream != null) {
					// fetches input stream of the upload file for the blob column
					psmt.setBlob(25, inputStream);
				}

				int i = psmt.executeUpdate();
				if (i > 0) {

					String filename = "C:\\Users\\TSIS\\Desktop\\Java_Programe.pdf";
					Document document = new Document();
					PdfWriter.getInstance(document, new FileOutputStream(filename));
					document.open();
					Paragraph paragraph = new Paragraph(registerbean.getApplicantName() + "\n " + "\n "
							+ registerbean.getAadhar() + "\n " + registerbean.getGender() + "\n "
							+ registerbean.getMaritalStatus() + "\n " + registerbean.getDob() + "\n "
							+ registerbean.getPan() + "\n " + registerbean.getAadhar() + "\n " + registerbean.getEmail()
							+ "\n " + registerbean.getPhone() + "\n " + registerbean.getQualification() + "\n "
							+ registerbean.getSSC() + "\n " + registerbean.getSSC_Percentage() + "\n "
							+ registerbean.getSSC_Year() + "\n " + registerbean.getHSC() + "\n "
							+ registerbean.getHSC_Percentage() + "\n " + registerbean.getHSC_Year() + "\n "
							+ registerbean.getGraduate() + "\n " + registerbean.getGraduate_Percentage() + "\n "
							+ registerbean.getGraduate_Year() + "\n " + registerbean.getPost_Graduate() + "\n "
							+ registerbean.getPost_Graduate_Percentage() + "\n " + registerbean.getPost_Graduate_Year()
							+ "\n " + registerbean.getSign());
					document.add(paragraph);
					document.close();

					out.println("<h2>" + "register sucessfull" + "<h2>");
					out.println("");
					out.println("<a href=login.jsp>" + " click for login page" + "</a>");
				} else
					out.println("no record inserted");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
