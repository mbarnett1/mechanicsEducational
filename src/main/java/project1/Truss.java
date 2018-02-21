package project1;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Truss {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void createTruss(double member1x1, double member1y1, double member1x2, double member1y2, double member2x1, double member2y1, double member2x2, double member2y2, double member3x1, double member3y1, double member3x2, double member3y2) {


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

        for (Member member: listOfMembers) {

            member.setI12(member.calculate_i12());
            member.setJ12(member.calculate_j12());
            member.setI21(member.calculate_i21());
            member.setJ21(member.calculate_j21());


           double x1 = member.getX1();
           double y1 = member.getY1();

           double x2 = member.getX2();
           double y2 = member.getY2();

           double I1 =  member.getI12();
           double J1 =  member.getJ12();

           double I2 =  member.getI21();
           double J2 =  member.getJ21();

            boolean match1 = false;
            boolean match2 = false;

            if (listOfNodes.isEmpty()) {
                listOfNodes.add(new Node(x1, y1, I1, J1));
                listOfNodes.add(new Node(x2, y2, I2, J2));
            } else {

                for (Node element : listOfNodes) {
                    if (element.getX() == x1 && element.getY() == y1) {
                        match1 = true;

                        double newXForcesSum = element.getXForcesSum() + I1;
                        element.setXForcesSum(newXForcesSum);
                        double newYForcesSum = element.getYForcesSum() + J1;
                        element.setYForcesSum(newYForcesSum);

                        break;
                    } else {
                        match1 = false;
                    }
                }

                for (Node element : listOfNodes) {
                    if (element.getX() == x2 && element.getY() == y2) {
                        match2 = true;

                        double newXForcesSum = element.getXForcesSum() + I2;
                        element.setXForcesSum(newXForcesSum);
                        double newYForcesSum = element.getYForcesSum() + J2;
                        element.setYForcesSum(newYForcesSum);

                        break;
                    } else {
                        match2 = false;
                    }
                }


                if (!match1) {
                    listOfNodes.add(new Node(x1, y1, I1, J1));
                }

                if (!match2) {
                    listOfNodes.add(new Node(x2, y2, I2, J2));
                }
            }
        }

        for(Node node : listOfNodes) {
            logger.debug(node.toString());
        }
            logger.debug("NEW RUN");


    }

}
