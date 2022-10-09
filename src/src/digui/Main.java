package src.digui;


import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BigDecimal b = sc.nextBigDecimal();


        BigDecimal n1 = new BigDecimal("1");
        BigDecimal n2 = new BigDecimal("2");


        BigDecimal sum = (b.add(n1)).multiply(b).divide(n2);
        System.out.println(sum);
    }


}
