package edu.matc.entity;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.PI;


public class Truss {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void createTruss(double member1x1,      double member1y1,  double member1x2, double member1y2,
                            double member2x1,      double member2y1,  double member2x2, double member2y2,
                            double member3x1,      double member3y1,  double member3x2, double member3y2,
                            double pinX,           double pinY,       double rollerX,   double rollerY,
                            double forceMagnitude, double forceAngle, double forceX, double forceY) {

        Member member1 = new Member();
        member1.setMemberId(1);

        member1.setX1(member1x1);
        member1.setY1(member1y1);

        member1.setX2(member1x2);
        member1.setY2(member1y2);

        Member member2 = new Member();
        member2.setMemberId(2);

        member2.setX1(member2x1);
        member2.setY1(member2y1);

        member2.setX2(member2x2);
        member2.setY2(member2y2);

        Member member3 = new Member();
        member3.setMemberId(2);

        member3.setX1(member3x1);
        member3.setY1(member3y1);

        member3.setX2(member3x2);
        member3.setY2(member3y2);

        Members members = new Members();
        Nodes nodes = new Nodes();

        members.addMemberToList(member1);
        members.addMemberToList(member2);
        members.addMemberToList(member3);

        ArrayList<Member> listOfMembers = members.getMemberList();
        ArrayList<Node> listOfNodes = nodes.getNodeList();

        int memberIdCount = 1;

        for (Member member : listOfMembers) {
            int memberLocationInArray = memberIdCount - 1;
            //member.setMemberId(memberLocationInArray);

            member.setI12(member.calculate_i12());
            member.setJ12(member.calculate_j12());
            member.setI21(member.calculate_i21());
            member.setJ21(member.calculate_j21());


            double x1 = member.getX1();
            double y1 = member.getY1();

            double x2 = member.getX2();
            double y2 = member.getY2();

            double I1 = member.getI12();
            double J1 = member.getJ12();

            double I2 = member.getI21();
            double J2 = member.getJ21();

            boolean match1 = false;
            boolean match2 = false;

            if (listOfNodes.isEmpty()) {

                addNewNodesToEmptyNodeList(x1, x2, y1, y2, I1, I2, J1, J2, memberLocationInArray, listOfNodes);

            } else {

                match1 = compareNode1ToListOfNodes(x1, y1, I1, J1, memberLocationInArray, listOfNodes, match1);
                match2 = compareNode2ToListOfNodes(x2, y2, I2, J2, memberLocationInArray, listOfNodes, match2);

                if (!match1) {
                    addUniqueNode1ToList(x1, y1, I1, J1, memberLocationInArray, listOfNodes);
                }

                if (!match2) {
                    addUniqueNode2ToList(x2, y2, I2, J2, memberLocationInArray, listOfNodes);
                }
            }

            memberIdCount++;
        }

        putRollerYIntoNodeArray(rollerX, rollerY, listOfNodes);
        putPinXIntoNodeArray(pinX, pinY, listOfNodes);
        putPinYIntoNodeArray(pinX, pinY, listOfNodes);



        forceAngle = forceAngle*PI/180;

        double forceComponentX;
        double forceComponentY;








        for (Node node : listOfNodes) {
            logger.debug(node.toString());
        }
        logger.debug("NEW RUN");


    }


    public void addNewNodesToEmptyNodeList(double x1, double x2, double y1, double y2, double I1, double I2, double J1, double J2, int memberLocationInArray, ArrayList<Node> listOfNodes) {
        // Node 1
        Node node1 = new Node(x1, y1, I1, J1);

        double[] array1X = node1.getArrayX();
        array1X[memberLocationInArray] = I1;
        node1.setArrayX(array1X);

        double[] array1Y = node1.getArrayY();
        array1Y[memberLocationInArray] = J1;
        node1.setArrayY(array1Y);

        listOfNodes.add(node1);


        // Node 2
        Node node2 = new Node(x2, y2, I2, J2);

        double[] array2X = node2.getArrayX();
        array2X[memberLocationInArray] = I2;
        node2.setArrayX(array2X);

        double[] array2Y = node2.getArrayY();
        array2Y[memberLocationInArray] = J2;
        node2.setArrayY(array2Y);

        listOfNodes.add(node2);
    }

