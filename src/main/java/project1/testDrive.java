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
        urlPatterns = {"/test"}
)

public class testDrive extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        Beam myBeam = new Beam();

        myBeam.length = 2;

        myBeam.pinDistance = 0;


        myBeam.simpleDistance = 2;

        myBeam.force = -100;
        myBeam.forceDistance = 1;

        System.out.println(myBeam.solve());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);

    }
}





















