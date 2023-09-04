package formproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import formbean.LoginBean;
import sun.java2d.opengl.OGLContext;

public class Login extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
//	out.println("<h1>"+"hello"+" "+"<h1>");
	LoginBean loginBean=new LoginBean();
	loginBean.setUsername(req.getParameter("user_name"));
	loginBean.setEmail(req.getParameter("user_email"));
	loginBean.setAadhar(req.getParameter("user_Adhar"));
	loginBean.setPancard(req.getParameter("user_pancard"));
	int count=1;

try{

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/formproject", "root", "umar25");
	
	  PreparedStatement statement = con.prepareStatement("SELECT * FROM formregister WHERE  aadhar_detail= ? AND pancard_detail = ?"); 

          
          statement.setString(1,loginBean.getAadhar());
          statement.setString(2,loginBean.getPancard());
          	
          
          
          try (ResultSet resultSet = statement.executeQuery()) {
              while (resultSet.next()) {
            	  count++;
                  String name1=resultSet.getString("name");
            	  out.println("<h2>"+"welcome "+name1+"<h2>");
            	  
            	  	int form_no = resultSet.getInt("form_no");
            	  	String Date = resultSet.getString("Date");
            	  	String name = resultSet.getString("name");
            	  	String address = resultSet.getString("address");
            	  	String gender = resultSet.getString("gender");
            	  	String maritalstatus = resultSet.getString("maritalstatus");
            	  	String dob = resultSet.getString("dob");
            	  	String pancard_detail = resultSet.getString("pancard_detail");
            	  	String aadhar_detail = resultSet.getString("aadhar_detail");
            	  	String email = resultSet.getString("email_detail");
            	  	String phone_detail= resultSet.getString("phone_detail");
            	  	String qulification_detail = resultSet.getString("qulification_detail");
            	  	String ssc_detail = resultSet.getString("ssc_detail");
            	  	String ssc_percentage = resultSet.getString("ssc_percentage");
            	  	String ssc_year = resultSet.getString("ssc_year");
            	  	String hsc = resultSet.getString("hsc");
            	  	String hsc_percentage = resultSet.getString("hsc_percentage");
            	  	String hsc_year = resultSet.getString("hsc_year");
            	  	String graduate = resultSet.getString("graduate");
            	  	String graduate_percentage = resultSet.getString("graduate_percentage");
            	  	String graduate_year = resultSet.getString("graduate_year");
            	  	String post_graduate = resultSet.getString("post_graduate");
            	  	String post_graduate_percentage = resultSet.getString("post_graduate_percentage");
            	  	String post_graduate_year = resultSet.getString("post_graduate_year");
            	  	String sign_detail=resultSet.getString("sign_detail");
            	  	
            	  	  	
            	  	out.println("<h2>"+"form_no"+form_no+"<h2>");
            	  	out.println("<h2>"+"date = "+Date+"<h2>");
            	  	out.println("<h2>"+"name = "+name+"<h2>");
            	  	out.println("<h2>"+"Address = "+address+"<h2>");
            	  	out.println("<h2>"+"gender = "+gender+"<h2>");
            	  	out.println("<h2>"+"maritalstatus = "+maritalstatus+"<h2>");
            	  	out.println("<h2>"+"dob = "+dob+"<h2>");
            	  	out.println("<h2>"+"pancard_detail = "+pancard_detail+"<h2>");
            	  	out.println("<h2>"+"aadhar = "+aadhar_detail+"<h2>");
            	  	out.println("<h2>"+"email = "+email+"<h2>");
            	  	out.println("<h2>"+"phone_no = "+phone_detail+"<h2>");
            	  	out.println("<h2>"+"qulification = "+qulification_detail+"<h2>");
            	  	out.println("<h2>"+"ssc_detail = "+ssc_detail+"<h2>");
            	  	out.println("<h2>"+"ssc_percentage ="+ssc_percentage+"<h2>");
            	  	out.println("<h2>"+"ssc_year = "+ssc_year+"<h2>");
            	  	out.println("<h2>"+"hsc = "+hsc+"<h2>");
            	  	out.println("<h2>"+"hsc_percentage = "+hsc_percentage+"<h2>");
            	  	out.println("<h2>"+"hsc_year = "+hsc_year+"<h2>");
            	  	out.println("<h2>"+"graduate = "+graduate+"<h2>");
            	  	out.println("<h2>"+"graduate_percentage = "+graduate_percentage+"<h2>");
            	  	out.println("<h2>"+"graduate_year = "+graduate_year+"<h2>");
            	  	out.println("<h2>"+"post_graduate = "+post_graduate+"<h2>");
            	  	out.println("<h2>"+"post_graduate_percentage = "+post_graduate_percentage+"<h2>");
            	  	out.println("<h2>"+"post_graduate = "+post_graduate_year+"<h2>");
            	  	out.println("<h2>"+"sign = "+sign_detail+"<h2>");
            	  	out.println("<a href=login.jsp>"+"logout"+"</a>");	
            	  	break;
              
              }
            if(count==1) {  
  	  		out.print("<h2>"+"login fail"+"<h2>");
  	  		out.print("<h2>"+"if not login please register first"+"<h2>");
  	  		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
  	  		rd.include(req, resp);
            }

          }
}
catch(Exception exception)
{
//	out.print("<h2>"+""+"<h2>");
//	RequestDispatcher rd=req.getRequestDispatcher("NewFile.jsp");
//	rd.forward(req, resp);
}

 
 
 }

}