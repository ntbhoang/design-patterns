package com.patterns.behavioral.strategy;


import java.util.ArrayList;
import java.util.List;

public interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy classes
class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    public void pay(int amount) {
        System.out.println(amount + " paid with credit/debit card");
    }
}

class PayPalStrategy implements PaymentStrategy {
    private String emailId;
    private String password;

    public PayPalStrategy(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal");
    }
}

// ShoppingCart class
class ShoppingCart {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int calculateTotal() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentStrategy) {
        int a = calculateTotal();
        paymentStrategy.pay(a);
    }


    class Item {
        private String upcCode;
        private int price;

        public Item(String upcCode, int price) {
            this.upcCode = upcCode;
            this.price = price;
        }

        public String getUpcCode() {
            return upcCode;
        }

        public int getPrice() {
            return price;
        }
    }
}

class ShoppingCartApp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(cart.new Item("1234", 10));
        cart.addItem(cart.new Item("5678", 40));

        cart.pay(new CreditCardStrategy("Max Nguyen", "1234567890123456", "786", "12/26"));

        cart.pay(new PayPalStrategy("max.nguyen@gmail.com", "123456"));
    }
}