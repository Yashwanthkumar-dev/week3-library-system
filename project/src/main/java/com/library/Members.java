package com.library;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Members {
    private int memberId;
    private String memberName;
    private Date createDate;
    List<Members> memberList = new ArrayList<>();

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Members(int memberId, String memberName, Date createDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.createDate = createDate;
    }

    public Members() {
    }

    public Members createMember() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your Member Id:");
        int memberId = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your Member Name:");
        String memberName = scan.nextLine();

        Date CurrentDate = new Date();

        Members mem = new Members(memberId, memberName, CurrentDate);
        memberList.add(mem);
        try {
            FileWriter writer = new FileWriter("Member.txt", true);
            writer.write(memberId + ", " + memberName + ", " + "CurrentDate");
            writer.close();
            System.out.println("Member was sucessfully stored in database");
        } catch (Exception e) {
            // TODO: handle exception
        }
        return mem;

    }

    public void viewMembers() {
        if (memberList.isEmpty()) {
            System.out.println("No member was their in database");
        } else {
            for (Members m : memberList) {
                System.out.println("Member id : " + m.memberId);
                System.out.println("Member name :" + m.memberName);
                System.out.println("Membership created date: " + m.createDate);
            }
        }

    }
}
