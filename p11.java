//Voter.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Voter extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        if (age >= 18) {
            pw.println("<font color='green' size='4'>Welcome " + name + " to this site</font>");
        }
        else{
        pw.println("<font color='red' size='4'>Hello " + name + ", you are not authorized to visit the site</font>");
        }
        pw.println("<br><br><a href= 'index.html'>back</a>");
        pw.close();
    }
}

//index.html
<html>
 <head>
 <title>VoterApp</title>
 </head>
 <body>
 <form action= "http://localhost:8080/project1/check" method="get">
 <fieldset style="width:20%; background-color:blue;">
 <table>
 <tr><td>Name</td><td><input type="text" name="name"></td></tr>
 <tr><td>Age</td><td><input type="text" name="age"></td></tr>
 <tr><td></td>
 <td><input type = "submit" value="Check Eligibility"></td></tr>
 </table>
 </fieldset>
 </form>
 </body>
 </html>

  //web.xml
 <web-app>
 <servlet>
 <servlet-name>abc</servlet-name>
 <servlet-class>Voter</servlet-class>
 </servlet>
 <servlet-mapping>
 <servlet-name>abc</servlet-name>
 <url-pattern>/check</url-pattern>
 </servlet-mapping>
 </web-app>
