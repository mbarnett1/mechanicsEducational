package edu.matc.controller;

import edu.matc.entity.Truss;
import org.hibernate.boot.jaxb.SourceType;

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


        try {

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

            double rollerX   = Double.parseDouble(req.getParameter("rx"));
            double rollerY   = Double.parseDouble(req.getParameter("ry"));

            double pinX      = Double.parseDouble(req.getParameter("px"));
            double pinY      = Double.parseDouble(req.getParameter("py"));

            double forceMagnitude = Double.parseDouble(req.getParameter("fm"));
            double forceAngle     = Double.parseDouble(req.getParameter("fa"));
            double forceX         = Double.parseDouble(req.getParameter("fx"));
            double forceY         = Double.parseDouble(req.getParameter("fy"));


            truss.createTruss(member1x1, member1y1, member1x2, member1y2, member2x1, member2y1, member2x2, member2y2, member3x1, member3y1, member3x2, member3y2, pinX, pinY, rollerX, rollerY, forceMagnitude, forceAngle, forceX, forceY);

        } catch (NullPointerException nullPointerException) {
            System.out.println("first time visting page null form data");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/truss.jsp");
        dispatcher.forward(req, resp);
    }
}



















