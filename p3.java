import java.util.*;

class Complex {
    int real, imaginary;

    Complex(int tempReal, int tempImaginary) {
        real = tempReal;
        imaginary = tempImaginary;
    }

    Complex addComp(Complex C1, Complex C2) {
        Complex temp = new Complex(0, 0);
        temp.real = C1.real + C2.real;
        temp.imaginary = C1.imaginary + C2.imaginary;
        return temp;
    }

    Complex subtractComp(Complex C1, Complex C2) {
        Complex temp = new Complex(0, 0);
        temp.real = C1.real - C2.real;
        temp.imaginary = C1.imaginary - C2.imaginary;
        return temp;
    }

    Complex increment() {
        Complex temp = new Complex(0, 0);
        temp.real = this.real + 1;
        temp.imaginary = this.imaginary + 1;
        return temp;
    }

    Complex decrement() {
        Complex temp = new Complex(0, 0);
        temp.real = this.real - 1;
        temp.imaginary = this.imaginary - 1;
        return temp;
    }

    void printComplexNumber() {
        System.out.println("Complex number: " + real + " + " + imaginary + "i");
    }
}

public class p3 {
    public static void main(String[] args) {
        int a, b, c, d;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first real part and then imaginary part of the two complex numbers");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        Complex C1 = new Complex(a, b);
        C1.printComplexNumber();
        Complex C2 = new Complex(c, d);
        C2.printComplexNumber();
        Complex C3 = new Complex(0, 0);
        C3 = C3.addComp(C1, C2);
        System.out.print("Sum of ");
        C3.printComplexNumber();
        C3 = C3.subtractComp(C1, C2);
        System.out.print("Difference of ");
        C3.printComplexNumber();
        System.out.print("incrementation");
        C3 = C1.increment();
        C3.printComplexNumber();
        System.out.print("decrementation");
        C3 = C2.decrement();
        C3.printComplexNumber();
    }
}