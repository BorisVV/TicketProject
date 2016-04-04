package com.BorisV.java;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class DeleteByIssue {
    public static void deleteByIssue(LinkedList<Ticket> ticketQueue) {
        try {
            FileWriter writer = new FileWriter("ResolvedTickets-File.txt");


            Ticket.printAllTickets(ticketQueue);   //display list for user

            if (ticketQueue.size() == 0) {    //no tickets!
                System.out.println("No tickets to delete!\n");
                return;
            }

            try {
                String deleteByIssue;
                Scanner issueScan = new Scanner(System.in);
                System.out.println("Enter the issue of ticket to delete");
                deleteByIssue = issueScan.nextLine();

                //Loop over all tickets. Delete the one with this ticket ID
                boolean found = false;
                for (Ticket ticket : ticketQueue) {
                    while (!deleteByIssue.equals(ticket.getDescription())) {
                        Ticket.printAllTickets(ticketQueue);
                        System.out.println("Invalid entry, check spelling or enter 'q' to return to main menu");
                        deleteByIssue = issueScan.nextLine();
                        if (deleteByIssue.equalsIgnoreCase("q")) {
                            break;
                        }
                    }


                    if (ticket.getDescription().equalsIgnoreCase(deleteByIssue)) {
                        Ticket resolved = ticket;
                        resolved.setDateOfResolution(new Date());
                        TicketManager.resolvedTicket.add(resolved);
                        writer.write(resolved.toString()+"\n");
                        System.out.println("Ticket added to resolved list\n" + ticket);

                        found = true;
                        ticketQueue.remove(ticket);

                        System.out.println("Ticket with the >" + deleteByIssue + "< issue was deleted");
                        break; //don't need loop any more.
                    }
//                } else if (ticket.getTicketID() != deleteID) System.out.println("Ticket not found");
                }
                if (!found)
                    System.out.println("Ticket not found");
            } catch (InputMismatchException ime) {
                System.out.println("Invalid entry");
                //TODO --DONE-– re-write this method to ask for ID again if not found
                //I added the try and catch to it, if user enter a string, the program will continue to run, and will print
                //out a message.
            }

            Ticket.printAllTickets(ticketQueue);  //print updated list

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
