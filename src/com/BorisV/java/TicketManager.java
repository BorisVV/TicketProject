package com.BorisV.java;


import java.util.*;

public class TicketManager {

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
                    deleteByID(ticketQueue);
                } else if (task == 3) {
                    //delete a ticket
                    deleteByIssue(ticketQueue);
                } else if (task == 4) {
                    //delete a ticket
                    deleteByName(ticketQueue);
                } else if (task == 5) {
                    //delete a ticket
                    printAllTickets(ticketQueue);

                } else if (task == 6) {
                    //Quit. Future prototype may want to save all tickets to a file
                    System.out.println("Quitting program");
                    break;
                } else {
                    System.out.println("Invalid number, enter a 1 trough 4 number");
                    //this will happen for 3 or any other selection that is a valid int
                    //TODO --DONE-- Program crashes if you enter anything else - please fix
                    //I added or created a try and catch with a NumberFormatException to catch the error....
                    //Default will be print all tickets
                    printAllTickets(ticketQueue);
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
            printAllTickets(ticketQueue);

            System.out.println("More tickets to add?");
            String more = sc.nextLine();
            if (more.equalsIgnoreCase("N")) {
                moreProblems = false;
            }
        }

    }

//    protected static void deleteTicket(LinkedList<Ticket> ticketQueue) {
//        printAllTickets(ticketQueue);   //display list for user
//        int deleteID = 0;
//        if (ticketQueue.size() == 0) {    //no tickets!
//            System.out.println("No tickets to delete!\n");
//            return;
//        }
//        try {
//            Scanner deleteScanner = new Scanner(System.in);
//            System.out.println("Enter ID of ticket to delete");
//            deleteID = deleteScanner.nextInt();
//
//            System.out.println();
//
//            //Loop over all tickets. Delete the one with this ticket ID
//            boolean found = false;
//            for (Ticket ticket : ticketQueue) {
//                if (ticket.getTicketID() == deleteID) {
//                    found = true;
//                    ticketQueue.remove(ticket);
//                    System.out.println(String.format("Ticket %d deleted", deleteID));
//                    break; //don't need loop any more.
//                }
////                } else if (ticket.getTicketID() != deleteID) System.out.println("Ticket not found");
//            }
//            if (found == false)
//                System.out.println("Ticket not found");
//        }catch (InputMismatchException ime) {
//            System.out.println("Invalid entry -- Enter a number");
//            //TODO --DONE-– re-write this method to ask for ID again if not found
//            //I added the try and catch to it, if user enter a string, the program will continue to run, and will print
//            //out a message.
//        }
//
//
//        printAllTickets(ticketQueue);  //print updated list
//
//    }


    public static void deleteByID(LinkedList<Ticket> ticketQueue) {
        printAllTickets(ticketQueue);   //display list for user
        int deleteID = 0;
        if (ticketQueue.size() == 0) {    //no tickets!
            System.out.println("No tickets to delete!\n");
            return;
        }
        try {
            Scanner deleteScanner = new Scanner(System.in);
            System.out.println("Enter ID of ticket to delete");
            deleteID = deleteScanner.nextInt();

            System.out.println();

            //Loop over all tickets. Delete the one with this ticket ID
            boolean found = false;
            for (Ticket ticket : ticketQueue) {
                if (ticket.getTicketID() == deleteID) {
                    found = true;
                    ticketQueue.remove(ticket);
                    System.out.println(String.format("Ticket %d deleted", deleteID));
                    break; //don't need loop any more.
                }
//                } else if (ticket.getTicketID() != deleteID) System.out.println("Ticket not found");
            }
            if (found == false)
                System.out.println("Ticket not found");
        }catch (InputMismatchException ime) {
            System.out.println("Invalid entry -- Enter a number");
            //TODO --DONE-– re-write this method to ask for ID again if not found
            //I added the try and catch to it, if user enter a string, the program will continue to run, and will print
            //out a message.
        }


        printAllTickets(ticketQueue);  //print updated list

    }
    public static void deleteByIssue(LinkedList<Ticket> ticketQueue) {
        printAllTickets(ticketQueue);   //display list for user

        if (ticketQueue.size() == 0) {    //no tickets!
            System.out.println("No tickets to delete!\n");
            return;
        }

        try {
        String deleteByIssue = " ";
            Scanner issueScan = new Scanner(System.in);
            System.out.println("Enter the description of ticket to delete");
            deleteByIssue = issueScan.nextLine();

            System.out.println();

            //Loop over all tickets. Delete the one with this ticket ID
            boolean found = false;
            for (Ticket ticket : ticketQueue) {
                if (ticket.getDescription().equalsIgnoreCase(deleteByIssue))  {
                    found = true;
                    ticketQueue.remove(ticket);

                    System.out.println("Ticket with the " + deleteByIssue + " issue was deleted");
                    break; //don't need loop any more.
                }
//                } else if (ticket.getTicketID() != deleteID) System.out.println("Ticket not found");
            }
            if (found == false)
                System.out.println("Ticket not found");
        }catch (InputMismatchException ime) {
            System.out.println("Invalid entry");
            //TODO --DONE-– re-write this method to ask for ID again if not found
            //I added the try and catch to it, if user enter a string, the program will continue to run, and will print
            //out a message.
        }


        printAllTickets(ticketQueue);  //print updated list
    }
    public static void deleteByName(LinkedList<Ticket> ticketQueue) {
        printAllTickets(ticketQueue);   //display list for user


        if (ticketQueue.size() == 0) {    //no tickets!
            System.out.println("No tickets to delete!\n");
            return;
        }
        try {
            String deleteByName = " ";
            Scanner nameScan = new Scanner(System.in);
            System.out.println("Enter the name/reporter of ticket to delete");
            deleteByName = nameScan.nextLine();

            System.out.println();

            //Loop over all tickets. Delete the one with this ticket ID
            boolean found = false;
            for (Ticket ticket : ticketQueue) {
                if (ticket.getReporter().equalsIgnoreCase(deleteByName)) {
                    found = true;
                    ticketQueue.remove(ticket);
                    System.out.println("Ticket reported by " + deleteByName + " was deleted");
                    break; //don't need loop any more.
                }
//                } else if (ticket.getTicketID() != deleteID) System.out.println("Ticket not found");
            }
            if (found == false)
                System.out.println("Ticket not found");
        }catch (InputMismatchException ime) {
            System.out.println("Invalid entry -- Enter a number");
            //TODO --DONE-– re-write this method to ask for ID again if not found
            //I added the try and catch to it, if user enter a string, the program will continue to run, and will print
            //out a message.
        }


        printAllTickets(ticketQueue);  //print updated list

    }

    protected static void addResolvedTickets(LinkedList<Ticket> resolvedTicketsQueue) {
        Ticket resolved = new Ticket();
        resolvedTicketsQueue.add(resolved);
    }

    protected static void printAllTickets(LinkedList<Ticket> tickets) {
        System.out.println(" ------- All open tickets ----------");

        for (Ticket t : tickets ) {
            System.out.println(t); //Write a toString method in Ticket class
            //println will try to call toString on its argument
        }
        System.out.println(" ------- End of ticket list ----------");

    }
}
