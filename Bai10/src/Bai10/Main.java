package Bai10;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String str = "  Day   lA   string    Mau.. /*-  ";
        Document doc = new Document(str);
        System.out.println("So tu: " + doc.getNumberOfWord());
        System.out.println("Ban tieu chuan cuoi: " + doc.getLastEditText());
        System.out.println("So chu a xuat hien: " + doc.countCharater("A"));

        doc.addText("    Chuoi nAy   dUoc    them vao   ");
        System.out.println("raw: "+doc.getRawText());
        System.out.println("So tu: " + doc.getNumberOfWord());
        System.out.println("Ban tieu chuan cuoi: " + doc.getLastEditText());
        System.out.println("So chu D xuat hien: " + doc.countCharater("D"));
    }
}
