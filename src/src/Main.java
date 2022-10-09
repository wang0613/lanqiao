package src;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public Main(){

        System.out.println("M  ");
    }
    {
        System.out.println(" M2");
    }
    static {
        System.out.println("M3 ");
    }


    public static void test1() {


        String str1 = "Name Addr";
        String str2 = "Name" + " " + "Addr";
        String str3 = new String("Name" + " " + "Addr");
        System.out.println(str1 == str2 && str2 == str3); //f
        System.out.println(str1 != str2 && str2 == str3); //f
        System.out.println(str1 != str2 && str2 != str3); // f
        //常量池
        System.out.println(str1 == str2 && str2 != str3); // t

        System.out.println(str1.equals(str2) && str2.equals(str3)); //t


    }

}