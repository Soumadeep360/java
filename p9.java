import java.util.*;

interface Compute {
    void convert();
}

class BytesConverter implements Compute{
    private int bytes;

    public BytesConverter(int bytes) {
        this.bytes = bytes;
    }
    public void convert() {
        double kilobytes = bytes / 1024.0;
        System.out.println(bytes + " bytes is equal to " + kilobytes + " kilobytes.");
    }
   
}

class CurrencyConverter implements Compute {
    private double euros;

    public CurrencyConverter(double euros) {
        this.euros = euros;
    }

    public void convert() {
        double rupees = euros * 90.0; 
        System.out.println(euros + " euros is equal to " + rupees + " rupees.");
    }
}

public class p9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of bytes: ");
        int bytesInput = scanner.nextInt();
        BytesConverter bytesConverter = new BytesConverter(bytesInput);
        bytesConverter.convert();

        System.out.print("Enter the amount in euros: ");
        double eurosInput = scanner.nextDouble();
        CurrencyConverter currencyConverter = new CurrencyConverter(eurosInput);
        currencyConverter.convert();

        scanner.close();
    }
}
