package project1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/trussServlet"}
)

public class TrussServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getParameter("1x1")    != null &&
            req.getParameter("1y1")    != null &&
            req.getParameter("1x2")    != null &&
            req.getParameter("1y2")    != null &&

            req.getParameter("2x1")    != null &&
            req.getParameter("2y1")    != null &&
            req.getParameter("2x2")    != null &&
            req.getParameter("2y2")    != null &&

            req.getParameter("3x1")    != null &&
            req.getParameter("3y1")    != null &&
            req.getParameter("3x2")    != null &&
            req.getParameter("3y2")    != null) {

            Truss truss = new Truss();
            double member1x1 = Double.parseDouble(req.getParameter("1x1"));
            double member1y1 = Double.parseDouble(req.getParameter("1y1"));
            double member1x2 = Double.parseDouble(req.getParameter("1x2"));
            double member1y2 = Double.parseDouble(req.getParameter("1y2"));
            double member2x1 = Double.parseDouble(req.getParameter("2x1"));
            double member2y1 = Double.parseDouble(req.getParameter("2y1"));
            double member2x2 = Double.parseDouble(req.getParameter("2x2"));
            double member2y2 = Double.parseDouble(req.getParameter("2y2"));
            double member3x1 = Double.parseDouble(req.getParameter("3x1"));
            double member3y1 = Double.parseDouble(req.getParameter("3y1"));
            double member3x2 = Double.parseDouble(req.getParameter("3x2"));
            double member3y2 = Double.parseDouble(req.getParameter("3y2"));



            truss.createTruss(member1x1, member1y1, member1x2, member1y2, member2x1, member2y1, member2x2, member2y2, member3x1, member3y1, member3x2, member3y2);
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/truss.jsp");
        dispatcher.forward(req, resp);
    }
}



















