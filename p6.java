import java.util.Scanner;

// Base class
class Bank {
    protected String name;
    protected long accountNumber;
    protected double balance;

    public void readDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        name = scanner.nextLine();
        System.out.print("Enter account number: ");
        accountNumber = scanner.nextLong();
        System.out.print("Enter balance: ");
        balance = scanner.nextDouble();
    }

    public void displayDetails() {
        System.out.println("Customer Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    public void calculateInterest() {
    }
}

class CityBank extends Bank {
    private double interestRate = 0.05; // 5%

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Interest earned at City Bank: $" + interest);
    }
}

class SBIBank extends Bank {
    private double interestRate = 0.06; // 6%

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Interest earned at SBI Bank: $" + interest);
    }
}

class CanaraBank extends Bank {
    private double interestRate = 0.04; // 4%

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Interest earned at Canara Bank: $" + interest);
    }
}

public class p6 {
    public static void main(String[] args) {
        CityBank cityBank = new CityBank();
        System.out.println("Enter details for City Bank:");
        cityBank.readDetails();
        cityBank.displayDetails();
        cityBank.calculateInterest();
        System.out.println();
        SBIBank sbiBank = new SBIBank();
        System.out.println("Enter details for SBI Bank:");
        sbiBank.readDetails();
        sbiBank.displayDetails();
        sbiBank.calculateInterest();
        System.out.println();
        CanaraBank canaraBank = new CanaraBank();
        System.out.println("Enter details for Canara Bank:");
        canaraBank.readDetails();
        canaraBank.displayDetails();
        canaraBank.calculateInterest();
    }
}