package exercise2_basic2_Java.Problem1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String... arg){

        //Arraylist
        long start = System.currentTimeMillis();
        WorkingWithList.addElements(new ArrayList<>());
        long end = System.currentTimeMillis();
        System.out.println("Time needed w/o threads "+ ((end - start)) + " msec");

        //linkedList
        start = System.currentTimeMillis();
        WorkingWithList.addElements(new LinkedList<>());
        end = System.currentTimeMillis();
        System.out.println("Time needed w/o threads "+ ((end - start)) + " msec");

    }
}
