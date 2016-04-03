package com.BorisV.java;


import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class DeleteByID {
    public static void deleteByID(LinkedList<Ticket> ticketQueue) {
        Ticket.printAllTickets(ticketQueue);   //display list for user
        int deleteID;
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
                while (deleteID != ticket.getTicketID()) {
                    Ticket.printAllTickets(ticketQueue);
                    System.out.println("Invalid number try again, or enter 'q' to return to main menu");
                    deleteID = deleteScanner.nextInt();
                    if (Integer.toString(deleteID).equalsIgnoreCase("q")) {
                        break;
                    }
                }
                Ticket resolved = ticket;
                resolved.setDateOfResolution(new Date());
                TicketManager.resolvedTicket.add(resolved);
                System.out.println("Ticket added to resolved list\n" + ticket);

                if (ticket.getTicketID() == deleteID) {
                    found = true;
                    ticketQueue.remove(ticket);
                    break; //don't need loop any more.
                }
//                } else if (ticket.getTicketID() != deleteID) System.out.println("Ticket not found");
            }
            if (!found)
                System.out.println("Ticket not found");
        } catch (InputMismatchException ime) {
            System.out.println("Invalid entry -- Enter a number");
            //TODO --DONE-– re-write this method to ask for ID again if not found
            //I added the try and catch to it, if user enter a string, the program will continue to run, and will print
            //out a message.
        }

    }

}