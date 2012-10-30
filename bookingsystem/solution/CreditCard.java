package bookingsystem.solution;

/** Can be assumed to be thread-safe. */
public interface CreditCard {
  /** Attempt to charge the credit card. Return true if successful, false otherwise. This method may
  take a few seconds to run while the transaction is processed by the credit card company.
   
   @param amount The amount to charge */
  public boolean charge(int amount);
}
