package bookingsystem.solution;

/** Must be thread-safe. */
public final class Ticket {
  private final String flightCode;
  private final int ticketNumber;
  private final int price;
  private boolean booked;

  Ticket(String flightCode, int ticketNumber, int price) {
    if (flightCode == null)
      throw new NullPointerException();
    if (price <= 0)
      throw new IllegalArgumentException();
    this.flightCode = flightCode;
    this.ticketNumber = ticketNumber;
    this.price = price;
  }

  public synchronized boolean isBooked() {
    return booked;
  }

  public synchronized boolean book(CreditCard creditCard) {
    if (booked)
      return false;
    booked = creditCard.charge(getPrice());
    return booked;
  }

  public String getFlightCode() {
    return flightCode;
  }

  public int getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Ticket))
      return false;
    Ticket that = (Ticket) obj;
    return this.ticketNumber == that.ticketNumber;
  }

  @Override
  public int hashCode() {
    return ticketNumber;
  }
}
