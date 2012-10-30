package bookingsystem;

/** Must be thread-safe. */
public final class Ticket {
  private final String flightCode;
  private final int ticketNumber;
  private final int price;

  Ticket(String flightCode, int ticketNumber, int price) {
    if (flightCode == null)
      throw new NullPointerException();
    if (price <= 0)
      throw new IllegalArgumentException();
    this.flightCode = flightCode;
    this.ticketNumber = ticketNumber;
    this.price = price;
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

