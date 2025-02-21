package com.thread;

class TicketBooking {
    private int availableSeats = 2; // Shared resource

    synchronized void bookTicket(String passenger, int seats) { // Instance method synchronized
        System.out.println(passenger + " trying to book " + seats + " seats.");
        if (availableSeats >= seats) {
            System.out.println(passenger + " successfully booked " + seats + " seats.");
            availableSeats -= seats;
        } else {
            System.out.println(passenger + " failed to book. Not enough seats available.");
        }
        System.out.println("Remaining seats: " + availableSeats);
    }
}

public class InstanceSyncExample {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking(); // Shared object

        Thread t1 = new Thread(() -> booking.bookTicket("Biswa", 1));
        Thread t2 = new Thread(() -> booking.bookTicket("Jit", 2));

        t1.start();
        t2.start();
    }
}
