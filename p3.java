 class ComplexNum {
    int real;
    int imag;

     ComplexNum() {   //default constructor..
        real = 0;
        imag = 0;
    }

     ComplexNum(int x, int y) {  // parameterised constructor..
        real = x;
        imag = y;
    }

     ComplexNum add(ComplexNum n) {
        return new ComplexNum(this.real + n.real, this.imag + n.imag);
    }

     ComplexNum subtract(ComplexNum n) {
        return new ComplexNum(this.real - n.real, this.imag - n.imag);
    }

     void increment() {
        this.real++;
        this.imag++;
    }

     void decrement() {
        this.real--;
        this.imag--;
    }

     boolean equals(ComplexNum n) {
        return this.real == n.real && this.imag == n.imag;
    }
}
    public class p3{
         public static void main(String[] args) {
        ComplexNum c1 = new ComplexNum(5, 8);
        ComplexNum c2 = new ComplexNum(1, 2);

        ComplexNum sum = c1.add(c2);
        System.out.println("Sum is " + sum.real + "+" + sum.imag + "i");

        ComplexNum diff = c1.subtract(c2);
        System.out.println("Difference is " + diff.real + "+" + diff.imag + "i");

        c1.increment();
        System.out.println("After increment " + c1.real + "+" + c1.imag + "i");

        c1.decrement();
        System.out.println("After decrement " + c1.real + "+" + c1.imag + "i");

        if (c1.equals(c2)) {
            System.out.println("Numbers are equal");
        } else {
            System.out.println("Numbers are not equal");
        }
    }
}
   
