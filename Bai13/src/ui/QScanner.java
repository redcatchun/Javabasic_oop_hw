package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class QScanner {
    public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // cac ham nhap gia tri ngay thang nam tu ban phim, return LocalDate hoac String
    public static String stringDate() {
        System.out.print("(dd/MM/yyyy) ");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        LocalDate date2;
        try {
            date2 = LocalDate.parse(date, fmt);
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalDate localDate() {
        System.out.print(" (dd/MM/yyyy)");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        LocalDate date2;
        try {
            date2 = LocalDate.parse(date, fmt);
            return date2;
        } catch (Exception e) {
            return null;
        }
    }
}
