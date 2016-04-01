package com.BorisV.java;


import java.util.*;

public class TicketManager{

    public static void main(String[] args) {


        LinkedList<Ticket> ticketQueue = new LinkedList<>();
        Scanner scan = new Scanner(System.in);

        while(true){
            try {
                System.out.println("1. Enter Ticket\n2. Delete TicketByID\n3. Delete TicketByIssue\n4. Delete TicketByName\n5. Display All Tickets\n6. Quit");
                int task = Integer.parseInt(scan.nextLine());

                if (task == 1) {
                    //Call addTickets, which will let us enter any number of new tickets
                    addTickets(ticketQueue);

                } else if (task == 2) {
                    //delete a ticket
                    DeleteByID.deleteByID(ticketQueue);
                } else if (task == 3) {
                    //delete a ticket
                    DeleteByIssue.deleteByIssue(ticketQueue);
                } else if (task == 4) {
                    //delete a ticket
                   DeleteByName.deleteByName(ticketQueue);
                } else if (task == 5) {
                    //delete a ticket
                    Ticket.printAllTickets(ticketQueue);

                } else if (task == 6) {
                    //Quit. Future prototype may want to save all tickets to a file
                    System.out.println("Quitting program");
                    break;
                } else {
                    System.out.println("Invalid number, enter a 1 trough 6 number");
                    //this will happen for 3 or any other selection that is a valid int
                    //TODO --DONE-- Program crashes if you enter anything else - please fix
                    //I added or created a try and catch with a NumberFormatException to catch the error....
                    //Default will be print all tickets
                    Ticket.printAllTickets(ticketQueue);
                }
            } catch (NumberFormatException ne) {
                System.out.println("Invalid entry, enter a numerical number\n");
                //This is the new block, the try and catch method.!!!!
                //TODO code was added here.!!!
            }
        }

        scan.close();

    }

    //Move the adding ticket code to a method
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

            Ticket resolved = new Ticket(description, priority, reporter, dateReported);


//            Collections.sort(ticketQueue);   //This code make the list in order by priority
            //To test, let's print out all of the currently stored tickets
            Ticket.printAllTickets(ticketQueue);

            System.out.println("More tickets to add?");
            String more = sc.nextLine();
            if (more.equalsIgnoreCase("N")) {
                moreProblems = false;
            }
        }

    }


    protected static void addResolvedTickets(LinkedList<Ticket> resolvedTicketsQueue) {
        Ticket resolved = new Ticket();
        resolvedTicketsQueue.add(resolved);
    }

}
