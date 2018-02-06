package project1;

import org.apache.commons.math3.linear.*;

import static java.lang.Math.cos;


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

    double angle = 0;

    double result = cos(angle);


    public RealVector solve() {

        RealMatrix coefficients =
                new Array2DRowRealMatrix(new double[][] { { 1, 0, 0 }, { 0, 1, 1}, { 0, pinDistance, rollerDistance } },
                        false);
        DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();


        RealVector constants = new ArrayRealVector(new double[] { 0, -force, -force*forceDistance - moment}, false);
        RealVector solution = solver.solve(constants);

        return solution;
    }

    public double angleTest() {
        double result = cos(angle);
        return result;
    }

}
