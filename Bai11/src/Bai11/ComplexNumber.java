package Bai11;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Class so phuc
 */
public class ComplexNumber {
    public double realPart;// phan thuc
    public double imaginaryPart;// phan ao

    public ComplexNumber(double realDouble) {
        this.realPart = realDouble;
        this.imaginaryPart = 0;
    }

    // Cac cach tao moi
    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public ComplexNumber plus(double realDouble) {
        return new ComplexNumber(realDouble + this.realPart, imaginaryPart);
    }

    /**
     * @description: Cac Ham cong so phuc
     * @param:
     * @return:
     */
    public ComplexNumber plus(ComplexNumber that) {
        return new ComplexNumber(realPart + that.realPart, imaginaryPart + that.imaginaryPart);
    }

    public ComplexNumber plus(double realPart, double imaginaryPart) {
        return new ComplexNumber(realPart + this.realPart, imaginaryPart + this.imaginaryPart);
    }


    public ComplexNumber multi(double realDouble) {
        return new ComplexNumber(realPart * realDouble, imaginaryPart * realDouble);
    }

    /**
     * @description: Cac ham nha so phuc
     * @param:
     * @return:
     */
    public ComplexNumber multi(ComplexNumber that) {
        double real = realPart * that.realPart - imaginaryPart * that.imaginaryPart;
        double imaginary = realPart * that.imaginaryPart + imaginaryPart * that.realPart;
        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber multi(double realPart, double imaginaryPart) {
        double real = realPart * this.realPart - imaginaryPart * this.imaginaryPart;
        double imaginary = realPart * this.imaginaryPart + imaginaryPart * this.realPart;
        return new ComplexNumber(real, imaginary);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplexNumber)) return false;
        ComplexNumber that = (ComplexNumber) o;
        return that.realPart == realPart && that.imaginaryPart == imaginaryPart;
    }

    public boolean equals(double doubleNumber) {
        return realPart == doubleNumber && imaginaryPart == 0;
    }

    public boolean equals(double realPart, double imaginaryPart) {
        return realPart == this.realPart && imaginaryPart == this.imaginaryPart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.####");
        if (realPart == 0 && imaginaryPart == 0) return "0";
        if (imaginaryPart < 0) return "(" + df.format(realPart) + "" + df.format(imaginaryPart) + "j)";
        return "(" + df.format(realPart) + "+" + df.format(imaginaryPart) + "j)";
    }
}
