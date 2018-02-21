package project1;

public class Node {

    private double x;
    private double y;

    private double xForcesSum;
    private double yForcesSum;

    //force of each member
    private double member1;
    private double member2;
    private double member3;

    //reaction forces
    private double pinX;
    private double pinY;
    private double rollerY;



    public Node(double x, double y) {
        xForcesSum = 0;
        yForcesSum = 0;
        pinX = 0;
        pinY = 0;
        rollerY = 0;
        this.x = x;
        this.y = y;
    }

    public Node(double x, double y, double xForcesSum, double yForcesSum) {
        this.xForcesSum = xForcesSum;
        this.yForcesSum = yForcesSum;
        pinX = 0;
        pinY = 0;
        rollerY = 0;
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getXForcesSum() {
        return xForcesSum;
    }

    public void setXForcesSum(double xForcesSum) {
        this.xForcesSum = xForcesSum;
    }

    public double getYForcesSum() {
        return yForcesSum;
    }

    public void setYForcesSum(double yForcesSum) {
        this.yForcesSum = yForcesSum;
    }


    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", xForcesSum=" + xForcesSum +
                ", yForcesSum=" + yForcesSum +
                ", member1=" + member1 +
                ", member2=" + member2 +
                ", member3=" + member3 +
                ", pinX=" + pinX +
                ", pinY=" + pinY +
                ", rollerY=" + rollerY +
                '}';
    }

}
