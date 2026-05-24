package com.library;

import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        Members member = new Members();

        System.out.println();
        System.out.println("Creating a new membership");
        member.createMember();
        System.out.println();

        System.out.println("View all memberShip details");
        member.viewMembers();
    }
}