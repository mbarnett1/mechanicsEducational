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

        if (req.getParameter("length")             != null &&
                req.getParameter("pinLocation")    != null &&
                req.getParameter("rollerLocation") != null &&
                req.getParameter("loadLocation")   != null &&
                req.getParameter("loadMagnitude")  != null) {

            beam.setLength(         Double.parseDouble(req.getParameter("length"         )));
            beam.setPinDistance(    Double.parseDouble(req.getParameter("pinLocation"    )));
            beam.setRollerDistance( Double.parseDouble(req.getParameter("rollerLocation" )));
            beam.setForceDistance(  Double.parseDouble(req.getParameter("loadLocation"   )));
            beam.setForce(          Double.parseDouble(req.getParameter("loadMagnitude"  )));
            beam.setForceAngle(     Double.parseDouble(req.getParameter("angle"          )));


            RealVector solution = beam.solve();

            beam.setPinReactionX((    solution.getEntry(0)));
            beam.setPinReactionY((    solution.getEntry(1)));
            beam.setRollerReactionY(( solution.getEntry(2)));



            req.setAttribute("beam", beam);
            req.setAttribute("beamLength"     , beam.getLength());
            req.setAttribute("pinDistance"    , beam.getPinDistance());
            req.setAttribute("rollerDistance" , beam.getRollerDistance());
            req.setAttribute("forceDistance"  , beam.getForceDistance());





            req.setAttribute("pinReactionX"   , beam.getPinReactionX());
            req.setAttribute("pinReactionY"   , beam.getPinReactionY());
            req.setAttribute("rollerReactionY", beam.getRollerReactionY());
        }





        RequestDispatcher dispatcher = req.getRequestDispatcher("/beam.jsp");
        dispatcher.forward(req, resp);

    }
}





















