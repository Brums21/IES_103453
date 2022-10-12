package lab2_1;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})

public class Main extends HttpServlet {
 
  private static final long serialVersionUID = -1915463532411657451L;
 
  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException 
  {
    //Do some work
    Map<String,String> data = getData();
     
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      // Write some content
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Titulo</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h2>Olá " + data.get("username") + ", " + data.get("message") + "</h2>");
      out.println("<h2>Dato: " + new Date() + "</h2>");
      //String exemplo = null;
      //out.println("<h2>"+ exemplo + " </h2>");
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }
  }

  private Map<String, String> getData() 
  {
    Map<String, String> data = new HashMap<String, String>();
    data.put("username", "Guest");
    data.put("message",  "Welcome to my world !!");
    return data;
  }
   
  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
  }
}