    public void addUniqueNode1ToList(double x1, double y1, double I1, double J1, int memberLocationInArray, ArrayList<Node> listOfNodes) {
        Node node1 = new Node(x1, y1, I1, J1);

        double[] array1X = node1.getArrayX();
        array1X[memberLocationInArray] = I1;
        node1.setArrayX(array1X);

        double[] array1Y = node1.getArrayY();
        array1Y[memberLocationInArray] = J1;
        node1.setArrayY(array1Y);

        listOfNodes.add(node1);
    }

    public void addUniqueNode2ToList(double x2, double y2, double I2, double J2, int memberLocationInArray, ArrayList<Node> listOfNodes) {
        Node node2 = new Node(x2, y2, I2, J2);

        double[] array2X = node2.getArrayX();
        array2X[memberLocationInArray] = I2;
        node2.setArrayX(array2X);

        double[] array2Y = node2.getArrayY();
        array2Y[memberLocationInArray] = J2;
        node2.setArrayY(array2Y);

        listOfNodes.add(node2);
    }

    public boolean compareNode1ToListOfNodes(double x1, double y1, double I1, double J1, int memberLocationInArray, ArrayList<Node> listOfNodes, boolean match1) {

        for (Node element : listOfNodes) {
            if (element.getX() == x1 && element.getY() == y1) {
                match1 = true;

                double[] array1X = element.getArrayX();
                array1X[memberLocationInArray] = I1;
                element.setArrayX(array1X);

                double[] array1Y = element.getArrayY();
                array1Y[memberLocationInArray] = J1;
                element.setArrayY(array1Y);

                break;
            } else {
                match1 = false;
            }
        }
        return match1;
    }

    public boolean compareNode2ToListOfNodes(double x2, double y2, double I2, double J2, int memberLocationInArray, ArrayList<Node> listOfNodes, boolean match2) {

        for (Node element : listOfNodes) {
            if (element.getX() == x2 && element.getY() == y2) {
                match2 = true;

                double[] array2X = element.getArrayX();
                array2X[memberLocationInArray] = I2;
                element.setArrayX(array2X);

                double[] array2Y = element.getArrayY();
                array2Y[memberLocationInArray] = J2;
                element.setArrayY(array2Y);

                break;
            } else {
                match2 = false;
            }
        }
        return match2;
    }

    public void putRollerYIntoNodeArray(double rx, double ry, ArrayList<Node> listOfNodes) {

        for (Node element : listOfNodes) {
            if (element.getX() == rx && element.getY() == ry) {

                double[] arrayY = element.getArrayY();

                // Roller Y always 3rd from the end
                int locationInArray = arrayY.length - 3;
                arrayY[locationInArray] = 1;
                element.setArrayY(arrayY);
            }
        }
    }

    public void putPinXIntoNodeArray(double px, double py, ArrayList<Node> listOfNodes) {

        for (Node element : listOfNodes) {
            if (element.getX() == px && element.getY() == py) {

                double[] arrayX = element.getArrayX();

                // Pin X always 2nd from the end
                int locationInArray = arrayX.length - 2;
                arrayX[locationInArray] = 1;
                element.setArrayX(arrayX);
            }
        }
    }

    public void putPinYIntoNodeArray(double px, double py, ArrayList<Node> listOfNodes) {

        for (Node element : listOfNodes) {
            if (element.getX() == px && element.getY() == py) {

                double[] arrayY = element.getArrayY();

                // Pin Y always last in array
                int locationInArray = arrayY.length - 1;
                arrayY[locationInArray] = 1;
                element.setArrayY(arrayY);
            }
        }
    }




}