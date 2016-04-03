package com.BorisV.java;


import java.util.Date;
import java.util.LinkedList;

public class Ticket extends LinkedList<Ticket> implements Comparable<Ticket>{
    private int priority;
    private String reporter;   //Stores person or department who reported issue
    private String description;
    private Date dateReported;
    private Date dateOfResolution;
    protected String resolution;

    public Date getDateOfResolution() {
        return dateOfResolution;
    }

    public void setDateOfResolution(Date dateOfResolution) {
        this.dateOfResolution = dateOfResolution;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }


    //STATIC Counter - accessible to all Ticket objects.
    //If any Ticket object modifies this counter, all Ticket objects will have the modified value
    //Make it private - only Ticket objects should have access
    private static int staticTicketIDCounter = 1;
    //The ID for each ticket - instance variable. Each Ticket will have it's own ticketID variable
    protected int ticketID;

    public int getTicketID() {
        return ticketID;
    }

    public Ticket(String desc, int p, String rep, Date date) {
        this.description = desc;
        this.priority = p;
        this.reporter = rep;
        this.dateReported = date;
        this.ticketID = staticTicketIDCounter;
        staticTicketIDCounter++;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateReported() {
        return dateReported;
    }

    public void setDateReported(Date dateReported) {
        this.dateReported = dateReported;
    }



    public int compareTo(Ticket priorities) {
        int comparePriority = priorities.getPriority();
        //ascending order
//        return priority - comparePriority;

        //descending order
        return comparePriority - priority;
    }


    public String toString(){
        return("ID = " + this.ticketID + "  Issue: " + this.description + "  Priority: "
                + this.priority + "  Reported by: "
                + this.reporter + "  Reported on: " + this.dateReported);
    }

    public static void printAllTickets(LinkedList<Ticket> tickets) {
        System.out.println(" ------- All open tickets ----------");

        for (Ticket t : tickets ) {
            System.out.println(t); //Write a toString method in Ticket class
            //println will try to call toString on its argument
        }
        if (tickets.size() == 0) {
            System.out.println("  >>EMPTY<<");
        }
        System.out.println(" ------- End of Open ticket list ----------");

    }

}


