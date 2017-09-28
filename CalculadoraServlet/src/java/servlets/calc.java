/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniela Quintana
 */
@WebServlet(name = "calc", urlPatterns = {"/calc"})
public class calc extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        double num1 = Double.parseDouble(request.getParameter("numero1"));
        double num2 = Double.parseDouble(request.getParameter("numero2"));
        String operacion = "";
        double resultado = 0;
        if(request.getParameter("suma") != null){
            operacion = "suma";
            resultado = num1 + num2;
        }
        if(request.getParameter("resta") != null){
            operacion = "resta";
            resultado = num1 - num2;
        }
        if(request.getParameter("division") != null){
            operacion = "división";
            resultado = num1 / num2;
        }
        if(request.getParameter("multiplicacion") != null){
            operacion = "multiplicación";
            resultado = num1 * num2;
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado de la " + operacion + "</title>");   
            out.println("<link href='https://fonts.googleapis.com/css?family=Sofia' rel='stylesheet'>");
            out.println("<style>\n" +
            " body\n" +
            " {\n" +
            " font-family: 'Sofia';font-size: 22px;\n" +
            " } \n" +
            " </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"calculadora\">");
            out.println("<br><br>");
            out.println("<center>");
            out.println("El resultado de la " + operacion + " es: <h3>" + resultado + "</h3>");
            out.println("<a href=\"index.html\">Otra operación</a>");
            out.println("</center>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
