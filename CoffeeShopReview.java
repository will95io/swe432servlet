package servlet;
/** *****************************************************************
    twoButtons.java   servlet example

        @author Jeff Offutt
********************************************************************* */

// Import Java Libraries
import java.io.*;
import java.util.*;

//Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
// CoffeeShopReview class
// CONSTRUCTOR: no constructor specified (default)
//
// ***************  PUBLIC OPERATIONS  **********************************
// public void doPost ()  --> prints a blank HTML page
// public void doGet ()  --> prints a blank HTML page
// private void PrintHead (PrintWriter out) --> Prints the HTML head section
// private void PrintBody (PrintWriter out) --> Prints the HTML body with
//              the form. Fields are blank.
// private void PrintBody (PrintWriter out, String lhs, String rhs, String rslt)
//              Prints the HTML body with the form.
//              Fields are filled from the parameters.
// private void PrintTail (PrintWriter out) --> Prints the HTML bottom
//***********************************************************************
@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/CoffeeShopReview"}
    )


public class CoffeeShopReview extends HttpServlet
{

/** *****************************************************
 *  Overrides HttpServlet's doPost().
 *  Converts the values in the form, performs the operation
 *  indicated by the submit button, and sends the results
 *  back to the client.
********************************************************* */
public void doPost (HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
{

   // first, set the "content type" header of the response
   response.setContentType ("text/html");
   //Get the response's PrintWriter to return text to the client.
   PrintWriter toClient = response.getWriter ();

   String para;
   Enumeration paraNames = request.getParameterNames();

   toClient.println("<html>");
   toClient.println("<head>");
   toClient.println("  <title>Generic form handler</title>");
   toClient.println("</head>");

   toClient.println("<body bgcolor=\"#DDEEDD\">");
   toClient.println("");
   toClient.println("<center><h2>Generic form handler</h2></center>");
   toClient.println("<p>");
   toClient.println("The following table lists all parameter names and");
   toClient.println("their values that were submitted from your form.");
   toClient.println("</p>");
   toClient.println("");
   toClient.println("<p>");
   toClient.println("<table cellSpacing=1 cellPadding=1 width=\"75%\" border=1 bgColor=lavender>");
   toClient.println("");
   toClient.println("  <tr bgcolor=\"#FFFFFF\">");
   toClient.println("   <th align=\"center\"><b>Parameter</b></td>");
   toClient.println("   <th align=\"center\"><b>Value</b></td>");
   toClient.println("  </tr>");

   while (paraNames.hasMoreElements())
   {  // For each parameter name.
      para = (String)paraNames.nextElement();
      if (!para.equalsIgnoreCase("submit"))
      {
         toClient.println("  <tr>");
         toClient.println("    <td style=\"width: 20%\" width=\"20%\"><b>" + para + "</b></td>");

         String[] values = request.getParameterValues(para);

         if (values != null && !values[0].equals(""))
            toClient.println("    <td>" + values[0] + "</td></tr>");
         else
            toClient.println("    <td>&nbsp;</td></tr>");

         for (int i = 1; i < values.length; i++)
         {
            if (!values[i].equals(""))
            {
               toClient.println("  <tr>");
               toClient.println("    <td style=\"width: 20%\" width=\"20%\">&nbsp;</td>");
               toClient.println("    <td>" + values[i] + "</td></tr>");
            }
         }
      }
   }
   toClient.println("</table>");
   toClient.println("");
   toClient.println("</body>");
   toClient.println("</html>");

   toClient.println("");

   // Close the writer; the response is done.
   toClient.close();   
}  // End doPost

/** *****************************************************
 *  Overrides HttpServlet's doGet().
 *  Prints an HTML page with a blank form.
********************************************************* */
public void doGet (HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException
{
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   PrintHead(out);
   PrintBody(out);
   PrintTail(out);
} // End doGet

/** *****************************************************
 *  Prints the <head> of the HTML page, no <body>.
********************************************************* */
private void PrintHead (PrintWriter out)
{

out.println("<html>");
out.println("        <head>");
out.println("                <title>Assignment 6</title>");
out.println("                <link rel=\"shortcut icon\" type=\"image/png\" href=\"https://media3.s-nbcnews.com/j/newscms/2019_33/2203981/171026-better-coffee-boost-se-329p_67dfb6820f7d3898b5486975903c2e51.fit-2000w.jpg\">");
out.println("<style>");
out.println("/* Modal background */");
out.println(".modal {");
out.println("  display: none; /* Hidden by default */");
out.println("  position: fixed; /* Stay in place */");
out.println("  z-index: 1; /* Sit on top */");
out.println("  padding-top: 100px; /* Location of the box */");
out.println("  padding-bottom: 100px;");
out.println("  left: 0;");
out.println("  top: 0;");
out.println("  width: 100%; /* Full width */");
out.println("  height: 100%; /* Full height */");
out.println("  overflow: auto; /* Enable scroll if needed */");
out.println("  background-color: rgb(0,0,0); /* Fallback color */");
out.println("  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */");
out.println("}");
out.println("");
out.println("/* Modal Content */");
out.println(".modal-content {");
out.println("  background-color: #fefefe;");
out.println("  margin: auto;");
out.println("  padding: 20px;");
out.println("  border: 1px solid #888;");
out.println("  width: 80%;");
out.println("}");
out.println("");
out.println("/* The Close Button */");
out.println(".close {");
out.println("  color: #aaaaaa;");
out.println("  float: right;");
out.println("  font-size: 28px;");
out.println("  font-weight: bold;");
out.println("}");
out.println("");
out.println(".close:hover,");
out.println(".close:focus {");
out.println("  color: #000;");
out.println("  text-decoration: none;");
out.println("  cursor: pointer;");
out.println("}");
out.println("");
out.println("        a {");
out.println("        text-decoration: none;");
out.println("        display: inline-block;");
out.println("        padding: 8px 16px;");
out.println("        } ");
out.println("        a:hover {");
out.println("        background-color: #ddd;");
out.println("        color: black;");
out.println("        }                ");
out.println("        .previous {");
out.println("        background-color: #f1f1f1;");
out.println("        color: black;");
out.println("        }                ");
out.println("        .next {");
out.println("        background-color: #f1f1f1;");
out.println("        color: black;");
out.println("        }               ");
out.println("        .round {");
out.println("        border-radius: 50%;");
out.println("        }");
out.println("</style>");
out.println("        </head>");
} // End PrintHead

/** *****************************************************
 *  Prints the <BODY> of the HTML page with the form data
 *  values from the parameters.
********************************************************* */
private void PrintBody (PrintWriter out, String lhs, String rhs, String rslt)
{

out.println("        <style>");
out.println("                body {background-color:#ddf8ff}");
out.println("        </style>");
out.println("        <body>");
out.println("        <div style=\"text-align:center\"><h1>GMU CAMPUS COFFEE</h1>");
out.println("                                ");
out.println("                 <button onclick=\"displayDate()\">today is?</button>");
out.println("                         <script>");
out.println("                                 function displayDate() {");
out.println("                                     document.getElementById(\"demo\").innerHTML = Date();");
out.println("                                }");
out.println("                        </script>");
out.println("                         <p id=\"demo\"></p>");
out.println("");
out.println("                <h4>Link to<a href=\"http://mason.gmu.edu/~kshiffl/\">Kim's Webpage</a></h4>");
out.println("");
out.println(" <!-- Trigger To Open The Modal -->");
out.println("<button id=\"myBtn\">Collaboration Summary</button>");
out.println("");
out.println("<!-- The Modal -->");
out.println("<div id=\"myModal\" class=\"modal\">");
out.println("");
out.println("  <!-- Modal content -->");
out.println("  <div class=\"modal-content\">");
out.println("    <span class=\"close\">&times;</span>");
out.println("    <p> The work was split evenly. Kim worked mostly on the HTML layout/format of the webpage and Intergrating the HTML onto the Java Servlet. Willy worked mostly on the form handling events and deploying the web page on heroku. We both did some code reviews and refactoring </p>");
out.println("  </div>");
out.println("");
out.println("</div>");
out.println("");
out.println("<script>");
out.println("        // Get the modal");
out.println("        var modal = document.getElementById(\"myModal\");");
out.println("        ");
out.println("        // Get the button that opens the modal");
out.println("        var btn = document.getElementById(\"myBtn\");");
out.println("        ");
out.println("        // Get the <span> element that closes the modal");
out.println("        var span = document.getElementsByClassName(\"close\")[0];");
out.println("        ");
out.println("        // When the user clicks the button, open the modal ");
out.println("        btn.onclick = function() {");
out.println("          modal.style.display = \"block\";");
out.println("        }");
out.println("        ");
out.println("        // When the user clicks on <span> (x), close the modal");
out.println("        span.onclick = function() {");
out.println("          modal.style.display = \"none\";");
out.println("        }");
out.println("        ");
out.println("        // When the user clicks anywhere outside of the modal, close it");
out.println("        window.onclick = function(event) {");
out.println("          if (event.target == modal) {");
out.println("            modal.style.display = \"none\";");
out.println("          }");
out.println("        }");
out.println("</script>");
out.println("<fieldset>");
out.println("<form Action=\"https://assignment-6-swe432.herokuapp.com/CoffeeShopReview\" method=\"post\">");
out.println("");
out.println("<p style = \"color:blue; font-size:25px;\"><b><i> select a coffe shop around campus and give it a rating :) </i></b></p>");
out.println("<p><b>We want our coffee to be as tasty as possible...</b></p>");
out.println("<img height=\"140\" width=\"180\"src=\"https://media3.s-nbcnews.com/j/newscms/2019_33/2203981/171026-better-coffee-boost-se-329p_67dfb6820f7d3898b5486975903c2e51.fit-2000w.jpg\">");
out.println("<br>");
out.println("");
out.println("<table>");
out.println("<tbody>");
out.println("<p>");
out.println("<b>Input the name of the location:</b>");
out.println("<br>");
out.println("<input type=\"text\" name=\"location\" size=\"20\">");
out.println("<tr>");
out.println("");
out.println("</p>");
out.println("</tbody>");
out.println("</table>");
out.println("");
out.println("<p>");
out.println("<b>Your Rating:</b>");
out.println("<br>");
out.println("<select rate=\"rating\" name=\"rating\">");
out.println("<option value=\"oneStar\" selected=“selected”>&#9733</option>");
out.println("<option value=\"twoStar\">&#9733 &#9733</option>");
out.println("<option value=\"threeStar\">&#9733 &#9733 &#9733</option>");
out.println("<option value=\"fourStar\">&#9733 &#9733 &#9733 &#9733 </option>");
out.println("<option value=\"fiveStar\">&#9733 &#9733 &#9733 &#9733 &#9733</option>");
out.println("</select>");
out.println("</p>");
out.println("");
out.println("<p>");
out.println("<b>Bonus Feature(s):</b>");
out.println("<br>");
out.println("<br>");
out.println("<input type=\"checkbox\" name=\"Wifi\" value=\"yes\"> Wifi &nbsp; &nbsp;");
out.println("<input type=\"checkbox\" name=\"Outlets\" value=\"yes\"> Outlets &nbsp; &nbsp;");
out.println("<input type=\"checkbox\" name=\"Kid\" value=\"yes\"> Kid Friendly &nbsp; &nbsp;");
out.println("<input type=\"checkbox\" name=\"Reward\" value=\"yes\"> Reward Program &nbsp; &nbsp;");
out.println("<input type=\"checkbox\" name=\"Sofa\" value=\"yes\"> Sofa(s)");
out.println("</p>");
out.println("");
out.println("<table>");
out.println("<tbody>");
out.println("<p>");
out.println("<b>Leave a brief review:</b>");
out.println("<br>");
out.println("<textarea rows=\"5\" cols=\"50\" name =\"review\" placeholder=\"Please enter your review here.\"></textarea>");
out.println("<tr>");
out.println("<br>");
out.println("<input type=\"submit\" value=\"Submit review\" name=\"submit\">");
out.println("&nbsp;&nbsp;&nbsp;");
out.println("<input type=\"reset\" value=\"Reset\" name=\"reset\">");
out.println("</p>");
out.println("</tbody>");
out.println("</table>");
out.println("</form >");
out.println("</fieldset>");
out.println("        <p>Assignment 6 instructions: <a href=\"https://cs.gmu.edu/~offutt/classes/432/assigns/assign06.html\">H6 instructions</a></p>    ");
out.println("<p> DUE TO COVID-19 WE ADVISE YOU MAKE COFFEE AT HOME, THANK YOU. </p> ");
out.println("               </div>");
out.println("        </body>");
} // End PrintBody

/** *****************************************************
 *  Overloads PrintBody (out,lhs,rhs,rslt) to print a page
 *  with blanks in the form fields.
********************************************************* */
private void PrintBody (PrintWriter out)
{
   PrintBody(out, "", "", "");
}

/** *****************************************************
 *  Prints the bottom of the HTML page.
********************************************************* */
private void PrintTail (PrintWriter out)
{
   out.println("");
   out.println("</html>");
} // End PrintTail

}  // End twoButtons
