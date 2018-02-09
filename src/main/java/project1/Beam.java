package project1;

import org.apache.commons.math3.linear.*;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;


public class Beam {

    private double length;

    private double pinReactionY;
    private double pinReactionX;
    private double pinDistance;

    private double rollerReactionY;
    private double rollerDistance;

    private double force;
    private double forceDistance;
    private double forceAngle;

    private double moment;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getPinReactionY() {
        return pinReactionY;
    }

    public void setPinReactionY(double pinReactionY) {
        this.pinReactionY = pinReactionY;
    }

    public double getPinReactionX() {
        return pinReactionX;
    }

    public void setPinReactionX(double pinReactionX) {
        this.pinReactionX = pinReactionX;
    }

    public double getPinDistance() {
        return pinDistance;
    }

    public void setPinDistance(double pinDistance) {
        this.pinDistance = pinDistance;
    }

    public double getRollerReactionY() {
        return rollerReactionY;
    }

    public void setRollerReactionY(double rollerReactionY) {
        this.rollerReactionY = rollerReactionY;
    }

    public double getRollerDistance() {
        return rollerDistance;
    }

    public void setRollerDistance(double rollerDistance) {
        this.rollerDistance = rollerDistance;
    }

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public double getForceDistance() {
        return forceDistance;
    }

    public void setForceDistance(double forceDistance) {
        this.forceDistance = forceDistance;
    }

    public double getForceAngle() {
        return forceAngle;
    }

    public void setForceAngle(double forceAngle) {
        this.forceAngle = forceAngle;
    }

    public double getMoment() {
        return moment;
    }

    public void setMoment(double moment) {
        this.moment = moment;
    }




    public RealVector solve() {

        forceAngle = forceAngle*PI/180;


        RealMatrix coefficients =
                new Array2DRowRealMatrix(new double[][] { { 1, 0, 0 }, { 0, 1, 1}, { 0, pinDistance, rollerDistance } },
                        false);
        DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();


        RealVector constants = new ArrayRealVector(new double[] { -force*sin(forceAngle), -force*cos(forceAngle), -force*cos(forceAngle)*forceDistance - moment}, false);
        RealVector solution = solver.solve(constants);

        return solution;
    }

}
