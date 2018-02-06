package project1;

import org.apache.commons.math3.linear.*;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;


public class Beam {

    double length;

    double pinReactionY;
    double pinReactionX;
    double pinDistance;

    double rollerReactionY;
    double rollerDistance;

    double force;
    double forceDistance;

    double moment;

    double angle;



    public RealVector solve() {

        angle = angle*PI/180;

        RealMatrix coefficients =
                new Array2DRowRealMatrix(new double[][] { { 1, 0, 0 }, { 0, 1, 1}, { 0, pinDistance, rollerDistance } },
                        false);
        DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();


        RealVector constants = new ArrayRealVector(new double[] { -force*sin(angle), -force*cos(angle), -force*cos(angle)*forceDistance - moment}, false);
        RealVector solution = solver.solve(constants);

        System.out.println("cosine of angle " + cos(angle));

        return solution;
    }

    public double angleTest() {
        double result = cos(angle);
        return result;
    }

}
