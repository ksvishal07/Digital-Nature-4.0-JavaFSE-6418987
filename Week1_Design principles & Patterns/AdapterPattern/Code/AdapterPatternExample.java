package AdapterPattern.Code;

interface PaymentProcessor {
    void processPayment(double amount);
}

// Adaptee 1
class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via PayPal.");
    }
}

// Adaptee 2
class StripeGateway {
    public void pay(double amount) {
        System.out.println("Processing payment of $" + amount + " via Stripe.");
    }
}

// Adapter for PayPal
class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;
    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }
    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}

// Adapter for Stripe
class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;
    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }
    public void processPayment(double amount) {
        stripeGateway.pay(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());

        paypalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(200.0);
    }
}
