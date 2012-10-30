package bookingsystem.solution;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class BookingSystem {
  private Map<String,Set<Ticket>> ticketsByFlightCode = new LinkedHashMap<String,Set<Ticket>>();
  private int currentTicketNumber = 0;

  /** Make a new ticket available at the specified price for the specified flight. */
  public synchronized void publishTicket(String flightCode, int price) {
    Ticket ticket = new Ticket(flightCode, currentTicketNumber++, price);
    Set<Ticket> ticketsForFlightCode = ticketsByFlightCode.get(ticket.getFlightCode());
    if (ticketsForFlightCode == null) {
      ticketsForFlightCode = new LinkedHashSet<Ticket>();
      ticketsByFlightCode.put(ticket.getFlightCode(), ticketsForFlightCode);
    }
    ticketsForFlightCode.add(ticket);
  }

  /** Get tickets for a particular flight.

   @param availableOnly If true, return only available tickets. */
  public Set<Ticket> getTicketsForFlight(String flightCode, boolean availableOnly) {
    Set<Ticket> ticketsForFlightCode = ticketsByFlightCode.get(flightCode);
    if (ticketsForFlightCode == null)
      return new LinkedHashSet<Ticket>();
    Set<Ticket> ret = new LinkedHashSet<Ticket>();
    for (Ticket ticket : ticketsForFlightCode) {
      if (!availableOnly || !ticket.isBooked())
        ret.add(ticket);
    }
    return ret;
  }

  /** If the ticket is still available, charge the credit card the price of the ticket, and book
  the ticket if successful.
   @return true if the ticket was successfully booked, false otherwise. */
  public boolean bookTicket(Ticket ticket, CreditCard creditCard) {
    return ticket.book(creditCard);
  }
}
