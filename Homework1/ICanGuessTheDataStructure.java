
/**
 * Created by kdn251 on 2/10/17.
 */

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {

        //initialize data structures
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        //initialize max priority queue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

        //initialize buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        //iterate through all test cases
        while ((line = br.readLine()) != null) {

            //initialize removals for each data structure
            int stackRemovals = 0;
            int queueRemovals = 0;
            int priorityQueueRemovals = 0;
            int totalRemovals = 0;

            //get number of test cases
            int numberOfCases = Integer.parseInt(line);

            //clear contents of data structures
            queue.clear();
            priorityQueue.clear();
            stack.clear();

            //iterate over all test cases
            for (int i = 0; i < numberOfCases; i++) {

                String[] currentLineSplit = br.readLine().split(" ");
                int command = Integer.parseInt(currentLineSplit[0]);
                int number = Integer.parseInt(currentLineSplit[1]);

                //if command is 1, push number into all data structures
                if (command == 1) {

                    stack.push(number);
                    queue.add(number);
                    priorityQueue.add(number);

                } else {

                    //check which data structure to remove from and increment its removal count
                    if (!stack.isEmpty() && stack.peek() == number && stackRemovals == totalRemovals) {

                        stackRemovals++;
                        stack.pop();

                    }

                    if (!queue.isEmpty() && queue.peek() == number && queueRemovals == totalRemovals) {

                        queueRemovals++;
                        queue.remove();

                    }

                    if (!priorityQueue.isEmpty() && priorityQueue.peek() == number && priorityQueueRemovals == totalRemovals) {

                        priorityQueueRemovals++;
                        priorityQueue.remove();

                    }

                    totalRemovals++;


                }

            }

            //check all removal counts for each data structure vs. total removal count and print the appropriate data structure
            if ((stackRemovals == totalRemovals && queueRemovals == totalRemovals) || (stackRemovals == totalRemovals && stackRemovals == priorityQueueRemovals) || (queueRemovals == totalRemovals && priorityQueueRemovals == totalRemovals)) {

                System.out.println("not sure");

            } else if (stackRemovals == totalRemovals) {

                System.out.println("stack");

            } else if (queueRemovals == totalRemovals) {

                System.out.println("queue");

            } else if (priorityQueueRemovals == totalRemovals) {

                System.out.println("priority queue");

            } else {

                System.out.println("impossible");

            }

        }


    }

}
