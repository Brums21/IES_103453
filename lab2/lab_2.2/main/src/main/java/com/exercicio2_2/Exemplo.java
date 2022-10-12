package com.exercicio2_2;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
 
public class Exemplo {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8680);
    ServletHandler servletHandler = new ServletHandler();
    server.setHandler(servletHandler);
            
    servletHandler.addServletWithMapping(HelloServlet.class, "/");
    
    server.start();
    server.join();
  }

public static class HelloServlet extends HttpServlet 
  {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
      Map<String,String> data = getData();
      
      response.setContentType("text/html");
      response.setStatus(HttpServletResponse.SC_OK);
      response.getWriter().println("<h1>New Hello Simple Servlet</h1>"); 
      response.getWriter().println("<html>");
      response.getWriter().println("<head>");
      response.getWriter().println("<title>Titulo</title>");
      response.getWriter().println("</head>");
      response.getWriter().println("<body>");
      response.getWriter().println("<h2>Olá " + data.get("username") + ", " + data.get("message") + "</h2>");
      response.getWriter().println("<h2>Data: " + new Date() + "</h2>");
      response.getWriter().println("</body>");
      response.getWriter().println("</html>");
    } 

    private Map<String, String> getData() 
    {
      Map<String, String> data = new HashMap<String, String>();
      data.put("username", "Guest");
      data.put("message",  "Welcome to my world !!");
      return data;
    }
  }
}
