package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
/**
 *
 * @author Jaydutt
 */
public class LoginServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        
        User user = (User) session.getAttribute("user");
        
        if(logout != null) {
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request,response);
            return;
        }
        
        if(user != null) {
            response.sendRedirect("home");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request,response);
            
            return;
    }
   
}