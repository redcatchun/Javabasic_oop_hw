package Bai11;

public class Main {
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(1, 1.13);
        ComplexNumber c2 = new ComplexNumber(2.5, -2);
        ComplexNumber c3 = new ComplexNumber(0, -2.2);
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        System.out.println("c1 + c2 = c1.plus(s2) =" + c1.plus(c2));
        System.out.println("c1 * c2 = c1.multi(c2) = " + c1.multi(c2));
        System.out.println("So sanh c3 va c1: " + c3.equals(c1));
        System.out.println("So sanh c3 va (0-2.2j): " + c3.equals(0,-2.2));
        System.out.println("So sanh c1 va (Double) 4: "+c1.equals(4));

    }
}
