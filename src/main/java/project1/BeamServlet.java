package project1;


import org.apache.commons.math3.linear.RealVector;

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
        urlPatterns = {"/beamServlet"}
)

public class BeamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Beam beam = new Beam();

        if (req.getParameter("length") != null &&
                req.getParameter("pinLocation") != null &&
                req.getParameter("rollerLocation") != null &&
                req.getParameter("loadLocation") != null &&
                req.getParameter("loadMagnitude") != null) {

            beam.length = Double.parseDouble(req.getParameter("length"));
            beam.pinDistance = Double.parseDouble(req.getParameter("pinLocation"));
            beam.rollerDistance = Double.parseDouble(req.getParameter("rollerLocation"));
            beam.forceDistance = Double.parseDouble(req.getParameter("loadLocation"));
            beam.force = Double.parseDouble(req.getParameter("loadMagnitude"));
            beam.force = Double.parseDouble(req.getParameter("loadMagnitude"));
            beam.angle = Double.parseDouble(req.getParameter("angle"));


            RealVector solution = beam.solve();

            beam.pinReactionX = (solution.getEntry(0));
            beam.pinReactionY = (solution.getEntry(1));
            beam.rollerReactionY = (solution.getEntry(2));




            req.setAttribute("beamLength", beam.length);
            req.setAttribute("pinReactionX", beam.pinReactionX);
            req.setAttribute("pinReactionY", beam.pinReactionY);
            req.setAttribute("rollerReactionY", beam.rollerReactionY);
        }





        RequestDispatcher dispatcher = req.getRequestDispatcher("/beam.jsp");
        dispatcher.forward(req, resp);

    }
}





















