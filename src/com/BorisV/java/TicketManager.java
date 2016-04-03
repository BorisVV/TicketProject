package com.BorisV.java;


import java.util.*;

public class TicketManager {

    protected static LinkedList<Ticket> allOpenTickets;
    protected static LinkedList<Ticket> resolvedTicket;
    protected static Scanner scan;

    public static void main(String[] args) {

        allOpenTickets = new LinkedList<>();
        resolvedTicket = new LinkedList<>();
        scan = new Scanner(System.in);

        boolean quit = false;
        while (!quit) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("------Main menu------\n" +
                        "1. Enter Ticket\n" +
                        "2. Delete TicketByID\n" +
                        "3. Delete TicketByIssue\n" +
                        "4. Delete TicketByName\n" +
                        "5. Display All Open Tickets\n" +
                        "6. Display All Resolved Tickets\n" +
                        "7. Quit");
                System.out.println(sb);

                int task = getPositiveIntInput(sb);

                if (task == 1) {
                    //Call addTickets, which will let us enter any number of new tickets
                    AddTickets.addTickets(allOpenTickets);
                } else if (task == 2) {
                    //delete a ticket
                    DeleteByID.deleteByID(allOpenTickets);

                } else if (task == 3) {
                    //delete a ticket
                    DeleteByIssue.deleteByIssue(allOpenTickets);
                } else if (task == 4) {
                    //delete a ticket
                    DeleteByName.deleteByName(allOpenTickets);
                } else if (task == 5) {
                    //Display all open tickets

                    Collections.sort(allOpenTickets);
                    Ticket.printAllTickets(allOpenTickets);
                } else if (task == 6) {
                    TicketManager.printResolvedTickets(resolvedTicket);

                } else if (task == 7) {
                    //Quit. Future prototype may want to save all tickets to a file
                    quit = true;
                    System.out.println("Quitting program");
                    break;
                }
                //this will happen for 3 or any other selection that is a valid int
                //TODO --DONE-- Program crashes if you enter anything else - please fix
                //I added or created a try and catch with a NumberFormatException to catch the error....
                //Default will be print all tickets
                //TODO code was added here.!!!
            } catch (NumberFormatException ne) {
                System.out.println("\nInvalid entry, enter a numerical number");
                //This is the new block, the try and catch method.!!!!
            }
        }

        scan.close();

    }

    private static int getPositiveIntInput(StringBuilder b) {
        while (true) {
            try {
                String stringInput = scan.nextLine();
                int intInput = Integer.parseInt(stringInput);
                if (intInput >= 0 || intInput <= 7) {
                    return intInput;
                } else {
                    System.out.println(b);
                    System.out.println("Please enter a positive number or lower");
                    continue;
                }
            } catch (NumberFormatException ime) {
                System.out.println(b);
                System.out.println("Please type a positive number");
            }
        }

    }

    public static void printResolvedTickets(LinkedList<Ticket> ticket) {
        System.out.println("Ticket added to resolved list\n" + ticket);
        System.out.println(" ------- All open tickets ----------");
        System.out.println(" ------- All Resolved tickets ----------");
        for (Ticket t: ticket)

        {
            System.out.println(t); //Write a toString method in Ticket class
            //println will try to call toString on its argument
        }

        if (ticket.size() == 0)

        {
            System.out.println("  >>EMPTY<<");
            System.out.println(" ------- End of Resolved ticket list ----------");
        }
    }
}







