package com.BorisV.java;


import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

public class SupportTicket{


    public static void main(String[] args) {
        LinkedList<Ticket> tickets = new LinkedList<>();
        tickets.add(new Ticket("Hardware", 5, "Oscar user", new Date()));
        tickets.add(new Ticket("Screensaver", 1, "Bob user", new Date()));
        tickets.add(new Ticket("Server down ", 2, " Flo SysAdmin ", new Date()));
        tickets.add(new Ticket("Lost document ", 3, " Mick typist ", new Date()));


        Collections.sort(tickets);
//        System.out.println(tickets);


        for (Ticket obj : tickets) {
            System.out.println(obj);
        }
    }

}