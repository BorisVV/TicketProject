package com.BorisV.java;


import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class AddTickets {

    protected static void addTickets(LinkedList<Ticket> ticketQueue) {
        Scanner sc = new Scanner(System.in);
        boolean moreProblems = true;
        String description;
        String reporter;
        //let's assume all tickets are created today, for testing. We can change this later if needed
        Date dateReported = new Date(); //Default constructor creates date with current date/time
        int priority;

        while (moreProblems){
            System.out.println("Enter problem");
            description = sc.nextLine();
            System.out.println("Who reported this issue?");
            reporter = sc.nextLine();
            System.out.println("Enter priority of " + description);
            priority = Integer.parseInt(sc.nextLine());

            Ticket t = new Ticket(description, priority, reporter, dateReported);
            ticketQueue.add(t);

//            Collections.sort(ticketQueue);   //This code make the list in order by priority
            //To test, let's print out all of the currently stored tickets
//            Ticket.printAllTickets(ticketQueue);

            System.out.println("More tickets to add? (y/n)");
            String more = sc.nextLine();
            if (more.equalsIgnoreCase("N")) {
                moreProblems = false;
            }
        }

    }

}
