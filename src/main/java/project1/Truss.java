package project1;

import java.util.ArrayList;

public class Truss {

    public void createTruss(double member1x1, double member1y1, double member1x2, double member1y2, double member2x1, double member2y1, double member2x2, double member2y2, double member3x1, double member3y1, double member3x2, double member3y2) {


        Member member1 = new Member();
        member1.setX1(member1x1);
        member1.setY1(member1y1);

        member1.setX2(member1x2);
        member1.setY2(member1y2);

        Member member2 = new Member();
        member2.setX1(member2x1);
        member2.setY1(member2y1);

        member2.setX2(member2x2);
        member2.setY2(member2y2);

        Member member3 = new Member();
        member3.setX1(member3x1);
        member3.setY1(member3y1);

        member3.setX2(member3x2);
        member3.setY2(member3y2);

        Members members = new Members();

        members.addMemberToList(member1);
        members.addMemberToList(member2);
        members.addMemberToList(member3);

        ArrayList<Member> listOfMembers = members.getMemberList();

        for (Member element: listOfMembers) {
            System.out.println(element.getX1());
            System.out.println(element.getY1());
            System.out.println(element.getX2());
            System.out.println(element.getY2());

        }


    }

}
