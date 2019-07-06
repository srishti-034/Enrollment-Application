import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/show")
public class DisplayDetails extends HttpServlet {
   public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
	   Connection con=null;
	   try{
		    Class.forName("oracle.jdbc.OracleDriver");
		    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AdvJava","AJ1234");
		    PreparedStatement pst=con.prepareStatement("select * from employeedetl order by id");
		    ResultSet rs=pst.executeQuery();
		    PrintWriter disp=res.getWriter();
		    disp.print("<div align='center'><table style='background:#F5FFFA; border:5px solid #6699aa; font-family:corbel; font-size:20px;'><th>Id</th><th>Name</th><th>Gender</th><th>City</th><th>Courses</th>");
		    while(rs.next())
		    {
		    	disp.print("<tr>");
		    	disp.print("<td>"+rs.getInt(1)+"</td>");
		    	disp.print("<td>"+rs.getString(2)+"</td>");
		    	disp.print("<td>"+rs.getString(3)+"</td>");
		    	disp.print("<td>"+rs.getString(4)+"</td>");
		    	disp.print("<td>"+rs.getString(5)+"</td>");
		    	disp.println("</tr>");
		    }
		        disp.println("</table></div>");
	      }catch(Exception e)
	        {
	    	  e.printStackTrace();
	        }
	   
                                                                    }
                                                 }
