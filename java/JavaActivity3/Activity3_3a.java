package JavaActivity3;

import java.util.LinkedList;
import java.util.Queue;

public class Activity3_3a {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        //Add elements
        for (int i=0;i<5;i++) {
            q.add(i);
        }

        //Display contents of the queue. 
        System.out.println("Elements in queue: " + q);
        
        System.out.println("Size of queue: " + q.size());

        System.out.println("Removed element: " + q.remove());

        System.out.println("Head of queue: " + q.peek());

        System.out.println("Updated size of queue: " + q.size());
    }
}