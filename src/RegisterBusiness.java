import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterBusiness extends HttpServlet {
	 public void doPost(HttpServletRequest req,HttpServletResponse res){
		 //reading requested data
		 String str=req.getParameter("eid");
		 int id=Integer.parseInt(str);
		 String str2=req.getParameter("ename");
		 String gender=req.getParameter("gen");
		 String city=req.getParameter("city");
		 String str3[]=req.getParameterValues("crs");
/*
 * {"Java","Python","Oracle"}
 * {"Java","Oracle"}
 * {"Oracle"}
 */
	StringBuffer sb=new StringBuffer();
	for(String st:str3)
	{
		sb.append(st+" ");
	}
	System.out.println("Selected course : "+sb);
	String course=sb.toString();
	Connection con=getCon();
	try
	{
	  PreparedStatement pst=con.prepareStatement("insert into employeedetl values(?,?,?,?,?)");
	  pst.setInt(1,id);
	  pst.setString(2,str2);
	  pst.setString(3,gender);
	  pst.setString(4,city);
	  pst.setString(5,course);
	  int res1=pst.executeUpdate();
	  if(res1>0)
	     {
		   PrintWriter out=res.getWriter();
		   out.println("<h2>User Registration successful.....</h2>");
		   out.close();
	     } 
	  con.close();
	}catch(Exception e){
		e.printStackTrace();
	                      }
	                                                                  } //close of doPost()
                                                 
//method to connect with database
private Connection getCon()
{  Connection con=null;
   try
   {
	   Class.forName("oracle.jdbc.OracleDriver");
	    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AdvJava","AJ1234");
   }catch(Exception e){
		e.printStackTrace();
                      }
   return con;
}
                                                         }
