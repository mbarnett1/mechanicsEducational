package project1;

import org.apache.commons.math3.linear.*;


public class Beam {

    double length;

    double pinReactionY;
    double pinReactionX;
    double pinDistance;

    double simpleReactionY;
    double simpleDistance;

    double force;
    double forceDistance;



    public RealVector solve() {

        RealMatrix coefficients =
                new Array2DRowRealMatrix(new double[][] { { 0, 0, 1 }, { 1, 1, 0}, { pinDistance, simpleDistance, 0 } },
                        false);
        DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();


        RealVector constants = new ArrayRealVector(new double[] { 0, -force, -force*forceDistance }, false);
        RealVector solution = solver.solve(constants);

        return solution;
    }

}
