package bookingsystem;

public class ExampleCreditCard implements CreditCard {
  @Override
  public boolean charge(int amount) {
    try {
      Thread.sleep((int) (Math.random() * 5000));
    } catch (InterruptedException e) { }
    return Math.random() > 0.2;
  }
}

