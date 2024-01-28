import java.util.*;

interface Compute {
    void convert();
}

class BytesConverter implements Compute{
     int gb;

     BytesConverter(int gb) {
        this.gb = gb;
    }
    public void convert() {
        long bytes = (long)(gb*1024.0*1024.0*1024.0);
        System.out.println(bytes + " bytes is equal to " + bytes + " kilobytes.");
    }
   
}

class CurrencyConverter implements Compute {
     double euros;

     CurrencyConverter(double euros) {
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

        System.out.print("Enter the number of gigabytes: ");
        int gb = scanner.nextInt();
        BytesConverter bytesConverter = new BytesConverter(gb);
        bytesConverter.convert();

        System.out.print("Enter the amount in euros: ");
        double eurosInput = scanner.nextDouble();
        CurrencyConverter currencyConverter = new CurrencyConverter(eurosInput);
        currencyConverter.convert();

        scanner.close();
    }
}
