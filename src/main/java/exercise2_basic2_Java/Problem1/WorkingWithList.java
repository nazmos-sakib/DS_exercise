package exercise2_basic2_Java.Problem1;

import java.util.List;

public class WorkingWithList {
    static void addElements(List<Integer> list){
        for (int i =0; i<100000;i++){
            list.add ((int) Math.random());
        }
    }

    static void addElementsAtBegin(List<Integer> list){
        for (int i =0; i<100000;i++){
            list.add ((int) Math.random());
        }
    }

}
