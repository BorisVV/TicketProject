package com.BorisV.java;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class SearchByName {
    public static void searchByName(LinkedList<Ticket> ticketQueue) {

        String searchByName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the person to search");
        searchByName = scanner.nextLine();

        try {
            //Loop over all tickets. Search by name.
            for (Ticket ticket : ticketQueue) {
                while (!ticket.getReporter().equalsIgnoreCase(searchByName)) {
                        System.out.println("Name not found, check spelling");
                        searchByName = scanner.nextLine();

                        if(ticket.getReporter().equalsIgnoreCase(searchByName)){
                        Ticket searchedByName = ticket;
                        TicketManager.searchByNames.add(searchedByName);
                        System.out.println("Ticket added to searchedByName list\n" + ticket);
                        }
                        break;
                }

            }
        } catch (InputMismatchException ime) {
            System.out.println("Invalid entry");
        }

    }
}
