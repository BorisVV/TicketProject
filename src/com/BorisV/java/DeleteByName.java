package com.BorisV.java;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class DeleteByName  {

    public static void deleteByName(LinkedList<Ticket> ticketQueue) {
        Ticket.printAllTickets(ticketQueue);
        if (ticketQueue.size() == 0) {    //no tickets!
            System.out.println("No tickets to delete!\n");
            return;
        }
        try {
            String deleteByName;
            Scanner nameScan = new Scanner(System.in);
            System.out.println("Enter the name/reporter of ticket to delete");
            deleteByName = nameScan.nextLine();

            //Loop over all tickets. Delete the one with this ticket ID
            boolean found = false;
            for (Ticket ticket : ticketQueue) {
                    while (!deleteByName.equalsIgnoreCase(ticket.getReporter())) {
                        Ticket.printAllTickets(ticketQueue);
                        System.out.println("Invalid entry, check spelling or enter 'q' to quit");
                        deleteByName = nameScan.nextLine();
                        if (deleteByName.equalsIgnoreCase("q")) {
                            break;
                        }
                    }
                if (ticket.getReporter().equalsIgnoreCase(deleteByName)) {
                    found = true;
                    ticketQueue.remove(ticket);
                    System.out.println("Ticket reported by " + deleteByName + " was deleted");
                    break; //don't need loop any more.
                }
            }
            if (!found)
                System.out.println("Ticket not found");
        }catch (InputMismatchException ime) {
            System.out.println("Invalid entry -- Enter a number");
            //TODO --DONE-– re-write this method to ask for ID again if not found
            //I added the try and catch to it, if user enter a string, the program will continue to run, and will print
            //out a message.
        }
        Ticket.printAllTickets(ticketQueue);
    }

}
