
/**
 * Created by kdn251 on 2/10/17.
 */

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line = br.readLine()) != null) {

            //read number
            int number = Integer.parseInt(line);

            //terminate if number is zero
            if(number == 0) break;

            //intialize variables
            int count = 0;
            int a = 0;
            int b = 0;

            while(number > 0) {


                //get lowest set bit
                int currentBit = number ^ (number & (number - 1));


                //if count is even or a with current bit
                if(count % 2 == 0) {

                    a |= currentBit;

                }

                //if count is odd or b with current bit
                else {

                    b |= currentBit;

                }

                //increment count
                count++;

                //clear lowest set bit for next iteration
                number &= (number - 1);

            }

            //print a and b
            System.out.println(a + " " + b);

        }


    }

}
