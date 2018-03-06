package edu.matc.entity;

import org.apache.commons.math3.linear.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

@Entity(name = "Beam")
@Table(name = "beam")
public class Beam {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    private User user;     //NOT user_id

    // Input Variables
    @Column(name = "length")
    private double length;

    @Column(name = "pin_distance")
    private double pinDistance;

    @Column(name = "roller_distance")
    private double rollerDistance;

    @Column(name = "force_F")
    private double force;

    @Column(name = "force_distance")
    private double forceDistance;

    @Column(name = "force_angle")
    private double forceAngle;

    @Column(name = "moment")
    private double moment;

    // Calculated Variables
    @Transient
    private double pinReactionX;

    @Transient
    private double pinReactionY;

    @Transient
    private double rollerReactionY;


    public Beam() { }

    public Beam(double length, double pinDistance, double rollerDistance, double force, double forceDistance, double forceAngle, double moment) {
        this.length = length;
        this.pinDistance = pinDistance;
        this.rollerDistance = rollerDistance;
        this.force = force;
        this.forceDistance = forceDistance;
        this.forceAngle = forceAngle;
        this.moment = moment;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getPinDistance() {
        return pinDistance;
    }

    public void setPinDistance(double pinDistance) {
        this.pinDistance = pinDistance;
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

    public double getPinReactionX() {
        return pinReactionX;
    }

    public void setPinReactionX(double pinReactionX) {
        this.pinReactionX = pinReactionX;
    }

    public double getPinReactionY() {
        return pinReactionY;
    }

    public void setPinReactionY(double pinReactionY) {
        this.pinReactionY = pinReactionY;
    }

    public double getRollerReactionY() {
        return rollerReactionY;
    }

    public void setRollerReactionY(double rollerReactionY) {
        this.rollerReactionY = rollerReactionY;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RealVector solve() {

        // Remove this when moment is implemented in inputs
        moment = 0;

        forceAngle = forceAngle*PI/180;

        double[] myArray = new double[] {0, 1, 1};


        RealMatrix coefficients =
                new Array2DRowRealMatrix(new double[][] { { 1, 0, 0 }, myArray, { 0, pinDistance, rollerDistance } },
                        false);
        DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();


        RealVector constants = new ArrayRealVector(new double[] { -force*sin(forceAngle), -force*cos(forceAngle), -force*cos(forceAngle)*forceDistance - moment}, false);
        RealVector solution = solver.solve(constants);

        return solution;
    }

}
