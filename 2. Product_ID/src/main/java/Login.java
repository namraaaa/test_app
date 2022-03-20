import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("./Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		 String p_ID = request.getParameter("p_ID");
		 out.print("<h1>Displaying the Product Details...</h1>");
		  out.print("<table border='1'><tr><th>Product Id</th><th>Product Name</th><th>Product Price</th></tr>");

		  try {
			  String sql="select * from Details where p_ID="+104+"";
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","Jeevi@10");
		       PreparedStatement ps=dbCon.prepareStatement(sql);
		       ResultSet rs = ps.executeQuery();
		       
		       while(rs.next()) {
		        
		        out.print("<tr><td>");
		        out.println(rs.getInt(1));
		        out.print("</td>");
		        out.print("<td>");
		        out.print(rs.getString(2));
		        out.print("</td>");
		        out.print("<td>");
		        out.print(rs.getInt(3));
		        out.print("</td>");
		        out.print("</tr>");   
		   }
		       
		  }
		  catch(Exception e){
		   
		   System.out.println("Some Issue : "+ e.getMessage());
		  }
		  
		  out.print("</table>");
		  
		 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
}

