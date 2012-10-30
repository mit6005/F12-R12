package bookingsystem;

import java.util.Set;

public class BookingSystem {
  /** Make a new ticket available at the specified price for the specified flight. */
  public void publishTicket(String flightCode, int price) {
    // TODO: Implement.
    throw new UnsupportedOperationException();
  }

  /** Get tickets for a particular flight.

   @param availableOnly If true, return only available tickets. */
  public Set<Ticket> getTicketsForFlight(String flightCode, boolean availableOnly) {
    // TODO: Implement.
    throw new UnsupportedOperationException();
  }

  /** If the ticket is still available, charge the credit card the price of the ticket, and book
  the ticket if successful.
   @return true if the ticket was successfully booked, false otherwise. */
  public boolean bookTicket(Ticket ticket, CreditCard creditCard) {
    // TODO: Implement.
    throw new UnsupportedOperationException();
  }
}
