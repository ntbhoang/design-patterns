package com.patterns.structural.adapter;

// Step 1: create the common interface that the app will use
interface PaymentGateway {
    void processPayment();
}

// Step 2: Create payment gateway adapters
class PayPalAdapter implements PaymentGateway {
    private PayPal paymentGateway;

    public PayPalAdapter(PayPal paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void processPayment() {
        paymentGateway.makePayment();
    }
}

class StripeAdapter implements PaymentGateway {
    private Stripe paymentGateway;

    public StripeAdapter(Stripe paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void processPayment() {
        paymentGateway.makePayment();
    }
}


// Step 3: Implement concrete Payment gateway providers
class PayPal {
    public void makePayment() {
        System.out.println("Making payment using PayPal");
    }
}


class Stripe {
    public void makePayment() {
        System.out.println("Making payment using Stripe");
    }
}

// Step 4: client code

class Demo {
    public static void main(String[] args) {
        PaymentGateway paymentGateway = new PayPalAdapter(new PayPal());
        paymentGateway.processPayment();

        paymentGateway = new StripeAdapter(new Stripe());
        paymentGateway.processPayment();
    }
}

